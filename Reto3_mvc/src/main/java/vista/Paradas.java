package vista;

import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controlador.Controlador;
import modelo.MyListModel;
import modelo.Parada;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.JButton;

public class Paradas extends JPanel {

	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	//String hola="L1";
	public static MyListModel lm = new MyListModel();
	public static JLabel label= new JLabel();
	JList listaParadasOrigen = new JList(lm);
	JList listaParadasDestino = new JList(lm);
	public JButton btnDestinos = new JButton("Destinos");
	Object i;
	
	//private String sentenciadbParada = "Select P.Cod_Parada, P.Nombre, P.Calle, P.Latitud, P.Longitud From Parada as P Inner Join `linea-parada` as LP ON  LP.Cod_Parada = P.Cod_Parada Where LP.Cod_Linea = 'L1'";
	public Paradas() throws Exception {
		setLayout(null);
		
		
		
		
		listaParadasOrigen.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {
					System.out.println("epa");
					label.setText(listaParadasOrigen.getSelectedValue().toString());
					Object i=listaParadasOrigen.getSelectedValue();
					
					int x=listaParadasOrigen.getSelectedIndex();
					System.out.println(i);
					/*try {
						Paradas.lm.llenarParada(Controlador.Codlinea);
					} catch (Exception e1) {
						System.out.println("el ArrayList de parada no ha sido rellenado");
						e1.printStackTrace();
					}
					ParadasDestino.listaParadasDestino.size();
					ParadasDestino.listaParadasDestino.remove(x);
					*/
					
					//listaParadasDestino.remove(listaParadasOrigen.getSelectedValue());
					
				}
				
			}
		});
		
		listaParadasOrigen.setBounds(238, 45, 151, 155);
		listaParadasOrigen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(listaParadasOrigen);
		
		label.setBounds(41, 232, 151, 27);
		add(label);
		;
		add(listaParadasDestino);
		
		listaParadasDestino.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaParadasDestino.setBounds(6, 45, 151, 155);
		
		
		btnDestinos.setBounds(108, 230, 117, 29);
		add(btnDestinos);
		
		
		
		
		

	}
}
