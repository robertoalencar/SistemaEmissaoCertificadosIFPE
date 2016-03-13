package br.com.ifpe.certificados.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpe.certificados.util.ConnectionFactory;

/**
 * @author Roberto Alencar
 */
public class EventoDao {

    private Connection connection;

    public EventoDao() {

	try {
	    this.connection = new ConnectionFactory().getConnection();
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public void salvar(Evento evento) {

	try {

	    String sql = "INSERT INTO evento (ano, descricao) VALUES (?,?)";
	    PreparedStatement stmt = connection.prepareStatement(sql);
	    stmt.setString(1, evento.getAno());
	    stmt.setString(2, evento.getDescricao().trim());
	    stmt.execute();
	    stmt.close();
	    connection.close();

	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public List<Evento> listar() {

	try {
	    List<Evento> listaEvento = new ArrayList<Evento>();
	    PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM evento ORDER BY ano, descricao");

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
		listaEvento.add(montarObjeto(rs));
	    }

	    rs.close();
	    stmt.close();
	    connection.close();

	    return listaEvento;

	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public List<Evento> pesquisar(String descricao, String ano) {

	try {
	    List<Evento> listaEvento = new ArrayList<Evento>();

	    PreparedStatement stmt = null;

	    if (!descricao.equals("") && ano.equals("")) {

		stmt = this.connection.prepareStatement("SELECT * FROM evento WHERE descricao LIKE ? ORDER BY ano, descricao");
		stmt.setString(1, "%" + descricao + "%");

	    } else if (descricao.equals("") && !ano.equals("")) {

		stmt = this.connection.prepareStatement("SELECT * FROM evento WHERE ano like ? ORDER BY ano, descricao");
		stmt.setString(1, ano);

	    } else if (!descricao.equals("") && !ano.equals("")) {

		stmt = this.connection.prepareStatement("SELECT * FROM evento WHERE descricao LIKE ? AND ano = ? ORDER BY ano, descricao");
		stmt.setString(1, "%" + descricao + "%");
		stmt.setString(2, ano);

	    } else {

		stmt = this.connection.prepareStatement("SELECT * FROM evento ORDER BY ano, descricao");
	    }

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
		listaEvento.add(montarObjeto(rs));
	    }

	    rs.close();
	    stmt.close();
	    connection.close();

	    return listaEvento;

	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public List<Evento> carregarEventos(String ano) {

	try {
	    List<Evento> listaEvento = new ArrayList<Evento>();

	    PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM evento WHERE ano like ? ORDER BY descricao");
	    stmt.setString(1, ano);

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
		listaEvento.add(montarObjeto(rs));
	    }

	    rs.close();
	    stmt.close();
	    connection.close();

	    return listaEvento;

	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public void remover(Evento evento) {

	try {
	    PreparedStatement stmt = connection.prepareStatement("DELETE FROM evento WHERE id = ?");
	    stmt.setLong(1, evento.getId());
	    stmt.execute();
	    stmt.close();
	    connection.close();
	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public Evento buscarPorId(int id) {

	try {
	    PreparedStatement stmt = connection.prepareStatement("SELECT * FROM evento WHERE id = ?");
	    stmt.setInt(1, id);
	    ResultSet rs = stmt.executeQuery();

	    Evento evento = null;
	    if (rs.next()) {
		evento = montarObjeto(rs);
	    }

	    rs.close();
	    stmt.close();
	    connection.close();
	    return evento;

	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    public void alterar(Evento evento) {

	String sql = "UPDATE evento SET ano = ? , descricao = ? WHERE id = ?";

	try {

	    PreparedStatement stmt = connection.prepareStatement(sql);
	    stmt.setString(1, evento.getAno());
	    stmt.setString(2, evento.getDescricao().trim());
	    stmt.setInt(3, evento.getId());
	    stmt.execute();
	    stmt.close();
	    connection.close();

	} catch (SQLException e) {
	    throw new RuntimeException(e);
	}
    }

    private Evento montarObjeto(ResultSet rs) throws SQLException {

	Evento evento = new Evento();
	evento.setId(rs.getInt("id"));
	evento.setAno(rs.getString("ano"));
	evento.setDescricao(rs.getString("descricao"));

	return evento;
    }
}
