package com.naver.bankInput;

import java.util.Calendar;
import java.util.Scanner;

import com.naver.account.AccountDTO;
import com.naver.accountInfo.AccountInfoDAO;
import com.naver.accountInfo.AccountInfoDTO;

public class AccountInput {
	/*
	public AccountDTO accountCreate(Scanner sc, String id) {
		AccountDTO accountDTO = new AccountDTO();
		System.out.println("accountName :");
		accountDTO.setAccountName(sc.next());
	
		//현재시간을 받아서 계좌번호로 한다.
		Calendar calendar= Calendar.getInstance();
		//calendar.getTimeInMillis();
		String.valueOf(calendar.getTimeInMillis());
		accountDTO.setAccountNumber(String.valueOf(calendar.getTimeInMillis()));
		
		//로그인한 아이디를 받아서 넣어준다.
		accountDTO.setId(id);
		
		return accountDTO;
		
	}//accountCreate
	*/
	
	public AccountDTO accountCreate(Scanner sc) throws Exception {
		AccountDTO accountDTO = new AccountDTO();
		AccountInfoDAO accountInfoDAO = new AccountInfoDAO();
		
		System.out.println("계좌명을 입력하세요.");
		accountDTO.setAccountName(sc.next());
		
		Calendar calendar = Calendar.getInstance();
		long accountnumber = calendar.getTimeInMillis();
		accountDTO.setAccountNumber(String.valueOf(accountnumber));
		
		Long ab = accountInfoDAO.total(accountDTO.getAccountNumber());
		accountDTO.setAccountBalance(ab);
		
		return accountDTO;
	}
	
	public AccountInfoDTO accountInfoCreate(Scanner sc,int a,String accountNumber) throws Exception {
		AccountInfoDTO accountInfoDTO = new AccountInfoDTO();
		AccountInfoDAO accountInfoDAO = new AccountInfoDAO();
		String account = null;
		
		//System.out.println("계좌번호를 입력하세요");
		//accountInfoDTO.setAccountNumber(sc.next());
		
		accountInfoDTO.setAccountNumber(accountNumber);
		
		if(a==1) {
			account = "입금";		
		} else if (a==-0) {
			account = "출금";
		}
		accountInfoDTO.setIncomeKind(a);
		System.out.println(account);
				
		System.out.println(account+"금액을 입력하세요");
		accountInfoDTO.setIncome(sc.nextLong());
	
		Long ab = accountInfoDAO.total(accountInfoDTO.getAccountNumber());
		if(account.equals("입금")) {
			accountInfoDTO.setAccountBalance(ab + accountInfoDTO.getIncome());			
		} else if (account.equals("출금")) {
			accountInfoDTO.setAccountBalance(ab - accountInfoDTO.getIncome());	
		}
		
		return accountInfoDTO;
	}
	
	



}
