package com.dihego.wb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import com.dihego.Main;
import com.dihego.dao.ClienteDAO;
import com.dihego.gerenciadores.GerenciadorCliente;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegistrarCliente {

	public JFrame frame;
	private JTextField txtPrimeiroNome;
	private JTextField txtUltimoNome;
	private JTextField txtCpf;
	private JTextField txtCelular;
	private JTextField txtEmail;
	private JTextField txtRg;
	private JDateChooser dataNascimento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarCliente window = new RegistrarCliente();
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
	public RegistrarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 499, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.setBounds(10, 11, 465, 32);
		frame.getContentPane().add(panelTitulo);
		panelTitulo.setBorder(border);
		
		JLabel lblCadastroCliente = new JLabel("CADASTRO DE CLIENTES");
		lblCadastroCliente.setFont(new Font("Arial", Font.BOLD, 16));
		panelTitulo.add(lblCadastroCliente);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtPrimeiroNome.getText().isEmpty() || txtUltimoNome.getText().isEmpty() || txtCpf.getText().isEmpty() || dataNascimento.getDate() == null) { 
					JOptionPane.showMessageDialog(null, "É preciso preencher os campos obrigatórios!");
					return;
				}
				Date date = dataNascimento.getDate();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String formattedDate = formatter.format(date);
				ClienteDAO cliente = new ClienteDAO(txtPrimeiroNome.getText(), txtUltimoNome.getText(), txtCelular.getText(), txtCpf.getText(), txtRg.getText(), txtEmail.getText(), Integer.parseInt(formattedDate.replace("/", "")));
				if(!GerenciadorCliente.exists(cliente)) { 
					cliente.register();
					GerenciadorCliente.addCliente(cliente);
					JOptionPane.showMessageDialog(null, "Cliente registrado com sucesso!");
					frame.dispose();
					Painel painel = new Painel();
					painel.frame.setVisible(true);
				} else { 
					JOptionPane.showMessageDialog(null, "Já existe cadastro para este CPF!");
				}
			}
		});
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 11));
		btnCadastrar.setBounds(386, 150, 89, 23);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 11));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Painel painel = new Painel();
				painel.frame.setVisible(true);
			}
		});
		btnVoltar.setBounds(10, 150, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		JPanel panelCorpo = new JPanel();
		panelCorpo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCorpo.setBounds(10, 54, 465, 90);
		panelCorpo.setBorder(border);
		frame.getContentPane().add(panelCorpo);
		panelCorpo.setLayout(null);
		
		JLabel lblPrimeiroNome = new JLabel("Primeiro nome:*");
		lblPrimeiroNome.setFont(new Font("Arial", Font.BOLD, 11));
		lblPrimeiroNome.setBounds(7, 10, 99, 14);
		panelCorpo.add(lblPrimeiroNome);
		
		txtPrimeiroNome = new JTextField();
		txtPrimeiroNome.setBounds(104, 7, 148, 20);
		panelCorpo.add(txtPrimeiroNome);
		txtPrimeiroNome.setColumns(10);
		txtPrimeiroNome.setBorder(border);
		
		JLabel lblUltimoNome = new JLabel("Último nome:*");
		lblUltimoNome.setFont(new Font("Arial", Font.BOLD, 11));
		lblUltimoNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUltimoNome.setBounds(252, 10, 81, 14);
		panelCorpo.add(lblUltimoNome);
		
		txtUltimoNome = new JTextField();
		txtUltimoNome.setBounds(343, 7, 115, 20);
		panelCorpo.add(txtUltimoNome);
		txtUltimoNome.setColumns(10);
		txtUltimoNome.setBorder(border);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Arial", Font.BOLD, 11));
		lblCelular.setBounds(7, 36, 71, 14);
		panelCorpo.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!Main.hasApagar(e.getKeyCode())) { 
					if(Character.isDigit(e.getKeyChar())) { 
						if(txtCelular.getText().length() == 0) { 
							txtCelular.setText(txtCelular.getText() + "(");
						} else if(txtCelular.getText().length() == 3) { 
							txtCelular.setText(txtCelular.getText() + ") ");
						} else if(txtCelular.getText().length() > 13) { 
							txtCelular.setText(String.valueOf(txtCelular.getText()).substring(0, 13));
						}
					}
				}
			}
		});
		txtCelular.setBounds(52, 33, 99, 20);
		panelCorpo.add(txtCelular);
		txtCelular.setColumns(10);
		txtCelular.setBorder(border);
		
		JLabel lblDataNascimento = new JLabel("Data de Nascimento:*");
		lblDataNascimento.setFont(new Font("Arial", Font.BOLD, 11));
		lblDataNascimento.setBounds(7, 63, 141, 14);
		panelCorpo.add(lblDataNascimento);
		lblDataNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblCpf = new JLabel("CPF:*");
		lblCpf.setFont(new Font("Arial", Font.BOLD, 11));
		lblCpf.setBounds(163, 38, 47, 14);
		panelCorpo.add(lblCpf);
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		
		txtCpf = new JTextField();
		txtCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!Main.hasApagar(e.getKeyCode())) { 
					if(txtCpf.getText().length() == 3 || txtCpf.getText().length() == 7) { 
						txtCpf.setText(txtCpf.getText() + ".");
					} else if(txtCpf.getText().length() == 11) { 
						txtCpf.setText(txtCpf.getText() + "-");
					} else if(txtCpf.getText().length() > 13) { 
						txtCpf.setText(String.valueOf(txtCpf.getText()).substring(0, 13));
					}
				}
			}
		});
		txtCpf.setBounds(196, 33, 109, 20);
		panelCorpo.add(txtCpf);
		txtCpf.setColumns(10);
		txtCpf.setBorder(border);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 11));
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setBounds(226, 63, 47, 14);
		panelCorpo.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(263, 60, 195, 20);
		panelCorpo.add(txtEmail);
		txtEmail.setColumns(10);
		txtEmail.setBorder(border);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("Arial", Font.BOLD, 11));
		lblRg.setBounds(315, 36, 28, 14);
		panelCorpo.add(lblRg);
		
		txtRg = new JTextField();
		txtRg.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(!Main.hasApagar(e.getKeyCode())) { 
					if(txtRg.getText().length() == 8) { 
						txtRg.setText(txtRg.getText() + "-");
					}
					if(txtRg.getText().length() > 9) { 
						txtRg.setText(String.valueOf(txtRg.getText()).substring(0, 9));
					}
				}
			}
		});
		txtRg.setColumns(10);
		txtRg.setBounds(343, 33, 115, 20);
		panelCorpo.add(txtRg);
		txtRg.setBorder(border);
		
		dataNascimento = new JDateChooser();
		dataNascimento.setBounds(127, 60, 88, 20);
		panelCorpo.add(dataNascimento);
		dataNascimento.setDateFormatString("dd/MM/yyyy");
		dataNascimento.setBorder(border);
	}
}
