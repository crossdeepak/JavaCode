package com.cg.bean;

public class Communication {
	private String userName,communication;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCommunication() {
		return communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((communication == null) ? 0 : communication.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Communication other = (Communication) obj;
		if (communication == null) {
			if (other.communication != null)
				return false;
		} else if (!communication.equals(other.communication))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Communication [userName=" + userName + ", communication=" + communication + "]";
	}

	public Communication(String userName, String communication) {
		super();
		this.userName = userName;
		this.communication = communication;
	}

	public Communication(String communication) {
		super();
		this.communication = communication;
	}
	
}
