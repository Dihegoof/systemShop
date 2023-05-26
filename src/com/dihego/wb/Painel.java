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
import javax.swing.JButton;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Painel {

	public JFrame frame;
	private JTextField txtComanda;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Painel window = new Painel();
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
	public Painel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 567, 292);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.setBounds(10, 11, 531, 32);
		panelTitulo.setBorder(border);
		frame.getContentPane().add(panelTitulo);
		
		JLabel lblPainel = new JLabel("PAINEL");
		lblPainel.setFont(new Font("Arial", Font.BOLD, 16));
		panelTitulo.add(lblPainel);
		
		JPanel panelCorpo = new JPanel();
		panelCorpo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCorpo.setBounds(10, 51, 531, 165);
		panelCorpo.setBorder(border);
		frame.getContentPane().add(panelCorpo);
		panelCorpo.setLayout(null);
		
		JLabel lblComanda = new JLabel("Comanda:");
		lblComanda.setFont(new Font("Arial", Font.BOLD, 11));
		lblComanda.setBounds(10, 10, 65, 14);
		panelCorpo.add(lblComanda);
		
		txtComanda = new JTextField();
		txtComanda.setBounds(72, 6, 56, 20);
		panelCorpo.add(txtComanda);
		txtComanda.setColumns(10);
		txtComanda.setBorder(border);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setFont(new Font("Arial", Font.BOLD, 11));
		lblProduto.setBounds(141, 10, 56, 14);
		panelCorpo.add(lblProduto);
		
		JComboBox<String> cbProduto = new JComboBox<String>();
		cbProduto.setBackground(Color.white);
		cbProduto.setBounds(195, 6, 139, 22);
		panelCorpo.add(cbProduto);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 11));
		btnRegistrar.setBounds(344, 6, 90, 23);
		panelCorpo.add(btnRegistrar);
		
		table = new JTable();
		table.setBounds(10, 36, 511, 122);
		panelCorpo.add(table);
		table.setBorder(border);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setFont(new Font("Arial", Font.BOLD, 11));
		btnFinalizar.setBounds(437, 6, 84, 23);
		panelCorpo.add(btnFinalizar);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar cliente");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RegistrarCliente registrarCliente = new RegistrarCliente();
				registrarCliente.frame.setVisible(true);
			}
		});
		btnCadastrarCliente.setFont(new Font("Arial", Font.BOLD, 11));
		btnCadastrarCliente.setBounds(127, 222, 127, 23);
		frame.getContentPane().add(btnCadastrarCliente);
		
		JButton btnDescartarProduto = new JButton("Descartar produto");
		btnDescartarProduto.setFont(new Font("Arial", Font.BOLD, 11));
		btnDescartarProduto.setBounds(265, 222, 133, 23);
		frame.getContentPane().add(btnDescartarProduto);
		
		JButton btnCadastrarProduto_1 = new JButton("Cadastrar produto");
		btnCadastrarProduto_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				RegistrarProduto registrarProduto = new RegistrarProduto();
				registrarProduto.frame.setVisible(true);
			}
		});
		btnCadastrarProduto_1.setFont(new Font("Arial", Font.BOLD, 11));
		btnCadastrarProduto_1.setBounds(408, 222, 133, 23);
		frame.getContentPane().add(btnCadastrarProduto_1);
		
		JButton btnBuscarCliente = new JButton("Buscar cliente");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				BuscarCliente buscarCliente = new BuscarCliente();
				buscarCliente.frame.setVisible(true);
			}
		});
		btnBuscarCliente.setBounds(10, 222, 105, 23);
		frame.getContentPane().add(btnBuscarCliente);
		btnBuscarCliente.setFont(new Font("Arial", Font.BOLD, 11));
	}
}
