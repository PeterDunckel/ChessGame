package Chess;

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
		
	}
}
