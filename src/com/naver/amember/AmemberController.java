package com.naver.amember;

import java.util.Scanner;

import com.naver.account.AccountController;
import com.naver.account.AccountDTO;
import com.naver.bankInput.AccountInput;
import com.naver.bankInput.AmemberInput;
import com.naver.bankView.BankView;

public class AmemberController {
	private Scanner sc;
	private AmemberDAO amemberDAO;
	private AmemberInput amemberInput;
	private BankView bankView;
	private AccountController accountController;

	public AmemberController() {
		sc = new Scanner(System.in);
		amemberDAO = new AmemberDAO();
		amemberInput = new AmemberInput();
		bankView = new BankView();
		accountController = new AccountController();
	}

	public void start() {
		Boolean check =true;
		int result = 0;
		String msg = null;

		while (check) {
			System.out.println("************");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 종료");
			int select = sc.nextInt();

			switch (select) {
			case 1: //로그인
				AmemberDTO amemberDTO = amemberInput.memberLogin(sc);
				AmemberDTO amemberDTO2 = amemberDAO.memberLogin(amemberDTO);
				if(amemberDTO2!=null) {
					System.out.println("로그인 성공");
					accountController.start(amemberDTO2.getId());
	
				//	check=!check;
				} else {
					System.out.println("로그인 실패");					
				}

				break;

			case 2: //회원가입
				AmemberDTO amemberDTO3 = amemberInput.memberjoin(sc);
				try {
					result = amemberDAO.memberJoin(amemberDTO3);
					
					msg ="회원가입 실패";
					if(result>0) {
						msg="회원가입 성공";
					} 
				} catch (Exception e) {
					e.printStackTrace();
					msg="회원가입 실패";

				} finally {
					bankView.view(msg);
				}
				break;


			default:
				check=!check;
				break;
			}
		}

	}
}
