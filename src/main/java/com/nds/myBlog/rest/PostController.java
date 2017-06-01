package com.nds.myBlog.rest;

import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nds.myBlog.api.Publisher;
import com.nds.myBlog.api.PublisherInterface;
import com.nds.myBlog.service.BlogPublisher;



@Path("/Posts")
public class PostController {
	
	private static PublisherInterface post1 = new BlogPublisher();
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response add(Publisher post_data) throws MyApplicationException {
		System.out.println("blogpost  before is "+ post_data.getBlogpost());
		System.out.println("post_title before is "+ post_data.getPosttitle());
		//user.setUsername("swetang");
		//user.setPassword("2234");
		//throw new MyApplicationException();
		int usr_fnd =post1.addPost(post_data);
		
		System.out.println("blogpost  after is "+ post_data.getBlogpost());
	System.out.println("post_title after is "+ post_data.getPosttitle());
		
		if (usr_fnd==1)
		return Response.ok().entity("user is found").build();
		else
		return Response.status(401).entity("can't add post, you are not authorized to add post").build();
	
	
	}// add
	

	
	@GET
	//@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{title}")
	public Response findPost(@PathParam("title") String title1) throws MyApplicationException
	{
		//List<Publisher> title_post = null;
		System.out.println("title to search is "+ title1);
	List<Publisher>	title_post1 =  post1.findPost(title1);
		//title_post1 = Arrays.asList(title_post1);
	    System.out.println( "Size in controller is "+title_post1.size());

		if(title_post1.isEmpty()){
			//JsonObject json1 = Json.createObjectBuilder().add("Posts","Not Found" ).build();
		 return	Response.status(204).build(); 
			//throw new MyApplicationException();
		}
		

	    try{	
	    	
	    	
		GenericEntity<List<Publisher>> enty1 = new GenericEntity<List<Publisher>>(title_post1){};
		System.out.println("Enty"+enty1.getType());
		System.out.println("Enty=   "+enty1.getEntity()); 
		return  Response.ok(enty1).build();
	    } catch(Exception e){e.printStackTrace();
	    
	    throw new MyApplicationException();
	    // return Response.serverError().build();
	    }
		
		
	
		
	}
	
	
 @DELETE
 @Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
 @Path("/{postid1}")
 public Response deletePost(@PathParam("postid1") int postid)
 {  int y=0;
 System.out.println("postid for delete is " + postid);
 	y= post1.deletePost(postid);
	
 	if (y==0)
 		return Response.status(404).entity("can't delete post").build();
 	else
 		return Response.ok().entity("post deleted").build();
 			
 			
	 
	 
 }
	
	
} //class
