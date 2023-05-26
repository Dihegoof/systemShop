package com.dihego.dao;

import java.sql.Statement;

import com.dihego.Main;

public class ClienteDAO {
	
	String primeiroNome, ultimoNome, celular, cpf, rg, email;
	int dataNascimento;
	
	public ClienteDAO(String primeiroNome, String ultimoNome, String celular, String cpf, String rg, String email, int dataNascimento) {
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.celular = celular;
		this.cpf = cpf;
		this.rg = rg;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}
	
	public void register() { 
		StringBuilder sb = new StringBuilder();
		try {
			Statement ps = Main.getMySql().getConn().createStatement();
			ps.executeUpdate(sb.append("INSERT INTO `cliente` (`primeironome`, `ultimonome`, `celular`, `cpf`, `rg`, `datanascimento`, `email`) VALUES ('" + getPrimeiroNome() + "', '" + getUltimoNome() + "', '" + getCelular() + "', '" + getCpf() + "', '" + getRg() + "', '" + getDataNascimento() + "', '" + getEmail() + "');").toString());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(int dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
