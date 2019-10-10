package com.naver.accountInfo;

import java.sql.Date;

public class AccountInfoDTO {
	
	private String tradeNumber;
	private String accountNumber;
	private int income;
	private int accountBalance;
	private int incomeKind;
	private Date tradeDate;
	
	public String getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(String tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getIncomeKind() {
		return incomeKind;
	}
	public void setIncomeKind(int incomeKind) {
		this.incomeKind = incomeKind;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
	
	

}
