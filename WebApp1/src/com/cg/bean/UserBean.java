package com.cg.bean;

import java.util.List;

public class UserBean {
	private String userName,firstName,lastName,password,email,mobileNo,gender,resumeFile,password1,graduation;
	private List<String>communication;
	public UserBean(String userName, String firstName, String lastName, String password, String email, String mobileNo,
			String gender, String resumeFile, List<String> communication) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.resumeFile = resumeFile;
		this.communication = communication;
	}
	@Override
	public String toString() {
		return "UserBean [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", email=" + email + ", mobileNo=" + mobileNo + ", gender=" + gender + ", resumeFile="
				+ resumeFile + ", password1=" + password1 + ", graduation=" + graduation + ", communication="
				+ communication + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((communication == null) ? 0 : communication.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((graduation == null) ? 0 : graduation.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((password1 == null) ? 0 : password1.hashCode());
		result = prime * result + ((resumeFile == null) ? 0 : resumeFile.hashCode());
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
		UserBean other = (UserBean) obj;
		if (communication == null) {
			if (other.communication != null)
				return false;
		} else if (!communication.equals(other.communication))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (graduation == null) {
			if (other.graduation != null)
				return false;
		} else if (!graduation.equals(other.graduation))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (password1 == null) {
			if (other.password1 != null)
				return false;
		} else if (!password1.equals(other.password1))
			return false;
		if (resumeFile == null) {
			if (other.resumeFile != null)
				return false;
		} else if (!resumeFile.equals(other.resumeFile))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getResumeFile() {
		return resumeFile;
	}
	public void setResumeFile(String resumeFile) {
		this.resumeFile = resumeFile;
	}
	public List<String> getCommunication() {
		return communication;
	}
	public void setCommunication(List<String> communication) {
		this.communication = communication;
	}
	public UserBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public UserBean(String userName, String firstName, String lastName, String password, String gender,
			String password1, String graduation, List<String> communication) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.gender = gender;
		this.password1 = password1;
		this.graduation = graduation;
		this.communication = communication;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getGraduation() {
		return graduation;
	}
	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	
}
