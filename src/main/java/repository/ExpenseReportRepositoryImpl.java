package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Profile;
import models.Report;

public class ExpenseReportRepositoryImpl extends ExpenseReportRepository {

	@Override
	public void store_profile(Profile user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into employees values(default, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, user.get_manager_id());
			stmt.setString(2, user.get_type());
			stmt.setString(3, user.get_password());
			stmt.setString(4, user.get_email());
			stmt.setString(5, user.get_fname());
			stmt.setString(6, user.get_lname());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionCloser.closeResource(conn);
			ConnectionCloser.closeResource(stmt);
		}
	}
	
	@Override
	public void update_profile(Profile user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "update employees set password = ?, email = ?, fname = ?, lname = ? where employee_id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, user.get_password());
			stmt.setString(2, user.get_email());
			stmt.setString(3, user.get_fname());
			stmt.setString(4, user.get_lname());
			stmt.setInt(5, user.get_user_id());
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionCloser.closeResource(conn);
			ConnectionCloser.closeResource(stmt);
		}
	}

	@Override
	public Profile get_profile(String email, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		Profile prof = null;
		final String SQL = "select * from employees where email = ? and password = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setString(1, email);
			stmt.setString(2, password);
			
			set = stmt.executeQuery();
			while(set.next()) {
				prof = new Profile(set.getInt(1), set.getInt(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6), set.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionCloser.closeResource(conn);
			ConnectionCloser.closeResource(stmt);
		}
		return prof;
	}

	@Override
	public boolean is_approved(int report_id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "select approved from reports where report_id = ?";
		boolean bool = false;
		ResultSet set = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, report_id);
			
			set = stmt.executeQuery();
			while(set.next()) {
				bool = set.getBoolean(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionCloser.closeResource(conn);
			ConnectionCloser.closeResource(stmt);
		}
		return bool;
	}

	@Override
	public Report get_report(int report_id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "select * from reports where report_id = ?";
		ResultSet set = null;
		Report ret = null;
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, report_id);
			
			set = stmt.executeQuery();	
			while(set.next()) {
				ret = new Report(set.getInt(1), set.getInt(2), set.getInt(3), set.getFloat(4), set.getBytes(5), set.getBoolean(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionCloser.closeResource(conn);
			ConnectionCloser.closeResource(stmt);
		}
		return ret;
	}

	@Override
	public void insert_report(int user_id, int manager_id, float amount, byte[] image) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "insert into reports values (default, ?, ?, ?, ?, ?)";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			
			stmt.setInt(1, user_id);
			stmt.setInt(2, manager_id);
			stmt.setFloat(3, amount);
			stmt.setBytes(4, image);
			stmt.setBoolean(5, false);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionCloser.closeResource(conn);
			ConnectionCloser.closeResource(stmt);
		}
	}

	@Override
	public ArrayList<Report> get_reports() {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "select * from reports";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionCloser.closeResource(conn);
			ConnectionCloser.closeResource(stmt);
		}
		return null;
	}

	@Override
	public ArrayList<Report> get_reports_by_user(Profile user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "select * from reports where employee_id = ?";
		ResultSet set = null;
		ArrayList<Report> rep = new ArrayList<Report>();
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, user.get_user_id());
			
			set = stmt.executeQuery();
			while(set.next()) {
				rep.add(new Report(set.getInt(1), set.getInt(2), set.getInt(3), set.getFloat(4), set.getBytes(5), set.getBoolean(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionCloser.closeResource(conn);
			ConnectionCloser.closeResource(stmt);
		}
		return rep;
	}

	@Override
	public void approve_or_deny(int report_id, boolean approved) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "update reports set approved = ? where report_id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setBoolean(1, approved);
			stmt.setInt(2, report_id);
			
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionCloser.closeResource(conn);
			ConnectionCloser.closeResource(stmt);
		}
	}

	@Override
	public ArrayList<Report> get_reports_by_manager(Profile manager) {
		Connection conn = null;
		PreparedStatement stmt = null;
		final String SQL = "select * from reports where manager_id = ?";
		ResultSet set = null;
		ArrayList<Report> rep = new ArrayList<Report>();
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, manager.get_user_id());
			
			set = stmt.executeQuery();
			while(set.next()) {
				rep.add(new Report(set.getInt(1), set.getInt(2), set.getInt(3), set.getFloat(4), set.getBytes(5), set.getBoolean(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionCloser.closeResource(conn);
			ConnectionCloser.closeResource(stmt);
		}
		return rep;
	}

	@Override
	public Profile get_profile_by_id(int user_id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet set = null;
		Profile prof = null;
		final String SQL = "select * from employees where employee_id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.prepareStatement(SQL);
			stmt.setInt(1, user_id);
			
			set = stmt.executeQuery();
			while(set.next()) {
				prof = new Profile(set.getInt(1), set.getInt(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6), set.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionCloser.closeResource(conn);
			ConnectionCloser.closeResource(stmt);
		}
		return prof;
	}

}
