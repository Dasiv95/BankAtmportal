package com.bell.s10;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class BAtm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your bank name : \n  examples are Amex,discover,BOA,Wpatt ");
		String bName = sc.next();  //this store bank name
		int cvvN=3;  // number of digits in cvv
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();   //This is used to get todays date
		SimpleDateFormat a = new SimpleDateFormat("MM/yy");
		String s = a.format(date);  // This converts the date object into string format
		String []b = s.split("/");
		//I am converting todays date into month and year and storig them in
		// 2 different variables
		int cDateM = Integer.valueOf(b[0]);
		int cDateY = Integer.valueOf(b[1]);
		
		// If its discover card then we do not accept it.
		if(bName.equalsIgnoreCase("discover")){
			System.out.println("We donot process Discover cards. Please use another bank");
		}
		// If it is amex card then it will have 15 digit number and a 4 digit cvv
		if(bName.equalsIgnoreCase("Amex")){
			cvvN=4;
		    System.out.println("Please enter your 15 digit card number");
		}
		//all other cards will have 3 digit cvv and 16 digit number
		
		else
			System.out.println("Please enter your 16 digit card number");
		String cNum  = sc.next();
		
		int check=0;
		// I am using this variable to check if all the characters entered are digits 4
		// or not
		for(int i=0;i<cNum.length();i++){
			if(Character.isDigit(cNum.charAt(i))){
				++check;
			}
		}
		/*
		 * If all the numbers are digits then I am continuing the process
		 * otherwise I am giving an exception in  else loop
		 */
		
		if(check==cNum.length()){
			System.out.println("Please enter the expiry date on your card in the format mm-yy");
			String eDate = sc.next();
			String []c = eDate.split("-");  // This is the date entered by user
			// Now we have to compare the expiry date
			int uDateM = 0;
			int uDateY = 0;
			try{
			uDateM = Integer.valueOf(c[0]);
			uDateY = Integer.valueOf(c[1]);
			}
			catch(NumberFormatException e){
				
				System.out.println("Please enter the expiry date in mm-yy format only");
			}
			/*
			 * If the expiry date is not given in the mentioned format or not
			 * integer numbersthen I am throwing exception 
			 */
			
			if(uDateY!=0 && uDateM!=0){
			if(uDateY>=cDateY){
				/*
				 * If the year is same then I am comparing the month 
				 */
				if(uDateY==cDateY){
					if(uDateM>=cDateM){
						System.out.println("Please enter you "+cvvN+" digit cvv:");
						String cvvInp = sc.next();
						try{
						int cvv = Integer.parseInt(cvvInp);
						System.out.println("Your card has been processed. Thank you.");
						}
						catch(NumberFormatException e){
							System.out.println("Please enter "+cvvN+" digit cvv number only");
						}
					}
					else{
						try {
							throw new Exception();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							System.out.println("Your card has expired this year. Please use an alternate card");
						}
					}
				}
				else{
					System.out.println("Please enter you "+cvvN+" digit cvv:");
					String cvvInp = sc.next();
					try{
					int cvv = Integer.parseInt(cvvInp);
					System.out.println("Your card has been processed. Thank you.");
					}
					catch(NumberFormatException e){
						System.out.println("Please enter "+cvvN+" digit cvv number only");
					}
				}
				
			}
			else{
				try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Your card has expired. Please use an alternate card");
				}
			}
		}
		}
			else{
				try {
					throw new Exception();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Please Enter digits only ");
				}
			}
			
			
			
	
		}
	}
	


