package com.WebApplication.WebApplication;

public class LoginData {
	
	@NotBlank(message="UserName cannot be null")
	@Size(min=3,max=10,message="UserName btn 3 to 10 character")
	private String userName;
	private String email;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	
	
	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", email=" + email + "]";
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	
}
