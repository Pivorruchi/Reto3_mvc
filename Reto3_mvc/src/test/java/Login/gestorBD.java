package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Set;
import Login.PrincipalVentana;

public class gestorBD {
	
	private Connection connect;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	public static ResultSet resultSet = null;
	public static String DNI;
	public static String cliente="cliente";
	
	public void gestorDB() {
		connect=null;
	}
	public void conectar() throws Exception {
	    try {
	        // This will load the MySQL driver, each DB has its own driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        // Setup the connection with the DB
	        connect = DriverManager
	                .getConnection("jdbc:mysql://localhost:3306/reto3?serverTimezone=UTC","root","elorrieta");
	         
	       
	    } catch (Exception e) {
	        
	    	e.printStackTrace();
	    } 
	
	}
	public String getNumeroFilas(String cliente) {
		String numeroFilas="";
		try {
	        // Statements allow to issue SQL queries to the database
	        statement = connect.createStatement();
	        // Result set get the result of the SQL query
	        resultSet = statement
	        		.executeQuery("select count(DNI) from " +cliente+"where DNI = \"16057217E");
		    while (resultSet.next()) {
		    	numeroFilas=resultSet.getString(1);
		    	
		    }
	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
		return numeroFilas;
	} 
	
	public String seleccionar(String sentencia) throws Exception {
	    try {
	        // Statements allow to issue SQL queries to the database
	        statement = connect.createStatement();
	        // Result set get the result of the SQL query
	        resultSet = statement
	                .executeQuery(sentencia);
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
	        //String Cod_bus = resultSet.getString("Cod_bus");
	        //String N_plazas = resultSet.getString("N_plazas");
	        DNI = resultSet.getString("DNI");
	//        Date date = resultSet.getDate("datum");
	       // System.out.println("Cod_bus: " + Cod_bus);
	       // System.out.println("N_plazas: " + N_plazas);
	        System.out.println(DNI);
	        
	        
	    }
	    return DNI;
	    
	}


	
	
	// You need to close the resultSet
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