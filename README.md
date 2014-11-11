resteasy-netty-context-servlet
==============================

Injecting HttpServletRequest when using Netty container with resteasy


Reproducing
=============================

* run `mvn clean package`

* run `mvn exec:java` and in another command line window run?

    *  `curl -X POST http://localhost:8080/resource/request`
    *  `curl -X POST http://localhost:8080/resource/response`
    *  `curl -X POST http://localhost:8080/resource/config`
    *  `curl -X POST http://localhost:8080/resource/context`

* You should see exception similar to the following:

~~~
== STARTING NETTY SERVER ==
Nov 06, 2014 9:28:37 PM org.jboss.resteasy.core.SynchronousDispatcher 
SEVERE: Failed executing POST /resource
org.jboss.resteasy.spi.LoggableFailure: Unable to find contextual data of type: javax.servlet.http.HttpServletRequest
	at org.jboss.resteasy.core.ContextParameterInjector$GenericDelegatingProxy.invoke(ContextParameterInjector.java:56)
	at com.sun.proxy.$Proxy33.toString(Unknown Source)
	at java.lang.String.valueOf(String.java:2847)
	at java.lang.StringBuilder.append(StringBuilder.java:128)
	at com.redhat.gss.ws.rs.SampleResource.go(SampleResource.java:15)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.jboss.resteasy.core.MethodInjectorImpl.invoke(MethodInjectorImpl.java:167)
	at org.jboss.resteasy.core.ResourceMethod.invokeOnTarget(ResourceMethod.java:269)
	at org.jboss.resteasy.core.ResourceMethod.invoke(ResourceMethod.java:227)
	at org.jboss.resteasy.core.ResourceMethod.invoke(ResourceMethod.java:216)
	at org.jboss.resteasy.core.SynchronousDispatcher.getResponse(SynchronousDispatcher.java:542)
	at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:524)
	at org.jboss.resteasy.core.SynchronousDispatcher.invoke(SynchronousDispatcher.java:126)
	at org.jboss.resteasy.plugins.server.netty.RequestDispatcher.service(RequestDispatcher.java:82)
	at org.jboss.resteasy.plugins.server.netty.RequestHandler.messageReceived(RequestHandler.java:51)
	at org.jboss.netty.channel.SimpleChannelUpstreamHandler.handleUpstream(SimpleChannelUpstreamHandler.java:75)
	at org.jboss.netty.channel.DefaultChannelPipeline.sendUpstream(DefaultChannelPipeline.java:564)
	at org.jboss.netty.channel.DefaultChannelPipeline$DefaultChannelHandlerContext.sendUpstream(DefaultChannelPipeline.java:792)
	at org.jboss.netty.handler.execution.ChannelUpstreamEventRunnable.run(ChannelUpstreamEventRunnable.java:44)
	at org.jboss.netty.handler.execution.OrderedMemoryAwareThreadPoolExecutor$ChildExecutor.run(OrderedMemoryAwareThreadPoolExecutor.java:315)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at java.lang.Thread.run(Thread.java:745)
~~~


* Then the following command should work. Which proves that the issue is only related to Servlet part:

    *  `curl -X POST http://localhost:8080/resource/rs-request`


Using TJWS server
=============================

If you change the main class in `pom.xml` to use `MainTJWS`, notice that it will work.
