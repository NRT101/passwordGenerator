package password.generator;

import java.util.Random;
import java.util.Scanner;

public class Generator {
	/*
	 * Integer verification check
	 */
	public static boolean isInteger(String input) {
		boolean isInteger=false;
		try {
			// checking input
			int integer =Integer.parseInt(input);
			if(integer>=8) {
				isInteger=true;
			}
		}
		catch(NumberFormatException e) {
		}
		return isInteger;
	}
	// ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*_=+-/.?<>)
	public static void main(String[] args) {
		// auto close scanner
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the character list to generate password from : ");

            // gets a valid input of characters
            String characterInput = scanner.nextLine();  // Read user input
            int inputLength=characterInput.length();
            while(inputLength==0) {
            	System.out.print("Enter a valid set of characters: ");
            	characterInput = scanner.nextLine();  
                inputLength=characterInput.length();
            }
            
            // Random Generator
            Random randomPointGenerator= new Random();
            
            // generates a random password length from user input
            System.out.print("What is the max password length. Minimum length is 8 : ");
            String passwordLengthInput= scanner.nextLine();
            while(!isInteger(passwordLengthInput)) {
            	System.out.print("Please enter a valid integer: ");
            	passwordLengthInput= scanner.nextLine();
            }
            int passwordLengthFromInput = Integer.parseInt(passwordLengthInput);
            
            // generates random password length from max given by user
            int randomPasswordLength=0;
            while(randomPasswordLength<8 || randomPasswordLength>passwordLengthFromInput) {
            	randomPasswordLength=randomPointGenerator.nextInt(passwordLengthFromInput);
            }
            //System.out.println("Password length: " +randomPasswordLength);
            // generates the password
            StringBuilder password = new StringBuilder(); // stores the result
            for(int point=0;point<randomPasswordLength;point++) {
            	password.append(characterInput.charAt(randomPointGenerator.nextInt(inputLength)));
            }
            System.out.println(password);
        }
        catch(Exception e) {
        	System.out.println(e);
        }

	}

}
