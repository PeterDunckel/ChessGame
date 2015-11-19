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
	public Bishop( int legalM){
		super(positionR, positionC, ptVal, name, name, isOwner);
		legalMoves = legalM; 
	}

	//Set and Get functions
	public void setLegalMoves(int allowedMoves){
		allowedMoves = legalMoves;
	}

	public int getLegalMoves(){
		return legalMoves;
	}

	//Bishop Functionality functions
	public int[][] possibleMoves(Spot[][] board){
		int[][] newBoard = new int[8][8];
		
		for( int ii = 1; ii <= 7 ; ii++ ){			
			Spot temp = board[positionR][positionC]; //set spot to be looked
													//at on the game board
			//Move Diagonally Across
			//Move Diagonally from corner 0,0 to corner 7,7
				
				if(((positionR+ii) <= 7) || ((positionC+ii) <= 7)){
					temp = board[positionR+ii][positionC+ii];
					if(temp.getOwner() == owner)
						break;
					if( temp.getOwner() != owner && temp.getOwner() != ""){
						newBoard[positionR+ii][positionC+ii] = 1;
						break;
					}
					newBoard[positionR+ii][positionC+ii] = 1;
				}	
			//Move Diagonally from corner 7,7 to corner 0,0
				
				if(((positionR-ii) >= 0) || ((positionC-ii) >= 7)){
					temp = board[positionR-ii][positionC-ii];
					if(temp.getOwner() == owner)
						break;
					if( temp.getOwner() != owner && temp.getOwner() != ""){
						newBoard[positionR-ii][positionC-ii] = 1;
						break;
					}
					newBoard[positionR-ii][positionC-ii] = 1;
				}
			//Move Diagonally from corner 0,7 to corner 7,0
				
				if(((positionR+ii) <= 0) || ((positionC-ii) >= 7)){
					temp = board[positionR+ii][positionC-ii];
					if(temp.getOwner() == owner)
						break;
					if( temp.getOwner() != owner && temp.getOwner() != ""){
						newBoard[positionR+ii][positionC-ii] = 1;
						break;
					}
					newBoard[positionR+ii][positionC-ii] = 1;
				}
			//Move Diagonally from corner 7,0 to corner 0,7
				
				if(((positionR-ii) >= 0) || ((positionC+ii) <= 7)){
					temp = board[positionR-ii][positionC+ii];
					if(temp.getOwner() == owner)
						break;
					if( temp.getOwner() != owner && temp.getOwner() != ""){
						newBoard[positionR-ii][positionC+ii] = 1;
						break;
					}
					newBoard[positionR-ii][positionC+ii] = 1;
				}
		}
		
		return newBoard;
	}
}
