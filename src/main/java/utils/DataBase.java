package utils;

import java.sql.*;

public class DataBase {
	
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
			System.out.print("�������ݿ�ʧ��");
		}
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	/**
	 *ִ�в�ѯ����
	 * @param sql
	 * @return ResultSet
	 */
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
	 * ִ�����Ӹ���ɾ������
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
	 * ͨ��statement�ر����ݿ�����
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
			System.out.print("�ر����ݿ�����ʧ��");
		}
	}
	
	/**
	 * ͨ��ResultSet�ر����ݿ�����
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
			System.out.print("�ر����ݿ�����ʧ��");
		}
	}
	
}
