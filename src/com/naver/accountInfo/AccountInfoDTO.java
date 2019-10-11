package com.naver.accountInfo;

import java.sql.Date;

public class AccountInfoDTO {
	
	private String tradeNumber;
	private String accountNumber;
	private long income;
	private long accountBalance;
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
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
	public long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(long accountBalance) {
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
