package web;

import repository.*;
import models.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoadTableHelper {
	
	public static ArrayList<Report> try_load_table(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		final int user_id = (Integer) session.getAttribute("user id");
		final int manager_id = (Integer) session.getAttribute("user manager");
		final String email = (String) session.getAttribute("user email");
		final String password = (String) session.getAttribute("password");
		final String fname = (String) session.getAttribute("user fname");
		final String lname = (String) session.getAttribute("user lname"); 
		final String type = (String) session.getAttribute("user type");
		
		Profile user = new Profile(user_id, manager_id, type, password, email, fname, lname);
		
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		ArrayList<Report> result = null;
		
		if(type.equals("manager")) {
			result = rep.get_reports_by_manager(user);
		} else if (type.equals("employee")) {
			result = rep.get_reports_by_user(user);
		}
		

		return result;
	}
}
