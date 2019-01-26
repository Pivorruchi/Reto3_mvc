package main;

import controlador.Controlador;
import modelo.Modelo;
import vista.Vista;
import modelo.MyListModel;

public class App {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		//System.out.println(misLineas.get(1));
		
		Controlador controlador = new Controlador(modelo, vista);

	}

}
