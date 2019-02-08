package vista;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;


import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JLabel;

public class Bienvenida extends JPanel {
	public JButton btnBienvenida = new JButton("¡Bienvenid@!");
	boolean hasclicked1 = false;
	JLabel click1label = null;

	public Bienvenida() {
		setLayout(null);
		
				JLabel lblNewLabel = new JLabel("New label");
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
				lblNewLabel.setIcon(new ImageIcon(Bienvenida.class.getResource("/imagenes/LogoTicket.png")));
				lblNewLabel.setBounds(0, 55, 444, 263);
				add(lblNewLabel);
		btnBienvenida.setBackground(UIManager.getColor("Button.highlight"));
		btnBienvenida.setIcon(null);
		btnBienvenida.setBounds(0, 0, 700, 600);
		add(btnBienvenida);

	}
}
