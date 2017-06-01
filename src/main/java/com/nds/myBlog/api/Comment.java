package com.nds.myBlog.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="comment")
public class Comment {

	
	@Id
	@Column(name="commentid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int commentid;
	
	@Column(name="commentdata")
	private String commentdata;
	
	
	@ManyToOne
	@JoinColumn(name="postid", nullable=false)
	private Publisher postid1;
	
	
	//private int postid;
	
	
	public Publisher getPostid1() {
		return postid1;
	}


	public void setPostid1(Publisher postid1) {
		this.postid1 = postid1;
	}


	public Comment(){}


	public int getCommentid() {
		return commentid;
	}




	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}




	public String getCommentdata() {
		return commentdata;
	}




	public void setCommentdata(String commentdata) {
		this.commentdata = commentdata;
	}


	



	
}


	
	





	



	
