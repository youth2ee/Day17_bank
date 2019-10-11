package com.naver.bank;

import java.util.Scanner;
import com.naver.amember.AmemberController;

public class BankMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		AmemberController amemberController = new AmemberController();
		amemberController.start();

	}

}
