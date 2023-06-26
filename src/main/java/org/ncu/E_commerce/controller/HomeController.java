package org.ncu.E_commerce.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ncu.E_commerce.Dao.DaoImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.ncu.E_commerce.entity.user;

@Controller

public class HomeController {

	@ModelAttribute("user")
	public user getUserEntity() {
		return new user();
	}

	@RequestMapping(value = "/")
	public ModelAndView test(HttpServletResponse response) throws IOException {
		return new ModelAndView("home");
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

}
