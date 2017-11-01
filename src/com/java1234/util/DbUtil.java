package com.java1234.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ݿ⹤����
 * @author 33003
 *
 */
public class DbUtil {

	private String dbUrl = "jdbc:mysql://localhost:3306/db_book";  //���ݿ����ӵ�ַ
	private String dbUserName = "Oscar";
	private String dbPassword ="88888";
	private String jdbcName = "com.mysql.jdbc.Driver";  //��������
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception{
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	
	/**
	 * �ر����ݿ�����
	 * @param con
	 * @throws Exception
	 */
	public void closeConnection(Connection con) throws Exception{
		if (con != null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getConnection();
			System.out.println("�ɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ʧ��");
		}
	}
}
