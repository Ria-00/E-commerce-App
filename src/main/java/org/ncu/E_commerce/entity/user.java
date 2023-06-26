package org.ncu.E_commerce.entity;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class user {
	
	@NotEmpty(message="Required")
	private String fname;
	private String lname;
	private String username;
	private String pass;
	private String email;
	private String type;
	private Map<String,String> types; 
	
	public user(){
		types=new HashMap<>();
		types.put("Seller", "Customer");
		types.put("Customer", "Seller");
	}
	
	public Map<String, String> getTypes() {
		return types;
	}
	public void setTypes(Map<String, String> types) {
		this.types = types;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "user [fname=" + fname + ", lname=" + lname + ", username=" + username + ", pass=" + pass + ", email="
				+ email + ", type=" + type + "]";
	}
	
	
	
}
