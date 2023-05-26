package com.dihego.gerenciadores;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dihego.Main;
import com.dihego.dao.ClienteDAO;

public class GerenciadorCliente {
	
	static List<ClienteDAO> armazenadorCliente = new ArrayList<>();
	public static List<ClienteDAO> getArmazenadorCliente() { 
		return armazenadorCliente;
	}
	
	public static void addCliente(ClienteDAO cliente) { 
		if(!armazenadorCliente.contains(cliente)) { 
			armazenadorCliente.add(cliente);
		}
	}
	
	public static void removeCliente(ClienteDAO cliente) { 
		if(armazenadorCliente.contains(cliente)) { 
			armazenadorCliente.remove(cliente);
		}
	}
	
	public static boolean exists(ClienteDAO cliente) { 
		for(ClienteDAO clientes : armazenadorCliente) { 
			return clientes.getCpf().equals(cliente.getCpf());
		}
		return false;
	}
	
	public static void carregarClientes() { 
		StringBuilder sb = new StringBuilder();
		try {
			Statement ps = Main.getMySql().getConn().createStatement();
			ResultSet rs = ps.executeQuery(sb.append("SELECT * FROM `cliente`").toString());
			while(rs.next()) {
				addCliente(new ClienteDAO(rs.getString("primeironome"), rs.getString("ultimonome"), rs.getString("celular"), rs.getString("cpf"), rs.getString("rg"), rs.getString("email"), rs.getInt("datanascimento")));
			}
		} catch (Exception e) {
		}
	}
}
