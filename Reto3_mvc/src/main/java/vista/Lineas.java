package vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

//import paneles.panelJlist.MyListModel;

import javax.swing.JButton;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Lineas extends JPanel {
	public JButton btnMostrarLineas = new JButton("Mostrar lineas");
	private JTextArea textAreaLineas;
	private ArrayList<String> al= new ArrayList<String>();
	
	public Lineas() {
		setLayout(null);
		
		/*
		textAreaLineas = new JTextArea();
		textAreaLineas.setBounds(66, 54, 201, 153);
		add(textAreaLineas);
		*/
		
		btnMostrarLineas.setBounds(66, 238, 201, 23);
		add(btnMostrarLineas);
		
		modelo.MyListModel lm = new modelo.MyListModel();		 
		JList listaLineas = new JList(lm);
		listaLineas.setBounds(41, 42, 151, 155);   
		listaLineas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(listaLineas);


	}
	
	public void MostrarLineas(String lineas) {
		textAreaLineas.append(lineas);
	}
	
	
	
	
}
