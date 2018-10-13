package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import model.ClienteVista;
import controller.Controlador;

public class AltaCochera extends javax.swing.JFrame {
	private JLabel lblprecio;
	private JLabel lbltamanio;
	private JTextField precio;
	private JComboBox tamanio;
	private JButton crear;
	private Controlador controlador;

	public AltaCochera(Controlador controlador) {
		this.controlador = controlador;
		crearPantalla();
	}
	
	private void crearPantalla() {
		try {
			setSize(390, 400);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			lblprecio = new JLabel();
			getContentPane().add(lblprecio);
			lblprecio.setText("Precio:");
			lblprecio.setBounds(21, 71, 63, 28);
			
			lbltamanio = new JLabel();
			getContentPane().add(lbltamanio);
			lbltamanio.setText("Tamaño:");
			lbltamanio.setBounds(21, 121, 63, 28);
			
			precio = new JTextField();
			getContentPane().add(precio);
			precio.setBounds(119, 71, 210, 28);
			
			String[] tamanios = {"Pequeña","Mediana","Grande"};
			tamanio = new JComboBox(tamanios);
			getContentPane().add(tamanio);
			tamanio.setBounds(119, 121, 210, 28);

			crear = new JButton();
			getContentPane().add(crear);
			crear.setText("Crear cochera");
			crear.setBounds(21, 171, 308, 28);
			crear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					JFrame frame = new JFrame("JOptionPane showMessageDialog example");
					if (precio.getText().compareTo("") == 0) {
						JOptionPane.showMessageDialog(frame,"El campo precio no puede quedar vacio.","Error", 0);
					}
					else
					{
						controlador.CrearCochera(String.valueOf(tamanio.getSelectedItem()), Float.parseFloat(precio.getText()));
						JOptionPane.showMessageDialog(frame, "Cochera creada", "Error", 1);
					}
				}
			});
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
