package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Profile;

public class GetUserHelper {
	
	public static Profile try_get_user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		final int user_id = (Integer) session.getAttribute("user id");
		final int manager_id = (Integer) session.getAttribute("user manager");
		final String email = (String) session.getAttribute("user email");
		final String password = (String) session.getAttribute("user password");
		final String type = (String) session.getAttribute("user type");
		final String fname = (String) session.getAttribute("user fname");
		final String lname = (String) session.getAttribute("user lname");
		return new Profile(user_id, manager_id, type, password, email, fname, lname);
	}
}
