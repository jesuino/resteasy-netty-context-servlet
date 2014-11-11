package com.redhat.gss.ws.rs;

import org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;

public class MainNetty {
	public static void main(String[] args) {
		System.out.println("== STARTING NETTY SERVER ==");
		ResteasyDeployment deployment = new ResteasyDeployment();
		NettyJaxrsServer netty = new NettyJaxrsServer();
		netty.setDeployment(deployment);
		netty.setPort(8080);
		netty.setRootResourcePath("");
		netty.setSecurityDomain(null);
		netty.start();
		deployment.getRegistry().addPerRequestResource(SampleResource.class);
		System.out.println("== STARTED ==");
	}

}
