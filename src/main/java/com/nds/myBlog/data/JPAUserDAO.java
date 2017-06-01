 package com.nds.myBlog.data;

import java.util.Collections;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.nds.myBlog.api.Publisher;
import com.nds.myBlog.api.User;

public class JPAUserDAO implements UserDAOInterface {

	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.nds.blog");

	@Override
	public void createUser(User user) {
		
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();

		
	}
	
	@Override
	public int updateUser(String u4, String OP4, String NP4) {
		int z=0;
		
		try{
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			
			Query query1 = em.createQuery("Select u from User  u where u.username  = ?1 " ).setParameter(1,u4);
			User u1 = (User) query1.getSingleResult();
			//String tmp_uname= u1.getUsername();
			String tmp_passwd= u1.getPassword();
			
			if (tmp_passwd.equals(OP4))
			{
			int q2 = em.createQuery("update User u set u.password = ?1 where u.username= ?2").setParameter(1, NP4).setParameter(2, u4).executeUpdate();
				z=1;
				
				em.getTransaction().commit();
				em.close();
				
			}
		}
			catch(NoResultException n){n.printStackTrace(); z=0;}
			catch(Exception e){e.printStackTrace();z=0;}
		return z;
	}
	
	

	@Override
	public int deleteUser(String user3, String password3) {
		
		int z=0;
		System.out.println("jPA user delete user is "+ user3);
		
		try{
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Query query1 = em.createQuery("Select u from User  u where u.username  = ?1 " ).setParameter(1,user3);
		
		 
		User u1 = (User) query1.getSingleResult();
		String tmp_uname= u1.getUsername();
		String tmp_passwd= u1.getPassword();
		
		
		
		
		if((tmp_uname.equals(user3)) && (tmp_passwd.equals(password3)) )
		{

			 em.createQuery("delete  from Publisher p where username like ?1").setParameter(1, tmp_uname).executeUpdate();
	
			em.remove(u1);
		
		em.getTransaction().commit();
		em.close();
		z=1;
		}
		else z=0;
		} // if
		catch(NoResultException n){n.printStackTrace(); z=0;}
		catch(Exception e){e.printStackTrace();z=0;}
		
		System.out.println("JPA delete user z is " + z);
		return z;
				
	
	
	}

	@Override
	public List<Publisher> FindUser(String user4, String passwd) {
		Object finduser6 = null;
		String db_password = null;
		String db_uname=null;
		String passwd1;
		String uname1;
		Object obj=null;
		List <Publisher> results=null;
		int id2 =0;
		
		//System.out.println("passwd1=" + passwd1 + "uname1="+ uname1);
		// TODO Auto-generated method stub
		EntityManager em = factory.createEntityManager();
	
		try{
		// finduser6 = em.createQuery("Select c from User c where Username like ?1 ").setParameter(1, user4.getUsername()).getSingleResult();
		
		 
			em.getTransaction().begin();
		User findUser1=	em.find(User.class,user4);
			//em.getTransaction().commit();
			//em.close();
		
			passwd1 = passwd;
			uname1 = user4;
			
			db_uname = findUser1.getUsername();
			 db_password = findUser1.getPassword();
			System.out.println("DB user name = " + findUser1.getUsername());
			System.out.println("DB password = " + findUser1.getPassword());
			
			
			
			if(db_password.equals(passwd1)){
				id2=0; System.out.println("login allowed");
				
			

				TypedQuery<Publisher> q2 = em.createQuery("select p  from Publisher p where username like ?1",Publisher.class).setParameter(1, db_uname);
			 results = q2.getResultList();
			//obj= results.toArray();
			System.out.println("size is " + results.size());
			
			for(Publisher ent : results){
			System.out.println(ent.getBlogpost());
			System.out.println(ent.getPosttitle());
				
			} // for
			
			
			em.getTransaction().commit();
			em.close();
			
			
			} // uname and password matched
			else{ id2=2; System.out.println("no login , passowrkd worng");}  // password doesn't match.
			
			
		}
		catch(NoResultException e)
		{
			e.printStackTrace();
			System.out.println("Doesn't match");
			id2 =1; // no user found
			}
		catch(NullPointerException enull){enull.printStackTrace(); id2=1;}
		
		
	
	//em.getTransaction().begin();
		//em.find(User.class,user4.getPersonid());
	//	em.getTransaction().commit();
	//	em.close();
		
		return results;
	
	}

	@Override
	public List<Publisher> finduserPost(String user1) {
		
		List<Publisher> p1 =null;
		
		EntityManager em = factory.createEntityManager();
		
		try{
		
		 
			em.getTransaction().begin();
			User findUser1=	em.find(User.class,user1);
			//System.out.println("User found in JPADAO :" +findUser1.getUsername());
			
			if(findUser1.getUsername() != null)
			{
				TypedQuery<Publisher> q22 = em.createQuery("select p  from Publisher p where username like ?1",Publisher.class).setParameter(1, findUser1.getUsername());
				 p1 = q22.getResultList();
				//obj= results.toArray();
				System.out.println("size is " + p1.size());
				
				if(p1.size()==0){ return p1;}
				
				for(Publisher ent : p1){
				System.out.println(ent.getBlogpost());
				System.out.println(ent.getPosttitle());
					
				} // for
				
				
				em.getTransaction().commit();
				em.close();
				
				
				} // uname and password matched
				else{ System.out.println("no login , passowrkd worng"); return p1;}  // password doesn't match.
				
			} // if user ! nulll
		catch(NoResultException e)
		{
			e.printStackTrace();
			System.out.println("Doesn't match");
			// no user found
			}
		catch(NullPointerException enull){
			System.out.println("In User DAO null pointer");
			enull.printStackTrace(); 
			p1 = Collections.emptyList();
			 }
		
	
		return p1;
			
			
	

	
	}




	

}
