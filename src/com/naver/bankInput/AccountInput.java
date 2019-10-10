package com.naver.bankInput;

import java.util.Calendar;
import java.util.Scanner;

import com.naver.account.AccountDTO;

public class AccountInput {
	
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


}
