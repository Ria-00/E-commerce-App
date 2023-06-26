package org.ncu.E_commerce.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.ncu.E_commerce.entity.product;
import org.ncu.E_commerce.entity.user;
import org.ncu.E_commerce.Dao.SqlCon;

public class DaoImp implements DaoUser {

	@Override
	public void insertUser(user m) {
		// TODO Auto-generated method stub
		try {
			SqlCon sql = new SqlCon();
			Connection con = sql.getCon();
			PreparedStatement stmt = con.prepareStatement("insert into users values(?,?,?,?,?,?)");
			stmt.setString(1, m.getFname());// 1 specifies the first parameter in the query
			stmt.setString(2, m.getLname());
			stmt.setString(3, m.getUsername());
			stmt.setString(4, m.getPass());
			stmt.setString(5, m.getEmail());
			stmt.setString(6, m.getType());
			stmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public ResultSet getUser(String username) {
		// TODO Auto-generated method stub
		try {
			SqlCon sql = new SqlCon();
			Connection con = sql.getCon();
			PreparedStatement stmt = con.prepareStatement("select username,password from users where username=?");
			stmt.setString(1, username);
			ResultSet rs=stmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getType(String username) {
		try {
			SqlCon sql = new SqlCon();
			Connection con = sql.getCon();
			PreparedStatement stmt = con.prepareStatement("select category from users where username=?");
			stmt.setString(1, username);
			ResultSet rs=stmt.executeQuery();
			String s;
			while(rs.next()) {
				s=rs.getString(1);
				return s;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertProduct(product p) {
		try {
			SqlCon sql = new SqlCon();
			Connection con = sql.getCon();
			PreparedStatement stmt = con.prepareStatement("insert into products values(?,?,?,?,?,?)");
			stmt.setString(1, p.getSname());// 1 specifies the first parameter in the query
			stmt.setString(2, p.getCategory());
			stmt.setString(3, p.getPname());
			stmt.setString(4, p.getQty());
			stmt.setString(5, p.getDesc());
			stmt.setInt(6, p.getPrice());
			stmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public ArrayList<product> getProducts(String sname) {
		try {
			SqlCon sql = new SqlCon();
			Connection con = sql.getCon();
			PreparedStatement stmt = con.prepareStatement("select * from products where sname=?");
			stmt.setString(1, sname);
			ResultSet rs=stmt.executeQuery();
			ArrayList<product> ar=new ArrayList<>();
			while (rs.next()) {
				product m=new product();
				m.setCategory(rs.getString(2));
				m.setPname(rs.getString(3));
				m.setQty(rs.getString(4));
				m.setDesc(rs.getString(5));
				m.setPrice(rs.getInt(6));
				ar.add(m);
			}
			return ar;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public ArrayList<product> getallProducts() {
		try {
			SqlCon sql = new SqlCon();
			Connection con = sql.getCon();
			PreparedStatement stmt = con.prepareStatement("select * from products");
			ResultSet rs=stmt.executeQuery();
			ArrayList<product> ar=new ArrayList<>();
			while (rs.next()) {
				product m=new product();
				m.setCategory(rs.getString(2));
				m.setPname(rs.getString(3));
				m.setQty(rs.getString(4));
				m.setDesc(rs.getString(5));
				m.setPrice(rs.getInt(6));
				ar.add(m);
			}
			return ar;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public ArrayList<product> checkOut(List<String> pro) {
		try {
			SqlCon sql = new SqlCon();
			Connection con = sql.getCon();
			ArrayList<product> ar=new ArrayList<>();
			PreparedStatement stmt = con.prepareStatement("select pname,price,descp,category from products where pname=?");
			for(String p:pro) {
				stmt.setString(1,p);
				ResultSet rs=stmt.executeQuery();
				while (rs.next()) {
					product m=new product();
					m.setPname(rs.getString(1));
					m.setPrice(rs.getInt(2));
					m.setDesc(rs.getString(3));
					m.setCategory(rs.getString(4));
					ar.add(m);
				}
			}
			return ar;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
