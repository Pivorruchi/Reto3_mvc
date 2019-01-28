package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPantallaDeRegistro = new JLabel("Pantalla de Registro");
		lblPantallaDeRegistro.setBounds(206, 0, 128, 53);
		contentPane.add(lblPantallaDeRegistro);
		
		JLabel lblDni = new JLabel("DNI : ");
		lblDni.setBounds(90, 69, 58, 16);
		contentPane.add(lblDni);
		
		textField = new JTextField();
		textField.setBounds(164, 66, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombreY = new JLabel("Nombre y Apellido: ");
		lblNombreY.setBounds(90, 112, 152, 16);
		contentPane.add(lblNombreY);
		
		textField_1 = new JTextField();
		textField_1.setBounds(229, 112, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(373, 112, 128, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento: ");
		lblFechaNacimiento.setBounds(90, 161, 116, 16);
		contentPane.add(lblFechaNacimiento);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dia = Integer.toString(dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH));
				String mes = Integer.toString(dateChooser.getCalendar().get(Calendar.MONTH) + 1);
				String year = Integer.toString(dateChooser.getCalendar().get(Calendar.YEAR));
				String fecha = (year + "-" + mes+ "-" + dia);

				pegado.setText(fecha);
			}
		});
		dateChooser.setBounds(229, 155, 105, 22);
		contentPane.add(dateChooser);
		
		JLabel lblSexo = new JLabel("Sexo: ");
		lblSexo.setBounds(90, 205, 56, 16);
		contentPane.add(lblSexo);
		
		String[] Genero = { "Hombre", "Mujer"};

		JComboBox GenBox = new JComboBox(Genero);
		GenBox.setBounds(156, 202, 105, 22);
		contentPane.add(GenBox);
		
	}
}
