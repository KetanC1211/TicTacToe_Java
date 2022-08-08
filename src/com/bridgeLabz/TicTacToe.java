package com.bridgeLabz;
import java.util.Scanner;

public class TicTacToe {
	public static char gameBoard [] = new char[10]; 
	
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
		if(gameBoard[position]!=' ') {
			play();
		}
		gameBoard[position] = enteredVal;
		displayBoard(gameBoard);
	}

	public static void play() {
		Scanner scan = new Scanner(System.in);
		int toss = (int)(Math.random()*10 %2);
		int n = 1;
		while( n <= 9) {
			switch(toss) {
				case 1:
					System.out.println("Enter the position to place X");
					int positionX = scan.nextInt();
					addXand0inBox('X',positionX);				
					break;
				case 0:
					System.out.println("Enter the position to place 0");
					//int position0 = scan.nextInt();
					addXand0inBox('0',(int)(Math.random()*10 %9 +1));
					break;
			}
			if(toss==1) {
				toss=0;
			}
			else {
				toss=1;
			}
			n++;
		}
	}

	public static void main(String[] args) {	
		System.out.println("Welcomw to Tic-Tac-Toe");
		for(int i=0;i<10;i++) {
			gameBoard [i] = ' ' ;
		}
		System.out.println();
		displayBoard(gameBoard);
		play();
	}		
}