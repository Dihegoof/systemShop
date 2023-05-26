package com.dihego.wb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login {

	public JFrame frame;
	private JTextField txtCpf;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 214, 209);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panelCorpo = new JPanel();
		panelCorpo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelCorpo.setBounds(10, 54, 176, 82);
		panelCorpo.setBorder(border);
		frame.getContentPane().add(panelCorpo);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf.setFont(new Font("Arial", Font.BOLD, 11));
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBorder(border);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("Arial", Font.BOLD, 11));
		
		txtSenha = new JPasswordField();
		GroupLayout gl_panelCorpo = new GroupLayout(panelCorpo);
		gl_panelCorpo.setHorizontalGroup(
			gl_panelCorpo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCorpo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelCorpo.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCpf)
						.addComponent(lblSenha))
					.addGap(18)
					.addGroup(gl_panelCorpo.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCpf, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
						.addComponent(txtSenha))
					.addContainerGap())
		);
		gl_panelCorpo.setVerticalGroup(
			gl_panelCorpo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCorpo.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panelCorpo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCpf)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panelCorpo.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		txtSenha.setBorder(border);
		panelCorpo.setLayout(gl_panelCorpo);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.setFont(new Font("Arial", Font.BOLD, 11));
		btnLogar.setBounds(107, 140, 79, 23);
		frame.getContentPane().add(btnLogar);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelTitulo.setBounds(10, 11, 176, 32);
		panelTitulo.setBorder(border);
		frame.getContentPane().add(panelTitulo);
		
		JLabel lblIdentificacao = new JLabel("IDENTIFICAÇÃO");
		lblIdentificacao.setFont(new Font("Arial", Font.BOLD, 16));
		panelTitulo.add(lblIdentificacao);
	}
}
