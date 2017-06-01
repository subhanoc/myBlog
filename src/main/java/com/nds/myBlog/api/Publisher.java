package com.nds.myBlog.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="posts")
public class Publisher {

	@Id
	@Column(name="postid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int postid;
	
	@Column(name="Date")
	private Date createdDate = new Date();

	
	@Column(name="posttitle")
	private String posttitle;
	
	@Column(name="blogpost")
	private String blogpost;

	
	@ManyToOne 
	@JoinColumn(name="username", nullable=false)
	private User uname ; 
		
	
	

@OneToMany( fetch=FetchType.EAGER, mappedBy="postid1")
//////@OneToMany
//////@JoinColumn(name="postid",referencedColumnName="postid")
	private Collection<Comment> comments= new ArrayList<Comment>();

	
	public int getPostid() {
		return postid;
	}



	public void setPostid(int postid) {
		this.postid = postid;
	}



	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public String getPosttitle() {
		return posttitle;
	}



	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}



	public String getBlogpost() {
		return blogpost;
	}



	public void setBlogpost(String blogpost) {
		this.blogpost = blogpost;
	}



	public User getUname() {
		return uname;
	}



	public void setUname(User uname) {
		this.uname = uname;
	}



	public Collection<Comment> getComments() {
		return comments;
	}



	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}



	


public Publisher(){}
	
}
