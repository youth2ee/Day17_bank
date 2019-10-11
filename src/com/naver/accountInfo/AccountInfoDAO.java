package com.naver.accountInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.naver.util.DBConnector;

public class AccountInfoDAO {
	
	public int income(AccountInfoDTO accountInfoDTO) throws Exception { //입금
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		con = DBConnector.getConnect();
		String sql = "insert into accountinfo values (trade_seq.nextval,?,?,?,?,sysdate)";
		st = con.prepareStatement(sql);
		st.setString(1, accountInfoDTO.getAccountNumber()); //계좌번호
		st.setLong(2, accountInfoDTO.getIncome()); //넣을 금액 
		st.setLong(3, accountInfoDTO.getAccountBalance()); //잔액
		st.setInt(4, accountInfoDTO.getIncomeKind()); //종류
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	} //income
	
	/*
	public AccountInfoDTO incomeSelect(String ac) throws Exception { //계좌번호별 계좌출력
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		AccountInfoDTO accountInfoDTO=null;
		
		con = DBConnector.getConnect();
		String sql = "select * from accountinfo where accountnumber=? "
				+ "and tradeDate=(select max(tradeDate) from accountinfo "
				+ "where accountnumber=?)";
		st = con.prepareStatement(sql);
		st.setString(1, ac);
		st.setString(2, ac);
		rs = st.executeQuery();
		
		if(rs.next()) {
			accountInfoDTO = new AccountInfoDTO();
			accountInfoDTO.setAccountNumber(ac);
			accountInfoDTO.setIncome(rs.getLong(3));
			accountInfoDTO.setAccountBalance(rs.getLong(4));
			accountInfoDTO.setIncomeKind(rs.getInt(5));
			accountInfoDTO.setTradeDate(rs.getDate(6));
			
		}
		
		return accountInfoDTO;
		
	}//incomeSelect 
	*/

	public List<AccountInfoDTO> incomeSelect(String ac) throws Exception { //계좌번호별 계좌출력
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		AccountInfoDTO accountInfoDTO=null;
		ArrayList<AccountInfoDTO> ar = new ArrayList<AccountInfoDTO>();
		
		con = DBConnector.getConnect();
		String sql = "select * from accountinfo where accountnumber=? "
				+ "order by tradenumber desc";
		st = con.prepareStatement(sql);
		
		st.setString(1, ac);
		rs = st.executeQuery();
		
		while(rs.next()) {
			accountInfoDTO = new AccountInfoDTO();
			accountInfoDTO.setTradeNumber(rs.getString(1));
			accountInfoDTO.setAccountNumber(rs.getString(2));
			accountInfoDTO.setIncome(rs.getLong(3));
			accountInfoDTO.setAccountBalance(rs.getLong(4));
			accountInfoDTO.setIncomeKind(rs.getInt(5));
			accountInfoDTO.setTradeDate(rs.getDate(6));
			
			ar.add(accountInfoDTO);
		}
		
		return ar;
		
	}//incomeSelect   
	
	public Long total(String ac) throws Exception {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs =null;
		Long accountBalance =0l;
		
		con = DBConnector.getConnect();
		String sql = "select accountbalance from accountinfo where accountnumber=? "
				+ "and tradenumber=(select max(tradenumber) from accountinfo "
				+ "where accountnumber=?)";
		
		st = con.prepareStatement(sql);
		st.setString(1, ac);
		st.setString(2, ac);
		
		rs = st.executeQuery();
		
		if(rs.next()) {
			accountBalance = rs.getLong(1);
		}
		
		rs.close();
		st.close();
		con.close();
		
		
		return accountBalance;
	}
	
	

}
