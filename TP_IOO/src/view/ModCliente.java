package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import model.ClienteVista;

public class ModCliente extends javax.swing.JFrame {

	private JLabel lbldni;
	private JLabel lblnombre;
	private JLabel lbldomicilio;
	private JLabel lbltelefono;
	private JLabel lblmail;
	private JLabel lblestado;
	private JTextField dni;
	private JTextField nombre;
	private JTextField domicilio;
	private JTextField telefono;
	private JTextField mail;
	private JComboBox estado;
	private JButton buscar;
	private JButton cambiar;
	private JButton limpiar;
	private Controlador controlador;
	public static final String CLIENTE_ACTIVO = "Activo";
	public static final String CLIENTE_INACTIVO = "Inactivo";
	public static final String[] ESTADOS_CLIENTE = {CLIENTE_ACTIVO, CLIENTE_INACTIVO};
	

	
	public ModCliente(Controlador controlador) {
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
			
			lblestado = new JLabel();
			getContentPane().add(lblestado);
			lblestado.setText("Estado:");
			lblestado.setBounds(21, 271, 63, 28);
			

			dni = new JTextField();
			getContentPane().add(dni);
			dni.setBounds(119, 21, 210, 28);

			nombre = new JTextField();
			getContentPane().add(nombre);
			nombre.setBounds(119, 71, 210, 28);
			nombre.setEnabled(false);

			domicilio = new JTextField();
			getContentPane().add(domicilio);
			domicilio.setBounds(119, 121, 210, 28);
			domicilio.setEnabled(false);

			telefono = new JTextField();
			getContentPane().add(telefono);
			telefono.setBounds(119, 171, 210, 28);
			telefono.setEnabled(false);

			mail = new JTextField();
			getContentPane().add(mail);
			mail.setBounds(119, 221, 210, 28);
			mail.setEnabled(false);
			
			estado = new JComboBox(ESTADOS_CLIENTE);
			getContentPane().add(estado);
			estado.setBounds(119, 271, 210, 28);
			estado.setEnabled(false);
			
			
			

			buscar = new JButton();
			getContentPane().add(buscar);
			buscar.setText("Buscar");
			buscar.setBounds(21, 321, 90, 28);
			buscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					JFrame frame = new JFrame("JOptionPane showMessageDialog example");
					if (dni.getText().compareTo("") == 0) {
						JOptionPane.showMessageDialog(frame,"El campo DNI no puede quedar vacio.","Error", 0);
					}
					else
					{
						
						if (controlador.ExisteCliente(Integer.parseInt(dni.getText()))) {
							ClienteVista cv = controlador.mostrarCliente();
							dni.setEnabled(false);
							nombre.setEnabled(true);
							nombre.setText(cv.getNombre());
							domicilio.setEnabled(true);
							domicilio.setText(cv.getDomicilio());
							telefono.setEnabled(true);
							telefono.setText(String.valueOf(cv.getTelefono()));
							mail.setEnabled(true);
							mail.setText(cv.getMail());
							estado.setEnabled(true);
							estado.setSelectedItem(cv.getEstado());
							buscar.setEnabled(false);
							cambiar.setEnabled(true);
							limpiar.setEnabled(true);
							
						} else {
							JOptionPane.showMessageDialog(frame, "El Cliente no existe", "Error", 0);
						}
					}
				}
			});
			
			limpiar = new JButton();
			getContentPane().add(limpiar);
			limpiar.setText("Limpiar");
			limpiar.setEnabled(false);
			limpiar.setBounds(131, 321, 90, 28);
			limpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					dni.setText("");
					dni.setEnabled(true);
					nombre.setText("");
					nombre.setEnabled(false);
					domicilio.setText("");
					domicilio.setEnabled(false);
					telefono.setText("");
					telefono.setEnabled(false);
					mail.setText("");
					mail.setEnabled(false);
					estado.setSelectedIndex(0);
					estado.setEnabled(false);
					buscar.setEnabled(true);
					limpiar.setEnabled(false);
					cambiar.setEnabled(false);
				}
			});
			
			cambiar = new JButton();
			getContentPane().add(cambiar);
			cambiar.setText("Cambiar");
			cambiar.setEnabled(false);
			cambiar.setBounds(241, 321, 90, 28);
			cambiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					JFrame frame = new JFrame("JOptionPane showMessageDialog");
					if (nombre.getText().compareTo("") == 0 || domicilio.getText().compareTo("") == 0 || telefono.getText().compareTo("") == 0 || mail.getText().compareTo("") == 0) {
						JOptionPane.showMessageDialog(frame,"Debe completar todos los campos!!!!!!!","Error", 0);
					}
					else {
						controlador.ModificarCliente(Integer.parseInt(dni.getText()), nombre.getText(), domicilio.getText(), Integer.parseInt(telefono.getText()), mail.getText(), String.valueOf(estado.getSelectedItem()));
						JOptionPane.showMessageDialog(frame,"Cliente modificado satsifactoriamente.","No Error", 1);
					}
				}
			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
