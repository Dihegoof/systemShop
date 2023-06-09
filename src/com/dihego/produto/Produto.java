package com.dihego.produto;

import java.sql.Statement;

import com.dihego.Main;

public class Produto {
	
	String nome, marca, sabor, descricao;
	Tipo tipo;
	double preco;
	
	public Produto(String nome, String marca, String sabor, String descricao, Tipo tipo, double preco) {
		this.nome = nome;
		this.marca = marca;
		this.sabor = sabor;
		this.descricao = descricao;
		this.tipo = tipo;
		this.preco = preco;
	}
	
	public void registrar() { 
		StringBuilder sb = new StringBuilder();
		try {
			Statement ps = Main.getMySql().getConn().createStatement();
			ps.executeUpdate(sb.append("INSERT INTO `produto` (`nome`, `marca`, `tipo`, `sabor`, `preco`, `descricao`) VALUES ('" + getNome() + "', '" + getMarca() + "', '" + getTipo().toString() + "', '" + getSabor() + "', '" + getPreco() + "', '" + getDescricao() + "');").toString());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
}
