package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import entregable1.Usuario;

public class GenActivosControl {
	
	private JButton generar;
	private Usuario user;
	
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
				System.out.println("ola");				
			}
			
		});
	}

}
