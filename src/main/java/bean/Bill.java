package bean;

public class Bill {

	private String bill_id;
	private String user_account;
	private String bill_password;
	private int bill_money;
	private String bill_record;
	
	
	public String getBill_id() {
		return bill_id;
	}
	public void setBill_id(String bill_id) {
		this.bill_id = bill_id;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	
	public String getBill_password() {
		return bill_password;
	}
	public void setBill_password(String bill_password) {
		this.bill_password = bill_password;
	}
	public int getBill_money() {
		return bill_money;
	}
	public void setBill_money(int bill_money) {
		this.bill_money = bill_money;
	}
	public String getBill_record() {
		return bill_record;
	}
	public void setBill_record(String bill_record) {
		this.bill_record = bill_record;
	}
	
	
}
