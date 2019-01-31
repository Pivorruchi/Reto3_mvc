package modelo;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Parada {
	private int cod_parada;
	private String nombre;
	private String calle;
	private float latitud;
	private float longitud;

	public Parada() {

	}

	public Parada(int cod_parada, String nombre, String calle, float latitud, float longitud) {
		this.cod_parada = cod_parada;
		this.nombre = nombre;
		this.calle = calle;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getNombre() {
		return nombre;
	}
	
	public ArrayList<Parada> ordenarParadas(ArrayList<Parada> listaParadas){
		listaParadas = null;
		return listaParadas;
	}

}