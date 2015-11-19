// EGR327 Project CBU
// Pawn.java source file for the Pawn class
// Created 11-2-15 NN
// This class is used for the Pawn piece
// REVISION HISTORY:
// Date By Details
//

package Chess;

public class Pawn extends Piece{

	private int legalMoves;
	private boolean inInitialSpot;


	//Constructor
	public Pawn( int legalM){
		super(positionR, positionC, ptVal, name, name, isOwner);
		legalMoves = legalM; 
	}

	//Set and Get functions
	public void setLegalMoves(int allowedMoves){
		allowedMoves = legalMoves;
	}
	public void setInInitialSpot(int allowedMoves){
		allowedMoves = legalMoves;
	}

	public int getLegalMoves(){
		return legalMoves;
	}
	public boolean getInInitialSpot(){
		return inInitialSpot;
	}

	//Pawn Functionality functions
	public int[][] possibleMoves(){
		int[][] board = new int[8][8];
		if(owner == "White"){
			// Initial position starting in Row 1 Col 0
			if(positionR== 1 && positionC == 0) {
				board[positionR+1][positionC] = 1;
				board[positionR+2][positionC] = 1;
			} 
			//Initial position starting in Row 1 Col 1
			else if(positionR == 1 && positionC == 1) {
				board[positionR+1][positionC] = 1;
				board[positionR+2][positionC]= 1;
			}
			//Initial position starting in Row 1 Col 2
			else if(positionR == 1 && positionC == 2) {
				board[positionR+1][positionC] = 1;
				board[positionR+2][positionC]= 1;
			}
			//Initial position starting in Row 1 Col 3
			else if(positionR == 1 && positionC == 3) {
				board[positionR+1][positionC] = 1;
				board[positionR+2][positionC]= 1;
			}
			//Initial position starting in Row 1 Col 4
			else if(positionR == 1 && positionC == 4) {
				board[positionR+1][positionC] = 1;
				board[positionR+2][positionC]= 1;
			}
			//Initial position starting in Row 1 Col 5
			else if(positionR == 1 && positionC == 5) {
				board[positionR+1][positionC] = 1;
				board[positionR+2][positionC]= 1;
			}
			//Initial position starting in Row 1 Col 6
			else if(positionR == 1 && positionC == 6) {
				board[positionR+1][positionC] = 1;
				board[positionR+2][positionC]= 1;
			}
			//Initial position starting in Row 1 Col 7
			else if(positionR == 1 && positionC == 7) {
				board[positionR+1][positionC] = 1;
				board[positionR+2][positionC]= 1;
			}
			//Anywhere on the board after first move 
			else if(positionR >= 2 && positionC >= 0) {
				board[positionR+1][positionC] = 1;
				
			}
		}
			if(owner == "Black") {
				// Initial position starting in Row 6 Col 
				if(positionR== 6 && positionC == 0) {
					board[positionR+1][positionC] = 1;
					board[positionR+2][positionC] = 1;
				} 
				//Initial position starting in Row 6 Col 1
				else if(positionR == 6 && positionC == 1) {
					board[positionR-1][positionC] = 1;
					board[positionR-2][positionC]= 1;
				}
				//Initial position starting in Row 6 Col 2
				else if(positionR == 6 && positionC == 2) {
					board[positionR-1][positionC] = 1;
					board[positionR-2][positionC]= 1;
				}
				//Initial position starting in Row 6 Col 3
				else if(positionR == 6 && positionC == 3) {
					board[positionR-1][positionC] = 1;
					board[positionR-2][positionC]= 1;
				}
				//Initial position starting in Row 6 Col 4
				else if(positionR == 6 && positionC == 4) {
					board[positionR-1][positionC] = 1;
					board[positionR-2][positionC]= 1;
				}
				//Initial position starting in Row 6 Col 5
				else if(positionR == 6 && positionC == 5) {
					board[positionR-1][positionC] = 1;
					board[positionR-2][positionC]= 1;
				}
				//Initial position starting in Row 6 Col 6
				else if(positionR == 6 && positionC == 6) {
					board[positionR-1][positionC] = 1;
					board[positionR-2][positionC]= 1;
				}
				//Initial position starting in Row 6 Col 7
				else if(positionR == 6 && positionC == 7) {
					board[positionR-1][positionC] = 1;
					board[positionR-2][positionC]= 1;
				}
				//Anywhere on the board after first move 
				else if(positionR <= 5 && positionC >= 0) {
					board[positionR-1][positionC] = 1;
					
				}
			}
			
				for(int ii=0; ii <8; ii++){
					for(int jj=0; jj<8; jj++){
					if(board[ii][jj] != 1)
						board[ii][jj] = 0;
					}
				}
			return board;
	}
}
