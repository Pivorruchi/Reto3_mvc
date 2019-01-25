package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Modelo;
import vista.Vista;

public class Controlador {
	
	public Modelo modelo;
	public Vista vista;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		initializeEvents();
	}
	
	public void initializeEvents() {
		this.vista.panelLinea.btnMostrarLineas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String lineas = modelo.linea.getNombre();
				
				vista.panelLinea.MostrarLineas(lineas);
			}
		});
	}

}
