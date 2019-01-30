package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Login.gestorBD;
import modelo.DBConnect;

public class Distancia {
	DBConnect db = new DBConnect();
	static int[] codParada= {1};
	public static String Latitud="Latitud";
	public static String Longitud="Longitud";
	static String latitudSelect = "select Latitud from parada where Cod_Parada=1" ;
	static String longitudSelect = "select Longitud from parada where Cod_Parada=1" ;
	static String codParadaSelect="select Cod_Parada from parada where Cod_Parada=";//+codParada;
	
	static int numParada=1;

	static String termiLat;
	static String termiLong;
	static String counnt="select count(*) from parada";
	 
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//String termiLat;
		double termiLanNum;
		double termiLongNum;

		//String latitudSelect = "select Latitud from parada where Cod_Parada=1" ;

		
		DBConnect.conectar();
		termiLat = (DBConnect.seleccionara(latitudSelect, Latitud));
		termiLong = (DBConnect.seleccionara(longitudSelect, Longitud));
		System.out.println(termiLat+ termiLong);
		termiLanNum= Double.parseDouble(termiLat);
		termiLongNum= Double.parseDouble(termiLong);
		numParada=(DBConnect.seleccionarInt(counnt,numParada));
		
		for (int i=0;i<=numParada;i++) {
			int a=1;
			codParada[i]=DBConnect.seleccionarArray(codParadaSelect+a,a);
			System.out.println(codParada[i]);
			a++;
		}
		
		
		System.out.println(distanciaCoord(termiLanNum,termiLongNum, 40.4167, -3.70325));

	}

	public static double distanciaCoord(double lat1, double lng1, double lat2, double lng2) {

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
