package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	
	static ArrayList<Integer> player_positions = new ArrayList<Integer>();
	static ArrayList<Integer> computer_positions = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		char [] [] gameboard = {
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}};
		
		
			
			while(true) {
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter your placement (1-9):");
				int Player_pos = scan.nextInt();
				while(player_positions.contains(Player_pos) || computer_positions.contains(Player_pos)) {
					System.out.println("Position already taken! Enter new position: ");
					Player_pos = scan.nextInt();
				}
				
				markBoard(gameboard, Player_pos, "Player");
				
				String result= checkWinner();
				if(result.length() > 0) {
					printGameBoard(gameboard);
					System.out.println(result);
					break;
				}
				
				
				Random rand = new Random();
				int Computer_pos = rand.nextInt(9) + 1;
				while(player_positions.contains(Computer_pos) || computer_positions.contains(Computer_pos)) {
					Computer_pos = rand.nextInt(9) + 1;
				}
				markBoard(gameboard, Computer_pos, "Computer");
				
				
				printGameBoard(gameboard);
				
				result= checkWinner();
				if(result.length() > 0) {
					printGameBoard(gameboard);
					System.out.println(result);
					break;
				}
				
			}
		
			}
	
	public static void printGameBoard(char[][] gameboard) {
		for(char[] row : gameboard) {
			for(char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}


	}
	
	public static void markBoard(char[][] gameboard, int pos, String user) {
		
		char symbol = ' ';
		
		if(user.equals("Player")) {
			symbol = 'X';
			player_positions.add(pos);
		}
		else if(user.equals("Computer")) {
			symbol = 'O';
			computer_positions.add(pos);
		}
		
		
		switch(pos) {
			case 1:
				gameboard[0][0] = symbol;
				break;
			case 2:
				gameboard[0][2] = symbol;
				break;
			case 3:
				gameboard[0][4] = symbol;
				break;
			case 4:
				gameboard[2][0] = symbol;
				break;
			case 5:
				gameboard[2][2] = symbol;
				break;
			case 6:
				gameboard[2][4] = symbol;
				break;
			case 7:
				gameboard[4][0] = symbol;
				break;
			case 8:
				gameboard[4][2] = symbol;
				break;
			case 9:
				gameboard[4][4] = symbol;
				break;	
			default:
				break;
	}
	}
	
	public static String checkWinner() {
		
		List toprow = Arrays.asList(1, 2, 3);
		List midrow = Arrays.asList(4, 5, 6);
		List botrow = Arrays.asList(7, 8, 9);
		List leftcol = Arrays.asList(1, 4, 7);
		List midcol = Arrays.asList(2, 5, 8);
		List rightcol = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3);
		
		List<List> winning_pos = new ArrayList<List>();
		winning_pos.add(toprow);
		winning_pos.add(midrow);
		winning_pos.add(botrow);
		winning_pos.add(leftcol);
		winning_pos.add(midcol);
		winning_pos.add(rightcol);
		winning_pos.add(cross1);
		winning_pos.add(cross2);
		
		for(List l : winning_pos) {
			if(player_positions.containsAll(l) ) {
				return "Yay You Winnn!";
			}
			else if(computer_positions.containsAll(l)) {
				return "Sorry You Lost:(";
			}
			else if(player_positions.size() + computer_positions.size() == 9) {
				return "Game Tied heh";
			}
		}
		
		return "";
	}

}
