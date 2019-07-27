/**
*The ConnectFour class is the main class used to allow the user and computer to take turns
*in placing a counter into the board and also this class is used to check to see if the
*board is full and therefore causing a tie.
*/

class ConnectFour{

private static board gameBoard = new board();
private static int movesDone;

public static void main(String[] args){
	System.out.println("CONNECT FOUR");
	gameBoard.connectBoard(0,' '); //Print an empty board to the screen.
	System.out.println();
	takeTurns();
}

public static void takeTurns(){
	Players human = new Players(); //Create a new player object.
	Players computer = new Players();	//Create a new player object.
	while(true){
		int humanInput = human.humanPlayer();
		int computerInput = computer.computerPlayer();
		if(humanInput <= -1){ 									//If the user inputs an invalid number 
			System.err.println("Error column doesn't exist");	//an error will print to the screen
				takeTurns();									//and they will be prompted to re enter a number.
		}else{
			if(!gameBoard.checkForFullColumn(humanInput) && !checkForFullBoard()){ //If the chosen column and the whole board is not full
				gameBoard.updateBoard(humanInput, 'R');							   //print the board to the screen
				movesDone++;													   //and add one to movesDone.
					if(gameBoard.checkForWin('R')){	//Check if R has won and if true
						System.exit(0);				//exit the game.
					}else{
						System.out.println();
						if(!gameBoard.checkForFullColumn(computerInput) && !checkForFullBoard()){ //If the chosen column and the whole board
							gameBoard.updateBoard(computerInput, 'Y');								  //print the board to the screen
							movesDone++;															  //and add one to movesDone.
					if(gameBoard.checkForWin('Y')){	//Check if R has won and if true	
							System.exit(0);			//exit the game.
					}	
					}
		   			}
		   	}
		}
	}

}

public static boolean checkForFullBoard(){
		if(movesDone >= 42){	//If movesDone is more than or equal 42 the board will be full so return true.
			System.err.println("The board is full so it is a draw");
			return true;
		}else{
			return false;
		}
}
}

