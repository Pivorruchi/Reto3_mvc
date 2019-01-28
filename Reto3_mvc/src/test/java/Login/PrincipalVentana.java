package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrincipalVentana extends JFrame {

	private JPanel contentPane;
	public static JTextField NumDNI;
	public JTextField passwd;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalVentana frame = new PrincipalVentana();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDni = new JLabel("DNI:");
		lblDni.setBounds(81, 90, 56, 16);
		contentPane.add(lblDni);
		
			NumDNI = new JTextField();
			NumDNI.setBounds(169, 90, 116, 22);
			contentPane.add(NumDNI);
			NumDNI.setColumns(10);
			NumDNI.getText();
		
		
		
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(81, 151, 78, 16);
		contentPane.add(lblContrasea);
		
			passwd = new JPasswordField();
			passwd.setBounds(169, 148, 116, 22);
			contentPane.add(passwd);
			passwd.setColumns(10);
			//passwd.getText();
		
		btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  {
			System.out.println(NumDNI.getText());
			System.out.println(passwd.getText());
			gestorBD gestor = new gestorBD();
			try {
				gestor.conectar();
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
					gestor.getNumeroFilas(gestorBD.cliente);
					String valiDni = gestor.getNumeroFilas(gestorBD.cliente);
					System.out.println(valiDni);
					if (valiDni == NumDNI.getText()) {
						System.out.println("Es Correcto");
				
					}
					else {
						System.out.println("Es incorrecto");
					}

				

			}
		});
		btnNewButton.setBounds(169, 212, 116, 22);
		contentPane.add(btnNewButton);
		
		
		
	}
}
