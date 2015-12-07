// EGR327 Project CBU
// Piece.java source file for the Piece class
// Created 11-2-15 PWD
// This class is used for generalizing piece information and keeping track of a piece's position 
// REVISION HISTORY:
// Date By Details
//

package Chess;

public class Piece {
	protected static int positionR;
	protected static int positionC;
	protected static int ptVal;
	protected static String name;
	protected static String owner;
	protected static boolean isOwner;
	
	//constructor
	public Piece(){
		positionR = 0;
		positionC = 0;
		ptVal = 0;
		name = "";
		owner = "";
		isOwner = false;
	}
	
	public Piece(int pr, int pc, int pv, String n, String o, boolean isO){
		positionR = pr;
		positionC = pc;
		ptVal = pv;
		name = n;
		owner = o;
		isOwner = isO;
	}
	
	//Virtual function
	
	public int[][] possibleMoves(Spot[][] gameBoard) {
		return null;
	}
	
	
	//Set and Get Functions
	public void setPositionR(int posR) {
		positionR = posR;
	}
	public void setPositionC(int posC){
		positionC = posC;
	}
	public void setPtVal(int ptValue) {
		ptVal = ptValue;
	}
	public void setName(String n){
		name = n;
	}
	public void setOwner(String o) {
		owner = o;
	}
	public void setIsOwner(boolean isOwn){
		isOwner = isOwn;
	}
	
	public int getPositionR(){
	   return positionR;	
	}
	
	public int getPositionC(){
		return positionC;
	}
	
	public int getPtVal(){
		return ptVal;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getOwner() {
		return owner; 	
	}
	
	public boolean getIsOwner() {
		return isOwner;
	}

};





