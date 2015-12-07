// EGR327 Project CBU
// ChessGUI.java			 source file for the Chess GUI
// Created 11/15/2015 JT
// This class is used for the GUI for playing a chess game
// REVISION HISTORY:
// Date By Details
//
// 12/3/2015 Created and worked on 
//			 checkIfPieceInSpotAndDisplayPossibleMoves function PWD & JT
// 12/3/2015 Added logic for when button is clicked 
//			 whether to move piece or select different piece PWD & JT

package Chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class chessGUI extends JFrame {

	private JPanel contentPane;
	private Spot[][] guiSpotsArray = new Spot[8][8];
	private Game newGame = new Game();
	private int[][] tempBoard = new int[8][8];
	private Spot selectedSpot;
	private boolean isBoardReset;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chessGUI frame = new chessGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public chessGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 725);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		boolean alt = false;
		
		//Set up board as grid of buttons
		for (int row = 0; row < 8; row++){
			
			for (int col = 0; col < 8; col++){
				
				guiSpotsArray[row][col] = new Spot(true, "", "", false, row, col);
				
				guiSpotsArray[row][col].setBounds((col * 75), 75 + (row * 75), 75, 75);

				guiSpotsArray[row][col].addMouseListener(new MouseAdapter() {
					
				
					//When a square of the chess board is clicked
					//this method is activated
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						
						//Get info of button pressed
						Spot spt = (Spot) e.getComponent();	
						
						if (newGame.getCurrentPlayer() == spt.getOwner() || 
								newGame.getCurrentPlayer() == selectedSpot.getOwner()){
						
							int r = spt.getPosR();
							int c = spt.getPosC();

							// if value stored as possible move on gameBoard is '1'
							if(tempBoard[guiSpotsArray[r][c].getPosR()][guiSpotsArray[r][c].getPosC()] == 1 && !isBoardReset){


								//Empty last spot the piece was at
								guiSpotsArray[selectedSpot.getPosR()][selectedSpot.getPosC()].setIsEmpty(true);

								//Move piece 
								newGame.movePiece(selectedSpot, guiSpotsArray[r][c], r, c);							

								updateGUIBoard();							
							}
							else{
								//otherwise check possible moves of button's piece
								//and display possible moves on board

								//selectedSpot.setPieceSpot(guiSpotsArray[r][c].getPieceID(), guiSpotsArray[r][c].getOwner(), r, c); 
								selectedSpot = new Spot(guiSpotsArray[r][c]);
								getAndDisplayPossibleMovesOfPieceSelected(guiSpotsArray[r][c]);	
								isBoardReset = false;
							}
						}
					}
				});
				
				
				
				if (alt){
					guiSpotsArray[row][col].setBackground(Color.BLACK);
					alt = false;
				} else {
					alt = true;
				}
				contentPane.add(guiSpotsArray[row][col]);
				
			}
			if (alt){
				alt = false;
			} else {
				alt = true;
			}
		}	
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//Create a new game with white starting
				createNewGame();
			}
		});
		btnNewGame.setBounds(0, 0, 97, 25);
		contentPane.add(btnNewGame);
		
		//When program run create initial new game
		guiSpotsArray = newGame.newGame(guiSpotsArray);
		setPieceImages();
		updateGUIBoard();
		//selectedSpot.setPieceSpot(null, null, -1, -1);
		newGame = new Game();
		for(int row=0; row < 8; row++){
			for(int col=0; col < 8; col++){
				tempBoard[row][col]=0;
			}
		}
		isBoardReset = true;
	}
		
	public void getAndDisplayPossibleMovesOfPieceSelected(Spot sptBtn){
		Piece newPiece = new Piece();
		
		newPiece = newGame.checkPieceType(sptBtn);
		
		//Set piece to piece to spot on board
		System.out.println(newPiece.getName());
		newPiece.setOwner(newGame.getCurrentPlayer());
		newPiece.setPositionR(sptBtn.getPosR());
		newPiece.setPositionC(sptBtn.getPosC());
		//Get possible moves of piece on board
		
//		for(int i = 0; i < 8 ; i++){
//			for(int j = 0; j<8; j++){
//				guiSpotsArray[i][j].printData();
//			}
//		}
		
		tempBoard = newPiece.possibleMoves(guiSpotsArray);
		
		for(int i = 0; i < 8 ; i++){
			for(int j = 0; j<8; j++){
				System.out.print(tempBoard[i][j] + " ");
			}
			System.out.println("");
		}
		//Display the possible moves on GUI
		guiSpotsArray = newGame.displayPossibleMoves(tempBoard, guiSpotsArray);
	}
	
	
	public void updateGUIBoard(){
		
		if (newGame.getCurrentPlayer() == "White"){
			
			for(int row = 0; row < 8; row++){
				
				for(int col = 0; col < 8; col++){
					
					if(guiSpotsArray[row][col].getOwner() == "White"){
						guiSpotsArray[row][col].setEnabled(true);
					} else {
						guiSpotsArray[row][col].setEnabled(false);
					}
					guiSpotsArray[row][col].setForeground(null);
				}
			}
		}
		
		if (newGame.getCurrentPlayer() == "Black"){
			
			for(int row = 0; row < 8; row++){
				
				for(int col = 0; col < 8; col++){
					
					if(guiSpotsArray[row][col].getOwner() == "Black"){
						guiSpotsArray[row][col].setEnabled(true);
					} else {
						guiSpotsArray[row][col].setEnabled(false);
					}
					guiSpotsArray[row][col].setForeground(null);
				}
			}
		}
	}
	
	//TODO: images not showing up for buttons, work on setting images for buttons
	//the correct values are being passed
	
	//Set button images
	public void setPieceImages() {
		for(int row=0; row<8; row++){
			for(int col=0; col<8; col++){
				if(guiSpotsArray[row][col].getPieceID() != null){
					switch(guiSpotsArray[row][col].getPieceID()){
					case "King":
						System.out.println("KING");
						guiSpotsArray[row][col].setText("King");
						guiSpotsArray[row][col].setIcon(new ImageIcon("KingIcon.png"));
						break;
					case "Queen":
						System.out.println("Queen");
						guiSpotsArray[row][col].setText("Queen");
						guiSpotsArray[row][col].setIcon(new ImageIcon("KingIcon.png"));
						break;
					case "Bishop":
						System.out.println("Bishop");
						guiSpotsArray[row][col].setText("Bishop");
						guiSpotsArray[row][col].setIcon(new ImageIcon("KingIcon.png"));
						break;
					case "Knight":
						System.out.println("Knight");
						guiSpotsArray[row][col].setText("Knight");
						guiSpotsArray[row][col].setIcon(new ImageIcon("KingIcon.png"));
						break;
					case "Rook":
						System.out.println("Rook");
						guiSpotsArray[row][col].setText("Rook");
						guiSpotsArray[row][col].setIcon(new ImageIcon("KingIcon.png"));
						break;
					case "Pawn":
						System.out.println("Pawn");
						guiSpotsArray[row][col].setText("Pawn");
						guiSpotsArray[row][col].setIcon(new ImageIcon("KingIcon.png"));	
						break;
					};
				}
			}
		}
	}
	
	public void createNewGame(){
		//Reset the board with pieces in initial spots
		guiSpotsArray = newGame.newGame(guiSpotsArray);
		
		setPieceImages();
		updateGUIBoard();
		selectedSpot.setPieceSpot(null, null, -1, -1);
		newGame = new Game();
		for(int row=0; row < 8; row++){
			for(int col=0; col < 8; col++){
				tempBoard[row][col]=0;
			}
		}
		isBoardReset = true;
	}
	
}



