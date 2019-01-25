package vista;

import javax.swing.JPanel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;

public class Calendarios extends JPanel {
	

	/**
	 * Create the panel.
	 */
	public Calendarios() {
		setLayout(null);
		
		JDateChooser CalendarioG = new JDateChooser();
		CalendarioG.setBounds(171, 61, 95, 20);
		add(CalendarioG);
		
		JButton ContinuarCalendario = new JButton("Continuar");
		ContinuarCalendario.setBounds(291, 223, 89, 23);
		add(ContinuarCalendario);
		
		JButton CancelarCalendario = new JButton("Cancelar");
		CancelarCalendario.setBounds(39, 223, 89, 23);
		add(CancelarCalendario);

	}
}
