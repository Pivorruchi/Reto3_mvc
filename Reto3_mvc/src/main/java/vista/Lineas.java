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
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Lineas extends JPanel {
	//public JButton btnSeleccionarParada = new JButton("Mostrar lineas");
	public JButton btnSeleccionarParada;
	private JTextArea textAreaLineas;
	private ArrayList<String> al= new ArrayList<String>();
	static MyListModel lm = new MyListModel();		
	public static JList listaLineas = new JList(lm);
	
	public Lineas() throws Exception{
		setLayout(null);
		
		btnSeleccionarParada= new JButton("Mostrar paradas");
		
		btnSeleccionarParada.setBounds(200, 450, 300, 100);
		add(btnSeleccionarParada);
		
		
		//JScrollPane scrollPane = new JScrollPane();
		 
		
		lm.llenarLinea();
		listaLineas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Seleccione la l\u00EDnea deseada:", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(235,145,168)));
		listaLineas.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		listaLineas.setSelectedIndex(0);
		listaLineas.setBounds(200, 65, 300, 250);   
		listaLineas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaLineas.setFixedCellHeight(50);
		listaLineas.setFixedCellWidth(100);
		//scrollPane.setViewportView(listaLineas);
		add(listaLineas);
		
		
	
			
		}
		
		
	public void MostrarLineas(String lineas) {
		textAreaLineas.append(lineas);
	}
}
