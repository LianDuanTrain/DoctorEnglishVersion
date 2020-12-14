package com.docker.restful.demo.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.docker.restful.demo.entities.User;
import com.docker.restful.demo.services.UserService;

@Path("/users")
public class UserResource {

	@Autowired
	private UserService userService;

	   
    @GET
    @Produces("application/json")
    public Response getUsers() {
    	final List<User> users = userService.findByPattern();
		return Response.status(200).entity(users).build();
	}

  
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response  getUsers(@PathParam("id") final String userId) {
    	 User user = userService.findById(userId);
    	 if(user == null) {
             return Response.status(404).build();
         }
    	 return Response.status(200).entity(user).build();
	}

    @POST
    @Consumes("application/json")
    public Response  createUser( final User user) {
    	userService.save(user);
    	 return Response.status(201).build();
	}

    @PUT
    @Path("/{id}")
    @Consumes("application/json")
  @Produces("application/json")
    public Response  updateUser(@PathParam("id") final String userId, final User user) {
    	user.setId(userId);
    	userService.update(user);
    	return Response.status(200).entity(user).build();
	}

    @DELETE
    @Path("/{id}")
    public Response  deleteUser(@PathParam("id") final String userId) {
    	userService.delete(userId);
    	return  Response.status(200).build();
	}

}
