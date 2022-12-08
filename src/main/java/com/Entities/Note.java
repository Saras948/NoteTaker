package com.Entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="notes")
public class Note {
	
	@Id
	private int Nid;
	private String Title;
	
	@Column(length=2000)
	private String content;
	
	private Date aadeddate;

	public int getNid() {
		return Nid;
	}

	public void setNid(int nid) {
		Nid = nid;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getAadeddate() {
		return aadeddate;
	}

	public void setAadeddate(Date aadeddate) {
		this.aadeddate = aadeddate;
	}

	public Note(String title, String content, Date aadeddate) {
		super();
		Nid = new Random().nextInt(1000000);
		Title = title;
		this.content = content;
		this.aadeddate = aadeddate;
	}

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
