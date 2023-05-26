package com.dihego;

import com.dihego.gerenciadores.GerenciadorCliente;
import com.dihego.mysql.MySql;
import com.dihego.wb.Painel;

public class Main {
	
	static MySql mySql;
	public static MySql getMySql() {
		return mySql;
	}
	
	public static void main(String[] args) { 
		mySql = new MySql("localhost", "root", "", "systemshop");
		try {
			GerenciadorCliente.carregarClientes();
			/*
			Login login = new Login();
			login.frame.setVisible(true);
			*/
			Painel painel = new Painel();
			painel.frame.setVisible(true);
		} catch (Exception e) {
		}
	}
	
	public static boolean hasApagar(int code) { 
		return code == 8;
	}
}
