package com.nds.myBlog.rest;
import javax.ws.rs.core.Response;

import javax.ws.rs.ext.ExceptionMapper;

public class MyApplicationExceptionHandler implements ExceptionMapper<MyApplicationException>{

	@Override
	public Response toResponse(MyApplicationException exception) {
		 
		System.out.println("in MyApplication Exception");
		exception.printStackTrace();
		
		return Response.status(500).entity(exception.getMessage()).build(); 	
	
	}

}
