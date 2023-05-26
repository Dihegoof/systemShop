package com.dihego.wb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.dihego.produto.Tipo;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class RegistrarProduto {

	public JFrame frame;
	private JTextField txtMarca;
	private JTextField txtSabor;
	private JTextField txtPreco;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarProduto window = new RegistrarProduto();
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
	public RegistrarProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 363, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panelCorpo = new JPanel();
		panelCorpo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCorpo.setBounds(11, 47, 327, 230);
		panelCorpo.setBorder(border);
		frame.getContentPane().add(panelCorpo);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.BOLD, 11));
		lblNome.setBounds(11, 15, 55, 14);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Arial", Font.BOLD, 11));
		lblMarca.setBounds(11, 40, 55, 14);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(52, 39, 95, 20);
		txtMarca.setColumns(10);
		txtMarca.setBorder(border);
		
		JLabel lblSabor = new JLabel("Sabor:");
		lblSabor.setFont(new Font("Arial", Font.BOLD, 11));
		lblSabor.setBounds(11, 65, 54, 14);
		
		txtSabor = new JTextField();
		txtSabor.setBounds(52, 62, 95, 20);
		txtSabor.setColumns(10);
		txtSabor.setBorder(border);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipo.setFont(new Font("Arial", Font.BOLD, 11));
		lblTipo.setBounds(157, 40, 39, 14);
		
		JComboBox<String> cbTipo = new JComboBox<String>();
		cbTipo.addItem("Nenhum");
		for(Tipo tipos : Tipo.values()) { 
			cbTipo.addItem(tipos.toString().toLowerCase().substring(0, 1).toUpperCase() + tipos.toString().toLowerCase().substring(1, tipos.toString().length()));
		}
		cbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tipo tipo = Tipo.valueOf(cbTipo.getSelectedItem().toString().toUpperCase());
				txtSabor.setEditable(!tipo.equals(Tipo.ESSENCIA) ? false : true);
				if(!txtSabor.getText().isEmpty()) { 
					txtSabor.setText("");
				}
			}
		});
		cbTipo.setBackground(Color.white);
		cbTipo.setBounds(202, 36, 110, 22);
		
		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Arial", Font.BOLD, 11));
		lblPreco.setBounds(157, 65, 42, 14);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(202, 62, 110, 20);
		txtPreco.setColumns(10);
		txtPreco.setBorder(border);
		
		JLabel lblDescricao = new JLabel("Descrição:");
		lblDescricao.setFont(new Font("Arial", Font.BOLD, 11));
		lblDescricao.setBounds(11, 88, 58, 14);
		panelCorpo.setLayout(null);
		
		JEditorPane epDesc = new JEditorPane();
		epDesc.setBounds(11, 105, 301, 80);
		epDesc.setBorder(border);
		
		panelCorpo.add(epDesc);
		panelCorpo.add(lblNome);
		panelCorpo.add(lblMarca);
		panelCorpo.add(cbTipo);
		panelCorpo.add(txtMarca);
		panelCorpo.add(lblSabor);
		panelCorpo.add(txtSabor);
		panelCorpo.add(lblPreco);
		panelCorpo.add(txtPreco);
		panelCorpo.add(lblDescricao);
		panelCorpo.add(lblTipo);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(52, 11, 260, 20);
		txtNome.setBorder(border);
		panelCorpo.add(txtNome);
		
		JButton btcVoltar = new JButton("Voltar");
		btcVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Painel painel = new Painel();
				painel.frame.setVisible(true);
			}
		});
		btcVoltar.setFont(new Font("Arial", Font.BOLD, 11));
		btcVoltar.setBounds(10, 196, 89, 23);
		panelCorpo.add(btcVoltar);
		
		JButton btcConfirmar = new JButton("Confirmar");
		btcConfirmar.setFont(new Font("Arial", Font.BOLD, 11));
		btcConfirmar.setBounds(223, 196, 89, 23);
		panelCorpo.add(btcConfirmar);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.setBounds(10, 11, 328, 32);
		panelTitulo.setBorder(border);
		frame.getContentPane().add(panelTitulo);
		
		JLabel lblCadastroProduto = new JLabel("CADASTRO DE PRODUTOS");
		lblCadastroProduto.setFont(new Font("Arial", Font.BOLD, 16));
		panelTitulo.add(lblCadastroProduto);
	}
}
