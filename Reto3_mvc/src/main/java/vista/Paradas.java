package vista;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import modelo.MyListModel;

import javax.swing.JList;

public class Paradas extends JPanel {

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	String hola="";
	public Paradas() throws Exception {
		setLayout(null);
		
		MyListModel lm = new MyListModel();	
		JList listaParadas = new JList(lm);
		lm.llenarParada(hola);
		listaParadas.setBounds(41, 42, 151, 155);
		listaParadas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(listaParadas);
		
		
		

	}
	

}
