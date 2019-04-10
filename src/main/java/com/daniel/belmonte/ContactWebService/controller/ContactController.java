package com.daniel.belmonte.ContactWebService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.daniel.belmonte.ContactWebService.dao.interfaces.ContactEntityInterface;

@Controller
public class ContactController {
	private ContactEntityInterface service;
	
	@Autowired
	public ContactController(ContactEntityInterface service) {
		this.service = service;
	}
}
