package models;

public class Profile {
	private String email;
	private String password;
	private int user_id;
	private int manager_id;
	private String fname;
	private String lname;
	private String user_type;
	
	public Profile(int _user_id, int _manager_id, String _user_type, String _password, String _email, String _fname, String _lname) {
		this.set_email(_email);
		this.set_password(_password);
		this.set_user_id(_user_id);
		this.set_manager_id(_manager_id);
		this.set_fname(_fname);
		this.set_lname(_lname);
		this.set_user_type(_user_type);
	}
	
	public void set_password(String _password) {
		this.password = _password;
	}

	public String get_password() {
		return this.password;
	}
	
	public String get_type() {
		return this.user_type;
	}
	
	public void set_user_type(String _user_type) {
		this.user_type = _user_type;
	}

	public int get_user_id() {
		return user_id;
	}

	public void set_user_id(int user_id) {
		this.user_id = user_id;
	}

	public int get_manager_id() {
		return manager_id;
	}

	public void set_manager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public String get_email() {
		return email;
	}

	public void set_email(String email) {
		this.email = email;
	}

	public String get_fname() {
		return fname;
	}

	public void set_fname(String fname) {
		this.fname = fname;
	}

	public String get_lname() {
		return lname;
	}

	public void set_lname(String lname) {
		this.lname = lname;
	}
}
