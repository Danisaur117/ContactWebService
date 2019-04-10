package com.daniel.belmonte.ContactWebService.dao.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.daniel.belmonte.ContactWebService.dao.entity.ContactEntity;
import com.daniel.belmonte.ContactWebService.dao.interfaces.ContactEntityInterface;
import com.daniel.belmonte.ContactWebService.dao.repository.ContactEntityRepository;

@Service
@Transactional
public class ContactEntityService implements ContactEntityInterface {
	private ContactEntityRepository repository;
	
	public ContactEntityService() {
		System.out.println("CONSTRUCTOR DEL SERVICE");
	}
	
	public ContactEntityService(ContactEntityRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public ContactEntity getContactById(int id) {
		try{
			System.out.println("ID EN EL SERVICE: " + id);
			System.out.println("COUNT: " + this.repository.count());;
			System.out.println("¿EXISTE? " + this.repository.existsById(id));
			System.out.println("¿ENCONTRADO? " + this.repository.findById(id).isPresent());
			return this.repository.findById(id).get();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public ContactEntity insertContact(ContactEntity contactEntity) {
		return null;
	}
	
	@Override
	public boolean updateContact(ContactEntity contactEntity) {
		return false;
	}
	
	@Override
	public boolean deleteContact(int id) {
		return false;
	}
}
