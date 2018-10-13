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

import model.ClienteVista;

public class BajaCliente extends javax.swing.JFrame {

	private JLabel lbldni;
	private JTextField dni;
	private JButton baja;
	private Controlador controlador;
	

	
	public BajaCliente(Controlador controlador) {
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
			lbldni.setBounds(21, 121, 63, 28);

			dni = new JTextField();
			getContentPane().add(dni);
			dni.setBounds(119, 121, 210, 28);

			baja = new JButton();
			getContentPane().add(baja);
			baja.setText("Baja cliente");
			baja.setBounds(21, 171, 308, 28);
			baja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					JFrame frame = new JFrame("JOptionPane showMessageDialog example");
					if (dni.getText().compareTo("") == 0) {
						JOptionPane.showMessageDialog(frame,"El campo DNI no puede quedar vacio.","Error", 0);
					}
					else
					{
						if (controlador.ExisteCliente(Integer.parseInt(dni.getText()))) {
							ClienteVista cv = controlador.mostrarCliente();
							int reply = JOptionPane.showConfirmDialog(frame, "Confirma baja del cliente " + cv.getNombre(), "Confirmar baja", JOptionPane.YES_NO_OPTION);
							if (reply == JOptionPane.YES_OPTION)
			                {
			                    controlador.BajaCliente();
			                }
						} 
						else {
							JOptionPane.showMessageDialog(frame, "El Cliente no existe", "Error", 0);
						}
					}
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
