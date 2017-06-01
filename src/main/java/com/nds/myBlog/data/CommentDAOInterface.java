package com.nds.myBlog.data;

import com.nds.myBlog.api.Comment;

public interface CommentDAOInterface {
	
	public int CreateComment(Comment cmt1);

	public int removeComment(int commentid);

	public Comment searchComment1(int cmtid);


}
