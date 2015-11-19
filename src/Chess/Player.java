// EGR327 Project CBU
// Player.java			 source file for the Player class
// Created 11/15/2015 PWD
// This class is used for keeping account of a chess Player status and information
// REVISION HISTORY:
// Date By Details
//

package Chess;

public class Player {
	private String name;
	private boolean isTurn;
	private int record;
	private int playerPoints;
	private Piece[] pieceArr = new Piece[16];
	
	public void Player(String n, boolean isT, int rec, int pPt, Piece[] p){
		name = n;
		isTurn = isT;
		record = rec;
		playerPoints = pPt;
		pieceArr = p;
	}
	
	public void setRecord(int r){
		record = r;
	}
	
	public void setPieceArr( Piece p, int pos){
		pieceArr[pos] = p;
	}
	
}
