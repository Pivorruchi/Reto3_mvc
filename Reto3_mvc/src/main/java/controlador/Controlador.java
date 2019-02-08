	package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.DB;
import modelo.Modelo;
import modelo.MyListModel;
import vista.BusPrecio;
import vista.Lineas;
import vista.Paradas;
import vista.Vista;

public class Controlador {

	public Modelo modelo;
	public Vista vista;
	public static String s;
	public static String comparar = "select Cod_Linea from linea where Nombre='%s'";
	public static String Codlinea;
	public static ResultSet rs;

	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		Eventos();
	}

	/*
	 * public void initializeEvents() {
	 * this.vista.panelLinea.btnSeleccionarParada.addActionListener(new
	 * ActionListener() { public void actionPerformed(ActionEvent e) {
	 * 
	 * //int index= ((MyListModel) modelo.mylist.misLineas).getSelectedIndex();
	 * 
	 * 
	 * //vista.panelParada.add(vista.panelLinea.txtParadaSeleccionada);
	 * 
	 * vista.mostrarPanel(vista.panelParada); vista.ventana.setVisible(true);
	 * 
	 * } });
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	public void Eventos() {
		this.vista.panelLinea.btnSeleccionarParada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = Lineas.listaLineas.getSelectedIndex();
				System.out.println("Index Selected: " + index);
				s = (String) Lineas.listaLineas.getSelectedValue();
				System.out.println("Value Selected: " + s);
				comparar = String.format(comparar, s);
				rs = DB.seleccionar(comparar);
				try {
					Codlinea = DB.writeResultSet(rs);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Paradas.lm.llenarParada(Controlador.Codlinea);
				} catch (Exception e1) {
					System.out.println("el ArrayList de parada no ha sido rellenado");
					e1.printStackTrace();
				}

				vista.mostrarPanel(vista.panelParada);
				vista.ventana.setVisible(true);
				BusPrecio.comboRell=String.format(BusPrecio.comboRell,s);
				System.out.println(BusPrecio.comboRell);
				DB.rellenarComboBox(BusPrecio.comboRell);
			}
		});

		this.vista.panelBienvenida.btnBienvenida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.mostrarPanel(vista.panelLinea);
				vista.ventana.setVisible(true);
			}
		});
		
		
		
		this.vista.panelParada.btnDestinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vista.mostrarPanel(vista.panelTrayecto);
				vista.ventana.setVisible(true);
			}
		});
		

	}

}
