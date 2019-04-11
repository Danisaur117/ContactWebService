package com.daniel.belmonte.ContactWebService.dao.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.belmonte.ContactWebService.dao.entity.ContactEntity;
import com.daniel.belmonte.ContactWebService.dao.interfaces.ContactEntityInterface;
import com.daniel.belmonte.ContactWebService.dao.repository.ContactEntityRepository;

@Service
@Transactional
public class ContactEntityService implements ContactEntityInterface {
	@Autowired
	private ContactEntityRepository repository;
	
	public ContactEntityService() {
		
	}
	
	public ContactEntityService(ContactEntityRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public ContactEntity getContactById(int id) {
		try{
			return this.repository.findById(id).get();
		}
		catch(Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public ContactEntity insertContact(ContactEntity contactEntity) {
		try {
			return this.repository.save(contactEntity);
		}
		catch(Exception e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean updateContact(ContactEntity contactEntity) {
		try {
			this.repository.save(contactEntity);
			return true;
		}
		catch(Exception e) {
			//e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deleteContact(int id) {
		try {
			this.repository.deleteById(id);
			return true;
		}
		catch(Exception e) {
			//e.printStackTrace();
			return false;
		}
	}
}
