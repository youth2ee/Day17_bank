package com.naver.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naver.util.DBConnector;

public class AccountDAO {
	
	public int accountCreate(AccountDTO accountDTO) {
		Connection con = null;
		PreparedStatement st =null;
		int result=0;
		
		try {
			con = DBConnector.getConnect();
			String sql = "insert into account values (?,?,0,?)";
			st = con.prepareStatement(sql);
			st.setString(1, accountDTO.getAccountNumber());
			st.setString(2, accountDTO.getAccountName());
			st.setString(3, accountDTO.getId());
			
			result = st.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
}
