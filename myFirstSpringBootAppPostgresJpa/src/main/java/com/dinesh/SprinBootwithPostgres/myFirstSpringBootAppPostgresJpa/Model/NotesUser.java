package com.dinesh.SprinBootwithPostgres.myFirstSpringBootAppPostgresJpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name="NoteUser")
public class NotesUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long noteUserId;
	
	@Column(name="noteUser")
	private String noteUserName;
	
	@Column(name="age")
	private int age;

	public NotesUser() {
		super();
	}

	public NotesUser(long noteUserId, String noteUserName, int age) {
		super();
		this.noteUserId = noteUserId;
		this.noteUserName = noteUserName;
		this.age = age;
	}

	public long getNoteUserId() {
		return noteUserId;
	}

	public void setNoteUserId(long noteUserId) {
		this.noteUserId = noteUserId;
	}

	public String getNoteUserName() {
		return noteUserName;
	}

	public void setNoteUserName(String noteUserName) {
		this.noteUserName = noteUserName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
