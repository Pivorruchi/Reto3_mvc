package vista;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lineas extends JPanel {
	public JButton btnMostrarLineas = new JButton("Mostrar lineas");
	private JTextArea textAreaLineas;
	public Lineas() {
		setLayout(null);
		
		textAreaLineas = new JTextArea();
		textAreaLineas.setBounds(66, 54, 201, 153);
		add(textAreaLineas);
		
		btnMostrarLineas.setBounds(66, 238, 201, 23);
		add(btnMostrarLineas);

	}
	
	public void MostrarLineas(String lineas) {
		textAreaLineas.append(lineas);
	}
}
