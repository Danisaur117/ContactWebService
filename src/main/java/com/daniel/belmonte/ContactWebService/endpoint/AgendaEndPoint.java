package com.daniel.belmonte.ContactWebService.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

import com.daniel.belmonte.ContactWebService.controller.ContactController;

@Endpoint
public class AgendaEndPoint {
	public static final String NAMESPACE_URI="http://www.daniel.belmonte.com/agenda-ws";
	ContactController controller;
	
	public AgendaEndPoint() {
		
	}
	
	@Autowired
	public AgendaEndPoint(ContactController controller) {
		this.controller = controller;
	}
}
