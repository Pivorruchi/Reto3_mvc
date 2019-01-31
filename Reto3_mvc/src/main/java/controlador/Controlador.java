package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Modelo;
import modelo.MyListModel;
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
		this.vista.panelLinea.btnSeleccionarParada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//int index= ((MyListModel) modelo.mylist.misLineas).getSelectedIndex();
				
				
				//vista.panelParada.add(vista.panelLinea.txtParadaSeleccionada);
				vista.mostrarPanel(vista.panelParada);
				vista.ventana.setVisible(true);
				
			}
		});
		
		
		
	}

}
