// EGR327 Project CBU
// Knight.java source file for the Knight class
// Created 11-2-15 PWD
// This class is used for the Knight piece
// REVISION HISTORY:
// Date By Details
//

package Chess;

public class Knight extends Piece{

	private int legalMoves;


	//Constructor
	public Knight( int legalM){
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

	
	//TODO: optimize the possible move code below
	//Knight Functionality functions
	public int[][] possibleMoves(){
		int[][] board = new int[8][8];
		
		//Knight in row 0 or 1
		if( (positionR == 0) || (positionR == 1)){
			if( positionC <= 1){
				board[positionR+2][positionC-1] = 1;
				board[positionR+2][positionC+1] = 1;
				board[positionR+1][positionC+2] = 1;
				if(positionR == 1)
					board[positionR-1][positionC+2] = 1;
			}
			else if( positionC >= 6){
				board[positionR+2][positionC+1] = 1;
				board[positionR+2][positionC-1] = 1;
				board[positionR+1][positionC-2] = 1;
				if(positionR == 1)
					board[positionR-1][positionC-2] = 1;
			}
			else{
				board[positionR+2][positionC+1] = 1;
				board[positionR+2][positionC-1] = 1;
				board[positionR+1][positionC-2] = 1;
				board[positionR+1][positionC+2] = 1;
				if(positionR == 1){
					board[positionR-1][positionC+2] = 1;
					board[positionR-1][positionC-2] = 1;
				}				
			}				
		}
		//Knight in row 6 or 7
		else if( (positionR == 6) || (positionR == 7)){
			if( positionC <= 1){
				board[positionR-2][positionC-1] = 1;
				board[positionR-2][positionC+1] = 1;
				board[positionR-1][positionC+2] = 1;
				if(positionR == 6)
					board[positionR+1][positionC+2] = 1;
			}
			else if( positionC >= 6){
				board[positionR-2][positionC+1] = 1;
				board[positionR-2][positionC-1] = 1;
				board[positionR-1][positionC-2] = 1;
				if(positionR == 6)
					board[positionR+1][positionC-2] = 1;
			}
			else{
				board[positionR-2][positionC+1] = 1;
				board[positionR-2][positionC-1] = 1;
				board[positionR-1][positionC-2] = 1;
				board[positionR-1][positionC+2] = 1;
				if(positionR == 6){
					board[positionR+1][positionC+2] = 1;
					board[positionR+1][positionC-2] = 1;
				}				
			}				
		}
		//Knight in column 0 or 1
		else if( (positionC == 0) || (positionC == 1)){
			if( positionR <= 1){
				board[positionR-1][positionC+2] = 1;
				board[positionR+1][positionC+2] = 1;
				board[positionR+2][positionC+1] = 1;
				if(positionC == 1)
					board[positionR+2][positionC-1] = 1;
			}
			else if( positionR >= 6){
				board[positionR+1][positionC+2] = 1;
				board[positionR-1][positionC+2] = 1;
				board[positionR-2][positionC+1] = 1;
				if(positionC == 1)
					board[positionR-2][positionC-1] = 1;
			}
			else{
				board[positionR+1][positionC+2] = 1;
				board[positionR-1][positionC+2] = 1;
				board[positionR-2][positionC+1] = 1;
				board[positionR+2][positionC+1] = 1;
				if(positionC == 1){
					board[positionR+2][positionC-1] = 1;
					board[positionR-2][positionC-1] = 1;
				}				
			}				
		}
		//Knight in column 6 or 7
		else if( (positionC == 6) || (positionC == 7)){
			if( positionR <= 1){
				board[positionR+2][positionC-1] = 1;
				board[positionR+2][positionC+1] = 1;
				board[positionR+1][positionC+2] = 1;
				if(positionC == 6)
					board[positionR-1][positionC+2] = 1;
			}
			else if( positionR >= 6){
				board[positionR+2][positionC+1] = 1;
				board[positionR+2][positionC-1] = 1;
				board[positionR+1][positionC-2] = 1;
				if(positionC == 6)
					board[positionR-1][positionC-2] = 1;
			}
			else{
				board[positionR+2][positionC+1] = 1;
				board[positionR+2][positionC-1] = 1;
				board[positionR+1][positionC-2] = 1;
				board[positionR+1][positionC+2] = 1;
				if(positionC == 6){
					board[positionR-1][positionC+2] = 1;
					board[positionR-1][positionC-2] = 1;
				}				
			}				
		}
		//Knight in rows 2-5 and columns 2-5
		else{
			board[positionR+2][positionC+1] = 1;
			board[positionR+2][positionC-1] = 1;
			board[positionR+1][positionC-2] = 1;
			board[positionR+1][positionC+2] = 1;
			board[positionR-1][positionC+2] = 1;
			board[positionR-1][positionC-2] = 1;
			board[positionR-2][positionC+1] = 1;
			board[positionR-2][positionC-1] = 1;				
		}
		
		return board;
	}
}
