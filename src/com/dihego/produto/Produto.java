package com.dihego.produto;

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
