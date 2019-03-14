package com.capgemini.BankApplication;

import java.util.Scanner;

import com.cg.ba.DTO.CustomerDetails;
import com.cg.ba.DTO.TransactionDetails;
import com.cg.ba.Service.BankAppServiceImpl1;
import com.cg.ba.Service.BankAppServiceImpl2;
import com.cg.ba.Service.IBankAppService1;
import com.cg.ba.Service.IBankAppService2;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CustomerDetails custDetails = new CustomerDetails();
		TransactionDetails td = new TransactionDetails();
		IBankAppService1 bankAppService1 = new BankAppServiceImpl1();
		IBankAppService2 bankAppService2 = new BankAppServiceImpl2();

		System.out.println("Enter 1. Account 2. Transaction");
		int menu = sc.nextInt();
		switch (menu) {
		case 1:
			System.out.println("Enter First name and last name");
			custDetails.setFirstName(sc.next());
			custDetails.setLastName(sc.next());
			System.out.println("Enter email_id");
			custDetails.setEmailId(sc.next());
			System.out.println("Enetr password");
			custDetails.setPassword(sc.next());
			System.out.println("Enter pancard no");
			custDetails.setPancardNo(sc.next());
			System.out.println("Enter aadharno");
			custDetails.setAadharNo(sc.next());
			System.out.println("Enter address ");
			custDetails.setAddress(sc.next());
			System.out.println("Enter mobile no");
			custDetails.setMobile(sc.nextInt());
			custDetails.setBalance(0);
			int accoNo = bankAppService1.registerCustomer(custDetails);

			System.out.println("Account no : " + accoNo);

			break;
		case 2:

			System.out.println("Enter 1.for Login");
			int i = sc.nextInt();
			if (i == 1) {

				do {

					System.out
							.println("Enter 1. Deposit 2. Withdraw 3. Show Balance 4. Fund Transfer 5. Exit");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Enter amount");
						int amount1 = sc.nextInt();
						System.out.println("Enter account no");
						int accono1 = sc.nextInt();

						int j = bankAppService2.deposit(accono1, amount1);
						if (j == 1) {
							System.out.println("Successfully Deposited ");
						}
						break;
					case 2:
						System.out.println("Enter amount");
						int amount2 = sc.nextInt();
						System.out.println("Enter account no");
						int accono2 = sc.nextInt();
						int m = bankAppService2.withdrawal(accono2, amount2);
						System.out.println("Successfully Withdrawn");
						break;
					case 3:
						System.out.println("Enter account no ");
						int accono3 = sc.nextInt();
						int k = bankAppService2.showBalance(accono3);
						System.out.println("Balance is: " + k);
						break;
					case 4:
						System.out.println("Enter amount to be transfered");
						td.setAmountTransfered(sc.nextInt());
						System.out.println("Enter from amount no");
						td.setFromAccountNo(sc.nextInt());
						System.out.println("Enter to account no");
						td.setToAccountNo(sc.nextInt());
						int n = bankAppService2.transferFund(td);
                             if(n==1){
                            	 System.out.println("Fund transfered from"+ td.getFromAccountNo()+" to "+td.getToAccountNo()+ " : "+ td.getAmountTransfered());
                             }
						break;
					case 5:
						System.exit(0);
						break;
					default:
						System.out.println("Invalid choice");

					}
				} while (true);
			}

		case 3:
			System.exit(0);
			break;
		default:
			System.out.println("invalid choice");
		}

	}

}