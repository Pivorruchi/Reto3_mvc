package modelo;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class MyListModel implements ListModel {
	private Parada parada = new Parada();
	private DB db = new DB();
	private String sentenciadbLinea = "select * from linea";
	private String sentenciadbParada = "Select P.Cod_Parada, P.Nombre, P.Calle, P.Latitud, P.Longitud \n" + 
			"From Parada as P Inner Join `linea-parada` as LP ON  LP.Cod_Parada = P.Cod_Parada\n" + 
			"Where LP.Cod_Linea = '%s'";
	ArrayList<Linea> misLineas = new ArrayList<Linea>();
	ArrayList<Parada> misParadas = new ArrayList<Parada>();
	

	private ArrayList<String> al = new ArrayList<String>();

	public ArrayList<Linea> llenarLinea() throws Exception {

		

		misLineas = db.seleccionarLineas(sentenciadbLinea);

		for (int index = 0; index < misLineas.size(); index++) {
			makeObj(misLineas.get(index).getNombre());
			al.add(misLineas.get(index).getNombre());
		}
		return misLineas;
	}

	public ArrayList<Parada> llenarParada(String Linea) throws Exception {

		

		sentenciadbParada = String.format(sentenciadbParada, Linea);
		misParadas = db.seleccionarParadas(sentenciadbParada);
		misParadas = parada.ordenarParadas(misParadas);
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

	
}
