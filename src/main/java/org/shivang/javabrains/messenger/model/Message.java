package org.shivang.javabrains.messenger.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {

	private long id;
	private String message;
	private Date created;
	private String author;
	
	private Map<Long,Comments> comments=new HashMap<>();
	
	public Message(){
		
	}
	
	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created=new Date();
		
		this.comments.put(1L,new Comments(1,"Comment 1",this.author));
		this.comments.put(2L,new Comments(2,"Comment 2",this.author));
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	
	@XmlTransient
	public Map<Long, Comments> getComments() {
		return comments;
	}

	public void setComments(Map<Long, Comments> comments) {
		this.comments = comments;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
