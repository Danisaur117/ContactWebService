package com.daniel.belmonte.ContactWebService.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.daniel.belmonte.ContactWebService.controller.ContactController;
import com.daniel.belmonte.gs_ws.ContactType;
import com.daniel.belmonte.gs_ws.GetContactByIdRequest;
import com.daniel.belmonte.gs_ws.GetContactByIdResponse;
import com.daniel.belmonte.gs_ws.ServiceStatus;

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
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="getContactByIdRequest")
	@ResponsePayload
	GetContactByIdResponse getContactById(@RequestPayload GetContactByIdRequest request) {
		GetContactByIdResponse response = new GetContactByIdResponse();
		ContactType contactType = this.controller.getContactById(request.getContactId());
		ServiceStatus serviceStatus = new ServiceStatus();
		
		if(contactType == null) {
			serviceStatus.setStatusCode("NOT FOUND");
			serviceStatus.setMessage("Error al buscar la entidad");
			
			response.setServiceStatus(serviceStatus);
			response.setContactType(contactType);
			
			return response;
		}
		
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Entidad encontrada correctamente");
		
		response.setServiceStatus(serviceStatus);
		response.setContactType(contactType);
		
		return response;
	}
}
