package modelo;

import javax.swing.DefaultListModel;

public class Parada {
	private String cod_parada;
	private String nombre;
	private String calle;
	private String latitud;
	private String longitud;
	
	static DefaultListModel<String> listModel = new DefaultListModel<>();

public Parada() {
	
}

public Parada(String cod_parada,String nombre,String calle, String latitud, String longitud) {
	this.cod_parada=cod_parada;
	this.calle=calle;
	this.latitud=latitud;
	this.longitud=longitud;
}

	public String getNombre() {
		return nombre;

	}

}