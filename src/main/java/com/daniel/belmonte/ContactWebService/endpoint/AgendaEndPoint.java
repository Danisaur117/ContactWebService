package com.daniel.belmonte.ContactWebService.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.daniel.belmonte.ContactWebService.controller.ContactController;
import com.daniel.belmonte.gs_ws.ContactType;
import com.daniel.belmonte.gs_ws.DeleteContactRequest;
import com.daniel.belmonte.gs_ws.DeleteContactResponse;
import com.daniel.belmonte.gs_ws.GetContactByIdRequest;
import com.daniel.belmonte.gs_ws.GetContactByIdResponse;
import com.daniel.belmonte.gs_ws.InsertContactRequest;
import com.daniel.belmonte.gs_ws.InsertContactResponse;
import com.daniel.belmonte.gs_ws.ServiceStatus;
import com.daniel.belmonte.gs_ws.UpdateContactRequest;
import com.daniel.belmonte.gs_ws.UpdateContactResponse;

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
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="insertContactRequest")
	@ResponsePayload
	InsertContactResponse insertContact(@RequestPayload InsertContactRequest request) {
		InsertContactResponse response = new InsertContactResponse();
		ContactType contactType = this.controller.insertContact(request);
		ServiceStatus serviceStatus = new ServiceStatus();
		
		response.setContactType(contactType);
		
		if(contactType == null) {
			serviceStatus.setStatusCode("CONFLICT");
			serviceStatus.setMessage("Error al añadir la entidad");
			
			response.setServiceStatus(serviceStatus);
			
			return response;
		}
		
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Entidad añadida correctamente");
		
		response.setServiceStatus(serviceStatus);
		
		return response;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="updateContactRequest")
	@ResponsePayload
	public UpdateContactResponse updateContact(@RequestPayload UpdateContactRequest request) {
		UpdateContactResponse response = new UpdateContactResponse();
		Boolean updated = this.controller.updateContact(request);
		ServiceStatus serviceStatus = new ServiceStatus();

		if(updated == null) {
			serviceStatus.setStatusCode("NOT FOUND");
			serviceStatus.setMessage("Error al buscar la entidad");
			
			response.setUpdated(false);
			response.setServiceStatus(serviceStatus);
			
			return response;
		}
		
		if(updated == false) {
			serviceStatus.setStatusCode("CONFLICT");
			serviceStatus.setMessage("Error al actualizar la entidad");
			
			response.setUpdated(false);
			response.setServiceStatus(serviceStatus);
			
			return response;
		}
		
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Entidad actualizada correctamente");
		
		response.setUpdated(true);
		response.setServiceStatus(serviceStatus);
		
		return response;
	}
	
	@PayloadRoot(namespace=NAMESPACE_URI, localPart="deleteContactRequest")
	@ResponsePayload
	public DeleteContactResponse deleteContact(@RequestPayload DeleteContactRequest request) {
		DeleteContactResponse response = new DeleteContactResponse();
		Boolean deleted = this.controller.deleteContact(request.getContactId());
		ServiceStatus serviceStatus = new ServiceStatus();

		if(deleted == null) {
			serviceStatus.setStatusCode("NOT FOUND");
			serviceStatus.setMessage("Error al buscar la entidad");
			
			response.setServiceStatus(serviceStatus);
			response.setDeleted(false);
			
			return response;
		}
		
		if(deleted == false) {
			serviceStatus.setStatusCode("CONFLICT");
			serviceStatus.setMessage("Error al borrar la entidad");
			
			response.setServiceStatus(serviceStatus);
			response.setDeleted(deleted);
			
			return response;
		}
		
		serviceStatus.setStatusCode("SUCCESS");
		serviceStatus.setMessage("Entidad borrada correctamente");
		
		response.setServiceStatus(serviceStatus);
		response.setDeleted(deleted);
		
		return response;
	}
}
