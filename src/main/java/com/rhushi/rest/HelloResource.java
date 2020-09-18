package com.rhushi.rest;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.rhushi.dao.MemberDAO;
import com.rhushi.model.Member;
import com.rhushi.services.Greeting;

// Run the payara micro server using the command mvn package payara-micro:start

@RequestScoped
@Path("/hello")
public class HelloResource {

	@Inject
	private MemberDAO memberDAO;

	@Inject
	@ConfigProperty(name = "username", defaultValue = "admin")
	private String username;

	@Inject
	Config config;

	@Inject
	Greeting greeting;

	@GET
	public Response hello() {
		Map<String, Object> configProperties = new HashMap<>();

		configProperties.put("username", username);
		// configProperties.put("password", config.getValue("password", String.class));
		configProperties.put("microprofile-apis", config.getValue("microprofile.apis", String[].class));
		Member member = this.memberDAO.getMember(1L);
		return Response.ok(member).build();

		// return Response.ok(configProperties).build();
	}
}
