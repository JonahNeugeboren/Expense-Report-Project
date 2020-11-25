package models;

public class Report {
	private int report_id;
	private int user_id;
	private int manager_id;
	private float amount;
	private byte[] image;
	boolean approved;
	
	
	public Report(int _report_id, int _user_id, int _manager_id, float _amount, byte[] _image, boolean _approved) {
		this.set_report_id(_report_id);
		this.set_user_id(_user_id);
		this.set_manager_id(_manager_id);
		this.set_amount(_amount);
		this.set_image(_image);
		this.approved = _approved;
		
	}
	
	public int get_report_id() {
		return this.report_id;
	}
	
	public void set_report_id(int _report_id) {
		this.report_id = _report_id;
	}

	public int get_user_id() {
		return this.user_id;
	}

	public void set_user_id(int _user_id) {
		this.user_id = _user_id;
	}

	public int get_manager_id() {
		return this.manager_id;
	}

	public void set_manager_id(int _manager_id) {
		this.manager_id = _manager_id;
	}

	public float get_amount() {
		return this.amount;
	}

	public void set_amount(float _amount) {
		this.amount = _amount;
	}

	public byte[] get_image() {
		return image;
	}

	public void set_image(byte[] image) {
		this.image = image;
	}

	public boolean get_approved() {
		return approved;
	}
	
	
}
