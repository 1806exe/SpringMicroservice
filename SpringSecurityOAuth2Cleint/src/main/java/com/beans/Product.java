package com.beans;

import java.util.List;

public class Product {
	
	private int prod_id;
	private String prod_name;
	List<User> users;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int prod_id, String prod_name, List<User> users) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.users = users;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Product [prod_id=" + prod_id + ", prod_name=" + prod_name + ", users=" + users + "]";
	}
	
	

}
