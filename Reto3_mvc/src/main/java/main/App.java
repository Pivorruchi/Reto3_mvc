package main;

import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		
		Controlador controlador = new Controlador(modelo, vista);

	}

}
