package vista;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import modelo.MyListModel;

public class ParadasDestino extends JPanel {
	public static MyListModel lm = new MyListModel();
	public static JList listaParadasDestino = new JList(lm);
	
	
	
	public ParadasDestino() {
		
		setLayout(null);
		listaParadasDestino.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaParadasDestino.setBounds(6, 45, 151, 155);
		add(listaParadasDestino);
		
		
	}

}
