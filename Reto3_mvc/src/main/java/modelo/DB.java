package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

//import modelo.Linea;

public class DB {
	
	public static Connection connect;
	public static Statement statement;
	public static ResultSet resultSet = null;
	static DefaultListModel<String> listModel = new DefaultListModel<>();
	
	
	public DB() {
		connect=null;
		conectar();
	}
	public static void conectar() {
	    try {
	      
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        
	        connect = DriverManager
	                .getConnection("jdbc:mysql://localhost:3306/reto3_V2?serverTimezone=UTC","root","elorrieta");
	         
	       
	    } catch (Exception e) {
	        
	    	e.printStackTrace();
	    } 
	
	}
	
	public ArrayList<Linea> seleccionarLineas(String select) throws Exception {
		ArrayList<Linea> misLineas = new ArrayList<Linea>();

		try {
			
			DB.resultSet = seleccionar(select);
			while (DB.resultSet.next()) {
				misLineas.add(
						new Linea(DB.resultSet.getString("Cod_Linea"), DB.resultSet.getString("Nombre")));
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
				misParadas.add(
						new Parada(DB.resultSet.getInt("Cod_Parada"), DB.resultSet.getString("Nombre"), DB.resultSet.getString("Calle"), resultSet.getFloat("Latitud"), resultSet.getFloat("Longitud") ));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return misParadas;
	}
	
	public ResultSet seleccionar(String select) {
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
	/*public void seleccionar(String sentencia) throws Exception {
	    try {
	       
	        statement = connect.createStatement();
	        
	        resultSet = statement
	                .executeQuery(sentencia);
	        writeResultSet(resultSet);
	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    

	}*/
	
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

	
	
	private void writeResultSet(ResultSet resultSet) throws SQLException {
	    
	    while (resultSet.next()) {
	        	        String Cod_bus = resultSet.getString("Cod_bus");
	        String N_plazas = resultSet.getString("N_plazas");
	
	        System.out.println("Cod_bus: " + Cod_bus);
	        System.out.println("N_plazas: " + N_plazas);
	        
	    }
	}
	
	
	

	public static String writeResultSeta(ResultSet resultSet, String str) throws SQLException {
		
		while (resultSet.next()) {
			
			
			str = resultSet.getString(str);
			
			System.out.println(str);

		}
		return str;

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

		int array=0;
		while (resultSet.next()) {
		
			array = resultSet.getInt(i);
	
			System.out.println(array);

		}
		return array;

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