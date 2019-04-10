package com.daniel.belmonte.ContactWebService.dao.interfaces;

import com.daniel.belmonte.ContactWebService.dao.entity.ContactEntity;

public interface ContactEntityInterface {
	public ContactEntity getContactById(int id);
	public ContactEntity insertContact(ContactEntity contactEntity);
	public boolean updateContact(ContactEntity contactEntity);
	public boolean deleteContact(int id);
}
