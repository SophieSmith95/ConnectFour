/**
*The Players class allows two types of Players object to be creates a human one which accepts
*input from the command line and a computer which generates a random number. Both of the numbers
*generated are used to represent which column the player would like to place their counter.
*/

import java.util.*;

class Players{

public static int humanPlayer(){
	try{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter column number between 1-7");
		int userInput = input.nextInt();			
			if(userInput <= 8 && userInput >=0){	//If the userInput is between 0 and 8
				return userInput -1;					//return the userInput and -1.
			}else{
				return -1;
			}
			}catch(Exception InputMismatchException){ 
				System.err.println("Error please enter a number between 1-7");
				return -1;
	}
}

public static int computerPlayer(){
	Random rand = new Random();	//Create a new Random object.
	int randomNumber = rand.nextInt((6-0) + 1) + 0;	//This allows a random number between 0 and 6 to be generated.
	return randomNumber;
}

public static int getUserInput(){
	return humanPlayer(); //Get the value of the userInput.
}
}