package com.naver.account;

import java.util.Scanner;

import com.naver.bankInput.AccountInput;
import com.naver.bankView.BankView;

public class AccountController {
	private Scanner sc;
	private AccountDAO accountDAO;
	private AccountInput accountInput;
	private BankView bankView;
	
	public AccountController() {
		sc = new Scanner(System.in);
		accountDAO = new AccountDAO();
		accountInput = new AccountInput();
		bankView = new BankView();
	}
	
	public void start(String id) {
		System.out.println("-------------");
		System.out.println("*계좌생성*");
		
		AccountDTO accountDTO = accountInput.accountCreate(sc, id);
		int result = accountDAO.accountCreate(accountDTO);
		String msg = "계좌생성 실패";
		if(result>0) {
			msg = "계좌생성 성공";
		} 
		bankView.view(msg);
	}//start
}
