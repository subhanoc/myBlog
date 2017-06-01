package com.nds.myBlog.api;

import java.util.List;


public interface PublisherInterface {

	public int addPost(Publisher publisher);

	public int deletePost(int postid);

	//public List<Publisher> findPost(String postTitle) throws PostsException , PostNotFound;

	public List<Publisher> findPost(String postTitle) ;
}
