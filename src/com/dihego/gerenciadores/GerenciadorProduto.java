package com.dihego.gerenciadores;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dihego.Main;
import com.dihego.produto.Produto;
import com.dihego.produto.Tipo;

public class GerenciadorProduto {
	
	static List<Produto> armazenadorProduto = new ArrayList<>();
	public static List<Produto> getArmazenadorProduto() { 
		return armazenadorProduto;
	}
	
	public static void addProduto(Produto produto) { 
		if(!armazenadorProduto.contains(produto)) { 
			armazenadorProduto.add(produto);
		}
	}
	
	public static void removeProduto(Produto produto) { 
		if(armazenadorProduto.contains(produto)) { 
			armazenadorProduto.remove(produto);
		}
	}
	
	public static boolean existe(Produto produto) { 
		for(Produto produtos : armazenadorProduto) { 
			return produtos.getNome().equals(produto.getNome()) && produtos.getTipo().equals(produto.getTipo());
		}
		return false;
	}
	
	public static void carregarProdutos() { 
		StringBuilder sb = new StringBuilder();
		try {
			Statement ps = Main.getMySql().getConn().createStatement();
			ResultSet rs = ps.executeQuery(sb.append("SELECT * FROM `produto`").toString());
			while(rs.next()) {
				addProduto(new Produto(rs.getString("nome"), rs.getString("marca"), rs.getString("sabor"), rs.getString("descricao"), Tipo.valueOf(rs.getString("tipo")), rs.getDouble("preco")));
			}
		} catch (Exception e) {
		}
	}
}
