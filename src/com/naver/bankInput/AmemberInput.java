package com.naver.bankInput;

import java.util.Calendar;
import java.util.Scanner;

import com.naver.account.AccountDTO;
import com.naver.amember.AmemberDTO;

public class AmemberInput {

	public AmemberDTO memberLogin(Scanner sc) {
		AmemberDTO amemberDTO = new AmemberDTO();
		System.out.println("-------------");
		System.out.println("*로그인*");
		System.out.println("id :");
		amemberDTO.setId(sc.next());
		System.out.println("pw :");
		amemberDTO.setPw(sc.next());

		return amemberDTO;
	}//login


	public AmemberDTO memberjoin (Scanner sc) { //회원가입
		AmemberDTO amemberDTO = new AmemberDTO();
		System.out.println("-------------");
		System.out.println("*회원가입*");
		System.out.println("id :");
		amemberDTO.setId(sc.next());
		System.out.println("pw :");
		amemberDTO.setPw(sc.next());
		System.out.println("name :");
		amemberDTO.setName(sc.next());
		System.out.println("phone :");
		amemberDTO.setPhone(sc.next());
		System.out.println("email :");
		amemberDTO.setEmail(sc.next());

		return amemberDTO;
	}//join
	

}
