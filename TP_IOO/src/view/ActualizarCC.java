package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controller.*;

import javax.swing.*;

import model.ClienteVista;


public class ActualizarCC extends javax.swing.JFrame  {
	private JButton btnActualizar;
	private Controlador controlador;
	private JTextArea txtArea;
	private JLabel lblTitulo;
	
	public ActualizarCC(Controlador controlador) {
		this.controlador = controlador;
		crearPantalla();

	}

	private void crearPantalla() {
		try {
			setSize(390, 400);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);

			lblTitulo = new JLabel();
			getContentPane().add(lblTitulo);
			lblTitulo.setText("NumeroContrato,Fecha(DD-MM-AAAA),Concepto,Monto");
			lblTitulo.setBounds(21, 21, 336, 28);

			
			txtArea = new JTextArea(17,48);
			getContentPane().add(txtArea);
			txtArea.setBounds(21, 51, 336, 248);
			
			btnActualizar = new JButton();
			getContentPane().add(btnActualizar);
			btnActualizar.setText("Actualizar Cuentas Corrientes");
			btnActualizar.setBounds(21, 311, 336, 28);
			btnActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					JFrame frame = new JFrame();
					for (String line : txtArea.getText().split("\\n")) {
						String[] linea = line.split(",");
						if (controlador.ExisteContrato(Integer.parseInt(linea[0]))) {
							SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
							Date fecha = new Date();
							try {
								fecha = formatter.parse(linea[1]);
							} catch (ParseException ex) {
								ex.printStackTrace();
							}
							controlador.ProcesarMovimiento(fecha, linea[2],  Float.valueOf(linea[3]));
						}
					}
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
