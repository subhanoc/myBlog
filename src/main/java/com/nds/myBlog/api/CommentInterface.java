package com.nds.myBlog.api;


public interface CommentInterface {
	public int addComment(Comment cmt1);
	public int deleteComment(int cmt_id);
	public Comment findcomment1(int cmtid);

}
