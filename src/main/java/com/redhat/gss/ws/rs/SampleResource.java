package com.redhat.gss.ws.rs;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;


@Path("resource")
public class SampleResource {

	@POST
	public void go(@Context HttpServletRequest request) {
		System.out.println("Request " + request);
		
	}
	
	@GET
	public String ping() {
		return "pong";		
	}
	
}
