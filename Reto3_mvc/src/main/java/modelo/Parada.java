package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import vista.Paradas;

public class Parada {
	private int cod_parada;
	private String nombre;
	private String calle;
	private float latitud;
	private float longitud;
	private double distancia;
	Distancia dis = new Distancia();

	public Parada() {

	}

	public Parada(int cod_parada, String nombre, String calle, float latitud, float longitud, double distancia) {
		this.cod_parada = cod_parada;
		this.nombre = nombre;
		this.calle = calle;
		this.latitud = latitud;
		this.longitud = longitud;
		this.distancia = distancia;
	}

	public String getNombre() {
		return nombre;
	}

	public float getLatitud() {
		return latitud;
	}

	public float getLongitud() {
		return longitud;
	}
	

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	
	public double getDistancia() {
		return distancia;
	}

	public ArrayList<Parada> ordenarParadas(ArrayList<Parada> listaParadas) {

		Parada parada;
		//este for tiene que ir fuera de este metodo ya que solo es para asignar las distancias a las paradas
		
		for (int count = 0; count < listaParadas.size() - 1; count++) {

			float lat = listaParadas.get(count + 1).getLatitud();
			float longi = listaParadas.get(count + 1).getLongitud();
			double dis = Distancia.distanciaCoord(Distancia.termiLanNum, Distancia.termiLongNum, lat, longi);
			//sentencia que haga insert into Distancia el valor de dis donde la longitud y latitud coincidan;

		}
		
		for(int i=0;i<listaParadas.size()-1;i++) {
			for(int j=0;j<listaParadas.size()-i-1;j++) {
				if(listaParadas.get(j+1).getDistancia()<listaParadas.get(j).getDistancia()) {
					parada=listaParadas.get(j+1);
					listaParadas.set(j+1, listaParadas.get(j));
					listaParadas.set(j, parada);
				}
			}
		}
		
		return listaParadas;
	}

}