package com.greatlearning.service;

import java.util.Scanner;

import com.greatlearning.interfaces.InternetBanking;

public class IndianBank implements InternetBanking{
	
	private int bankBalance = 1000;
	
	Scanner userInput = new Scanner(System.in);
	
	public boolean deposit() {
		//amountToDeposit
		System.out.println("Enter the amount to be deposited ");
		int amountToDeposit = userInput.nextInt();
		if(amountToDeposit > 0) {
			//add this amount to the bank balance
			bankBalance = bankBalance + amountToDeposit;
			System.out.println("The amount " + amountToDeposit + "is deposited successfully");
			System.out.println("Updated bank balance : " + bankBalance);
			return true;
		} else {
			System.out.println("Amount entered was invalid - less than zero");
			return false;
		}
	}
	
	public boolean withdraw() {
		//amount to withdraw
		System.out.println("Enter the amount to withdraw ");
		int amountToWithdraw = userInput.nextInt();
		int currentAmount = bankBalance - amountToWithdraw;
		if(currentAmount >=0 ) {
			System.out.println("Amount " +amountToWithdraw + " is withdrawn successfully");
			bankBalance = currentAmount;
			System.out.println("Remaining bank balance is " + bankBalance);
			return true;
		} else {
			System.out.println("Insufficient funds - Enter a value less than or equal to " +bankBalance);
			return false;
		}
		//check balance
	}
	
	public boolean transfer() {
		OTPGenerator otpGenerator = new OTPGenerator();
		int otpGenerated = otpGenerator.generateOTP();
		
		System.out.println("OTP Generated is " + otpGenerated);
		
		//user inputs otp
		System.out.println("Enter the OTP");
		int otpUserInput = userInput.nextInt();
		
		//verify/validate the OTP
		if(otpGenerated == otpUserInput) {
			System.out.println("OTP validation successful");
			//user has to input amount to transfer
			System.out.println("Enter the amount to transfer");
			int amountToTransfer = userInput.nextInt();
			
			//the destination/target accountNo
			System.out.println("Enter the bank account No to which you wish to transfer the amount");
			int targetBankAccountNo = userInput.nextInt();
			
			int currentAmount = bankBalance - amountToTransfer;
			//replicate withdraw
			if(currentAmount >=0 ) {
				System.out.println("Amount " + amountToTransfer + "transferred successfully to " + targetBankAccountNo);
				bankBalance = currentAmount;
				System.out.println("Remaining bank balance " + bankBalance);
				return true;
			} else {
				System.out.println("Insufficient funds - cannot complete transfer request ");
				return false;
			}
			
		} else {
			System.out.println("OTP entered is invalid");
			return false;
		}
		
		
	}
	
	public int checkbalance() {
		return this.bankBalance;
	}
	
}
