package com.nds.myBlog.data;

import java.util.List;

import com.nds.myBlog.api.Publisher;


public interface PublisherDAOInterface {
	
	public int createPost(Publisher publisher);

	public int removePost(int post1);

	public List<Publisher> SearchPost(String postTitle);


}
