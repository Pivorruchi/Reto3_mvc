package vista;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.App;


public class Vista{

	public Panel ventana = new Panel();
	public Lineas panelLinea = new Lineas();
	public Paradas panelParada = new Paradas();	
	public Bienvenida panelBienvenida= new Bienvenida();
	public BusPrecio panelTrayecto= new BusPrecio();
	//public ParadasDestino panelDestino= new ParadasDestino();
	JLabel lblBackground= new JLabel();
	
	public Vista()throws Exception {
		mostrarPanel(panelBienvenida);
		ventana.setVisible(true);
	}
	
	public void mostrarPanel(JPanel panel) {
		panel.setBounds(0,0,700,600);
		ventana.setContentPane(panel);
		lblBackground.setIcon(new ImageIcon(Panel.class.getResource("/imagenes/Reto3_background.png")));
		lblBackground.setBounds(0, 0, 700, 600);
		panel.add(lblBackground);
	}
}
