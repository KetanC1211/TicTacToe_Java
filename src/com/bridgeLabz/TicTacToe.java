package com.bridgeLabz;
import java.util.Scanner;

public class TicTacToe {
	public static String gameBoard [] = new String[10]; 
	static int tossToDecideWhoStartsFirst = (int)(Math.random()*10 %2);
	static int tossResultForComputer;
	static int playerChoiceForXand0;
	static int computerChoiceForXand0;
	static int playerChoiceForToss;

	public static void tossBetweenPlayerAndComputer() {
		System.out.println("lets to do Toss");
		System.out.println("To select heads enter 1 \nTo select tails enter 0");
		Scanner sc = new Scanner(System.in);
		playerChoiceForToss = sc.nextInt();
		 
		if(tossToDecideWhoStartsFirst==playerChoiceForToss) {
			System.out.println("You won the toss you can play first");
			System.out.println("To play with X enter 1 \nTo play with 0 enter 0");
			playerChoiceForXand0 = sc.nextInt();
			if(playerChoiceForXand0==1) {
				System.out.println("You have selected X to start Game \nComputer will play with 0");
				computerChoiceForXand0=0;
			}
			else {
				System.out.println("You have selected 0 to start game \nComputer will play with X");
				computerChoiceForXand0=1;
			}
		}
		else {
			System.out.println("You lost the toss computer will play first");
			computerChoiceForXand0 = (int)(Math.random()*10 %2);
			if(computerChoiceForXand0==1) {
				System.out.println("Computer have selected X to start Game \nYou have to will play with 0");
				playerChoiceForXand0=0;
			}
			else {
				System.out.println("Computer have selected 0 to start Game \nYou have to will play with X");
				playerChoiceForXand0=1;
			}
		}
		
	}
	
	public static void displayBoard(String gameBoard[]) {
		for(int i=1;i<10;i++) {
			if(i==1) {
				System.out.println("-------------");
			}
			System.out.print("| "+gameBoard[i]+" ");
			if(i==3||i==6) {
				System.out.print("|");
				System.out.println("\n-------------");
			}
		}
		System.out.println("|");
		System.out.println("-------------");
	}
	
	public static void checkWinSituation(){
        for (int a = 0; a < 8; a++) {
            String line = null;
  
            switch (a) {
            case 0:
                line = gameBoard[1] + gameBoard[2] + gameBoard[3];
                break;
            case 1:
                line = gameBoard[4] + gameBoard[5] + gameBoard[6];
                break;
            case 2:
                line = gameBoard[7] + gameBoard[8] + gameBoard[9];
                break;
            case 3:
                line = gameBoard[1] + gameBoard[2] + gameBoard[3];
                break;
            case 4:
                line = gameBoard[4] + gameBoard[5] + gameBoard[6];
                break;
            case 5:
                line = gameBoard[3] + gameBoard[6] + gameBoard[9];
                break;
            case 6:
                line = gameBoard[1] + gameBoard[5] + gameBoard[9];
                break;
            case 7:
                line = gameBoard[3] +gameBoard[5] + gameBoard[7];
                break;
            }
            //For X winner
            if (line.equals("XXX")) {
            	if(playerChoiceForXand0==1) { //players has choosen X
    				System.out.println("You won the Game");
    			}
            	else {
            		System.out.println("You have Lost the game");
            	}
            System.exit(0);	
            }
            // For O winner
            if(line.equals("000")) {
            	if(playerChoiceForXand0==1) { //players has choosen X
    				System.out.println("You have Lost the Game");
    			}
            	else {
            		System.out.println("You won the game");
            	}
            System.exit(0);
            }         
        }  
	}
	public static void allBoxFilledthenEndTheGame() {
		int numberOfBoxFilled=0;
		for(int i =1;i<10;i++) {
			if(gameBoard[i]!=" ") {
				numberOfBoxFilled++;
			}
		}
		if(numberOfBoxFilled==9) {
			System.out.println("GameOver");
			System.exit(0);
		}
	} 

	public static void addXand0inBox(String enteredVal, int position) {
		gameBoard[position] = enteredVal;
		displayBoard(gameBoard);
	}



	public static void playFromPlayerSide() {
		checkWinSituation();
		allBoxFilledthenEndTheGame() ;
		Scanner sc = new Scanner(System.in);
		switch(playerChoiceForXand0) {//if he gets 1 he will go with X or 0
			case 1:
				System.out.println("Enter Player position to place X");
				int positionX = sc.nextInt();
				if(gameBoard[positionX]!=" ") {
					System.out.println("Space not empty please enter vaild position");
					playFromPlayerSide();
					break;
				}
				addXand0inBox("X",positionX);				
				break;
			case 0:
				System.out.println("Enter Player position to place 0");
				int position0 = sc.nextInt();
				if(gameBoard[position0]!=" ") {
					System.out.println("Space not empty please enter vaild position");
					playFromPlayerSide();
					break;
				}
				addXand0inBox("0",position0);
				break;
		}
	}

	public static void playFromComputerSide() {
		checkWinSituation();
		allBoxFilledthenEndTheGame() ;
		Scanner sc = new Scanner(System.in);
		switch(computerChoiceForXand0) {			
			case 1:
				int positionX =(int)(Math.random()*10 %9 +1);
				if(gameBoard[positionX]!=" ") {
					//System.out.println("Space not empty please enter vaild position");
					playFromComputerSide();
					break;
				}
				System.out.println("Computer Turn's");
				addXand0inBox("X",positionX);				
				break;
			case 0:
				int position0 =(int)(Math.random()*10 %9 +1);
				if(gameBoard[position0]!=" ") {
					//System.out.println("Space not empty please enter vaild position");
					playFromComputerSide();
					break;
				}
				System.out.println("Computer Turn's");
				addXand0inBox("0",position0);
				break;
		}
	}

	public static void play() {
		int n=1;
		if(tossToDecideWhoStartsFirst==playerChoiceForToss){	
			while(n<=50) {
				playFromPlayerSide();
				playFromComputerSide();
				n++;
			}
		}
		else{
			while(n<=50) {
				playFromComputerSide();
				playFromPlayerSide();
				n++;
			}
		}
	}

	public static void main(String[] args) {	
		System.out.println("Welcomw to Tic-Tac-Toe");
		for(int i=0;i<10;i++) {
			gameBoard [i] = " ";
		}
		displayBoard(gameBoard);
		tossBetweenPlayerAndComputer();		
		play();
	}		
}