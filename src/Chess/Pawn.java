// EGR327 Project CBU
// Pawn.java source file for the Pawn class
// Created 11-2-15 NN
// This class is used for the Pawn piece
// REVISION HISTORY:
// Date By Details
//DATE		ID		CHANGES
//12/29/15  PWD 	Added en passant move to possibleMoves function so that Pawn has complete set of moves

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
	public int[][] possibleMoves(Spot[][] board) {
		int[][] newBoard = new int[8][8];
		Spot tempSpot = new Spot();

		if (owner == "White") {
			// White Pawn is attacking to the right
			if (positionC <= 6) {
				tempSpot = board[positionR - 1][positionC + 1];
				if (tempSpot.getOwner() != owner && tempSpot.getOwner() != null
						&& positionR - 1 >= 0 && positionC + 1 <= 7) {
					newBoard[positionR - 1][positionC + 1] = 1;
				} else if (tempSpot.getOwner() == null && positionR - 1 >= 0
						&& positionC + 1 <= 7) {
					newBoard[positionR - 1][positionC + 1] = 2;
				}
			}
			// White Pawn attacking to the left
			if (positionC >= 1) {
				tempSpot = board[positionR - 1][positionC - 1];
				if (tempSpot.getOwner() != owner && tempSpot.getOwner() != null
						&& positionR - 1 >= 0 && positionC - 1 >= 0) {
					newBoard[positionR - 1][positionC - 1] = 1;
				} else if (tempSpot.getOwner() == null && positionR - 1 >= 0
						&& positionC - 1 >= 0) {
					newBoard[positionR - 1][positionC - 1] = 2;
				}
			}
			// White pawn moving from initial spot
			tempSpot = board[positionR - 2][positionC];
			if (positionR == 6 && tempSpot.getOwner() == null) {
				newBoard[positionR - 2][positionC] = 1;
			}

			// White pawn moving anywhere
			tempSpot = board[positionR - 1][positionC];
			if (positionR - 1 >= 0 && tempSpot.getOwner() == null) {
				newBoard[positionR - 1][positionC] = 1;
			}
			// En Passant Move for White Pawn
			// TODO: need to create database so that can check if black pawn jumped 2 or not
			// If black pawn did jump 2 and would have been in attacking range for white pawn
			// (had black pawn only jumped 1 space)
			// , then white pawn can kill black pawn by moving one space behind it.
		}

		if (owner == "Black") {

			// Black Pawn attacking to the right
			if (positionC <= 6) {
				tempSpot = board[positionR + 1][positionC + 1];
				if (tempSpot.getOwner() != owner && tempSpot.getOwner() != null
						&& positionR + 1 <= 7 && positionC + 1 <= 7) {
					newBoard[positionR + 1][positionC + 1] = 1;
				} else if (tempSpot.getOwner() == null && positionR + 1 <= 7
						&& positionC + 1 <= 7) {
					newBoard[positionR + 1][positionC + 1] = 2;
				}
			}
			// Black Pawn attacking to the left
			if (positionC >= 1) {
				tempSpot = board[positionR + 1][positionC - 1];
				if (tempSpot.getOwner() != owner && tempSpot.getOwner() != null
						&& positionR + 1 <= 7 && positionC - 1 >= 0) {
					newBoard[positionR + 1][positionC - 1] = 1;
				} else if (tempSpot.getOwner() == null && positionR + 1 <= 7
						&& positionC - 1 >= 0) {
					newBoard[positionR + 1][positionC - 1] = 2;
				}
			}
			// Pawn in initial spot can move forward 2
			tempSpot = board[positionR + 2][positionC];
			if (positionR == 1 && tempSpot.getOwner() == null) {
				newBoard[positionR + 2][positionC] = 1;
			}
			// Black pawn moving anywhere on board
			tempSpot = board[positionR + 1][positionC];
			if (tempSpot.getOwner() == null) {
				newBoard[positionR + 1][positionC] = 1;
			}
			// En Passant Move for Black Pawn
			// TODO: need to create database so that can check if white pawn jumped 2 or not
			// If white pawn did jump 2 and would have been in attacking range for black pawn 
			// (had white pawn only jumped 1 space)
			// , then black pawn can kill white pawn by moving one space behind it.
		}
		return newBoard; 	
	}
}
