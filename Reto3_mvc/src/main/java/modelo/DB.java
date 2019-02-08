package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
//import javax.swing.ListModel;

//import modelo.Linea;

public class DB {

	public static Connection connect;
	public static Statement statement;
	public static ResultSet resultSet = null;
	static DefaultListModel<String> listModel = new DefaultListModel<>();
	public static JComboBox<String> comboBox = new JComboBox<String>();

	public DB() {
		connect = null;
		conectar();
	}

	public static void conectar() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/reto3_V2?serverTimezone=UTC", "root",
					"elorrieta");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public ArrayList<Linea> seleccionarLineas(String select) throws Exception {
		ArrayList<Linea> misLineas = new ArrayList<Linea>();

		try {

			DB.resultSet = seleccionar(select);
			while (DB.resultSet.next()) {
				misLineas.add(new Linea(DB.resultSet.getString("Cod_Linea"), DB.resultSet.getString("Nombre")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return misLineas;
	}

	public ArrayList<Parada> seleccionarParadas(String select) throws Exception {
		ArrayList<Parada> misParadas = new ArrayList<Parada>();

		try {

			DB.resultSet = seleccionar(select);
			while (DB.resultSet.next()) {
				misParadas.add(new Parada(DB.resultSet.getInt("Cod_Parada"), DB.resultSet.getString("Nombre"),
						DB.resultSet.getString("Calle"), resultSet.getFloat("Latitud"), resultSet.getFloat("Longitud"),
						resultSet.getDouble("Distancia")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return misParadas;
	}

	public static ResultSet seleccionar(String select) {
		ResultSet rs = null;
		try {
			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();
			// Result set get the result of the SQL query
			rs = statement.executeQuery(select);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;

	}
	
	public static JComboBox<String> rellenarComboBox(String select) {
		
		try {
			statement=connect.createStatement();
			resultSet=statement.executeQuery(select);
			
			
			while (resultSet.next()) {
				comboBox.addItem(resultSet.getString("Color"));
			//	return str ;
				
			}
			
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			
		}
return comboBox;
	}
	
	
	/*
	 * public void seleccionar(String sentencia) throws Exception { try {
	 * 
	 * statement = connect.createStatement();
	 * 
	 * resultSet = statement .executeQuery(sentencia); writeResultSet(resultSet);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * }
	 */

	public static String seleccionara(String sentencia, String str) throws Exception {
		try {

			statement = connect.createStatement();

			resultSet = statement.executeQuery(sentencia);
			return writeResultSeta(resultSet, str);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}

	public static String writeResultSet(ResultSet resultSet) throws SQLException {
		String str = "";

		while (resultSet.next()) {
			str = resultSet.getString("Cod_Linea");
		}
		return str;
	}

	public static String writeResultSeta(ResultSet resultSet, String str) throws SQLException {

		String str2 = "";
		while (resultSet.next()) {

			str2 = resultSet.getString(str);

			System.out.println(str2);

		}
		return str2;

	}

	public static int seleccionarInt(String sentencia, int i) throws Exception {
		try {

			statement = connect.createStatement();

			resultSet = statement.executeQuery(sentencia);
			return writeResultSetInt(resultSet, i);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public static int writeResultSetInt(ResultSet resultSet, int i) throws SQLException {

		while (resultSet.next()) {

			i = resultSet.getInt(i);
			System.out.println(i);

		}
		return i;

	}

	public static int seleccionarArray(String sentencia, int i) throws Exception {
		try {
			statement = connect.createStatement();

			resultSet = statement.executeQuery(sentencia);
			return writeResultSetArray(resultSet, i);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public static int writeResultSetArray(ResultSet resultSet, int i) throws SQLException {

		int array = 0;
		while (resultSet.next()) {

			array = resultSet.getInt(i);

			System.out.println(array);

		}
		return array;

	}
	
	public static void Insertar(String str) {
		
	}

	public void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {

		}
	}

}