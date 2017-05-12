package org.mao.service.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.mao.service.restful.model.Customer;

import com.google.gson.Gson;


@Path("/rest")
public class RestfulService {

    @GET
    @Path("/TextPlan")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTextPlan() {
        return "Hello MediaType.TEXT_PLAIN";
    }
    
    
    @GET
    @Path("/ApplicationXML")
    @Produces(MediaType.APPLICATION_XML)
    public Customer getApplicationXML() {
    	Customer customer = new Customer();
    	customer.setId(1);
    	customer.setName("APPLICATION_XML");
        return customer;
    }
    
    @GET
    @Path("/ApplicationJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public String getApplicationJSON() {
    	Customer customer = new Customer();
    	customer.setId(1);
    	customer.setName("APPLICATION_JSON");
    	Gson gson = new Gson();
    	return  gson.toJson(customer);
    }
}
