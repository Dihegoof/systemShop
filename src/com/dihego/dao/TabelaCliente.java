package com.dihego.dao;

import javax.swing.table.AbstractTableModel;

import com.dihego.gerenciadores.GerenciadorCliente;

public class TabelaCliente extends AbstractTableModel {

	public String[] colunas = {"Nome", "Sobrenome", "Celular", "CPF", "RG", "Email", "DataAniversario"};

	@Override
	public int getRowCount() {
		return GerenciadorCliente.getArmazenadorCliente().size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 1:
			return GerenciadorCliente.getArmazenadorCliente().get(rowIndex).getPrimeiroNome();
		case 2:
			return GerenciadorCliente.getArmazenadorCliente().get(rowIndex).getUltimoNome();
		case 3:
			return GerenciadorCliente.getArmazenadorCliente().get(rowIndex).getCelular();
		case 4:
			return GerenciadorCliente.getArmazenadorCliente().get(rowIndex).getCpf();
		case 5:
			return GerenciadorCliente.getArmazenadorCliente().get(rowIndex).getRg();
		case 6:
			return GerenciadorCliente.getArmazenadorCliente().get(rowIndex).getEmail();
		case 7:
			return GerenciadorCliente.getArmazenadorCliente().get(rowIndex).getDataNascimento();
		}
		return null;
	}
}
