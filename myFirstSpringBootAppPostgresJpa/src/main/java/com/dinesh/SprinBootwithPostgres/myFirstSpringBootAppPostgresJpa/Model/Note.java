package com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StickyNotes")
public class Note {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
    @Column(name = "title")
	private String title;
    
    @Column(name = "subject")
	private String subject;
    
    @Column(name = "content")
	private String content;
	
	
	
	public Note() {
		super();
	}
	
	public Note(String title, String subject, String content) {
		super();
		this.title = title;
		this.subject = subject;
		this.content = content;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	

}
