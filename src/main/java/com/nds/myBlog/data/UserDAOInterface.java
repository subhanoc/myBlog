package com.nds.myBlog.data;

import java.util.List;

import com.nds.myBlog.api.Publisher;
import com.nds.myBlog.api.User;


public interface UserDAOInterface {
	
	public void createUser(User user) ;

	public int deleteUser(String user3, String password3);
	
	public List<Publisher> FindUser(String user4, String passwd);

	public List<Publisher> finduserPost(String user1);

	public int updateUser(String u4, String OP4, String NP4);


}
