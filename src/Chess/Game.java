// EGR327 Project CBU
// Game.java source file for the Game class
// Created 11-2-15 PWD
// This class is used for the rules, scores, and board of the Chess program
// REVISION HISTORY:
// Date By Details
//
// 12/3/2015 Implemented resetBoard and created setWhite/BlackInitialSpots
//

package Chess;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Game {
	
	private static Spot[][] gameBoard = new Spot[8][8];
	private String winner;
	private String loser;
	private static String currentPlayersTurn;
	private int scoreP1;
	private int scoreP2;
	private int timePerTurn;
	private int turn;
	
	Game(){	
		currentPlayersTurn = "White";
	}
	
	//constructor
	Game(Spot[][] gBoard, String win, String los, 
			int scoP1, int scoP2, int turnTime, int t){
		gameBoard = gBoard;
		winner = win;
		loser = los;
		scoreP1 = scoP1;
		scoreP2 = scoP2;
		timePerTurn = turnTime;
		turn = t;
		currentPlayersTurn = "White";
	}
	
	//Get and set functions
	public static Spot[][] getGameBoard()
	{
		return gameBoard;
	}
	
	//Function to move piece desired to a new spot on the board
	public void movePiece(Spot pieceSpotInfo, Spot guiBoardSpot, int r, int c){
		//Set spot going from to spot going to	
		
		gameBoard[r][c].setPieceSpot(pieceSpotInfo.getPieceID(), pieceSpotInfo.getOwner(), 
				r, c);
		guiBoardSpot.setText(pieceSpotInfo.getPieceID());
		guiBoardSpot.setPieceSpot(pieceSpotInfo.getPieceID(), pieceSpotInfo.getOwner(), 
				r, c);
		
		if (currentPlayersTurn == "White"){
			currentPlayersTurn = "Black";
		} else {
			currentPlayersTurn = "White";
		}
	}
	
	//Function to check if the king is in check for the player
	public void checkForCheck( Spot[][]guiBoard, String playerToCheck){
		String pieceID;
		String owner;
		for(int row=0; row < 8; row++){
			for(int col=0; col < 8; col++){
				pieceID = guiBoard[row][col].getPieceID();
				owner = guiBoard[row][col].getOwner();
				if(owner == playerToCheck){
					
				}
			}
		}
		//if piece moved next possible move targets king
		//Other players King is in check
		//Only piece that other player can move is King or 
		//piece that can disrupt attack line on King without causing check
		//Or kill piece targeting King		
	}
	
	//Determine if player is in checkmate
	public void checkForCheckMate(){
		//If the King is in Check and no more
		//moves where it is not in check
	}
	
	//Reset board at players choice, at end of game, or at beginning of game
	public Spot[][] resetBoard(Spot[][] sptBtn){
		
		//Set all the spots on the board to empty		
		for(int row=0; row<8; row++){
			for(int col=0; col<8; col++){
				gameBoard[row][col]=sptBtn[row][col];
				gameBoard[row][col].setIsEmpty(true);
				gameBoard[row][col].setPosR(row);
				gameBoard[row][col].setPosC(col);
			}
		}

		//Set initial spots of all of the pieces
		setWhiteInitialSpots();
		setBlackInitialSpots();	
		
//		for(int i = 0; i < 8 ; i++){
//			for(int j = 0; j<8; j++){
//				gameBoard[i][j].printData();
//			}
//		}
		
		
		return gameBoard;
	}

	public String getCurrentPlayer(){
		return currentPlayersTurn;
	}
	
	public void setCurrentPlayer(String cp){
		currentPlayersTurn = cp;
	}
	
	//Set all the white pieces in initial spots
	public void setWhiteInitialSpots(){
		
		//Set Whites Pawns in initial positions
		for(int wc=0; wc<8; wc++){
			gameBoard[6][wc].setPieceSpot("Pawn","White",6,wc);
		}		
		//Set Whites Rooks, Knights, Bishops, 
		//King and Queen in initial positions
		//Rooks
		gameBoard[7][0].setPieceSpot("Rook","White",7,0);
		gameBoard[7][7].setPieceSpot("Rook","White",7,7);
		//Knights
		gameBoard[7][1].setPieceSpot("Knight","White",7,1);
		gameBoard[7][6].setPieceSpot("Knight","White",7,6);
		//Bishops
		gameBoard[7][2].setPieceSpot("Bishop","White",7,2);
		gameBoard[7][5].setPieceSpot("Bishop","White",7,5);
		//Queen
		gameBoard[7][3].setPieceSpot("Queen","White",7,3);
		//King
		gameBoard[7][4].setPieceSpot("King","White",7,4);
	}
	
	//Set all the black pieces in initial spots
	public void setBlackInitialSpots(){
		//Set Blacks Pawns in initial positions
		for(int bc=0; bc<8; bc++){
			gameBoard[1][bc].setPieceSpot("Pawn","Black",1,bc);
		}		
		//Set Whites Rooks, Knights, Bishops, 
		//King and Queen in initial positions
		//Rooks
		gameBoard[0][0].setPieceSpot("Rook","Black",0,0);
		gameBoard[0][7].setPieceSpot("Rook","Black",0,7);
		//Knights
		gameBoard[0][1].setPieceSpot("Knight","Black",0,1);
		gameBoard[0][6].setPieceSpot("Knight","Black",0,6);
		//Bishops
		gameBoard[0][2].setPieceSpot("Bishop","Black",0,2);
		gameBoard[0][5].setPieceSpot("Bishop","Black",0,5);
		//Queen
		gameBoard[0][4].setPieceSpot("Queen","Black",0,4);
		//King
		gameBoard[0][3].setPieceSpot("King","Black",0,3);
		
	}	
	
	//Kill piece if this is part of possible moves for a piece and is opposing teams piece
	public void killPiece(){
		
	}
		
	//start the game 
	public Spot[][] newGame(Spot[][] guiSpotsArray){		
		return resetBoard(guiSpotsArray);
	}
	
	//end the game
	public void endGame(){
		
	}
	
	//Set a timer for timing the game
	public void timer(){
		
	}
	
	//Check whether their is stalemate
	public void chkStalemate(){
		
	}
	
	//check whether a player keeps playing in the same place 
	public void chkSameMovRepetition(){
		
	}
	
	//check the fifty move rule
	public void chkFiftyMovRule(){
		
	}
	
	//check if kings are the only pieces remaining on the board
	public void chkOnlyKingsRemain(){
		
	}
	
	//check if both flags are down
	public void chkBothFlagsDown(){
		
	}
	
	//display possible moves for the user to use
	public static Spot[][] displayPossibleMoves(int[][] board, Spot[][] guiBoard){
		
		//if possible moves is not equal to 1 and 
				//if spot not equal to owner
				//disable button
				
				//if possible moves is equal to 1 then highlight spot
		
		for (int r = 0; r < 8; r++){
			
			for(int c = 0; c < 8; c++){
				
				System.out.print(board[r][c]);
				
				if(board[r][c] == 1){
					
					guiBoard[r][c].setEnabled(true);
					guiBoard[r][c].setForeground(Color.GREEN);
					
				} else if(guiBoard[r][c].getOwner() == currentPlayersTurn){
					
					guiBoard[r][c].setEnabled(true);
					guiBoard[r][c].setForeground(null);
					
				} else {
					guiBoard[r][c].setEnabled(false);
					guiBoard[r][c].setForeground(null);
				}
					
			}
			System.out.println(" ");
		}		
		
		return guiBoard;
	}
	
	public Piece checkPieceType(Spot sptBtn){
		
		//Check to see which piece the
		//button is by checking the pieceID(pid)
		switch(sptBtn.getPieceID())
		{
		case "King":
			return new King();			
		case "Queen":
			return new Queen();
		case "Bishop":
			return new Bishop();
		case "Knight":
			return new Knight();
		case "Rook":
			return new Rook();
		case "Pawn":
			return new Pawn();
		}		
		return null;
	}
	
}
