package com.redhat.gss.ws.rs;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;


@Path("resource")
public class SampleResource {

	@POST
	@Path("request")
	public void go(@Context HttpServletRequest request) {
		System.out.println("Request " + request);		
	}
	
	@POST
	@Path("response")
	public void go(@Context HttpServletResponse response) {
		System.out.println("Response " + response);
	}
	
	@POST
	@Path("config")
	public void go(@Context ServletConfig config) {
		System.out.println("Config " + config);
	}
	
	@POST
	@Path("context")
	public void go(@Context ServletContext context) {
		System.out.println("Context " + context);		
	}
	
	@POST
	@Path("rs-request")
	public void go(@Context Request request) {
		System.out.println("RS Request " + request);		
	}
	
	@GET
	public String ping() {
		return "pong";		
	}
	
}
