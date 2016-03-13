package br.com.ifpe.certificados.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() throws SQLException {

	String nomeBanco = "certificados";
	String usuario = "root";
	String senha = "123456";

	try {
	    Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	    throw new SQLException(e);
	}

	return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + nomeBanco + "?useUnicode=true&characterEncoding=utf-8",
		usuario, senha);
    }

}
