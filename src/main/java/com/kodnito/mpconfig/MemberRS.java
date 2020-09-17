package com.kodnito.mpconfig;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

// Run the payara micro server using the command mvn package payara-micro:start

@RequestScoped
@Path("/member")
public class MemberRS {

	@Inject
	private MemberDAO memberDAO;

	@GET
	@Path("/{id}")
	public Response list(@PathParam("id") Long id) {
		Member member = this.memberDAO.getMember(id);
		return Response.ok(member).build();
	}

	@POST
	@Path("/")
	public Response post(@FormParam("lastName") String lastName, @FormParam("firstName") String firstName) {
		Long newId = this.memberDAO.newMember(lastName, firstName);
		return Response.ok().entity("{\"id\":" + newId + "}").build();
	}

	@PUT
	@Path("/{id}")
	public Response put(@FormParam("lastName") String lastName, 
			            @FormParam("firstName") String firstName,
			            @PathParam("id") Long id) {
		this.memberDAO.updateMember(lastName, firstName, id);
		return Response.ok().entity("{}").build();
	}

	@DELETE
	@Path("/{id}")
	@Produces("application/json")
	public Response del(@PathParam("id") Long id) {
		this.memberDAO.deleteMember(id);
		return Response.ok().entity("{}").build();
	}

}
