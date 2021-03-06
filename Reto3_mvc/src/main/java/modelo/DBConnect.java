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

public class DBConnect {
	
	public static Connection connect;
	public static Statement statement;
	public static ResultSet resultSet = null;
	static DefaultListModel<String> listModel = new DefaultListModel<>();
	
	
	public DBConnect() {
		connect=null;
	}
	public void conectar() throws Exception {
	    try {
	        // This will load the MySQL driver, each DB has its own driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        // Setup the connection with the DB
	        connect = DriverManager
	                .getConnection("jdbc:mysql://localhost:3306/reto3_V2?serverTimezone=UTC","root","elorrieta");
	         
	       
	    } catch (Exception e) {
	        
	    	e.printStackTrace();
	    } 
	
	}
	
	
	public void seleccionar(String sentencia) throws Exception {
	    try {
	        // Statements allow to issue SQL queries to the database
	        statement = connect.createStatement();
	        // Result set get the result of the SQL query
	        resultSet = statement
	                .executeQuery(sentencia);
	        writeResultSet(resultSet);
	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    
	    

	}

	
	
	private void writeResultSet(ResultSet resultSet) throws SQLException {
	    // ResultSet is initially before the first data set
	    while (resultSet.next()) {
	        // It is possible to get the columns via name
	        // also possible to get the columns via the column number
	        // which starts at 1
	        // e.g. resultSet.getSTring(2);
	        String Cod_bus = resultSet.getString("Cod_bus");
	        String N_plazas = resultSet.getString("N_plazas");
	   //     Date date = resultSet.getDate("datum");
	   //     System.out.println("Cod_bus: " + Cod_bus);
	   //     System.out.println("N_plazas: " + N_plazas);
	        
	    }
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