package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.Controlador;

import javax.swing.*;
import javax.swing.JFrame;

public class BajaMdP extends javax.swing.JFrame {
	public static final String[] MEDIOS_DE_PAGO = {"Efectivo", "Tarjeta de Credito", "Transferencia Bancaria"};
	private Controlador controlador;
	
	private JLabel lblContrato;
	private JTextField Contrato;
	private JButton buscarContrato;
	
	private JComboBox medioDePago;
	private JButton seleccionarMedio;
	
	private JLabel label;
	private JTextField numero;
	
	private JButton bajaMedio;

	
	public BajaMdP(Controlador controlador) {
		this.controlador = controlador;
		crearPantalla();
	}
	
	private void crearPantalla() {
		try {
			setSize(390, 400);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			lblContrato = new JLabel();
			getContentPane().add(lblContrato);
			lblContrato.setText("Contrato:");
			lblContrato.setBounds(21, 21, 63, 28);
			
			Contrato = new JTextField();
			getContentPane().add(Contrato);
			Contrato.setBounds(104, 21, 155, 28);
			
			buscarContrato = new JButton();
			getContentPane().add(buscarContrato);
			buscarContrato.setText("Buscar");
			buscarContrato.setBounds(279, 21, 78, 28);
			buscarContrato.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					JFrame frame = new JFrame("JOptionPane showMessageDialog");
					if (Contrato.getText().compareTo("") == 0) {
						JOptionPane.showMessageDialog(frame,
								"Debe completar el numero de Contrato!!!!!!!",
								"Error", 0);
					}
					else
					{
						if (controlador.ExisteContrato(Integer.parseInt(Contrato.getText()))) {
							medioDePago.setEnabled(true);
							seleccionarMedio.setEnabled(true);
							Contrato.setEnabled(false);
							buscarContrato.setEnabled(false);
						} else {
							JOptionPane.showMessageDialog(frame,"El contrato no existe.", "Error", 0);
						}
					}
				}
			});
			
			
			medioDePago = new JComboBox(MEDIOS_DE_PAGO);
			getContentPane().add(medioDePago);
			medioDePago.setBounds(21, 71, 238, 28);
			medioDePago.setEnabled(false);
			
			seleccionarMedio = new JButton();
			getContentPane().add(seleccionarMedio);
			seleccionarMedio.setText("OK");
			seleccionarMedio.setEnabled(false);
			seleccionarMedio.setBounds(279, 71, 78, 28);
			seleccionarMedio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					JFrame frame = new JFrame("JOptionPane showMessageDialog");
					medioDePago.setEnabled(false);
					seleccionarMedio.setEnabled(false);
					bajaMedio.setVisible(true);

					switch (medioDePago.getSelectedIndex()) {
					case 0:
						//Efectivo
						break;
					case 1:
						//Tarjeta
						label.setVisible(true);
						label.setText("Numero Tarjeta");
						numero.setVisible(true);
						break;
					case 2:
						//Transferencia
						label.setVisible(true);
						label.setText("CBU");
						numero.setVisible(true);
						break;
					}
				}
			});
			
			label = new JLabel();
			getContentPane().add(label);
			label.setVisible(false);
			label.setBounds(21, 121, 63, 28);
			
			numero = new JTextField();
			getContentPane().add(numero);
			numero.setVisible(false);
			numero.setBounds(104, 121, 253, 28);
			
			bajaMedio = new JButton();
			getContentPane().add(bajaMedio);
			bajaMedio.setText("Confirmar Baja");
			bajaMedio.setVisible(false);
			bajaMedio.setBounds(21, 271, 336, 28);
			bajaMedio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					JFrame frame = new JFrame("JOptionPane showMessageDialog");
					switch (medioDePago.getSelectedIndex()) {
					case 0:
						//Efectivo
						//Crear Efectivo
						controlador.BajaEfectivo();
						break;
					case 1:
						//Tarjeta
						if (numero.getText().compareTo("") == 0) {
							JOptionPane.showMessageDialog(frame,
									"Debe completar todos los campos!!!!!!!",
									"Error", 0);
						}
						else {
							//BajaTarjeta
							controlador.BajaTarjeta(Integer.parseInt(numero.getText()));
						}
						break;
					case 2:
						//Transferencia
						if (numero.getText().compareTo("") == 0) {
							JOptionPane.showMessageDialog(frame,
									"Debe completar todos los campos!!!!!!!",
									"Error", 0);
						}
						else {
							//Crear Tarjeta
							controlador.BajaCBU(Integer.parseInt(numero.getText()));
						}
						break;
					}
					JOptionPane.showMessageDialog(frame,
							"Medio de pago dado de baja correctamente.",
							"No Error", 1);
					Contrato.setText("");
					Contrato.setEnabled(true);
					buscarContrato.setEnabled(true);
					bajaMedio.setVisible(false);
					label.setVisible(false);
					numero.setVisible(false);

				}
			});
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
