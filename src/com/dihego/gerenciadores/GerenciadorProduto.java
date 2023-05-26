package com.dihego.gerenciadores;

import java.util.ArrayList;
import java.util.List;

import com.dihego.produto.Produto;

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
}
