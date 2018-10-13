package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import controller.Controlador;

public class NewJFrame  extends javax.swing.JFrame {
	private JButton altaCliente;
	private JButton modCliente;
	private JButton bajaCliente;
	private JButton altaCochera;
	private JButton altaMdP;
	private JButton bajaMdP;
	private JButton altaContrato;
	private JButton bajaContrato;
	private JButton pagoEfectivo;
	private JButton actCC;
	private JButton controlCobranzas;
	private JButton procesarCobranzas;
	private Controlador controlador;
	
	public static void main(String[] args) 
	{
		NewJFrame inst = new NewJFrame();
		
		inst.setVisible(true);
	}
	
	public NewJFrame()
	{
		controlador = new Controlador();
		initGUI();
	}
	
	private void initGUI() 
	{
		try 
		{
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			pack();
			setSize(390, 400);
			
			altaCliente = new JButton();
			getContentPane().add(altaCliente);
			altaCliente.setText("Alta Cliente");
			altaCliente.setBounds(25, 25, 155, 28);
			altaCliente.setVisible(true);
			altaCliente.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					AltaCliente ac = new AltaCliente(controlador);
					ac.setVisible(true);
				}
			});
			
			modCliente = new JButton();
			getContentPane().add(modCliente);
			modCliente.setText("Modificar Cliente");
			modCliente.setBounds(200, 25, 155, 28);
			modCliente.setVisible(true);
			modCliente.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					ModCliente mc = new ModCliente(controlador);
					mc.setVisible(true);
				}
			});

			
			bajaCliente = new JButton();
			getContentPane().add(bajaCliente);
			bajaCliente.setText("Baja Cliente");
			bajaCliente.setBounds(25, 75, 155, 28);
			bajaCliente.setVisible(true);
			bajaCliente.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					BajaCliente bc = new BajaCliente(controlador);
					bc.setVisible(true);
				}
			});

			
			altaCochera = new JButton();
			getContentPane().add(altaCochera);
			altaCochera.setText("Alta Cochera");
			altaCochera.setBounds(200, 75, 155, 28);
			altaCochera.setVisible(true);
			altaCochera.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					AltaCochera ac = new AltaCochera(controlador);
					ac.setVisible(true);
				}
			});
//asasdasdasdasd
			altaMdP = new JButton();
			getContentPane().add(altaMdP);
			altaMdP.setText("Alta Medio de Pago");
			altaMdP.setBounds(25, 125, 155, 28);
			altaMdP.setVisible(true);
			altaMdP.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					AltaMdP amdp = new AltaMdP(controlador);
					amdp.setVisible(true);
				}
			});

			bajaMdP = new JButton();
			getContentPane().add(bajaMdP);
			bajaMdP.setText("Baja Medio de Pago");
			bajaMdP.setBounds(200, 125, 155, 28);
			bajaMdP.setVisible(true);
			bajaMdP.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					BajaMdP ac = new BajaMdP(controlador);
					ac.setVisible(true);
				}
			});
			
			altaContrato = new JButton();
			getContentPane().add(altaContrato);
			altaContrato.setText("Alta Contrato");
			altaContrato.setBounds(25, 175, 155, 28);
			altaContrato.setVisible(true);
			altaContrato.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					//altaContrato ac = new altaContrato(controlador);
					//ac.setVisible(true);
				}
			});
			
			bajaContrato = new JButton();
			getContentPane().add(bajaContrato);
			bajaContrato.setText("Baja Contrato");
			bajaContrato.setBounds(200, 175, 155, 28);
			bajaContrato.setVisible(true);
			bajaContrato.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					//bajaContrato ac = new bajaContrato(controlador);
					//ac.setVisible(true);
				}
			});
			//asdasdasdasd
			procesarCobranzas = new JButton();
			getContentPane().add(procesarCobranzas);
			procesarCobranzas.setText("Procesar Cobranzas");
			procesarCobranzas.setBounds(25, 225, 155, 28);
			procesarCobranzas.setVisible(true);
			procesarCobranzas.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					JFrame frame = new JFrame();
					int reply = JOptionPane.showConfirmDialog(frame, "Confirma procesar las cobranzas?", "Confirmacion", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						Date fecha = new Date();
						controlador.ProcesarCuota(fecha);
						JOptionPane.showMessageDialog(frame,"Cuotas debitadas.","No Error", 1);
					}
				}
			});

			controlCobranzas = new JButton();
			getContentPane().add(controlCobranzas);
			controlCobranzas.setText("Control Cobranzas");
			controlCobranzas.setBounds(200, 225, 155, 28);
			controlCobranzas.setVisible(true);
			controlCobranzas.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					JFrame frame = new JFrame();
					int reply = JOptionPane.showConfirmDialog(frame, "Confirma realizar control de cobranzas?", "Confirmacion", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						controlador.ActualizarEstadoCochera();
						JOptionPane.showMessageDialog(frame,"Control de cobranzas realizado.","No Error", 1);
					}
					
				}
			});
			
			pagoEfectivo = new JButton();
			getContentPane().add(pagoEfectivo);
			pagoEfectivo.setText("Pago en Efectivo");
			pagoEfectivo.setBounds(25, 275, 155, 28);
			pagoEfectivo.setVisible(true);
			pagoEfectivo.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					PagoenEfectivo pee = new PagoenEfectivo(controlador);
					pee.setVisible(true);
				}
			});
			
			actCC = new JButton();
			getContentPane().add(actCC);
			actCC.setText("Actualizar CC");
			actCC.setBounds(200, 275, 155, 28);
			actCC.setVisible(true);
			actCC.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt) 
				{
					ActualizarCC ac = new ActualizarCC(controlador);
					ac.setVisible(true);
				}
			});
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
