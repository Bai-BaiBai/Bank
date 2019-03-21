package DAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import bean.Bill;
import bean.PayMoney;
import bean.SaveMoney;
import bean.UpdatePasswd;
import bean.User;
import utils.DataBase;

public class BillDAO {
	
	/***
	 *  通过user_account返回此用户的存单信息
	 * @param user
	 * @return ArrayList<Bill>
	 */
	public static ArrayList<Bill> getBillview(User user){
		ArrayList<Bill> bills = new ArrayList<Bill>();
		String sql = "select * from bill where user_account = '" + user.getUser_account() + "';";
		try {
			ResultSet rSet = DataBase.executeSQL(sql);
			while(rSet.next()) {
				Bill nbill = new Bill();
				nbill.setBill_id(rSet.getString("bill_id"));
				nbill.setUser_account(rSet.getString("user_account"));
				//nbill.setBill_password(rSet.getString("bill_password"));
				nbill.setBill_money(rSet.getInt("bill_money"));
				nbill.setBill_record(rSet.getString("bill_record"));
				bills.add(nbill);
			}
			DataBase.closeAll(rSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bills;
	}
	
	/***
	 * 返回user_account对应的存单的密码和支出记录
	 * @param user_account
	 * @return password & record
	 */
	public static String[] ReturnPasswdRecord(String user_account) {
		String[] str = new String[2]; 
		String sql1 = "select * from bill where user_account = '" + user_account + "';";
		ResultSet rSet;
		try {
			rSet = DataBase.executeSQL(sql1);
			rSet.next();
			str[0] = rSet.getString("bill_password");
			str[1] = rSet.getString("bill_record");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		return str;
	}
	
	/***
	 * 缴费
	 * @param sMoney
	 * @return
	 */
	public static boolean Save(SaveMoney sMoney) {
		String[] strings = ReturnPasswdRecord(sMoney.getUser_account());
		strings[1] += String.valueOf(new Date());
		strings[1] += "存" + String.valueOf(sMoney.getMoney()) + "元;";
		if(strings[0].equals(sMoney.getPassword())) {
			String sql = "update bill set bill_money = bill_money + " + sMoney.getMoney() + " where user_account = '" + sMoney.getUser_account() + "';";
			String sql2 = "update bill set bill_record = '" + strings[1] + "' where user_account = '" + sMoney.getUser_account() + "';";
			try {
				DataBase.executeUpdate(sql);
				DataBase.executeUpdate(sql2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else {
			return false;
		}
		
	}
	
	/***
	 * 缴费
	 * @param pMoney
	 * @return
	 */
	public static boolean Pay(PayMoney pMoney) {
		String[] strings = ReturnPasswdRecord(pMoney.getUser_account());
		strings[1] += String.valueOf(new Date());
		strings[1] += "缴纳" + pMoney.getType() + String.valueOf(pMoney.getMoney()) + "元;";
		if(strings[0].equals(pMoney.getPassword())) {
			String sql = "update bill set bill_money = bill_money - " + pMoney.getMoney() + " where user_account = '" + pMoney.getUser_account() + "';";
			String sql2 = "update bill set bill_record = '" + strings[1] + "' where user_account = '" + pMoney.getUser_account() + "';";
			try {
				DataBase.executeUpdate(sql);
				DataBase.executeUpdate(sql2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return true;
		}else {
			return false;
		}
		
	}
	
	/***修改存单密码
	 * 
	 * @param uPasswd
	 * @return
	 */
	public static boolean upBillPassword(UpdatePasswd uPasswd) {
		ResultSet rSet;
		String old_passwd = "";
		String sql = "select bill_password from bill where user_account = '" + uPasswd.getUser_account() + "';";
		try {
			rSet = DataBase.executeSQL(sql);
			rSet.next();
			old_passwd = rSet.getString("bill_password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(old_passwd.equals(uPasswd.getOld_password())) {
			sql = "update bill set bill_password = '" + uPasswd.getNew_password() + "' where user_account = '" + uPasswd.getUser_account() + "';";
			try {
				DataBase.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else {
			return false;
		}
		
	}
	
	/***修改用户登录密码
	 * 
	 * @param uPasswd
	 * @return
	 */
	public static boolean upUserPassword(UpdatePasswd uPasswd) {
		ResultSet rSet;
		String old_passwd = "";
		String sql = "select user_password from user where user_account = '" + uPasswd.getUser_account() + "';";
		try {
			rSet = DataBase.executeSQL(sql);
			rSet.next();
			old_passwd = rSet.getString("user_password");
			rSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(old_passwd.equals(uPasswd.getOld_password())) {
			sql = "update user set user_password = '" + uPasswd.getNew_password() + "' where user_account = '" + uPasswd.getUser_account() + "';";
			try {
				DataBase.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean printBill(User user) {
		String sql = "select bill_record from bill where user_account = '" + user.getUser_account() + "';";
		ResultSet rSet;
		String record = "空";
		try {
			rSet = DataBase.executeSQL(sql);
			rSet.next();
			record = rSet.getString("bill_record");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		File billfile = new File("D:\\billfile.txt");
		
		try {
			PrintWriter pw = new PrintWriter(billfile);
			if(!record.isEmpty()) {
				pw.write(record);
			}
			
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public static ArrayList<Bill> getBills(){
		ArrayList<Bill> bills = new ArrayList<Bill>();
		String sql = "select * from bill";
		try {
			ResultSet rSet = DataBase.executeSQL(sql);
			while(rSet.next()) {
				Bill bill = new Bill();
				bill.setBill_id(rSet.getString("bill_id"));
				bill.setUser_account(rSet.getString("user_account"));
				bill.setBill_password(rSet.getString("bill_password"));
				bill.setBill_money(rSet.getInt("bill_money"));
				bill.setBill_record(rSet.getString("bill_record"));
				bills.add(bill);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bills;
	}
	
	public static Bill getBillbyid(String bill_id) {
		Bill bill = new Bill();
		String sql = "select * from bill where bill_id = '" + bill_id + "';";
		try {
			ResultSet rSet = DataBase.executeSQL(sql);
			rSet.next();
			bill.setBill_id(rSet.getString("bill_id"));
			bill.setUser_account(rSet.getString("user_account"));
			bill.setBill_password(rSet.getString("bill_password"));
			bill.setBill_money(rSet.getInt("bill_money"));
			bill.setBill_record(rSet.getString("bill_record"));
			rSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bill;
	}
	
	public static boolean modify(Bill bill) {
		String sql = "update bill set bill_password = '" + bill.getBill_password() 
					+ "', bill_money = '" + bill.getBill_money() 
					+ "', bill_record = '" + bill.getBill_record()
					+ "' where bill_id = '" + bill.getBill_id() + "';";
		try {
			DataBase.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static boolean deleteByid(String bill_id) {
		String sql = "delete from bill where bill_id = '" + bill_id + "';";
		try {
			DataBase.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static ArrayList<User> getUsers() {
		ArrayList<User> users = new ArrayList<User>();
		String sql = "select * from user;";
		try {
			ResultSet rSet = DataBase.executeSQL(sql);
			while(rSet.next()) {
				User user = new User();
				user.setUser_account(rSet.getString("user_account"));
				user.setUser_name(rSet.getString("user_name"));
				user.setUser_password(rSet.getString("user_password"));
				users.add(user);
			}
			rSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return users;
	}
	
	public static boolean addBill(Bill bill) {
		String sql = "insert into bill values('"
					+ bill.getBill_id() + "','"
					+ bill.getUser_account() + "','"
					+ bill.getBill_password() + "','"
					+ bill.getBill_money() + "','"
					+ bill.getBill_record() + "');";
		try {
			DataBase.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}

