package com.dihego.wb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarCliente {

	public JFrame frame;
	private JTextField txtCpf;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarCliente window = new BuscarCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuscarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Arial", Font.BOLD, 11));
		frame.setBounds(100, 100, 450, 302);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.setBounds(10, 11, 414, 32);
		panelTitulo.setBorder(border);
		frame.getContentPane().add(panelTitulo);
		
		JLabel lblBuscarCliente = new JLabel("BUSCAR CLIENTE");
		lblBuscarCliente.setFont(new Font("Arial", Font.BOLD, 16));
		panelTitulo.add(lblBuscarCliente);
		
		JPanel panelTitulo_1 = new JPanel();
		panelTitulo_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo_1.setBounds(10, 54, 414, 172);
		panelTitulo_1.setBorder(border);
		frame.getContentPane().add(panelTitulo_1);
		panelTitulo_1.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 11));
		lblCpf.setBounds(10, 11, 46, 14);
		panelTitulo_1.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(47, 8, 159, 20);
		panelTitulo_1.add(txtCpf);
		txtCpf.setColumns(10);
		txtCpf.setBorder(border);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 11));
		btnBuscar.setBounds(216, 7, 89, 23);
		panelTitulo_1.add(btnBuscar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEditar.setBounds(315, 7, 89, 23);
		panelTitulo_1.add(btnEditar);
		
		table = new JTable();
		table.setBounds(10, 39, 394, 122);
		panelTitulo_1.add(table);
		table.setBorder(border);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Painel painel = new Painel();
				painel.frame.setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 233, 89, 23);
		frame.getContentPane().add(btnVoltar);
	}
}
