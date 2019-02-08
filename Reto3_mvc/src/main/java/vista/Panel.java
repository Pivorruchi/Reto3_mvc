package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class Panel extends JFrame {

	JLabel lblBackground= new JLabel();
	
	public Panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 700, 600);
		lblBackground.setIcon(new ImageIcon(Panel.class.getResource("/imagenes/Reto3_background.png")));
		
		
		
		lblBackground.setBounds(0, 0, 700, 600);
		
		getContentPane().add(lblBackground);
		
	}


}
