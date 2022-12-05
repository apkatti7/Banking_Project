package com.greatlearning.main;

import java.util.Scanner;

import com.greatlearning.interfaces.InternetBanking;
import com.greatlearning.model.Customer;
import com.greatlearning.service.IndianBank;

public class DriverClass {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		//create customer object and set the hardcoded values for bankaccount no and password
		
		Customer indianBankCustomer1 = new Customer();
		indianBankCustomer1.setBankAccountNo("110011");
		indianBankCustomer1.setPassword("password*123");
		
		InternetBanking indianBank = new IndianBank();
		
		//validate the credentials from the user input
		//user input to be read
		System.out.println("Welcome to Indian Bank ...");
		
		System.out.println("Enter the bank account no");
		String bankAccountNo = userInput.nextLine();
		
		System.out.println("Enter the password");
		String password = userInput.nextLine();
		
		// and then validated
		if(indianBankCustomer1.getBankAccountNo().equals(bankAccountNo) 
				&& (indianBankCustomer1.getPassword().equals(password)) ) {
			System.out.println("Logged in successfully");
			int option;
			do {
				//give options to 1.deposit, 2.withdraw, 3. transfer, 4. check balance
				System.out.println("Choose the option you wish to perform");
				System.out.println("1. Deposit");
				System.out.println("2. Withdrawal");
				System.out.println("3. Transfer");
				System.out.println("4. Check balance");
				System.out.println("0. Logout");
				
				option = userInput.nextInt();
				
				//use switch case to direct to the appropriate bank operation
				switch(option) {
					case 0:
						break;
						
					case 1: {
						boolean depositStatus = indianBank.deposit();
						System.out.println("Deposit status is : " + ((depositStatus) ? "Success" : "Failed" ));
						/*if(depositStatus) {
							System.out.println("Deposit was a success");
						} else {
							System.out.println("Deposit was a failure");
						}*/
					}
					break;
					
					case 2: {
						boolean withdrawStatus = indianBank.withdraw();
						System.out.println("Withdraw status is : " + ((withdrawStatus) ? "Success" : "Failed" ));
					}
					break;
					
					case 3: {
						boolean transferStatus = indianBank.transfer();
						System.out.println("Transfer status is : " + ((transferStatus) ? "Success" : "Failed" ));
					}
					
					case 4: {
						int bankBalance = indianBank.checkbalance();
						System.out.println("Bank balance is " + bankBalance);
						
					}
				}
				
			} while (option !=0);//until user selects logout option (0) repeat this loop
			System.out.println("Logged out successfully");
			userInput.close();
		} else {
			System.out.println("Credentials entered are invalid - Please check the bank account no and password");
		}
		
	}
}
