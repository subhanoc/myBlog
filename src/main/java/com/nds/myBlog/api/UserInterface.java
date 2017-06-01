package com.nds.myBlog.api;

import java.util.List;


public interface UserInterface {
	
	public void addUser(User user);

	public int delete(String user3, String password3);

	public List<Publisher> find(String user4, String passwd);

	public List<Publisher>  finduserPost(String user1);

	public int update(String u4, String OP4, String NP4);


}
