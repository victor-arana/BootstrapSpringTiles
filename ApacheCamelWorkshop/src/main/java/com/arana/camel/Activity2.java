package com.arana.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Activity2 {

	public static void main(String[] args) throws Exception{
		CamelContext context = new DefaultCamelContext();
    	context.addRoutes(new RouteBuilder() {
			public void configure() {
				from("file:data/test_input?noop=true)")
					.choice()
						.when(header("CamelFileName").endsWith(".xml"))						
				.to("file:data/test_output");
			}
		});
    	context.start();
    	Thread.sleep(10000);
    	context.stop();
	}

}
