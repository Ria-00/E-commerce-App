package org.ncu.E_commerce.controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ncu.E_commerce.Dao.DaoImp;
import org.ncu.E_commerce.entity.product;
import org.ncu.E_commerce.entity.user;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/user")
public class Usercontroller {
	
		@ModelAttribute("user")
		public user getUserEntity() {
			return new user();
		}
		
		@ModelAttribute("product")
		public product getproductEntity() {
			return new product();
		}
		
		@RequestMapping(value="/insert")
		public String insertForm() {
			return "insert";
		}

		@RequestMapping(value="/insert-process")
		public String insertProcess(@ModelAttribute("user") user u,Model model) {
			try {
				DaoImp d=new DaoImp();
				d.insertUser(u);
				System.out.println("Inserted Successfully");
				return "home";
				
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}	
		}
		
		@RequestMapping(value = "/process")
		public String login(@ModelAttribute("user") user u,HttpServletRequest req, Model model) {
			try {
				DaoImp d = new DaoImp();
				ResultSet rs = d.getUser(u.getUsername());
				String uname = u.getUsername();
				String pass = u.getPass();
				while (rs.next()) {
					if (rs.getString(1).equals(uname) && rs.getString(2).equals(pass)) {
						String type=d.getType(uname);
						HttpSession ses=req.getSession();
						ses.setAttribute("user", uname);
						if (type.toLowerCase().equals("seller")) {
							return "spage";
						} 
						else {
							return "cpage";
						}
					}

				}
				return null;
			} catch (SQLException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

		@RequestMapping(value="/add-product")
		public String addProduct() {
			return "insert-product";
		}
		
		@RequestMapping(value="/add-process")
		public String insertProcess(@ModelAttribute("product") product p,HttpServletRequest req,Model model) {
			try {
				DaoImp d=new DaoImp();
				d.insertProduct(p);
				System.out.println("Inserted Successfully");
				HttpSession ses=req.getSession(false);  
		        String n=(String)ses.getAttribute("user"); 
				ArrayList<product> rs=d.getProducts(n);
				model.addAttribute("list",rs);
				
				return "view-product";
				
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}	
		}
		
		@RequestMapping(value="/seller-view")
		public String view(HttpServletRequest req,Model model) {
			try {
				HttpSession ses=req.getSession(false);  
		        String n=(String)ses.getAttribute("user");  
				DaoImp d=new DaoImp();
				ArrayList<product> rs=d.getProducts(n);
				model.addAttribute("list",rs);
				return "view-product";
				
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}	
		}
		
		@RequestMapping(value="/cust-view")
		public String custview(HttpServletRequest req,Model model) {
			try {
				DaoImp d=new DaoImp();
				ArrayList<product> rs=d.getallProducts();
				model.addAttribute("list",rs);
				return "cart";
				
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}	
		}
		
		@RequestMapping(value="/checkout")
		public String checkout(@ModelAttribute("product") product p,HttpServletRequest req,Model model) {
			try {
				DaoImp d=new DaoImp();
				ArrayList<product> rs=d.checkOut(p.getProducts());
				model.addAttribute("list",rs);
				return "checkout-page";
				
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}	
		}
		
		@RequestMapping(value="/logout")
		public String logout(HttpServletRequest req,Model model) {
			try {
				HttpSession ses=req.getSession(false);
				ses.invalidate();
				return "home";
				
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}	
		}
		
	
}
