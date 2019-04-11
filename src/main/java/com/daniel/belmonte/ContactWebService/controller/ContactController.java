package com.daniel.belmonte.ContactWebService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.daniel.belmonte.ContactWebService.dao.entity.ContactEntity;
import com.daniel.belmonte.ContactWebService.dao.interfaces.ContactEntityInterface;
import com.daniel.belmonte.gs_ws.ContactType;
import com.daniel.belmonte.gs_ws.InsertContactRequest;

@Controller
public class ContactController {
	private ContactEntityInterface service;
	
	@Autowired
	public ContactController(ContactEntityInterface service) {
		this.service = service;
	}
	
	public ContactType getContactById(int id) {
		ContactEntity contactEntity = service.getContactById(id);
		ContactType contactType = new ContactType();
		
		if(contactEntity == null) return null;
		
		contactType.setContactId(id);
		contactType.setFirstName(contactEntity.getFirstName());
		contactType.setLastName(contactEntity.getLastName());
		contactType.setAddress(contactEntity.getAddress());
		contactType.setPostalCode(contactEntity.getPostalCode());
		contactType.setCity(contactEntity.getCity());
		contactType.setPhone1(contactEntity.getPhone1());
		contactType.setPhone2(contactEntity.getPhone2());
		contactType.setEmail1(contactEntity.getEmail1());
		contactType.setEmail2(contactEntity.getEmail2());
		contactType.setLastUpdate(contactEntity.getLastUpdate());
		
		return contactType;
	}
	
	public ContactType insertContact(InsertContactRequest request) {
		ContactEntity contactEntity
			= new ContactEntity(request.getFirstName(), request.getLastName(), request.getAddress(),
								request.getPostalCode(), request.getCity(), request.getPhone1(),
								request.getPhone2(), request.getEmail1(), request.getEmail2());
		ContactType contactType = new ContactType();
		ContactEntity saved = service.insertContact(contactEntity);
		
		if(saved == null) return null;
		
		contactType.setContactId(saved.getContactId());
		contactType.setFirstName(saved.getFirstName());
		contactType.setLastName(saved.getLastName());
		contactType.setAddress(saved.getAddress());
		contactType.setPostalCode(saved.getPostalCode());
		contactType.setCity(saved.getCity());
		contactType.setPhone1(saved.getPhone1());
		contactType.setPhone2(saved.getPhone2());
		contactType.setEmail1(saved.getEmail1());
		contactType.setEmail2(saved.getEmail2());
		contactType.setLastUpdate(saved.getLastUpdate());

		return contactType;
	}
	
	public boolean updateContact(ContactEntity contactEntity) {
		return false;
	}
	
	public boolean deleteContact(int id) {
		return false;
	}
}