package com.nds.myBlog.service;

import java.util.List;

import com.nds.myBlog.api.*;
import com.nds.myBlog.data.JPAUserDAO;
import com.nds.myBlog.data.UserDAOInterface;




public class BlogUsers implements UserInterface {

	private UserDAOInterface userdao = new JPAUserDAO();


	
	public void addUser(User user)  {
		if(user.getUsername()==null)
			System.out.println("username received is null");
		
		// TODO Auto-generated method stub
		System.out.println("in blogUsers");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		//user.setPassword(user.password);
		
      userdao.createUser(user);
	}

	
	public int delete(String user3,String password3) {
		
		int	y= userdao.deleteUser(user3,password3);
			
		return y;
		}

	
	public List <Publisher> find(String user4, String passwd4) {
		//List<Object> id2=null;
		List<Publisher> p2 = null;
	
		//System.out.println("Blog User find passowrd= " + user4.getPassword());
		//System.out.println("Blog User find Userid = " + user4.getUsername());
				
			//id2=	(List<Object>) userdao.FindUser(user4,passwd4);
		p2=	(List<Publisher>) userdao.FindUser(user4,passwd4);
		
		System.out.println("-----------------------");
		
			for(Publisher i:p2){
				System.out.println(i.getPosttitle());
				System.out.println(i.getBlogpost());
			}
			System.out.println("Id2 in blog is = " + p2);
				return p2;
		
	}
	
	public List<Publisher> finduserPost(String user1)
	{
		List<Publisher> p1 = null;
p1=	(List<Publisher>) userdao.finduserPost(user1);
		
		System.out.println("-----------------------");
		
			for(Publisher i:p1){ 
				System.out.println(i.getPosttitle());
				System.out.println(i.getBlogpost());
			}
			System.out.println("p1 in blog is = " + p1);
				return p1;
		
	
	}


	@Override
	public int update(String u4, String OP4, String NP4) {
		
		int	y= userdao.updateUser(u4,OP4,NP4);
		
		return y;
	}

	

}//class
