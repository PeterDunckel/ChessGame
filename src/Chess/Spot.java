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
		Spot(boolean emp, String pID, String own, boolean isS, int pR, int pC){
			isEmpty = emp;
			pieceID = pID;
			owner = own;
			isSelected = isS;
			posR = pR;
			posC = pC;
		}
		
		public Spot() {
			// TODO Auto-generated constructor stub
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
		
		public void setPosR(int pR){
			posR = pR;
		}
		public void setPosC(int pC){
			posC = pC;
		}
}