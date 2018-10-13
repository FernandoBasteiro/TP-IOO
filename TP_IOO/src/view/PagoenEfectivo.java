package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import controller.Controlador;

import javax.swing.*;
import javax.swing.JFrame;

public class PagoenEfectivo extends javax.swing.JFrame {
	private Controlador controlador;
	
	private JLabel lblContrato;
	private JTextField Contrato;
	private JButton buscarContrato;
	
	private JLabel lblConcepto;
	private JTextField txtConcepto;
	private JLabel lblMonto;
	private JTextField txtMonto;
	
	private JButton procesarPago;
	
	public PagoenEfectivo(Controlador controlador) {
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
			
			lblConcepto = new JLabel();
			getContentPane().add(lblConcepto);
			lblConcepto.setText("Concepto:");
			lblConcepto.setBounds(21, 71, 63, 28);
	
			txtConcepto = new JTextField();
			txtConcepto.setText("Pago en efectivo");
			txtConcepto.setEnabled(false);
			getContentPane().add(txtConcepto);
			txtConcepto.setBounds(104, 71, 253, 28);
			
			lblMonto = new JLabel();
			getContentPane().add(lblMonto);
			lblMonto.setText("Monto:");
			lblMonto.setBounds(21, 121, 63, 28);
	
			txtMonto = new JTextField();
			txtMonto.setEnabled(false);
			getContentPane().add(txtMonto);
			txtMonto.setBounds(104, 121, 253, 28);
			
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
							procesarPago.setEnabled(true);
							txtConcepto.setEnabled(true);
							txtMonto.setEnabled(true);
							Contrato.setEnabled(false);
							buscarContrato.setEnabled(false);
						} else {
							JOptionPane.showMessageDialog(frame,"El contrato no existe.", "Error", 0);
						}
					}
				}
			});
			
			procesarPago = new JButton();
			getContentPane().add(procesarPago);
			procesarPago.setText("Procesar Pago");
			procesarPago.setEnabled(false);
			procesarPago.setBounds(21, 171, 336, 28);
			procesarPago.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					JFrame frame = new JFrame("JOptionPane showMessageDialog");
					if (txtMonto.getText().compareTo("") == 0) {
						JOptionPane.showMessageDialog(frame,
								"Debe completar el monto pagado!!!!!!!",
								"Error", 0);
					}
					else {
						Date fecha = new Date();
						controlador.ProcesarMovimiento(fecha, txtConcepto.getText(), Float.valueOf(txtMonto.getText()));
						JOptionPane.showMessageDialog(frame,"Pago Procesado.", "No Error", 1);
						Contrato.setText("");
						Contrato.setEnabled(true);
						buscarContrato.setEnabled(true);
						procesarPago.setEnabled(false);
						txtConcepto.setEnabled(false);
						txtConcepto.setText("Pago en efectivo");
						txtMonto.setEnabled(false);
						txtMonto.setText("");
					}

				}
			});
			
			
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
