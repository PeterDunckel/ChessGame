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
		
		for (int row = 0; row < 8; row++){
			
			for (int col = 0; col < 8; col++){
				
				Spot spt = new Spot(true, "", "", false, row, col);
	
				spt.setBounds((col * 75), 75 + (row * 75), 75, 75);
				

				spt.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(spt.getPieceID() == "rook1" || spt.getPieceID() == "rook2"){
							Rook rk = new Rook();
							rk.setPositionR(spt.getPosR());
							rk.setPositionC(spt.getPosC());
							Game.displayPossibleMoves(rk.possibleMoves(newGame.getGameBoard()));
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
}
