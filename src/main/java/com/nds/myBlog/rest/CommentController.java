package com.nds.myBlog.rest;

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

import com.nds.myBlog.api.*;
import com.nds.myBlog.service.BlogComment;


@Path("/Comments")
public class CommentController {

	
	private static CommentInterface cmintf = new BlogComment();

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response add(Comment cmt_data) {
		//System.out.println("blogpost  before is "+ post_data.getBlogpost());
		//System.out.println("post_title before is "+ post_data.getPosttitle());
		//user.setUsername("swetang");
		//user.setPassword("2234");
		int user_found=	cmintf.addComment(cmt_data);
		//System.out.println("blogpost  after is "+ post_data.getBlogpost());
		//System.out.println("post_title after is "+ post_data.getPosttitle());
		if (user_found==1){
			return Response.ok().entity("comment added").build();}
		else
			return Response.status(401).entity("user is not authorized to create comment or post doesn't exist").build();

	}

	@GET
	//@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{cmtid}")
	public Response findcomment(@PathParam ("cmtid") int cmt1)
	{

			Comment cmts = cmintf.findcomment1( cmt1);
			System.out.println("cmt is " + cmt1);
			System.out.println("commentController.findcomment() cmts: " + cmts.getCommentdata()
			+" cmts "+ cmts.getCommentid());
			
			

			GenericEntity<Comment> enty1 = new GenericEntity<Comment>(cmts){};

			System.out.println("commentController.findcomment() enty1: "+ enty1);
			return Response.ok(enty1).build();

	}



	@DELETE
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{commentId}")
	public Response deleteComment(@PathParam("commentId") int cmt_id)
	{
		int is_deleted =cmintf.deleteComment(cmt_id);
		System.out.println("commentctrl= "+is_deleted);

		if(is_deleted ==0) return Response.ok().entity("Can't delete").build();
		else  return Response.ok().build();


	}


	
}  //class
