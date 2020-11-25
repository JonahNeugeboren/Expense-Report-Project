package web;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import repository.*;
import models.*;

public class SubmitHelper {
	
	public static void try_submit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		final int user_id = (Integer) session.getAttribute("user id");
		final int manager_id = (Integer) session.getAttribute("user manager");
		//final float amount = Float.parseFloat(request.getParameter("amount"));
		float amount = 0;
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		FileItem image;
		byte[] tmp = null;
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem item : items) {
				if(item.getFieldName().equals("file")) {
					image = item;
					tmp = image.get();
				} else if (item.getFieldName().equals("amount")) {
					amount = Float.parseFloat(item.getString());
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		
		
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		rep.insert_report(user_id, manager_id, amount, tmp);
		
		//System.out.println("Submitted: " + amount);
		
		response.sendRedirect("../views/home.html");
	}
}
