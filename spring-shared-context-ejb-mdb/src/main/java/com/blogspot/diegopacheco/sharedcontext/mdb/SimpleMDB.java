package com.blogspot.diegopacheco.sharedcontext.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.interceptor.Interceptors;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.jboss.ejb3.annotation.ResourceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.blogspot.diegopacheco.business.service.BrazilBorderService;
import com.blogspot.diegopacheco.business.service.PortugualBorderService;
import com.blogspot.diegopacheco.ejb.interceptor.SpringBeanAutowiringInterceptorMod;


@Interceptors(SpringBeanAutowiringInterceptorMod.class)
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "border_queue"),
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge") })
@ResourceAdapter("activemq-ra.rar")
public class SimpleMDB implements MessageListener {
	
	@Autowired
	@Qualifier("brazilBorderService")
	private BrazilBorderService brazilBorderService;
	
	@Autowired
	@Qualifier("portugualBorderService")
	private PortugualBorderService portugualBorderService;
	
	@Override
	public void onMessage(Message msg) {
		
		System.out.println("Services Avaliable: ");
		System.out.println("BR: " + brazilBorderService);
		System.out.println("PT: " + portugualBorderService);
		System.out.println("..................................");
		System.out.println("MSG:\n" + msg );
		
		String fromContry = null;
		try {
			fromContry = ((TextMessage)msg).getText();			
		} catch (JMSException e) {
			e.printStackTrace();
		}
		System.out.println("..................................");
		
		System.out.println("In Brazil you are   : " +  brazilBorderService.enterOrNot(fromContry) );
		System.out.println("In Portugal you are : " +  portugualBorderService.enterOrNot(fromContry) );
	}
	
}
