package com.banking.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.banking.model.User;

@Entity
public class Requests {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;
	private Date date;
	private String requestType;
	private String requestDiscription;
	private boolean accept;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Requests() {
		// TODO Auto-generated constructor stub
	}



	public int getRequestId() {
		return requestId;
	}



	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getRequestType() {
		return requestType;
	}



	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}



	public String getRequestDiscription() {
		return requestDiscription;
	}



	public void setRequestDiscription(String requestDiscription) {
		this.requestDiscription = requestDiscription;
	}



	public boolean isAccept() {
		return accept;
	}



	public void setAccept(boolean accept) {
		this.accept = accept;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "Requests: requestId=" + requestId + ", date=" + date + ", requestType=" + requestType
				+ ", requestDiscription=" + requestDiscription + ", accept=" + accept + ", user=" + user + "";
	}
	
	


}
