package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Profile;
import repository.ExpenseReportRepository;
import repository.ExpenseReportRepositoryImpl;

public class UpdateHelper {

	public static void try_update(int user_id, String to_edit, String update) {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Profile user = rep.get_profile_by_id(user_id);
		System.out.println(update);
		if(to_edit.equals("email")) {
			user.set_email(update);
		} else if(to_edit.equals("password")) {
			user.set_password(update);
		} else if(to_edit.equals("fname")) {
			user.set_fname(update);
		} else if(to_edit.equals("lname")) {
			user.set_lname(update);
		}
		
		rep.update_profile(user);
	}
}
