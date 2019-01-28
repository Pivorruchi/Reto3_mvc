package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Login.gestorBD;
import modelo.DBConnect;

public class Distancia {
	DBConnect db = new DBConnect();
	// public static Connection connect;
	public static Statement statement;
	public static ResultSet resultSet = null;
	private static String Latitud;
	static String latitudSelect = "select Latitud from parada where Cod_Parada=1" ;

	static String termiLat="";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//String termiLat;
		double termiLon;

		String latStr = "";
		//String latitudSelect = "select Latitud from parada where Cod_Parada=1" ;

		latStr = "1";
		termiLat = (seleccionar(latitudSelect));
		System.out.println(termiLat);
		System.out.println(distanciaCoord(43.257, -2.9234443, 40.4167, -3.70325));

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

	public static String seleccionar(String sentencia) throws Exception {
		try {
			// Statements allow to issue SQL queries to the database
			DBConnect.statement = DBConnect.connect.createStatement();
			// Result set get the result of the SQL query
			resultSet = statement.executeQuery(sentencia);
			return writeResultSet(resultSet);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}

	public static String writeResultSet(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			// String Cod_bus = resultSet.getString("Cod_bus");
			// String N_plazas = resultSet.getString("N_plazas");
			Latitud = resultSet.getString("Latitud");
			// Date date = resultSet.getDate("datum");
			// System.out.println("Cod_bus: " + Cod_bus);
			// System.out.println("N_plazas: " + N_plazas);
			System.out.println(Latitud);

		}
		return Latitud;

	}

}
