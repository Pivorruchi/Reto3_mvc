package modelo;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class Lista {
	
	
	static DefaultListModel<String> listModel = new DefaultListModel<>();

	public ArrayList<Linea> seleccionar() throws Exception {
        ArrayList<Linea> misLineas=new ArrayList<Linea>();

	    try {
	    	DBConnect.conectar();
	        // Statements allow to issue SQL queries to the database
	    	DBConnect.statement = DBConnect.connect.createStatement();
	        // Result set get the result of the SQL query
	    	DBConnect.resultSet = DBConnect.statement
	                .executeQuery("select * from linea");
		    while (DBConnect.resultSet.next()) {
		    	misLineas.add(new Linea(DBConnect.resultSet.getString("Cod_Linea"),DBConnect.resultSet.getString("Nombre")));
		        
		    }
	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    DBConnect.close();
	    return misLineas;

	}
}
