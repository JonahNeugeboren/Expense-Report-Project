package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.*;

public class ApproveHelper {
	
	public static void try_approve_or_deny(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int report_id = Integer.parseInt(request.getParameter("id"));
		ExpenseReportRepositoryImpl rep = new ExpenseReportRepositoryImpl();
		
		
		boolean approved = rep.is_approved(report_id);
		rep.approve_or_deny(report_id, !approved);
		response.sendRedirect("../views/home.html");
	}
}
