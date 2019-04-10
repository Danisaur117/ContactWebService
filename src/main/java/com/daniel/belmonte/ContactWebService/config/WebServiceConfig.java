package com.daniel.belmonte.ContactWebService.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import com.daniel.belmonte.ContactWebService.endpoint.AgendaEndPoint;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}
	
	@Bean(name = "agenda")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("AgendaPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setTargetNamespace(AgendaEndPoint.NAMESPACE_URI);
		wsdl11Definition.setSchema(schema);
		return wsdl11Definition;
	}
	
	@Bean
	public XsdSchema actorsSchema() {
		return new SimpleXsdSchema(new ClassPathResource("/xsd/agenda.xsd"));
	}
}
