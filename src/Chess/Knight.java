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
	public Knight(){
		super(positionR, positionC, ptVal, name, name, isOwner);
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
	@Override
	public int[][] possibleMoves(Spot[][] board){
		int[][] newBoard = new int[8][8];
		Spot tempSpot;
		
		//All moves for knight, anywhere on the board
		if(positionR - 2 >= 0 && positionC + 1 <=7 )  //Checks boundaries of the board    
		{ 
			tempSpot = board[positionR -2][positionC + 1];
			if(tempSpot.getOwner() == owner) {
				System.out.println("Owner is in the way");
			}
			else{
				newBoard[positionR -2][positionC+1] = 1; 
			}
		}
		if(positionR - 2 >= 0 && positionC - 1 >=0 ) {
			tempSpot = board[positionR -2][positionC - 1];
			if(tempSpot.getOwner() == owner) {
				System.out.println("Owner is in the way");
			}
			else{
				newBoard[positionR -2][positionC-1] = 1; 
			}
		}
		if(positionR - 1 >= 0 && positionC - 2 >= 0 ) {
			tempSpot = board[positionR -1][positionC -2];
			if(tempSpot.getOwner() == owner) {
				System.out.println("Owner is in the way");
			}
			else{
				newBoard[positionR -1][positionC-2] = 1; 
			}
		}
		if(positionR - 1 >= 0 && positionC + 2 <=7 ) {
			tempSpot = board[positionR -1][positionC + 2];
			if(tempSpot.getOwner() == owner) {
				System.out.println("Owner is in the way");
			}	
			else{
				newBoard[positionR -1][positionC+2] = 1; 
			}
		}
		if(positionR +1 <= 7 && positionC - 2 >= 0 ) {
			tempSpot = board[positionR + 1][positionC - 2];
			if(tempSpot.getOwner() == owner) {
				System.out.println("Owner is in the way");
			}	
			else{
				newBoard[positionR +1][positionC-2] = 1; 
			}
		}
		if(positionR + 1 <= 7 && positionC + 2 <=7 ) {
			tempSpot = board[positionR + 1][positionC + 2];
			if(tempSpot.getOwner() == owner) {
				System.out.println("Owner is in the way");
			}
			else{
				newBoard[positionR +1][positionC+2] = 1; 
			}
		}
		if(positionR + 2 <= 7 && positionC - 1 >= 0 ) {
			tempSpot = board[positionR + 2][positionC - 1];
			if(tempSpot.getOwner() == owner) {
				System.out.println("Owner is in the way");
			}
			else{
				newBoard[positionR +2][positionC-1] = 1; 
			}
		}
		if(positionR + 2 <= 7 && positionC + 1 <=7 ) {
			tempSpot = board[positionR + 2][positionC + 1];
			if(tempSpot.getOwner() == owner) {
				System.out.println("Owner is in the way");
			}
			else{
				newBoard[positionR +2][positionC+1] = 1; 
			}
		} 
		
		return newBoard;

	}
}
	
			
