package com.bridgeLabz;
import java.util.Scanner;

public class TicTacToe {
	public static char gameBoard [] = new char[10]; 
	static int tossResultForPlayer = (int)(Math.random()*10 %2);
	static int tossResultForComputer;
	
	public static void displayBoard(char gameBoard[]) {
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

	public static void addXand0inBox(char enteredVal, int position) {
		gameBoard[position] = enteredVal;
		displayBoard(gameBoard);
	}

	public static void playFromPlayerSide() {
		Scanner sc = new Scanner(System.in);
		switch(tossResultForPlayer) {//if he gets 1 he will go with X or 0
			case 1:
				System.out.println("Enter Player position to place X");
				int positionX = sc.nextInt();
				if(gameBoard[positionX]!=' ') {
					System.out.println("Space not empty please enter vaild position");
					playFromPlayerSide();
					break;
				}
				addXand0inBox('X',positionX);				
				break;
			case 0:
				System.out.println("Enter Player position to place 0");
				int position0 = sc.nextInt();
				if(gameBoard[position0]!=' ') {
					System.out.println("Space not empty please enter vaild position");
					playFromPlayerSide();
					break;
				}
				addXand0inBox('0',position0);
				break;
		}
	}

	public static void playFromComputerSide() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Computer Turn's");
		switch(tossResultForComputer) {			
			case 1:
				int positionX =(int)(Math.random()*10 %9 +1);
				if(gameBoard[positionX]!=' ') {
					System.out.println("Space not empty please enter vaild position");
					playFromComputerSide();
					break;
				}
				addXand0inBox('X',positionX);				
				break;
			case 0:
				int position0 =(int)(Math.random()*10 %9 +1);
				if(gameBoard[position0]!=' ') {
					System.out.println("Space not empty please enter vaild position");
					playFromComputerSide();
					break;
				}
				addXand0inBox('0',position0);
				break;
		}
	}

	public static void play() {
		int n=1;
		while(n<=50) {
			playFromPlayerSide();
			playFromComputerSide();
			n++;
		}
	}

	public static void main(String[] args) {	
		System.out.println("Welcomw to Tic-Tac-Toe");
		for(int i=0;i<10;i++) {
			gameBoard [i] = ' ' ;
		}
		if(tossResultForPlayer==1) {
			tossResultForComputer=0;
		}else {
			tossResultForComputer=1;
		}
		displayBoard(gameBoard);
		play();
	}		
}