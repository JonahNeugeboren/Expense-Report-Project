package tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;

import web.*;
import models.*;
import repository.ExpenseReportRepository;
import repository.ExpenseReportRepositoryImpl;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

public class Tests {
	Profile p;
	Profile p3;
	Report r;
	
	@Before
	public void before() {
		/*
		 * We need to initialize our Mocks using the static init mocks methods
		 */
		MockitoAnnotations.openMocks(this);
		p = Mockito.mock(Profile.class);
		when(p.get_email()).thenReturn("jonah.neugeboren@revature.net");
		when(p.get_fname()).thenReturn("Jonah");
		when(p.get_lname()).thenReturn("Neugeboren");
		when(p.get_manager_id()).thenReturn(1);
		when(p.get_user_id()).thenReturn(1);
		when(p.get_password()).thenReturn("pass");
		when(p.get_type()).thenReturn("manager");
		
		p3 = Mockito.mock(Profile.class);
		when(p.get_email()).thenReturn("jonahneugeboren@gmail.com");
		when(p.get_fname()).thenReturn("nonah");
		when(p.get_lname()).thenReturn("jeugeboren");
		when(p.get_manager_id()).thenReturn(1);
		when(p.get_user_id()).thenReturn(2);
		when(p.get_password()).thenReturn("pass");
		when(p.get_type()).thenReturn("employee");
		
		r = Mockito.mock(Report.class);
		when(r.get_amount()).thenReturn((float) 100);
		when(r.get_approved()).thenReturn(false);
		when(r.get_manager_id()).thenReturn(1);
		when(r.get_user_id()).thenReturn(1);
		when(r.get_report_id()).thenReturn(1);
		
	}
	
	@Test
	public void testLoginGetUserEmail() {
		
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Profile p2 = rep.get_profile(p.get_email(), p.get_password());
		assertEquals(p2.get_email(), p.get_email());
	}
	
	@Test
	public void testLoingGetUserFName() {
		
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Profile p2 = rep.get_profile(p.get_email(), p.get_password());
		assertEquals(p2.get_fname(), p.get_fname());
	}
	
	@Test
	public void testLoingGetUserLName() {
		
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Profile p2 = rep.get_profile(p.get_email(), p.get_password());
		assertEquals(p2.get_lname(), p.get_lname());
	}
	
	@Test
	public void testLoingGetUserType() {
		
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Profile p2 = rep.get_profile(p.get_email(), p.get_password());
		assertEquals(p2.get_type(), p.get_type());
	}
	
	@Test
	public void testLoingGetUserManagerId() {
		
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Profile p2 = rep.get_profile(p.get_email(), p.get_password());
		assertEquals(p2.get_manager_id(), p.get_manager_id());
	}
	
	@Test
	public void testLoingGetUserId() {
		
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Profile p2 = rep.get_profile(p.get_email(), p.get_password());
		assertEquals(p2.get_user_id(), p.get_user_id());
	}
	
	@Test 
	public void testIsApproved() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		boolean b = rep.is_approved(4);
		assertEquals(b, true);
	}
	
	@Test 
	public void testIsApprovedFalse() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		boolean b = rep.is_approved(1);
		assertEquals(b, false);
	}
	
	@Test
	public void testGetReportAmount() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Report r2 = rep.get_report(r.get_report_id());
		boolean b = r2.get_amount() == r.get_amount();
		assert(b);
	}
	
	@Test
	public void testGetReportManagerId() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Report r2 = rep.get_report(r.get_report_id());
		assertEquals(r2.get_manager_id(), r.get_manager_id());
	}
	
	@Test
	public void testGetReportApproved() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Report r2 = rep.get_report(r.get_report_id());
		assertEquals(r2.get_approved(), r.get_approved());
	}
	
	@Test
	public void testGetReportId() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Report r2 = rep.get_report(r.get_report_id());
		assertEquals(r2.get_report_id(), r.get_report_id());
	}
	
	@Test
	public void testGetReportUserId() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Report r2 = rep.get_report(r.get_report_id());
		assertEquals(r2.get_user_id(), r.get_user_id());
	}
	
	@Test
	public void testGetProfileByIdEmail() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Profile p2 = rep.get_profile_by_id(p.get_user_id());
		assertEquals(p2.get_email(), p.get_email());
	}
	
	@Test
	public void testGetProfileByIdPassword() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Profile p2 = rep.get_profile_by_id(p.get_user_id());
		assertEquals(p2.get_password(), p.get_password());
	}
	
	@Test
	public void testGetProfileByIdUserId() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Profile p2 = rep.get_profile_by_id(p.get_user_id());
		assertEquals(p2.get_user_id(), p.get_user_id());
	}
	
	@Test
	public void testGetProfileByIdManagerId() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Profile p2 = rep.get_profile_by_id(p.get_user_id());
		assertEquals(p2.get_manager_id(), p.get_manager_id());
	}
	
	@Test
	public void testGetProfileByIdType() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Profile p2 = rep.get_profile_by_id(p.get_user_id());
		assertEquals(p2.get_type(), p.get_type());
	}
	
	@Test
	public void testGetProfileByIdFname() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Profile p2 = rep.get_profile_by_id(p.get_user_id());
		assertEquals(p2.get_fname(), p.get_fname());
	}
	
	@Test
	public void testGetProfileByIdLname() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		Profile p2 = rep.get_profile_by_id(p.get_user_id());
		assertEquals(p2.get_lname(), p.get_lname());
	}
	
	//some of these will break as I add reports 
	@Test
	public void testGetReportsByManager() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		ArrayList<Report> r2 = rep.get_reports_by_manager(p);
		assertEquals(4, r2.size());
	}
	
	@Test
	public void testGetReportsByManagerVerifyManagerId() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		ArrayList<Report> r2 = rep.get_reports_by_manager(p);
		assertEquals(p.get_manager_id(), r2.get(0).get_manager_id());
	}
	
	@Test
	public void testGerReportsByUser() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		ArrayList<Report> r2 = rep.get_reports_by_user(p3);
		assertEquals(2, r2.size());
	}
	
	@Test
	public void testGerReportsByUserVerifyEmployeeId() {
		ExpenseReportRepository rep = new ExpenseReportRepositoryImpl();
		ArrayList<Report> r2 = rep.get_reports_by_user(p3);
		assertEquals(p3.get_user_id(), r2.get(0).get_user_id());
	}
}
