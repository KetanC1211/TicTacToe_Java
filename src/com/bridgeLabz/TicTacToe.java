package com.bridgeLabz;

public class TicTacToe {
	public static char gameboard [] = new char[10]; 
	
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
	
	public static void main(String[] args) {	
		System.out.println("Welcomw to Tic-Tac-Toe");
		for(int i=0;i<10;i++) {
			gameboard [i] = ' ' ;
		}
		System.out.println();
		displayBoard(gameboard);
	}		
}