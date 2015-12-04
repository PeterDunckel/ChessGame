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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class chessGUI extends JFrame {

	private JPanel contentPane;
	private Spot[] buttons = new Spot[64];
	private Game newGame = new Game();
	private int[][] tempBoard = new int[8][8];
	
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
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				newGame.resetBoard();
			}
		});
		btnNewGame.setBounds(0, 0, 97, 25);
		contentPane.add(btnNewGame);
		
		boolean alt = false;
		
		for (int row = 0; row < 8; row++){
			
			for (int col = 0; col < 8; col++){
				
				Spot spt = new Spot(true, "", "", false, row, col);
	
				spt.setBounds((col * 75), 75 + (row * 75), 75, 75);

				spt.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						if(spt.getIsSelected() && tempBoard[spt.getPosR()][spt.getPosC()] == 1){
							newGame.movePiece();
						}
						else{
							checkIfPieceInSpotAndDisplayPossibleMoves(spt.getPieceID(), spt);
							
						}
					}
				});
				
				if (alt){
					spt.setBackground(Color.BLACK);
					alt = false;
				} else {
					alt = true;
				}
				contentPane.add(spt);
				
			}
			if (alt){
				alt = false;
			} else {
				alt = true;
			}
		}			
	}
		
	public void checkIfPieceInSpotAndDisplayPossibleMoves(String pid, Spot spt){
		Piece newPiece = new Piece();
		switch(pid)
		{
		case "King":
			newPiece = new King();
			
			break;
		case "Queen":
			Queen qn = new Queen();
			qn.setPositionR(spt.getPosR());
			qn.setPositionC(spt.getPosC());
			tempBoard = qn.possibleMoves(newGame.getGameBoard());
			Game.displayPossibleMoves(tempBoard);
			break;
		case "Bishop":
			Bishop bp = new Bishop();
			bp.setPositionR(spt.getPosR());
			bp.setPositionC(spt.getPosC());
			tempBoard = bp.possibleMoves(newGame.getGameBoard());
			Game.displayPossibleMoves(tempBoard);
			break;
		case "Knight":
			Knight kt = new Knight();
			kt.setPositionR(spt.getPosR());
			kt.setPositionC(spt.getPosC());
			tempBoard = kt.possibleMoves(newGame.getGameBoard());
			Game.displayPossibleMoves(tempBoard);
			break;
		case "Rook":
			Rook rk = new Rook();
			rk.setPositionR(spt.getPosR());
			rk.setPositionC(spt.getPosC());
			tempBoard = rk.possibleMoves(newGame.getGameBoard());
			Game.displayPossibleMoves(tempBoard);
			break;
		case "Pawn":
			Pawn pn = new Pawn();
			pn.setPositionR(spt.getPosR());
			pn.setPositionC(spt.getPosC());
			tempBoard = pn.possibleMoves(newGame.getGameBoard());
			Game.displayPossibleMoves(tempBoard);
			break;		
		}
		
		newPiece.setPositionR(spt.getPosR());
		newPiece.setPositionC(spt.getPosC());
		tempBoard = newPiece.possibleMoves(newGame.getGameBoard());
		Game.displayPossibleMoves(tempBoard);
	}
}

