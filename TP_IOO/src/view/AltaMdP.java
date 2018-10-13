package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;

public class AltaMdP extends javax.swing.JFrame {
	public static final String[] MEDIOS_DE_PAGO = {"Efectivo", "Tarjeta de Credito", "Transferencia Bancaria"};
	private Controlador controlador;
	
	private JLabel lblContrato;
	private JTextField Contrato;
	private JButton buscarContrato;
	
	private JComboBox medioDePago;
	private JButton seleccionarMedio;
	
	private JButton altaMedio;
	
	
	private JLabel lblentidadBancaria;
	private JLabel lblCBU;
	private JTextField entidadBancaria;
	private JTextField CBU;
	
	
	private JLabel lblentidadEmisora;
	private JLabel lblNumero;
	private JLabel lblFecha;
	private JTextField entidadEmisora;
	private JTextField Numero;
	private JTextField Fecha;
	
	
	public AltaMdP(Controlador controlador) {
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
					altaMedio.setVisible(true);

					switch (medioDePago.getSelectedIndex()) {
					case 0:
						//Efectivo
						break;
					case 1:
						//Tarjeta
						lblentidadEmisora.setVisible(true);
						entidadEmisora.setVisible(true);
						lblNumero.setVisible(true);
						Numero.setVisible(true);
						lblFecha.setVisible(true);
						Fecha.setVisible(true);

						break;
					case 2:
						//Transferencia
						lblentidadBancaria.setVisible(true);
						entidadBancaria.setVisible(true);
						lblCBU.setVisible(true);
						CBU.setVisible(true);

						break;
					}
				}
			});
			
			lblentidadEmisora = new JLabel();
			getContentPane().add(lblentidadEmisora);
			lblentidadEmisora.setText("Entidad Emisora:");
			lblentidadEmisora.setVisible(false);
			lblentidadEmisora.setBounds(21, 121, 63, 28);
			
			entidadEmisora = new JTextField();
			getContentPane().add(entidadEmisora);
			entidadEmisora.setVisible(false);
			entidadEmisora.setBounds(104, 121, 253, 28);
			
			
			lblNumero = new JLabel();
			getContentPane().add(lblNumero);
			lblNumero.setText("Numero:");
			lblNumero.setVisible(false);
			lblNumero.setBounds(21, 171, 63, 28);
			
			Numero = new JTextField();
			getContentPane().add(Numero);
			Numero.setVisible(false);
			Numero.setBounds(104, 171, 253, 28);
			
			
			lblFecha = new JLabel();
			getContentPane().add(lblFecha);
			lblFecha.setText("Fecha Vencimiento: (DD-MM-AAAA)");
			lblFecha.setVisible(false);
			lblFecha.setBounds(21, 221, 63, 28);
			
			Fecha = new JTextField();
			getContentPane().add(Fecha);
			Fecha.setVisible(false);
			Fecha.setBounds(104, 221, 253, 28);
			

			lblentidadBancaria = new JLabel();
			getContentPane().add(lblentidadBancaria);
			lblentidadBancaria.setText("Entidad Bancaria:");
			lblentidadBancaria.setVisible(false);
			lblentidadBancaria.setBounds(21, 121, 63, 28);
			
			entidadBancaria = new JTextField();
			getContentPane().add(entidadBancaria);
			entidadBancaria.setVisible(false);
			entidadBancaria.setBounds(104, 121, 253, 28);
			
			
			lblCBU = new JLabel();
			getContentPane().add(lblCBU);
			lblCBU.setText("CBU:");
			lblCBU.setVisible(false);
			lblCBU.setBounds(21, 171, 63, 28);
			
			CBU = new JTextField();
			getContentPane().add(CBU);
			CBU.setVisible(false);
			CBU.setBounds(104, 171, 253, 28);
			
			altaMedio = new JButton();
			getContentPane().add(altaMedio);
			altaMedio.setText("Confirmar Alta");
			altaMedio.setVisible(false);
			altaMedio.setBounds(21, 271, 336, 28);
			altaMedio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					JFrame frame = new JFrame("JOptionPane showMessageDialog");
					switch (medioDePago.getSelectedIndex()) {
					case 0:
						//Efectivo
						//Crear Efectivo
						controlador.AltaEfectivo();
						break;
					case 1:
						//Tarjeta
						if (entidadEmisora.getText().compareTo("") == 0
						|| Numero.getText().compareTo("") == 0
						|| Fecha.getText().compareTo("") == 0) {
							JOptionPane.showMessageDialog(frame,
									"Debe completar todos los campos!!!!!!!",
									"Error", 0);
						}
						else {
							//CrearTarjeta
							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
							Date fecha = new Date();
							try {
								fecha = formatter.parse(Fecha.getText());
							} catch (ParseException ex) {
								ex.printStackTrace();
							}
							controlador.AltaTarjeta(entidadEmisora.getText(), Integer.parseInt(Numero.getText()), fecha);
						}
						break;
					case 2:
						//Transferencia
						if (entidadBancaria.getText().compareTo("") == 0
						|| CBU.getText().compareTo("") == 0) {
							JOptionPane.showMessageDialog(frame,
									"Debe completar todos los campos!!!!!!!",
									"Error", 0);
						}
						else {
							//Crear Tarjeta
							controlador.AltaCBU(entidadBancaria.getText(), Integer.parseInt(CBU.getText()));
						}
						break;
					}
					JOptionPane.showMessageDialog(frame,
							"Medio de pago dado de alta correctamente.",
							"No Error", 1);
					Contrato.setText("");
					Contrato.setEnabled(true);
					buscarContrato.setEnabled(true);
					altaMedio.setVisible(false);
					lblentidadEmisora.setVisible(false);
					entidadEmisora.setVisible(false);
					lblNumero.setVisible(false);
					Numero.setVisible(false);
					lblFecha.setVisible(false);
					Fecha.setVisible(false);
					lblentidadBancaria.setVisible(false);
					entidadBancaria.setVisible(false);
					lblCBU.setVisible(false);
					CBU.setVisible(false);
				}
			});
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
