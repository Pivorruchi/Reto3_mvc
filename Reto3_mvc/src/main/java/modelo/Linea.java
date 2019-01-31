package modelo;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Linea {
	private String cod_linea;
	private String nombre;	
	
	
	public Linea() {
		
	}
	public Linea(String cod_linea,String nombre) {
		this.cod_linea=cod_linea;
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	
	
	}

}
