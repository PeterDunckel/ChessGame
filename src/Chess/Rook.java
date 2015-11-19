// EGR327 Project CBU
// Rook.java source file for the Rook class
// Created 11-2-15 JT
// This class is used for the Rook piece

// UPDATED ON 11/16/2015

package Chess;

public class Rook extends Piece{

	private int legalMoves;

	//Constructor
	public Rook(){
		super(positionR, positionC, ptVal, name, name, isOwner);
		
	}

	//Set and Get functions
	public void setLegalMoves(int allowedMoves){
		allowedMoves = legalMoves;
	}

	public int getLegalMoves(){
		return legalMoves;
	}

	//Rook Functionality functions
	public int[][] possibleMoves(Spot[][] board){
		int[][] newBoard = new int[8][8];
		
		for( int ii = 1; ii <= 7 ; ii++ ){			
			 //set spot to be looked
			Spot temp = board[positionR][positionC];	//at on the game board
			//Move Straight Across		
			//Move straight from row 0 to 7 
			
			if((positionR+ii) <= 7 ){
				temp = board[positionR +ii][positionC];
				if(temp.getOwner() == owner)
					break;
				if( temp.getOwner() != owner && temp.getOwner() != ""){
					newBoard[positionR+ii][positionC] = 1;
					break;
				}
				newBoard[positionR+ii][positionC] = 1;
			}
			//Move straight from row 7 to 0 
			
			if((positionR - ii) >= 0 ){
				temp = board[positionR - ii][positionC];
				if(temp.getOwner() == owner)
					break;
				if( temp.getOwner() != owner && temp.getOwner() != ""){
					newBoard[positionR-ii][positionC] = 1;
					break;
				}
				newBoard[positionR-ii][positionC] = 1;
			}
			//Move straight from col 0 to 7 
			
			if((positionC+ii) <= 7 ){
				temp = board[positionR][positionC + ii];
				if(temp.getOwner() == owner)
					break;
				if( temp.getOwner() != owner && temp.getOwner() != ""){
					newBoard[positionR][positionC+ii] = 1;
					break;
				}
				newBoard[positionR][positionC+ii] = 1;
			}
			//Move straight from col 7 to 0 
			
			if((positionC-ii) >= 0 ){
				temp = board[positionR][positionC - ii];
				if(temp.getOwner() == owner)
					break;
				if( temp.getOwner() != owner && temp.getOwner() != ""){
					newBoard[positionR][positionC-ii] = 1;
					break;
				}
				newBoard[positionR][positionC-ii] = 1;
			}
		}

		return newBoard;
	}
}
