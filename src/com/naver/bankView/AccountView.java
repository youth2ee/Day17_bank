package com.naver.bankView;

import java.util.List;

import com.naver.account.AccountDTO;

public class AccountView {
	
	public void view(List<AccountDTO> ar) {
		
		System.out.println("계좌번호\t\t계좌명\t잔액");
		
		for(int i=0;i<ar.size();i++) {
			/*
			System.out.println("-----------------------------------");
			System.out.println("*"+ar.get(i).getId()+"의 "+(i+1)+"번째 계좌정보*");
			System.out.println("계좌번호 : "+ar.get(i).getAccountNumber());
			System.out.println("계좌명 : "+ar.get(i).getAccountName());
			System.out.println("잔액 : "+ar.get(i).getAccountBalance());
			//System.out.println("아이디 : "+ar.get(i).getId());
			*/
			
			System.out.print(ar.get(i).getAccountNumber()+"\t");
			System.out.print(ar.get(i).getAccountName()+"\t");
			System.out.println(ar.get(i).getAccountBalance());
		}
	}

}
