package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AltaCliente extends javax.swing.JFrame {

	private JLabel lbldni;
	private JLabel lblnombre;
	private JLabel lbldomicilio;
	private JLabel lbltelefono;
	private JLabel lblmail;
	private JTextField dni;
	private JTextField nombre;
	private JTextField domicilio;
	private JTextField telefono;
	private JTextField mail;
	private JButton alta;
	private Controlador controlador;


	public AltaCliente(Controlador controlador) {
		this.controlador = controlador;
		crearPantalla();

	}

	private void crearPantalla() {
		try {
			setSize(390, 400);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			lbldni = new JLabel();
			getContentPane().add(lbldni);
			lbldni.setText("DNI:");
			lbldni.setBounds(21, 21, 63, 28);

			lblnombre = new JLabel();
			getContentPane().add(lblnombre);
			lblnombre.setText("Nombre:");
			lblnombre.setBounds(21, 71, 63, 28);

			lbldomicilio = new JLabel();
			getContentPane().add(lbldomicilio);
			lbldomicilio.setText("Domicilio:");
			lbldomicilio.setBounds(21, 121, 63, 28);

			lbltelefono = new JLabel();
			getContentPane().add(lbltelefono);
			lbltelefono.setText("Telefono:");
			lbltelefono.setBounds(21, 171, 63, 28);

			lblmail = new JLabel();
			getContentPane().add(lblmail);
			lblmail.setText("Mail:");
			lblmail.setBounds(21, 221, 63, 28);

			dni = new JTextField();
			getContentPane().add(dni);
			dni.setBounds(119, 21, 210, 28);

			nombre = new JTextField();
			getContentPane().add(nombre);
			nombre.setBounds(119, 71, 210, 28);

			domicilio = new JTextField();
			getContentPane().add(domicilio);
			domicilio.setBounds(119, 121, 210, 28);

			telefono = new JTextField();
			getContentPane().add(telefono);
			telefono.setBounds(119, 171, 210, 28);

			mail = new JTextField();
			getContentPane().add(mail);
			mail.setBounds(119, 221, 210, 28);

			alta = new JButton();
			getContentPane().add(alta);
			alta.setText("Ok");
			alta.setBounds(238, 277, 63, 28);
			alta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					JFrame frame = new JFrame(
							"JOptionPane showMessageDialog");
					if (dni.getText().compareTo("") == 0
							|| nombre.getText().compareTo("") == 0
							|| domicilio.getText().compareTo("") == 0
							|| telefono.getText().compareTo("") == 0
							|| mail.getText().compareTo("") == 0) {
						JOptionPane.showMessageDialog(frame,
								"Debe completar todos los campos!!!!!!!",
								"Error", 0);
					}
					else
					{
						if (!controlador.ExisteCliente(Integer.parseInt(dni
								.getText()))) {
							controlador.AltaClienteNuevo(
									Integer.parseInt(dni.getText()),
									nombre.getText(), domicilio.getText(),
									Integer.parseInt(telefono.getText()),
									mail.getText());
							JOptionPane.showMessageDialog(frame,
									"Cliente fue dado de alta correctamente", "No Error", 1);
							dni.setText("");
							nombre.setText("");
							domicilio.setText("");
							telefono.setText("");
							mail.setText("");

						} else {
							JOptionPane.showMessageDialog(frame,
									"Usuario ya existe", "Error", 0);
						}
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
