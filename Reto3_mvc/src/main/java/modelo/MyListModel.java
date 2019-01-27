package modelo;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class MyListModel implements ListModel {
	private DBConnect db = new DBConnect();
	private String dbLinea = "select * from linea";
	private String dbParada = "select * from parada";
	private String codLinea = "Cod_Linea";
	private String codParada = "Cod_Parada";

	private ArrayList<String> al = new ArrayList<String>();

	public ArrayList<Linea> llenarLinea() throws Exception {

		ArrayList<Linea> misLineas = new ArrayList<Linea>();

		misLineas = seleccionar(dbLinea, codLinea);

		for (int index = 0; index < misLineas.size(); index++) {
			makeObj(misLineas.get(index).getNombre());
			al.add(misLineas.get(index).getNombre());
		}
		return misLineas;
	}

	public ArrayList<Linea> llenarParada() throws Exception {

		ArrayList<Linea> misParadas = new ArrayList<Linea>();

		misParadas = seleccionar(dbParada, codParada);

		for (int index = 0; index < misParadas.size(); index++) {
			makeObj(misParadas.get(index).getNombre());
			al.add(misParadas.get(index).getNombre());
		}
		return misParadas;
	}

	public Object makeObj(final String item) {
		return new Object() {
			public String toString() {
				return item;
			}
		};
	}

	// @Override
	public int getSize() {
		return al.size();
	}

	// @Override
	public Object getElementAt(int index) {
		return al.get(index);
	}

	@Override
	public void addListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeListDataListener(ListDataListener l) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Linea> seleccionar(String select, String Cod) throws Exception {
		ArrayList<Linea> misLineas = new ArrayList<Linea>();

		try {
			db.conectar();
			// Statements allow to issue SQL queries to the database
			db.statement = db.connect.createStatement();
			// Result set get the result of the SQL query
			DBConnect.resultSet = db.statement.executeQuery(select);
			while (DBConnect.resultSet.next()) {
				misLineas.add(
						new Linea(DBConnect.resultSet.getString(Cod), DBConnect.resultSet.getString("Nombre")));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		db.close();
		return misLineas;

	}
}
