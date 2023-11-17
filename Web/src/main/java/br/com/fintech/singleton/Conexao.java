package br.com.fintech.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
	private final String user = "rm550758";
	private final String pass = "290604";
	private static Conexao conexao;
	
	private Conexao() {
		
	}
	
	public static Conexao getInstance() {
		if (conexao == null) {
			conexao = new Conexao();
		}
		return conexao;
	}
	
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(URL, user, pass);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
}
