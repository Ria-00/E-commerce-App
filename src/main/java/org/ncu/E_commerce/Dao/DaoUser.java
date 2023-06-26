package org.ncu.E_commerce.Dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.ncu.E_commerce.entity.product;
import org.ncu.E_commerce.entity.user;

public interface DaoUser {

	public void insertUser(user u);
	public ResultSet getUser(String username);
	public String getType(String username);
	public void insertProduct(product p);
	public ArrayList<product> getProducts(String sname);
	public ArrayList<product> getallProducts();
	public ArrayList<product> checkOut(List<String> pro);
	
}
