package com.naver.accountInfo;

import java.util.List;
import java.util.Scanner;
import com.naver.bankInput.AccountInput;
import com.naver.bankView.AccountInfoView;

public class AccountInfoController {
	private Scanner sc;
	private AccountInfoDAO accountInfoDAO;
	private AccountInput accountInput;
	private AccountInfoView accountInfoView;

	public AccountInfoController() {
		sc = new Scanner(System.in);
		accountInfoDAO = new AccountInfoDAO();
		accountInput = new AccountInput();
		accountInfoView = new AccountInfoView();
	}

	public void start(String accountNumber) throws Exception {
		//매개변수로 계좌번호를 받아야 한다.
		boolean check = true;

		while(check) {
			System.out.println("1. 입출금내역조회");
			System.out.println("2. 입금"); //입금금액 
			System.out.println("3. 출금"); //출금금액
			System.out.println("4. 종료");
			int num = sc.nextInt();
			int result = 0;
			int a = 0;

			switch (num) {
			case 1:
				//매개변수로 계좌번호 받기
				try {
					List<AccountInfoDTO> ar = accountInfoDAO.incomeSelect(accountNumber);
					if(ar.size()!=0) {
						accountInfoView.view(ar);						
					} else {
						System.out.println("계좌정보 없습니다.");
					}
				} catch (Exception e) {
					System.out.println("계좌정보 없습니다.");
					e.printStackTrace();
				}
				break;

			case 2: //입금
				//매개변수로 계좌번호 받기
				//incomekind=1
				a = 1;
				AccountInfoDTO accountInfoDTO = accountInput.accountInfoCreate(sc,a,accountNumber);
				try {
					result = accountInfoDAO.income(accountInfoDTO);

					if(result>0) {
						System.out.println("입금 성공");
					} else {
						System.out.println("입금 실패");
					}
				} catch (Exception e) {
					System.out.println("입금 실패");
					e.printStackTrace();
				}

				break;

				
				

			case 3: //출금
				//incomekind=0
				a = 0;
				AccountInfoDTO accountInfoDTO2 = accountInput.accountInfoCreate(sc,a,accountNumber);
				try {
					result = accountInfoDAO.income(accountInfoDTO2);

					if(result>0) {
						System.out.println("출금 성공");
					} else {
						System.out.println("출금 실패");
					}

				} catch (Exception e) {
					System.out.println("출금 실패");
					e.printStackTrace();
				}
				break;

			case 4:
				//종료
				check=!check;
				break;

			default:
				break;
			}

		}


	}

}
