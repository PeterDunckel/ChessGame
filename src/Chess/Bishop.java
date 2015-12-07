// EGR327 Project CBU
// Bishop.java source file for the Bishop class
// Created 11-2-15 PWD
// This class is used for the Bishop piece
// REVISION HISTORY:
// Date By Details
// 11/18/2015 JT Added additional functionality to possibleMoves function to check if a piece is in the way of a move 
//

package Chess;

public class Bishop extends Piece{

	private int legalMoves;


	//Constructor
	public Bishop(){
		super(positionR, positionC, ptVal, name, name, isOwner);
	}

	//Set and Get functions
	public void setLegalMoves(int allowedMoves){
		allowedMoves = legalMoves;
	}

	public int getLegalMoves(){
		return legalMoves;
	}

	//Bishop Functionality functions
	@Override
	public int[][] possibleMoves(Spot[][] board){
		int[][] newBoard = new int[8][8];
		boolean[] isPossible = new boolean[8];
		
		for( int pos = 0; pos <8; pos++){
			isPossible[pos] = true;
		}
		
		for( int ii = 1; ii <= 7 ; ii++ ){			
			Spot temp = board[positionR][positionC]; //set spot to be looked
													//at on the game board				
			//Move Diagonally Across
			//Move Diagonally from corner 0,0 to corner 7,7
			if((((positionR+ii) <= 7) && ((positionC+ii) <= 7)) && isPossible[4] == true){
				temp = board[positionR+ii][positionC+ii];
				if(temp.getOwner() == owner) {
					isPossible[4] = false;
				} else if( temp.getOwner() != owner && temp.getOwner() != null){
					newBoard[positionR+ii][positionC+ii] = 1;
					isPossible[4] = false;
				} else {
					newBoard[positionR+ii][positionC+ii] = 1;
				}
			}	
			
			//Move Diagonally from corner 7,7 to corner 0,0
			if((((positionR-ii) >= 0) && ((positionC-ii) >= 0)) && isPossible[5] == true){
				temp = board[positionR-ii][positionC-ii];
				if(temp.getOwner() == owner) {
					isPossible[5] = false;
				} else if( temp.getOwner() != owner && temp.getOwner() != null){
					newBoard[positionR-ii][positionC-ii] = 1;
					isPossible[5] = false;
				} else {
					newBoard[positionR-ii][positionC-ii] = 1;
				}
			}
			
			//Move Diagonally from corner 0,7 to corner 7,0
			if((((positionR+ii) <= 7) && ((positionC-ii) >= 0)) && isPossible[6] == true){
				temp = board[positionR+ii][positionC-ii];
				if(temp.getOwner() == owner) {
					isPossible[6] = false;
				} else if( temp.getOwner() != owner && temp.getOwner() != null){
					newBoard[positionR+ii][positionC-ii] = 1;
					isPossible[6] = false;
				} else {
					newBoard[positionR+ii][positionC-ii] = 1;
				}
			}
			
			//Move Diagonally from corner 7,0 to corner 0,7
			if((((positionR-ii) >= 0) && ((positionC+ii) <= 7)) && isPossible[7] == true){
				temp = board[positionR-ii][positionC+ii];
				if(temp.getOwner() == owner) {
					isPossible[7] = false;
				} else if( temp.getOwner() != owner && temp.getOwner() != null){
					newBoard[positionR-ii][positionC+ii] = 1;
					isPossible[7] = false;
				} else {
				newBoard[positionR-ii][positionC+ii] = 1;
				}
			}
		}
		
		return newBoard;
	}
}
