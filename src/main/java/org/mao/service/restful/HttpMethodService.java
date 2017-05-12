package org.mao.service.restful;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rest")
public class HttpMethodService {

	/**
	 * Create: 201 (Created), 'Location' header with link to /customers/{id} containing new ID.
	 * 404 (Not Found), 409 (Conflict) if resource already exists.
	 */
	@POST
	@Path("/post")
	public Response doPost() {	    
	    return Response.ok().entity("Hello POST").build();
	}
	
	/**
	 * Read: 200 (OK), list of customers. Use pagination, sorting and filtering to navigate big lists.
	 * 200 (OK), single customer. 404 (Not Found), if ID not found or invalid.
	 */	
	@GET
	@Path("/get")
	@Produces(MediaType.TEXT_PLAIN)
	public String doGet() {
		return "Hello GET";
	}
	
	/**
	 * Update/Replace 404 (Not Found), unless you want to update/replace every resource in the entire collection.
	 * 200 (OK) or 204 (No Content). 404 (Not Found), if ID not found or invalid.
	 */
	@PUT
	@Path("/put")
	public String doPut() {	    
	    return "Hello PUT";
	}
	
	/**
	 * Delete 404 (Not Found), unless you want to delete the whole collection—not often desirable.
	 * 200 (OK). 404 (Not Found), if ID not found or invalid.
	 * 
	 */	
	@DELETE
	@Path("/delete")
	public String doDelete() {	    
	    return "Hello DELETE";
	}
}
