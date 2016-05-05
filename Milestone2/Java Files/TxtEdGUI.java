/* Author - Ryan_Owens  
 * Version 1.0 
 * Formal Language & Computability - Milestone 2
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TxtEdGUI extends JFrame {

	private JPanel contentPane = new JPanel();
	private Validator validator = new Validator();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnFile = new JMenu("File");
	private JMenuItem mntmSaveFile = new JMenuItem("Save File");	
	private JMenuItem mntmLoadFile = new JMenuItem("Load File");
	private JButton btnValidate = new JButton("Validate");
	private JTextPane txtpnVarXX = new JTextPane();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TxtEdGUI frame = new TxtEdGUI();
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
	public TxtEdGUI() {
		setTitle("Ryan Owens Text Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 468);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		menuBar.setBounds(0, 0, 35, 21);
		contentPane.add(menuBar);
		
		menuBar.add(mnFile);
		
		mnFile.add(mntmSaveFile);
		
		mnFile.add(mntmLoadFile);
		
		
		btnValidate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				onClickValidate();
			}
		});
		
		
		txtpnVarXX.setText("var x x = 5 print( x )");
		txtpnVarXX.setBounds(10, 24, 297, 291);
		contentPane.add(txtpnVarXX);
	
		btnValidate.setBounds(35, 344, 89, 23);
		contentPane.add(btnValidate);
	}
	
	public void onClickValidate() {
		validator.Validate(txtpnVarXX);
		
	}
}
