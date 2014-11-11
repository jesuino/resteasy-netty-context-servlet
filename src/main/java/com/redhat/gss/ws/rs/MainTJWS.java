package com.redhat.gss.ws.rs;

import org.jboss.resteasy.plugins.server.tjws.TJWSEmbeddedJaxrsServer;

public class MainTJWS {

	public static void main(String[] args) {
		System.out.println("== STARTING TJWS SERVER ==");
		TJWSEmbeddedJaxrsServer tjws = new TJWSEmbeddedJaxrsServer();
		tjws.setPort(8080);
		tjws.start();
		tjws.getDeployment().getRegistry()
				.addPerRequestResource(SampleResource.class);
		System.out.println("== TJWS SERVER STARTED==");
	}

}
