// EGR327 Project CBU
// Spot.java			 source file for the Spot class
// Created 11/15/2015 PWD
// This class is used for a spot on a chess board
// REVISION HISTORY:
// Date By Details
//

package Chess;

import javax.swing.JButton;

public class Spot extends JButton{

		private boolean isEmpty;
		private String pieceID;
		private String owner;
		private boolean isSelected;
		private int posR;
		private int posC;
		
		//Constructor		
		public Spot() {
			// TODO Auto-generated constructor stub
		}
		
		Spot(boolean emp, String pID, String own, boolean isS, int pR, int pC){
			isEmpty = emp;
			pieceID = pID;
			owner = own;
			isSelected = isS;
			posR = pR;
			posC = pC;
		}
		
		public Spot(Spot spotToCopy){
			
			this(spotToCopy.isEmpty, spotToCopy.getPieceID(), spotToCopy.getOwner(), spotToCopy.getIsSelected(), spotToCopy.getPosR(), spotToCopy.getPosC());
			
		}
		
		//Get and Set functions
		public boolean getIsEmpty(){
			return isEmpty;
		}
		public String getPieceID(){
			return pieceID;
		}
		public String getOwner(){
			return owner;
		}
		public boolean getIsSelected(){
			return isSelected;
		}
		public int getPosR(){
			return posR;
		}
		public int getPosC(){
			return posC;
		}
		
		public void setIsEmpty(boolean isEmp){
			isEmpty = isEmp;
			//if spot is empty then there is no 
			//piece or owner
			if(isEmpty){
				setPieceID(null);
				setOwner(null);
				setText(null);
			}
		}
		public void setPieceID(String pid){
			pieceID = pid;
		}
		public void setOwner(String own){
			owner = own;
		}
		public void setPosR(int pR){
			posR = pR;
		}
		public void setPosC(int pC){
			posC = pC;
		}
		public void setPieceSpot(String pid, String own, int pR, int pC ){
			isEmpty = false;
			pieceID = pid;
			owner = own;
			posR = pR;
			posC = pC;
		}
		
		
		public void printData(){
			System.out.println(isEmpty +" "+ pieceID +" "+ owner +" "+ isSelected +" "+ posR +" "+ posC +"\n");
		}
}