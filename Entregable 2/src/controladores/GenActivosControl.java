package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daos.CoinDAO;
import daos.UsuarioDAO;
import entregable1.Coin;
import entregable1.Saldo;
import entregable1.TipoMoneda;
import entregable1.Usuario;
import vistas.GenerarActivos;

public class GenActivosControl {
	
	private JButton generar;	
	private Usuario user;
	GenerarActivos abrirPanel;
	
	public GenActivosControl(JButton generar,Usuario user)
	{
		this.generar = generar;
		this.user = user;
		this.addListener();
	}
	
	private void addListener()
	{
		this.generar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				abrirPanel = new GenerarActivos();	
				setComportamiento();
			}			
		});
		
		
	}
	
	private void setComportamiento()
	{
		JButton cancelar = abrirPanel.getCancelar();
		JButton aceptar = abrirPanel.getAceptar();
		JComboBox<String> opciones = abrirPanel.getOpciones();		
		JTextField valor = abrirPanel.getValor();	
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				abrirPanel.dispose();
			}
		});
		
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				cargarSaldo(opciones,valor);
				abrirPanel.dispose();
			}
		});		
	}
	
	private void cargarSaldo(JComboBox<String> opciones,JTextField valor)
	{
		//JOptionPane.showMessageDialog(null, "Se cargo "+valor.getText()+" de "+opciones.getSelectedItem().toString(), "Carga Exitosa", JOptionPane.INFORMATION_MESSAGE);
		double saldoNuevo = Double.parseDouble(valor.getText());		
		//hay que agregar checker par que siempre metan numeros
		List<Saldo> arregloSaldo = this.user.getBilletera().getArregloSaldo();
		//rotura de encapsulamiento
		if(arregloSaldo == null)
		{
			System.err.println("Arreglo saldo vacio");
			return;
		}
		if(opciones.getSelectedItem().toString().equals("Todo"))
		{		
			//solo agrega a monedas pre-existentes en la billetera
			for(Saldo mySaldo: arregloSaldo)
			{
				mySaldo.setCantMonedas(mySaldo.getCantMonedas() + saldoNuevo);				
			}
			JOptionPane.showMessageDialog(null, "Se cargo "+valor.getText()+" a todas sus monedas.", "Carga Exitosa", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			boolean encontro = false;
			for(Saldo mySaldo: arregloSaldo)
			{
				if(mySaldo.getSigla().equals(opciones.getSelectedItem().toString()))
				{
					mySaldo.setCantMonedas(mySaldo.getCantMonedas() + saldoNuevo);
					encontro = true;
				}				
			}
			if(!encontro)
			{
				CoinDAO nombres = new CoinDAO();
				TipoMoneda myTipo = null;
				for(Coin moneda: nombres.devolverTabla())
				{
					if(moneda.getSigla().equals(opciones.getSelectedItem().toString()))
						myTipo = moneda.getTipo();
				}
				Saldo nuevoSaldo = new Saldo(user.getDNI(),myTipo,opciones.getSelectedItem().toString()
						,saldoNuevo);
				arregloSaldo.add(nuevoSaldo);
			}
			JOptionPane.showMessageDialog(null, "Se cargo "+valor.getText()+" de "+opciones.getSelectedItem().toString(), "Carga Exitosa", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}	

}