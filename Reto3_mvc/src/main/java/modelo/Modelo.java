package modelo;

public class Modelo {
	public Linea linea;
	public Parada parada;
	public MyListModel mylist;
	public DB db;
	
	public Modelo()
	{
		this.linea = new Linea();
		this.parada = new Parada();
		this.mylist=new MyListModel();
		this.db=new DB();


	}
}
