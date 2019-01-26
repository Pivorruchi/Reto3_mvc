package vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;

import modelo.DBConnect;
import modelo.Linea;
import modelo.MyListModel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Lineas extends JPanel {
	public JButton btnMostrarLineas = new JButton("Mostrar lineas");
	private JTextArea textAreaLineas;
	private ArrayList<String> al= new ArrayList<String>();
	
	public Lineas() throws Exception{
		setLayout(null);
		
		
		btnMostrarLineas.setBounds(66, 238, 201, 23);
		add(btnMostrarLineas);
		
		
		MyListModel lm = new MyListModel();		 
		JList listaLineas = new JList(lm);
		lm.llenarLinea();
		listaLineas.setBounds(41, 42, 151, 155);   
		listaLineas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(listaLineas);
		
		
	
			
		}
		
		
	public void MostrarLineas(String lineas) {
		textAreaLineas.append(lineas);
	}
	
	
	
	
}
