package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import modelo.DB;

public class BusPrecio extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	public static String comboRell="select B.Color, B.Consumo_km, B.N_plazas, B.Cod_bus " + 
			"from autobus B inner join(linea_autobus inner join linea "+ 
			"on linea_autobus.Cod_linea=linea.Cod_linea)" + 
			"on B.Cod_bus=linea_autobus.Cod_bus " + 
			"where linea.Nombre=\"%s\" ";
	
	public BusPrecio(){
		setLayout(null);
		
		JLabel lblBus = new JLabel("Tipo Autobús:");
		lblBus.setBounds(200, 200, 200, 37);
		lblBus.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		add(lblBus);
		
		
		//comboRell=String.format(comboRell,Lineas.listaLineas.getSelectedValue());
		//DB.rellenarComboBox(comboRell);
		
		DB.comboBox.setBounds(350, 200, 107, 27);
		add(DB.comboBox);
		
		JLabel lblPlazasDisponibles = new JLabel("Plazas Disponibles:");
		lblPlazasDisponibles.setBounds(200, 300, 200, 16);
		lblPlazasDisponibles.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		add(lblPlazasDisponibles);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(400, 295, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(400, 400, 61, 16);
		lblPrecio.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		add(lblPrecio);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(475, 395, 130, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		
		
	}
}
