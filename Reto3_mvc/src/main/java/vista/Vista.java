package vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Vista{
	public Panel ventana = new Panel();
	public Lineas panelLinea = new Lineas();
	public Paradas panelParada = new Paradas();	
	
	public Vista()throws Exception {
		mostrarPanel(panelLinea);
		ventana.setVisible(true);
	}
	
	public void mostrarPanel(JPanel panel) {
		ventana.setContentPane(panel);
	}
}
