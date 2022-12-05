package com.greatlearning.service;

public class OTPGenerator {
	
	public int generateOTP() {
		int randomOTP = (int)(Math.random() * 9000) + 1000;
		return randomOTP;
	}
}
