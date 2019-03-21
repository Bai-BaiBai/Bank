package DAO;

import java.sql.*;
import java.util.ArrayList;

import bean.User;
import utils.DataBase;

/**
 * @author nicko
 *
 */
public class userDAO {
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/bank?&useSSL=false&serverTimezone=UTC";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";
	
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("连接数据库失败");
		}
	}
	/**
	 * 获取数据库连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	public static ResultSet executeSQL(String sql) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		return rs;
	}
	/**
	 * 执行增加更新删除操作
	 * @param sql
	 */
	public static void executeUpdate(String sql) throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		
		closeAll(pstmt);
	}
	
	/**
	 * 通过statement关闭数据库连接
	 * @param pstmt
	 */
	public static void closeAll(PreparedStatement pstmt){
		try {
			Connection conn = pstmt.getConnection();
			
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("关闭数据库连接失败");
		}
	}
	
	/**
	 * 通过ResultSet关闭数据库连接
	 * @param rs
	 */
	public static void closeAll(ResultSet rs){
		try {
			Statement stmt = rs.getStatement();
			Connection conn = stmt.getConnection();
			
			conn.close();
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("关闭数据库连接失败");
		}
	}
	public int test(String account,String passwd) throws SQLException
	{
		int j=0;
		ResultSet rs = executeSQL("select * from user");		
		while(rs.next())
		{
			String user_account = rs.getString("user_account");
			String user_password = rs.getString("user_password");
			if(account.equals("admin")&&passwd.equals("admin"))
			{
				j = 1;
				break;
			}else if(account.equals(user_account))
			{
				if(passwd.equals(user_password))
				{
					j = 2;
					break;
				}
			}
		}
		return j;
	}
	
	public String getUser_name(User user) throws SQLException {
		String username = "";
		ResultSet rs = executeSQL("select user_name from user where user_account = '" + user.getUser_account() + "';");
		rs.next();
		username = rs.getString("user_name");
		return username;
	}
	
	public static User getUserByid(String user_account) {
		User user = new User();
		String sql = "select * from user where user_account ='" + user_account + "';";
		try {
			ResultSet rSet = DataBase.executeSQL(sql);
			rSet.next();
			user.setUser_account(rSet.getString("user_account"));
			user.setUser_name(rSet.getString("user_name"));
			user.setUser_password(rSet.getString("user_password"));
			rSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	public static boolean modify(User user) {
		String sql = "update user set user_name = '" + user.getUser_name()
					+ "', user_password = '" + user.getUser_password()
					+ "' where user_account = '" + user.getUser_account() + "';";
		try {
			DataBase.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static boolean deleteUserbyid(String user_account) {
		String sql = "delete from user where user_account = '" + user_account + "';";
		try {
			DataBase.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static boolean addUser(User user) {
		String sql = "insert into user values('" + user.getUser_account() + "','" + user.getUser_name() + "','" + user.getUser_password() + "')";
		try {
			DataBase.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public static ArrayList<String> getUser_account(){
		ArrayList<String> accounts = new ArrayList<String>();
		String sql = "select user_account from user";
		try {
			ResultSet rSet = DataBase.executeSQL(sql);
			while(rSet.next()) {
				String string = rSet.getString("user_account");
				accounts.add(string);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accounts;
	}
	
}

