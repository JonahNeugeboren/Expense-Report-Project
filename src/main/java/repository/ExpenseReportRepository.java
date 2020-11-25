package repository;

import java.util.ArrayList;

import models.*;

public abstract class ExpenseReportRepository {

	//interaction with profiles
	public abstract void store_profile(Profile user);
	public abstract void update_profile(Profile user);
	public abstract Profile get_profile(String email, String password);
	
	
	//interaction with reports
	public abstract boolean is_approved(int report_id);
	public abstract Report get_report(int report_id);
	public abstract void insert_report(int user_id, int manager_id, float amount, byte[] image);
	
	public abstract ArrayList<Report> get_reports();
	public abstract ArrayList<Report> get_reports_by_user(Profile user);
	public abstract ArrayList<Report> get_reports_by_manager(Profile manager);
	public abstract void approve_or_deny(int report_id, boolean approved);
	public abstract Profile get_profile_by_id(int user_id);
	
	
}
