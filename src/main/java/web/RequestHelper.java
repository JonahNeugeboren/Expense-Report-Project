package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class RequestHelper {

	public static Object processGet(HttpServletRequest request, HttpServletResponse response) {
		final String uri = request.getRequestURI();
		System.out.println("get " + uri);
		if (uri.equals("/ExpenseReportProject/ExpenseReportServlet/LoadTableHelper")) {
			try {
				return LoadTableHelper.try_load_table(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		} else if (uri.equals("/ExpenseReportProject/ExpenseReportServlet/SubmitService")) {
			//making sure any requests from home.html redirect to the right place
			//not sure if this if clause is ever entered
			return  "./views/home.html";
		} else if (uri.equals("/ExpenseReportProject/ExpenseReportServlet/views/home.html")) {
			return  "./views/home.html";
		} else if (uri.equals("/ExpenseReportProject/ExpenseReportServlet/GetUser")) {
			try {
				return GetUserHelper.try_get_user(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
		
		return "No such endpoint or resource: " + uri;
	}
	
	public static void processPost(HttpServletRequest request, HttpServletResponse response) {
		final String uri = request.getRequestURI();
		System.out.println("post " + uri);
		if(uri.equals("/ExpenseReportProject/ExpenseReportServlet")) {
			try {
				LoginHelper.try_login(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else if (uri.equals("/ExpenseReportProject/ExpenseReportServlet/SubmitService")) {
			try {
				SubmitHelper.try_submit(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (uri.equals("/ExpenseReportProject/ExpenseReportServlet/ApproveService")) {
			try {
				ApproveHelper.try_approve_or_deny(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (uri.equals("/ExpenseReportProject/ExpenseReportServlet/UpdateFName")) {
			HttpSession session = request.getSession();
			final int user_id = (Integer) session.getAttribute("user id");
			String update = (String) request.getParameter("nfname");
			UpdateHelper.try_update(user_id, "fname", update);
			try {
				response.sendRedirect("../views/home.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (uri.equals("/ExpenseReportProject/ExpenseReportServlet/UpdateLName")) {
			HttpSession session = request.getSession();
			final int user_id = (Integer) session.getAttribute("user id");
			String update = (String) request.getParameter("nlname");
			UpdateHelper.try_update(user_id, "lname", update);
			try {
				response.sendRedirect("../views/home.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (uri.equals("/ExpenseReportProject/ExpenseReportServlet/UpdateEmail")) {
			HttpSession session = request.getSession();
			final int user_id = (Integer) session.getAttribute("user id");
			String update = (String) request.getParameter("nemail");
			UpdateHelper.try_update(user_id, "email", update);
			try {
				response.sendRedirect("../views/home.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (uri.equals("/ExpenseReportProject/ExpenseReportServlet/UpdatePassword")) {
			HttpSession session = request.getSession();
			final int user_id = (Integer) session.getAttribute("user id");
			String update = (String) request.getParameter("npassword");
			UpdateHelper.try_update(user_id, "password", update);
			try {
				response.sendRedirect("../views/home.html");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (uri.equals("/ExpenseReportProject/ExpenseReportServlet/Logout")) {
			try {
				LogoutHelper.try_logout(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
