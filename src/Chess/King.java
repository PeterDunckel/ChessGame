// EGR327 Project CBU
// King.java source file for the King class
// Created 11-2-15 NN
// This class is used for the king piece

// UPDATED ON 11/16/2015

package Chess;

public class King extends Piece {
private boolean isCheck;
private int legalMoves;


//Constructor
public King(boolean isC, int legalM){
	super(positionR, positionC, ptVal, name, name, isOwner);
	isCheck = isC;
	legalMoves = legalM; 
}

//Set and Get functions
public void setIsCheck(boolean inCheck){ 
	isCheck = inCheck;
}
public void setLegalMoves(int allowedMoves){
	allowedMoves = legalMoves;
}

public boolean getIsCheck(){
	return isCheck;
}
public int getLegalMoves(){
	return legalMoves;
}

//King Functionality functions
public boolean isInCheck(){
	return false;		

}

public int[][] possibleMoves(Spot[][] board){
	
	int[][] newBoard = new int[8][8];
	
	Spot temp;
	//Move straight from row 0 to 7 
	
	if((positionR + 1) <= 7 ){
		temp = board[positionR + 1][positionC];
		if(temp.getOwner() == owner){
			System.out.print("owner in the way");
		} else if( temp.getOwner() != owner && temp.getOwner() != ""){
			newBoard[positionR + 1][positionC] = 1;
		} else {
			newBoard[positionR + 1][positionC] = 1;
		}
	}
	//Move straight from row 7 to 0 

	if((positionR - 1) >= 0 ){
		temp = board[positionR - 1][positionC];
		if(temp.getOwner() == owner){
			System.out.print("owner in the way");
		} else if( temp.getOwner() != owner && temp.getOwner() != ""){
			newBoard[positionR - 1][positionC] = 1;
		} else {
			newBoard[positionR - 1][positionC] = 1;
		}
	}
	//Move straight from col 0 to 7 

	if((positionC + 1) <= 7 ){
		temp = board[positionR][positionC + 1];
		if(temp.getOwner() == owner){
			System.out.print("owner in the way");
		} else if( temp.getOwner() != owner && temp.getOwner() != ""){
			newBoard[positionR][positionC + 1] = 1;
		} else {
			newBoard[positionR][positionC + 1] = 1;
		}
	}
	//Move straight from col 7 to 0 

	if((positionC - 1) >= 0 ){
		temp = board[positionR][positionC - 1];
		if(temp.getOwner() == owner){
			System.out.print("owner in the way");
		} else if( temp.getOwner() != owner && temp.getOwner() != ""){
			newBoard[positionR][positionC - 1] = 1;	
		} else {
			newBoard[positionR][positionC - 1] = 1;
		}
	}

	//Move Diagonally Across
	//Move Diagonally from corner 0,0 to corner 7,7

	if(((positionR + 1) <= 7) || ((positionC + 1) <= 7)){
		temp = board[positionR + 1][positionC + 1];
		if(temp.getOwner() == owner){
			System.out.print("owner in the way");
		} else if( temp.getOwner() != owner && temp.getOwner() != ""){
			newBoard[positionR + 1][positionC + 1] = 1;
		} else {
			newBoard[positionR + 1][positionC + 1] = 1;
		}
	}	
	
	//Move Diagonally from corner 7,7 to corner 0,0
	if(((positionR - 1) >= 0) || ((positionC - 1) >= 7)){
		temp = board[positionR - 1][positionC - 1];
		if(temp.getOwner() == owner){
			System.out.print("owner in the way");
		} else if( temp.getOwner() != owner && temp.getOwner() != ""){
			newBoard[positionR - 1][positionC - 1] = 1;
		} else {
			newBoard[positionR - 1][positionC - 1] = 1;
		}
	}
	
	//Move Diagonally from corner 0,7 to corner 7,0
	if(((positionR + 1) <= 0) || ((positionC - 1) >= 7)){
		temp = board[positionR + 1][positionC - 1];
		if(temp.getOwner() == owner){
			System.out.print("owner in the way");
		} else if( temp.getOwner() != owner && temp.getOwner() != ""){
			newBoard[positionR + 1][positionC - 1] = 1;
		} else {
			newBoard[positionR + 1][positionC - 1] = 1;
		}
	}
	
	//Move Diagonally from corner 7,0 to corner 0,7
	if(((positionR - 1) >= 0) || ((positionC + 1) <= 7)){
		temp = board[positionR - 1][positionC + 1];
		if(temp.getOwner() == owner){
			System.out.print("owner in the way");
		} else if( temp.getOwner() != owner && temp.getOwner() != ""){
			newBoard[positionR - 1][positionC + 1] = 1;
		} else {
			newBoard[positionR - 1][positionC + 1] = 1;
		}
	}
	
	return newBoard;
}

}
