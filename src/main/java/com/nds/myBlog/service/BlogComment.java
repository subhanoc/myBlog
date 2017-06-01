package com.nds.myBlog.service;

import com.nds.myBlog.api.*;
import com.nds.myBlog.data.*;

public class BlogComment implements CommentInterface {

	
	private static CommentDAOInterface cmtdao = new JPACommentDAO();
	@Override
	public int addComment(Comment cmt1) {
		// TODO Auto-generated method stub
		int user_found = cmtdao.CreateComment(cmt1);
		System.out.println("user found(comments) = " + user_found);
	return user_found;
	}

	@Override
	public int deleteComment(int cmt_id) {
		
	int is_deleted=	cmtdao.removeComment(cmt_id);
	System.out.println("blogcomment = "+is_deleted);
		
		return is_deleted;
		
	}
	
	public Comment findcomment1(int cmtid) {
		
			Comment lstcmt = cmtdao.searchComment1(cmtid);
	//	System.out.println("blogcomment post id is  = "+lstcmt.getIdpost().getPostid());
		System.out.println("blogcomment comment  id is  = "+lstcmt.getCommentid());
		System.out.println("blogcomment comment data is  = "+lstcmt.getCommentdata());
		System.out.println("blogcomment class  is  = "+lstcmt.getClass());
		return lstcmt;
			
		}

	
	
	
} //class
