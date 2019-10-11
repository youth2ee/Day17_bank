package com.naver.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.naver.util.DBConnector;
import com.sun.org.glassfish.external.statistics.annotations.Reset;

public class AccountDAO {
	/*
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
	 */

	public int accountCreate(AccountDTO accountDTO) throws Exception{
		int result =0;
		Connection con =null;
		PreparedStatement st =null;

		con = DBConnector.getConnect();
		String sql = "insert into account values (?,?,?,?)";
		st = con.prepareStatement(sql);
		st.setString(1, accountDTO.getAccountNumber());
		st.setString(2, accountDTO.getAccountName());
		st.setLong(3, accountDTO.getAccountBalance());
		st.setString(4, accountDTO.getId());

		result = st.executeUpdate();

		st.close();
		con.close();

		return result;
	}

	public List<AccountDTO> accountSelect (String id) throws Exception {//조회
		Connection con = null;
		PreparedStatement st =null;
		ResultSet rs = null;
		ArrayList<AccountDTO> ar = new ArrayList<AccountDTO>();
		AccountDTO accountDTO=null;

		con = DBConnector.getConnect();
		String sql = "select * from account where id =?";
		st = con.prepareStatement(sql);
		st.setString(1, id);

		rs = st.executeQuery();

		while(rs.next()) {
			accountDTO = new AccountDTO();
			accountDTO.setAccountNumber(rs.getString(1));
			accountDTO.setAccountName(rs.getString(2));
			accountDTO.setAccountBalance(rs.getLong(3));
			accountDTO.setId(rs.getString(4));	

			ar.add(accountDTO);
		}

		rs.close();
		st.close();
		con.close();

		return ar;
	}//accountSelect


}
