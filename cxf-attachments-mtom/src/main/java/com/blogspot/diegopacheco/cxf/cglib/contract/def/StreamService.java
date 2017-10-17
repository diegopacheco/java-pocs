package com.blogspot.diegopacheco.cxf.cglib.contract.def;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService
public interface StreamService {

	@WebMethod
	public @WebResult(name = "pdfStream")
		   @XmlMimeType("application/octet-stream")
		   DataHandler getPDFAsStream(
				   					@WebParam(name = "userID") String userID
				   				 );

}
