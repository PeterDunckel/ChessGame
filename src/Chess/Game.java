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

import javax.swing.ImageIcon;

public class Game {
	
	private static Spot[][] gameBoard = new Spot[8][8];
	private String winner;
	private String loser;
	private int scoreP1;
	private int scoreP2;
	private int timePerTurn;
	private int turn;
	
	Game(){		
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
	}
	
	//Get and set functions
	public static Spot[][] getGameBoard()
	{
		return gameBoard;
	}
	
	//Function to move piece desired to a new spot on the board
	public void movePiece(){
		
	}
	
	//Function to check if the king is in check for the player
	public void checkForCheck(){
		
	}
	
	//Determine if player is in checkmate
	public void checkMate(){
		
	}
	
	//Reset board at players choice, at end of game, or at beginning of game
	public void resetBoard(){
		
		//Set all the spots on the board to empty
		Spot emptySpot = new Spot();
		for(int row=0; row<8; row++){
			for(int col=0; col<8; col++){
				gameBoard[row][col]=emptySpot;
			}
		}
		
		//Set initial spots of all of the pieces
		Spot spt = new Spot(false,"Pawn","White",false,0,0);
		setWhiteInitialSpots(spt);
		spt.setOwner("Black");
		setBlackInitialSpots(spt);
		
		setPieceImages();
		
	}
	
	private void setPieceImages() {
		Spot tempSpt = new Spot();
		for(int row=0; row<8; row++){
			for(int col=0; col<8; col++){
				tempSpt = gameBoard[row][col];
				switch(tempSpt.getOwner()){
				case "King":
					tempSpt.setIcon(new ImageIcon("KingIcon.png"));
					break;
				case "Queen":
					tempSpt.setIcon(new ImageIcon("KingIcon.png"));
					break;
				case "Bishop":
					tempSpt.setIcon(new ImageIcon("KingIcon.png"));
					break;
				case "Knight":
					tempSpt.setIcon(new ImageIcon("KingIcon.png"));
					break;
				case "Rook":
					tempSpt.setIcon(new ImageIcon("KingIcon.png"));
					break;
				case "Pawn":
					tempSpt.setIcon(new ImageIcon("KingIcon.png"));
					break;		
				};
			}
		}
	}

	//Set all the white pieces in initial spots
	public void setWhiteInitialSpots(Spot spt){
		
		//Set Whites Pawns in initial positions
		spt.setPosR(6);
		for(int wc=0; wc<8; wc++){
			spt.setPosC(wc);
			gameBoard[6][wc] = spt;
		}		
		//Set Whites Rooks, Knights, Bishops, 
		//King and Queen in initial positions
		//Rooks
		spt.setPosR(7);
		spt.setPosC(0);
		spt.setPieceID("Rook");
		gameBoard[7][0] = spt;
		spt.setPosC(7);
		gameBoard[7][7] = spt;
		//Knights
		spt.setPieceID("Knight");
		spt.setPosC(1);
		gameBoard[7][1] = spt;
		spt.setPosC(6);
		gameBoard[7][6] = spt;
		//Bishops
		spt.setPieceID("Bishop");
		spt.setPosC(2);
		gameBoard[7][2] = spt;
		spt.setPosC(3);
		gameBoard[7][3] = spt;
		//Queen
		spt.setPieceID("Queen");
		spt.setPosC(4);
		gameBoard[7][4] = spt;
		//King
		spt.setPieceID("King");
		spt.setPosC(5);
		gameBoard[7][5] = spt;
	}
	
	public void setBlackInitialSpots(Spot spt){
		//Set Blacks Pawns in initial positions
		spt.setPosR(1);
		for(int wc=0; wc<8; wc++){
			spt.setPosC(wc);
			gameBoard[6][wc] = spt;
		}		
		//Set Blacks Rooks, Knights, Bishops, 
		//King and Queen in initial positions
		//Rooks
		spt.setPosR(0);
		spt.setPosC(0);
		spt.setPieceID("Rook");
		gameBoard[0][0] = spt;
		spt.setPosC(7);
		gameBoard[0][7] = spt;
		//Knights
		spt.setPieceID("Knight");
		spt.setPosC(1);
		gameBoard[0][1] = spt;
		spt.setPosC(6);
		gameBoard[0][6] = spt;
		//Bishops
		spt.setPieceID("Bishop");
		spt.setPosC(2);
		gameBoard[0][2] = spt;
		spt.setPosC(3);
		gameBoard[0][3] = spt;
		//Queen
		spt.setPieceID("Queen");
		spt.setPosC(5);
		gameBoard[0][5] = spt;
		//King
		spt.setPieceID("King");
		spt.setPosC(4);
		gameBoard[0][4] = spt;
	}	
	
	//Kill piece if this is part of possible moves for a piece and is opposing teams piece
	public void killPiece(){
		
	}
	
	//Display score of the game
	public void displayScore(){
		
	}
	
	//start the game 
	public void startGame(){
		
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
	public static void displayPossibleMoves(int[][] board){
		
		//if possible moves is not equal to 1 and 
		//if spot not equal to owner
		//disable button
		
		//if possible moves is equal to 1 then highlight spot
	}
	
}
