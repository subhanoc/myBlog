package com.nds.myBlog.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nds.myBlog.api.*;
import com.nds.myBlog.service.BlogUsers;




@Path("/User")
public class UserController {
	private static UserInterface user2 = new BlogUsers();

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)

	
	@Produces(MediaType.TEXT_PLAIN)
	public Response add(User user) {
		System.out.println("Username is "+ user.getUsername());
		System.out.println("password is "+ user.getPassword());
		//user.setUsername("swetang");
		//user.setPassword("2234");
		user2.addUser(user);
		System.out.println("Username after is "+ user.getUsername());
		System.out.println("passwd after is "+ user.getPassword());
		return Response.ok()
				.build();
	
}


	@GET
	@Path("/{username}/Posts")

	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response finduserPost(@PathParam("username") String user1)
	//public Response find(User user4)
	{
		List<Publisher> p1=null;
	System.out.println(user1);
	p1 =(List<Publisher>) user2.finduserPost(user1);
	GenericEntity <List<Publisher>>enty2 = new GenericEntity<List<Publisher>>(p1){};


		return Response.ok(enty2).build();
	} // user method
	
	
	@PUT
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{username}/{oldpassword}/{newpassword}")
	public Response update(@PathParam("username") String u4,@PathParam("oldpassword") String OP4, @PathParam("newpassword") String NP4)
	{
		int y=0;
		System.out.println("userid for delete is " + u4);
		System.out.println("oldpassword for delete is " + OP4);
		
		System.out.println("newpassword for delete is " + NP4);
		y= user2.update(u4,OP4,NP4);
		
		if(y==1){
		String str1="User updated.";
			return Response.ok(str1).build();
		}
			else{
				String str2 = "can't update user";
				return Response.status(304).entity(str2).build();}
		}
		
	
	
	@DELETE
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{username}/{password}")
	public Response delete(@PathParam("username") String u2, @PathParam("password") String p2)
	{  
		int y=0;
	System.out.println("userid for delete is " + u2);
	System.out.println("password for delete is " + p2);
		y= user2.delete(u2,p2);
		
		System.out.println("received y in usercontroller" + y);
		if (y==0)
			//return Response.status(404).entity("can't delete user").build();
			return Response.status(204).build();
		else
			//return Response.ok().entity("user deleted").build();
			return Response.ok().build();
				
		}

	
	

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@QueryParam("username") String user4, @QueryParam("password") String passwd)
	//public Response find(User user4)
	{
		List<Publisher> id2 = null;
	
		System.out.println("User find passowrd= " + passwd);
		
		//System.out.println("User find personid = " + user4.getPersonid());
		System.out.println("User find Userid is = " + user4);
		
		id2 = (List<Publisher>) user2.find(user4,passwd);
		GenericEntity <List<Publisher>>enty1 = new GenericEntity<List<Publisher>>(id2){};
		//String message1 = "found user are " + Integer.toString(deletedUserCount);
		//String failed = "User is not deleted";
			
		
		/*
		switch(id2)
		{
		case 0:
			return Response.ok().status(200).entity("user is found").build();			
			//break;
		case 1:
			return Response.status(401).entity("User not found in DB, please register").build();
		//	break;
		case 2:
			return Response.status(401).entity("password didn't match").build();
			//break;
		default:
			//return Response.ok().status(200).entity("user is found").build();
			return Response.serverError().status(500).build();
			
		}
		*/
		
			
		if(id2==null){
			System.out.println("no data in Usercontroller");
			return Response.status(401).entity("User not found in DB, please register").build();}
		else
			System.out.println("sending response back" + enty1.getEntity());
			return Response.ok(enty1).build(); 
	//	else 
	//	 
		//return Response.status(404).entity(failed).build();
	}
	
	

} //class
