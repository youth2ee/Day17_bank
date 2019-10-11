package com.naver.account;

import java.util.List;
import java.util.Scanner;

import com.naver.accountInfo.AccountInfoController;
import com.naver.accountInfo.AccountInfoDAO;
import com.naver.accountInfo.AccountInfoDTO;
import com.naver.amember.AmemberDTO;
import com.naver.bankInput.AccountInput;
import com.naver.bankView.AccountInfoView;
import com.naver.bankView.AccountView;
import com.naver.bankView.BankView;

public class AccountController {
	private Scanner sc;
	private AccountDTO accountDTO;
	private AccountDAO accountDAO;
	private AccountInfoDAO accountInfoDAO;
	private AccountInput accountInput;
	private AccountView accountView;
	private AccountInfoView accountInfoView;
	private AccountInfoController accountInfoController;
	private BankView bankView;

	public AccountController() {
		sc = new Scanner(System.in);
		accountDAO = new AccountDAO();
		accountInfoDAO = new AccountInfoDAO();
		accountInput = new AccountInput();
		accountView = new AccountView();
		accountInfoView = new AccountInfoView();
		accountInfoController = new AccountInfoController();
		bankView = new BankView();
	}

	//public void start(String id) {
	public void start(AmemberDTO amemberDTO) {
		boolean check = true;
		int num=0;
		int result=0;
		String msg =null;


		while(check) {
			System.out.println("-------------");
			System.out.println("1. 계좌생성");
			System.out.println("2. 계좌조회");
			System.out.println("3. 거래");
			System.out.println("4. 종료");
			num = sc.nextInt();

			switch(num) {
			case 1: //계좌생성
				//AccountDTO accountDTO = accountInput.accountCreate(sc, id);

				try {
					accountDTO = accountInput.accountCreate(sc);
					accountDTO.setId(amemberDTO.getId());
					result = accountDAO.accountCreate(accountDTO);

				} catch (Exception e) {
					e.printStackTrace();
					result =0;
				}

				msg = "계좌생성 실패";
				if(result>0) {
					msg = "계좌생성 성공";
				} 
				bankView.view(msg);
				break;

			case 2: //계좌조회
				try {
					List<AccountDTO> ar = accountDAO.accountSelect(amemberDTO.getId());

					if(ar.size()!=0) {
						accountView.view(ar);						
					} else {
						System.out.println("계좌정보 없습니다.");
					}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("계좌정보 없습니다.");
				}

				break;

				/*
			case 3 : //입출금
				AccountInfoDTO accountInfoDTO = accountInput.accountInfoCreate(sc);
				System.out.println("받기성공");
				try {
					result = accountInfoDAO.income(accountInfoDTO);
					if(result>0) {
						System.out.println("입금 성공");
					} else {
						System.out.println("입금 실패");
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				break;

			case 4 : //계좌거래내역
				System.out.println("계좌번호를 입력하세요");
				String ac = sc.next();
				try {
					List<AccountInfoDTO> ar = accountInfoDAO.incomeSelect(ac);
					accountInfoView.view(ar);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				break;
				 */

			case 3:
				System.out.println("계좌번호를 입력하세요");
				String accountNumber = sc.next();
				
				try {
					accountInfoController.start(accountNumber);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;	


			case 4: //종료
				System.out.println("종료합니다.");
				check=!check;
				break;

			default:
				System.out.println("정확한 번호를 입력해주세요.");

			}
		}//while
	}//start
}
