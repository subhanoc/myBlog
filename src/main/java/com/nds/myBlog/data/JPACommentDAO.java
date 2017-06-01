package com.nds.myBlog.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.hibernate.TransientPropertyValueException;

import com.nds.myBlog.api.Comment;

public class JPACommentDAO implements  CommentDAOInterface {

	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.nds.blog");

	
	@Override
	public int CreateComment(Comment cmt1) {
		
	
		EntityManager em = factory.createEntityManager();
		//int temp1 = cmt1.getTemp_postid();
		//String cmt_username = cmt1.getTemp_user();

		//System.out.println("comment postid = "+ temp1);
		//System.out.println("comment username = "+ cmt_username);
		try{
			//Query query1 = em.createQuery("Select username from User  u where u.username  = ?1 " ).setParameter(1, cmt_username);
			//   String result = (String) query1.getSingleResult();
			// System.out.println("username is :" + result);

			//   Query query2 = em.createQuery("Select postid from Publisher p  where p.postid  = ?1 " ).setParameter(1, postid);
			//   int result1 = (int) query2.getSingleResult();
			//    System.out.println("postid is :" + result1);


			em.getTransaction().begin();
			//  em.flush();

			// User u2 = new User();
			// u2.setUsername(cmt_username);
			//  cmt1.setUname1(u2);

			//Publisher p1 = new Publisher();
			//p1.setPostid(temp1);
			//cmt1.setIdpost(p1);

			em.persist(cmt1);
			em.getTransaction().commit();
			em.close();


			return 1;
		}catch (NoResultException e) {
			System.out.println("in comment exception");
			return 0;}catch (TransientPropertyValueException te){te.printStackTrace(); return 0;}

		
	}

	@Override
	public int removeComment(int commentid) {
		EntityManager em = factory.createEntityManager();

		int i=0;





		try{


			em.getTransaction().begin();
			//System.out.println(" in db:" + c1 );
			System.out.println(" in request:" + commentid );

			Comment cmmt = em.find(Comment.class, commentid);
			System.out.println("comment  to remove is " + cmmt.getCommentdata());
			em.remove(cmmt);
			em.getTransaction().commit();
			em.close();
			i=1;
		}catch (NullPointerException e) {
			System.out.print("Caught the NullPointerException");i=0;

		}
		System.out.println("JPACommentDAO  = "+i );



		return i;

	
	}

	@Override
	public Comment searchComment1(int cmtid) {
	
		System.out.println("JPAComment Cmtid " + cmtid);
		Comment lstcmt = null;

		try{
			EntityManager em = factory.createEntityManager();
			//TypedQuery<Comment> q22 = em.createQuery("select c  from Comment c where commentid = ?1",Comment.class).setParameter(1, cmtid);
			em.getTransaction().begin();
			lstcmt=	em.find(Comment.class, cmtid);
			em.getTransaction().commit();
			em.close();
		//	System.out.println("lstcmt is " + lstcmt.getIdpost().getPostid());

		}
		catch(Exception e){
			e.printStackTrace();
		}

		return lstcmt;
	}
	
	}


