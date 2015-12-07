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
	public Pawn(){
		super(positionR, positionC, ptVal, name, name, isOwner);
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
	@Override
	public int[][] possibleMoves(Spot[][]board){
		int[][] newBoard = new int[8][8];
		Spot tempSpot = new Spot();
		
		if(owner == "White"){
			//White Pawn is attacking to the right
			if(positionC <=6){
				tempSpot = board[positionR - 1][positionC + 1];
				if(tempSpot.getOwner() != owner && tempSpot.getOwner() != null && positionR - 1 >=0 && positionC + 1 <= 7) { 
					newBoard[positionR - 1][positionC + 1] = 1;
				}
				else if(tempSpot.getOwner() == null && positionR - 1 >=0 && positionC + 1 <= 7){
					newBoard[positionR - 1][positionC + 1] = 2;
				}
			}
			//White Pawn attacking to the left 
			if(positionC >=1){
				tempSpot = board[positionR -1][positionC -1];
				if(tempSpot.getOwner() != owner && tempSpot.getOwner() != null && positionR - 1 >= 0 && positionC - 1 >= 0) {
					newBoard[positionR -1][positionC -1]= 1;
				} 
				else if(tempSpot.getOwner() == null && positionR - 1 >= 0 && positionC - 1 >= 0){
					newBoard[positionR -1][positionC -1]= 2;
				}
			}
			//White pawn moving from initial spot
			tempSpot = board[positionR -2][positionC];
			if(positionR == 6 && tempSpot.getOwner() == null) {
				newBoard[positionR -2][positionC] = 1;					
			} 
			
			//White pawn moving anywhere
			tempSpot = board[positionR -1][positionC];
			if(positionR -1 >= 0 && tempSpot.getOwner() == null){
				newBoard[positionR - 1][positionC] =1;
			}
		}
		
		if(owner == "Black") {
			
			//Black Pawn attacking to the right 
			if(positionC <= 6){
				tempSpot = board[positionR + 1][positionC + 1];
				if(tempSpot.getOwner() != owner && tempSpot.getOwner() != null && positionR+1 <=7 && positionC+1 <= 7) {
					newBoard[positionR + 1][positionC + 1] = 1;
				}
				else if(tempSpot.getOwner() == null && positionR+1 <=7 && positionC+1 <= 7){
					newBoard[positionR + 1][positionC + 1] = 2;
				}
			}
			//Black Pawn attacking to the left 
			if(positionC >= 1){
				tempSpot = board[positionR + 1][positionC -1];
				if(tempSpot.getOwner() != owner && tempSpot.getOwner() != null && positionR+1 <= 7 && positionC-1 >= 0) {
					newBoard[positionR + 1][positionC -1]= 1;
				}	
				else if(tempSpot.getOwner() == null && positionR+1 <= 7 && positionC-1 >= 0){
					newBoard[positionR + 1][positionC -1]= 2;
				}
			}
			//Pawn in initial spot can move forward 2 
				tempSpot = board[positionR + 2][positionC];
			 if(positionR == 1 && tempSpot.getOwner() == null) {
				newBoard[positionR + 2][positionC]=1;
			}				
				//Black pawn moving anywhere on board
				tempSpot = board[positionR + 1][positionC];
			 if(tempSpot.getOwner() == null){
				newBoard[positionR + 1][positionC] =1;
			}
		}
		return newBoard; 	
	}
}
