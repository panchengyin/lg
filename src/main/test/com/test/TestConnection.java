package com.test;


import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class TestConnection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
		String user = "root"; // 用户名
		String pwd = ""; // 密码

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			// 建立到MySQL的连接
			Connection conn = (Connection) DriverManager.getConnection(url, user, pwd);
			if(conn!=null){
				System.out.print("连接成功!!!");
			}else{
				System.out.print("连接失败!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
