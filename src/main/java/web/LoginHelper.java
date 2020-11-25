package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.*;
import repository.*;

public class LoginHelper {
	
	public static void try_login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String email = request.getParameter("username");
		final String password = request.getParameter("password");
		
		ExpenseReportRepositoryImpl rep = new ExpenseReportRepositoryImpl();
		Profile prof = rep.get_profile(email, password);

		
		if(prof != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user email", email);
			session.setAttribute("user password", password);
			session.setAttribute("user id" , prof.get_user_id());
			session.setAttribute("user fname", prof.get_fname());
			session.setAttribute("user lname", prof.get_lname());
			session.setAttribute("user manager", prof.get_manager_id());
			session.setAttribute("user type", prof.get_type());
			
			response.sendRedirect("./views/home.html");
		}
	}
}
