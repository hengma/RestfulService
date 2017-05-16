package org.mao.service.restful;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

@Path("/feature")
public class RestFeatureService {

	@GET
	@Path("/QueryParam")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getQueryParam(@QueryParam("id") String id) {
		// Example: URI Pattern: /feature/QueryParam?id=1
		return Response.status(Status.OK).entity("QueryParam id : " + id)
				.build();
	}

	@GET	
	@Path("/PathParam/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getPathParam(@PathParam("id") String id) {
		// Example: URI Pattern: /feature/PathParam/1/
		return Response.status(Status.OK).entity("PathParam id :" + id).build();
	}

	@GET
	@Path("/UriInfo")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getUriInfo(@Context UriInfo uriInfo) {

		//Example URI Pattern: /feature/UriInfo?id=1&name=Mao&Gender=Male
		// ID
		String id = uriInfo.getQueryParameters().getFirst("id");
		// Name
		String name = uriInfo.getQueryParameters().getFirst("name");
		// Gender
		String gender = uriInfo.getQueryParameters().getFirst("gender");

		return Response
				.status(Status.OK)
				.entity("id: " + id + ", name: " + name + ", gender: " + gender)
				.build();
	}

	@GET
	@Path("/DefaultValue")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getDefaultValue(@DefaultValue("1000") @QueryParam("timeout") int timeout) {
		//Example: URI Pattern: /feature/DefaultValue
		return Response.ok().entity("DefaultValue: " + timeout).build();
	}
}
