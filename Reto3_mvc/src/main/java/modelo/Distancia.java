package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Login.gestorBD;
import modelo.DB;
import vista.Paradas;

public class Distancia {
	DB db = new DB();
	static int[] codParada = { 1 };
	public static String Latitud = "Latitud";
	public static String Longitud = "Longitud";
	static String latitudSelect = "select Latitud from parada where Cod_Parada=1";
	static String longitudSelect = "select Longitud from parada where Cod_Parada=1";
	static String codParadaSelect = "select Cod_Parada from parada where Cod_Parada='%s'";// +codParada;

	static int numParada = 1;

	static String termiLat;
	static String termiLong;
	static String counnt = "select count(*) from parada";
	public static float termiLanNum;
	public static float termiLongNum;


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// String termiLat;
		//double termiLanNum;
		//double termiLongNum;

		// String latitudSelect = "select Latitud from parada where Cod_Parada=1" ;

		
		DB.conectar();
		termiLat = (DB.seleccionara(latitudSelect, Latitud));
		termiLong = (DB.seleccionara(longitudSelect, Longitud));
		System.out.println(termiLat + termiLong);
		termiLanNum = Float.parseFloat(termiLat);
		termiLongNum = Float.parseFloat(termiLong);
		numParada = (DB.seleccionarInt(counnt, numParada));
		for (int count=0;count<Paradas.lm.getSize()-1;count++) {
			
			 System.out.println("hola"+count);
		}
		System.out.println(distanciaCoord(termiLanNum, termiLongNum, 40.4167f, -3.70325f));

		

		/*
		 * for (int i=0;i<=numParada;i++) { int a=1;
		 * codParada[i]=DB.seleccionarArray(codParadaSelect+i+1,a);
		 * System.out.println(codParada[i]); a++;
		 * 
		 * }
		 */
		/*
		  for(int x=0;x<Paradas.lm.getSize();x++) {
		  System.out.println(Paradas.lm.get(x)); }
		 */
		
	}

	public static double distanciaCoord(float lat1, float lng1, float lat2, float lng2) {

		double radioTierra = 6371;
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		double distancia = radioTierra * va2;

		return distancia;
	}

}
