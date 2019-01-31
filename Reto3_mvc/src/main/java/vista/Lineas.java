package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;

import modelo.DB;
import modelo.Linea;
import modelo.MyListModel;

import javax.swing.JButton;

import javax.swing.JList;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Lineas extends JPanel {
	public JButton btnSeleccionarParada = new JButton("Mostrar lineas");
	private JTextArea textAreaLineas;
	private ArrayList<String> al= new ArrayList<String>();
	
	public Lineas() throws Exception{
		setLayout(null);
		
		
		btnSeleccionarParada.setBounds(66, 238, 201, 23);
		add(btnSeleccionarParada);
		
		
		JScrollPane scrollPane = new JScrollPane();
		MyListModel lm = new MyListModel();		 
		JList listaLineas = new JList(lm);
		lm.llenarLinea();
		listaLineas.setBounds(93, 36, 151, 155);   
		listaLineas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listaLineas);
		add(listaLineas);
		
		
	
			
		}
		
		
	public void MostrarLineas(String lineas) {
		textAreaLineas.append(lineas);
	}
	
	
	
	
}
