package com.nds.myBlog.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.nds.myBlog.api.Publisher;

public class JPAPublisherDAO implements PublisherDAOInterface{

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.nds.blog");

	@Override
	public int createPost(Publisher publisher) {

		System.out.println(publisher.getBlogpost() + publisher.getPosttitle());
		EntityManager em = factory.createEntityManager();
		
	//String temp1=	publisher.getTemp_name();
		//User  publisher_username=  publisher.setUname(publisher.getUname());
	//	System.out.println("this is publisher_username" +  publisher_username.getUsername());
		// String publisher_username = "sam";
		
		try{
			//Query query1 = em.createQuery("Select username from User  u where u.username  = ?1 " ).setParameter(1, publisher_username);
		 //     String result = (String) query1.getSingleResult();
		  //    System.out.println("username is :" + result);
		    
		     
			System.out.println("in publisherDAO");
			    
		em.getTransaction().begin();
	//	em.flush();
	//	User user1 = new User();
		// user1.setUsername(temp1);
	//	publisher.setUname(user1);
		em.persist(publisher);
		em.getTransaction().commit();
		em.close();
		return 1;
		} 
		catch (NoResultException e) {
			System.out.println("in posts DAO exception");
		      return 0;}
		
		
		
	}

	@Override
	public int removePost(int post1) {
		
		int y =0;
		EntityManager em = factory.createEntityManager();
		Publisher pbl = em.find(Publisher.class, post1);
		
		if(pbl!=null){
			try{
				int c1 = pbl.getPostid();
				
				System.out.println(" in db:" + c1 );
				System.out.println(" in request:" + post1 );
			  em.getTransaction().begin();
			  em.remove(pbl);
			  em.getTransaction().commit();
			  em.close();
			  y=1;
			}catch (NullPointerException e) {
				  System.out.print("Caught the NullPointerException");y=0;

			}
			System.out.println("JPAPublishserDAO  = "+y );
			
		
		}
		
		return y;

	}

	@Override
	public List<Publisher> SearchPost(String postTitle) {
		
		String ps = postTitle;
		ps ="%"+ps+"%";
	List<Publisher> p11 =null;
	List<Publisher> l1 =null;
	
	Publisher p12 =null;
	
	EntityManager em = factory.createEntityManager();
	
		try{
			
			em.getTransaction().begin();
			
			TypedQuery<Publisher> q22 = em.createQuery("select p  from Publisher p where posttitle like ?1",Publisher.class).setParameter(1, ps);
			//TypedQuery<Publisher> q22 = em.createQuery("select p  from Publisher p where posttitle like ?1",Publisher.class).setParameter(1, ps);
			//TypedQuery<Publisher> q22 = em.createQuery("select p  from Publisher p left outer join Comment ct on ct.idpost =p.postid where posttitle like ?1",Publisher.class).setParameter(1, ps);
			//Query q22 = em.createQuery("select p from Publisher p where postid =1");
			p11 =   q22.getResultList();
			//p12 = em.find(Publisher.class, postTitle);
			
			
			
		//	System.out.println("size is " + p11.size());
			 
			// l1 = new ArrayList<Publisher>();
			
			
			//List<Comment> c = (List<Comment>) p12.getComments();
		//   System.out.println(c);
		    
		
		//em.persist(postTitle);
		em.getTransaction().commit();
		em.close();
		System.out.println(p11);
		
	//	List<Publisher> p22 = new  ArrayList<Publisher>();
		
	/*
		for(Publisher ent : p12){
			System.out.println(ent.getBlogpost());
			
			System.out.println(ent.getPosttitle());
			
			System.out.println(ent.getUname());
			//System.out.println(ent.getTemp_name());
			
			//System.out.println(ent.getComments());
			System.out.println(ent.getCreatedDate());
			System.out.println(ent.getPostid());
			
			
			
			}  
		*/
		
		//System.out.println(p12.getBlogpost());
		//System.out.println("Comments are -:" +p12.getComments());
		
		} 
		catch (NoResultException e) {
			System.out.println("in posts DAO exception");}
		     // return  Collections.EMPTY_LIST;}
		
		catch(Exception e){e.printStackTrace();
		//if(em !=null){em.getTransaction().rollback();}
		}
		
		// finally{ if(em ==null) em.close();}
		return   p11;
	}  //find

		
		
	}


