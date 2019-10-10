package com.naver.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	
	public static Connection getConnect() throws Exception {

		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(driver); //문자열로 된 주소를 찾아서 객체를 생성해줘
		Connection con = DriverManager.getConnection(url, user, password);
		
		return con;
	}
	
	

}
