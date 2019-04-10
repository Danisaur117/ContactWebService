package com.daniel.belmonte.ContactWebService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.daniel.belmonte.ContactWebService.dao.entity.ContactEntity;
import com.daniel.belmonte.ContactWebService.dao.interfaces.ContactEntityInterface;
import com.daniel.belmonte.gs_ws.ContactType;

@Controller
public class ContactController {
	private ContactEntityInterface service;
	
	@Autowired
	public ContactController(ContactEntityInterface service) {
		this.service = service;
	}
	
	public ContactType getContactById(int id) {
		System.out.println("ID EN EL CONTROLLER: " + id);
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
	
	public ContactEntity insertContact(ContactEntity contactEntity) {
		return null;
	}
	
	public boolean updateContact(ContactEntity contactEntity) {
		return false;
	}
	
	public boolean deleteContact(int id) {
		return false;
	}
}