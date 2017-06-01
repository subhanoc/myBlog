package com.nds.myBlog.service;

import java.util.List;

import com.nds.myBlog.api.*;
import com.nds.myBlog.data.*;



public class BlogPublisher implements PublisherInterface {
	private PublisherDAOInterface publisherdao = new JPAPublisherDAO();

	public int addPost(Publisher publisher) {
		// TODO Auto-generated method stub
		//System.out.println("In blogpublisher post is::" + publisher.getBlogpost());
		//System.out.println("In blogpublisher title:: "+publisher.getPosttitle());
		//System.out.println("User is: "+publisher.getUsername());
		//user.setPassword(user.password);
		//User u = new User();String s = u.getUsername();
		//publisher.setUsername(s);
		
   int user_fnd=   publisherdao.createPost(publisher);
   return user_fnd;

	}

	public int deletePost(int post1) {
	  int y=0;
		
		y= publisherdao.removePost(post1);
		return y;
	}

public  List<Publisher> findPost(String postTitle) {
		
		List<Publisher> title_posts = null;
		
		 System.out.println("in findPost of Blog publisher");
		title_posts = publisherdao.SearchPost(postTitle);
		
		System.out.println("in Blog title_post size is "+title_posts.size());
	//	title_posts.toArray();
		 return title_posts;
		 
	}

	
}//class
