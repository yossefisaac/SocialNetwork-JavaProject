package bancoDeDados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Eventos;

public class EventosDAO implements InterfaceDAO<Eventos> {

    @Override
    public void add(Eventos devEvents) {
	try {
	    String sql = "INSERT INTO DevEvents (username, eventName, eventDate, eventLocal, eventDescription) VALUES ('"
		    + devEvents.getUsuario().getNomeUsuario() + "', '" + devEvents.getEventoNome() + "', '"
		    + devEvents.getEventoData() + "', '" + devEvents.getEventoLocal() + "', '"
		    + devEvents.getEventoDescricao() + "')";
	    UtilBD.updateDB(sql);

	    sql = "INSERT INTO UserDevEvents (user_fk, devevents_fk) VALUES (" + devEvents.getUsuario().getId() + ","
		    + getLastId() + ");";
	    UtilBD.updateDB(sql);

	} catch (SQLException e) {
		System.out.println("{ COULDN'T ADD THIS DEV EVENT }");
	}
    }

    @Override
    public void update(Eventos devEvents) {
	try {
	    String sql = "UPDATE DevEvents SET eventName = '" + devEvents.getEventoNome() + "', " + "eventDate = '"
		    + devEvents.getEventoData() + "', " + "eventLocal = '" + devEvents.getEventoLocal() + "', "
		    + "eventDescription = '" + devEvents.getEventoDescricao() + "' " + "WHERE id = "
		    + devEvents.getEventoId() + ";";
	    UtilBD.updateDB(sql);
	} catch (SQLException e) {
		System.out.println("{ COULDN'T SET THIS DEV EVENT }");
	}
    }

    @Override
    public void remove(Eventos devEvents) {
	try {
	    String sql = "DELETE FROM DevEvents WHERE id = '" + devEvents.getEventoId() + "'";
	    UtilBD.updateDB(sql);

	    sql = "DELETE FROM UserDevEvents WHERE devevents_fk = '" + devEvents.getEventoId() + "'";
	    UtilBD.updateDB(sql);
	} catch (SQLException e) {
		System.out.println("{ COULDN'T REMOVE THIS DEV EVENT }");
	}
    }

    @Override
    public List<Eventos> all() {
	List<Eventos> retrn = new ArrayList<Eventos>();
	try {
	    String sql = "SELECT id, username, eventName, eventDate, eventLocal, eventDescription FROM DevEvents";
	    ResultSet resultSet = UtilBD.consultDB(sql);
	    while (resultSet.next()) {
		Integer id = resultSet.getInt("id");
		String username = resultSet.getString("username");
		String eventName = resultSet.getString("eventName");
		String eventDate = resultSet.getString("eventDate");
		String eventLocal = resultSet.getString("eventLocal");
		String eventDescription = resultSet.getString("eventDescription");
		retrn.add(new Eventos( new UserDAO().getByName(username), id, eventName, eventDate, eventLocal,
			eventDescription));
	    }
	    resultSet.getStatement().close();
	} catch (SQLException e) {
		System.out.println("{ COULDN'T LIST GAME EVENTS }");
	}
	return retrn;
    }

    public Eventos get(Integer id) {
	Eventos retrn = null;
	try {
	    String sql = "SELECT id, username, eventName, eventDate, eventLocal, eventDescription FROM DevEvents WHERE id = '"
		    + id + "'";
	    ResultSet resultSet = UtilBD.consultDB(sql);
	    while (resultSet.next()) {
		Integer idDe = resultSet.getInt("id");
		String username = resultSet.getString("username");
		String eventName = resultSet.getString("eventName");
		String eventDate = resultSet.getString("eventDate");
		String eventLocal = resultSet.getString("eventLocal");
		String eventDescription = resultSet.getString("eventDescription");
		retrn = new Eventos(new UserDAO().getByName(username), idDe, eventName, eventDate, eventLocal,
			eventDescription);
	    }
	    resultSet.getStatement().close();
	} catch (SQLException e) {
		System.out.println("{ IMPOSSIBLE TO VIEW A DEV EVENT }");
	}
	return retrn;
    }

    public int getLastId() {
	int id = 0;
	try {
	    String sql = "SELECT MAX(id) as id FROM DevEvents;";
	    ResultSet resultSet = UtilBD.consultDB(sql);
	    while (resultSet.next()) {
		id = resultSet.getInt("id");
	    }

	    resultSet.getStatement().close();
	} catch (SQLException e) {
		System.out.println("{ UNABLE TO DO TI }");
	}

	return id;
    }
}