package com.naver.bankView;

import java.util.List;

import com.naver.accountInfo.AccountInfoDTO;

public class AccountInfoView {
	
	public void view(List<AccountInfoDTO> ar) {
		
		System.out.println("순서\t계좌번호\t\t입출금액\t잔액\t종류\t거래일");
		for(AccountInfoDTO a : ar) {
			System.out.print(a.getTradeNumber()+"\t");
			System.out.print(a.getAccountNumber()+"\t");
			System.out.print(a.getIncome()+"\t");
			System.out.print(a.getAccountBalance()+"\t");
			System.out.print(a.getIncomeKind()+"\t");
			System.out.println(a.getTradeDate());
			
			
		}
		
		/*
		System.out.println("--------------------------");
		System.out.println("계좌번호 : "+accountInfoDTO.getAccountNumber());
		System.out.println("잔액 : "+accountInfoDTO.getAccountBalance());
	*/
	}

}
