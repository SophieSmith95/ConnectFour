/**
*The board class creates a standard sized connect four board and prints it to the screen.
*This class also allows the board to be printed to the screen each time a turn is take and a new counter
*has been placed into the board. The board class is also used to check for a full column,
*vertical, horizontal and both direction of diagonal wins.
*/

import java.util.*;

class board{

private static char[][] Board = new char[6][7];

public static char[][] connectBoard(int col, char counter){
	for(col=0; col<Board.length; col++){ 			//Looping through array.
		for(int row=0; row<Board[0].length; row++){ //Looping through array.
				Board[col][row] = counter; 			//Prints a counter to the position specified by the col and row integers.
			}
		}
	printTable(Board);
	return Board;
}

public static void printTable(char[][] board){
	for(int col=0; col<Board.length; col++){ 			 //Looping through array and printing '|' at each postion in array.
		System.out.print("|"); 							 //Height.
			for(int row=0; row<Board[0].length; row++){  //Looping through array and printing '|' at each postion in array.
				System.out.print(Board[col][row] + "|"); //Width.
			}
		System.out.println();
	}
}

public static void updateBoard(int row, char counter){
	boolean played = false;
		for(int col = Board.length-1; col>=0; col--){	//If the integer col is equal to the length of the Board[][] -1
			if(Board[col][row] == ' '){					//and more than or equal to 0, -1 from col. Add col and row 
				if(played == false){					//to the array, if empty space add counter and change
					Board[col][row] = counter;			//played to true to stop the loop.
					played = true;				
				}	
			}
		}
	printTable(Board);
}

public static boolean checkForFullColumn(int row){
	boolean full = false;
		for(int col = Board.length-1; col>=0; col--){  //If the integer col is equal to the length of the Board[][] -1
			if(Board[col][row] == ' '){				   //and more than or equal to 0, -1 from col. Add col and row to
				return false;						   //the array, if empty space and return false to show there is an
			}else{									   //empty space.
			
			}
		}
		return true;
}

public static boolean checkForWin(char colour){
	int counter = 0;
	boolean win = false;
	
		//Check for a horizontal win.
		for(int col = 0; col<6; col++){ 		//Looping through each column.
			for(int row = 0; row<7; row++){ 	//Looping through each row.
				if(Board[col][row] == colour){	//If the position specified by the row and column is filled with a color
					counter ++;					//add one to counter.
				}else{
					counter = 0;
				}
			if(counter == 4){	//If the counter equals 4 print to the screen the winner and set win to true.
				System.out.println("WINNER is player with counter " + colour);  
				win = true;
			}
			}
		}
		//Check for a vertical win.
		for(int row = 0; row<7; row++){ 		//Looping through each row.	
			for(int col = 0; col<6; col++){		//Looping through each column.
				if(Board[col][row] == colour){	//If the position specified by the row and column is filled with a color
					counter++;					//add one to the counter.
				}else{
					counter = 0;
				}	
			if(counter ==4){   //If the counter equals 4 print to the screen the winner and set win to true.
				System.out.println("WINNER is player with counter " + colour);
				win = true;
			}
		}
		}
		//Check for a backwards diagonal.
		for(int col=0; col<3; col++){			//Looping through each column.
			for(int row=0; row<4; row++){		//Looping through each row.
				if((Board[col][row] == colour &&	//If each position specified by the row and column is filled with a colour
				   Board[col+1][row+1] == colour &&
				   Board[col+2][row+2] == colour &&
				   Board[col+3][row+3] == colour) ||
		//Check for a forwards diagonal.
				   (Board[col+3][row] == colour &&
				   Board[col+2][row+1] == colour &&
				   Board[col+1][row+2] == colour &&
				   Board[col][row+3] == colour)){
				   System.out.println("WINNER is player with counter " + colour); //Print to the screen the winner 
				   win = true;													  //and set win tot true.
				}
			}
		}
		return win;
}

}


