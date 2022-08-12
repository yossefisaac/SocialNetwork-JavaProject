package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilBD {
    private static Connection conection;

    public static Connection getConection() {
	try {

	    if (conection == null)
		openConection();

	    if (conection.isClosed())
		openConection();

	} catch (SQLException e) {
		System.out.println("{ ERROR: COULDN'T OPEN DATABASE CONECTION }");
	}

	return conection;
    }

    private static void openConection() {
	try {
	    Class.forName("org.sqlite.JDBC");
	    conection = DriverManager.getConnection("jdbc:sqlite:banco.sqlite");
	} catch (SQLException e) {
		System.out.println("{ ERROR: COULDN'T OPEN DATABASE CONECTION }");
	} catch (ClassNotFoundException e2) {
		System.out.println("{ ERROR: PROBLEM WITH SQL LIB }");
	}
    }

    public static void closeConection() {
	if (conection == null)
	    return;

	try {
	    if (!conection.isClosed())
		conection.close();
	} catch (SQLException e) {
		System.out.println("{ ERROR: COULDN'T CREATE DATABASE CONNECTION }");
	}
    }

    public static void initBD() {
	try {
	    conection = getConection();
	    Statement stm = conection.createStatement();
	    createUser(stm);
	    createEventos(stm);
	    createFollow(stm);
	    createPost(stm);
	    createUserEventos(stm);
	    createUserPost(stm);
	    stm.executeUpdate("PRAGMA foreign_keys=ON");
	    stm.close();
	} catch (SQLException e) {
		System.out.println("{ ERROR: COULDN'T CREATE DATABASE }");
	    System.out.println(e);
	}
    }

    private static void createUser(Statement stm) throws SQLException {
	stm.executeUpdate("DROP TABLE IF EXISTS User");
	stm.executeUpdate("CREATE TABLE User (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
		+ "username VARCHAR(50) NOT NULL, " + " password VARCHAR(50) NOT NULL," + " name VARCHAR(150) NOT NULL,"
		+ " birthdate VARCHAR(10) NOT NULL," + " relationship VARCHAR (50) NOT NULL);");
	stm.executeUpdate("INSERT INTO User (username, password, name, birthdate, relationship) "
		+ "VALUES('@jose','123','José Antonio','17/12/2002','Solteiro')");
	stm.executeUpdate("INSERT INTO User (username, password, name, birthdate, relationship) "
		+ "VALUES('@yossef','987','Yossef Isaac','22/09/2000','Solteiro')");
    }

    private static void createEventos(Statement stm) throws SQLException {
	stm.executeUpdate("DROP TABLE IF EXISTS DevEvents");
	stm.executeUpdate("CREATE TABLE DevEvents (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
		+ "username VARCHAR(50)," + "eventname VARCHAR(50) NOT NULL," + "eventdate VARCHAR(10) NOT NULL,"
		+ "eventlocal VARCHAR(50) NOT NULL," + "eventdescription VARCHAR(300) NOT NULL, "
		+ "CONSTRAINT username FOREIGN KEY (username) REFERENCES User (username) ON UPDATE CASCADE ON DELETE CASCADE);");
	stm.executeUpdate("INSERT INTO DevEvents (username, eventname, eventdate, eventlocal, eventdescription) "
		+ "VALUES('@jose','Projeto do LAB II','22/07/2022','UEPB',"
		+ "'Dia ao qual será destinado para enviarmos a apresentação desse projeto')");
	stm.executeUpdate("INSERT INTO DevEvents (username, eventname, eventdate, eventlocal, eventdescription) "
		+ "VALUES('@yossef','Computação day','22/07/2022','UEPB',"
		+ "'Dia da computação')");
    }

    private static void createFollow(Statement stm) throws SQLException {
	stm.executeUpdate("DROP TABLE IF EXISTS Follow");
	stm.executeUpdate("CREATE TABLE Follow (follower_fk INTEGER NOT NULL," + "followed_fk INTEGER NOT NULL, "
		+ "CONSTRAINT follower_fk FOREIGN KEY (follower_fk) REFERENCES User (id) ON UPDATE CASCADE ON DELETE CASCADE, "
		+ "CONSTRAINT followed_fk FOREIGN KEY (followed_fk) REFERENCES User (id) ON UPDATE CASCADE ON DELETE CASCADE);");
	stm.executeUpdate("INSERT INTO Follow (follower_fk, followed_fk) " + "VALUES(1,2)");
    }

    private static void createPost(Statement stm) throws SQLException {
	stm.executeUpdate("DROP TABLE IF EXISTS Post");
	stm.executeUpdate("CREATE TABLE Post (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," + "username VARCHAR(50),"
		+ "content VARCHAR(300) NOT NULL, "
		+ "CONSTRAINT username_fk FOREIGN KEY (username) REFERENCES User (username) ON UPDATE CASCADE ON DELETE CASCADE);");
	stm.executeUpdate("INSERT INTO Post (username, content) "
		+ "VALUES('@jose','teste 1')");
		stm.executeUpdate("INSERT INTO Post (username, content) "
		+ "VALUES('@yossef','teste 2')");
    }

    private static void createUserEventos(Statement stm) throws SQLException {
	stm.executeUpdate("DROP TABLE IF EXISTS UserDevEvents");
	stm.executeUpdate("CREATE TABLE UserDevEvents (user_fk INTEGER NOT NULL," + "devevents_fk INTEGER NOT NULL, "
		+ "CONSTRAINT user_fk FOREIGN KEY (user_fk) REFERENCES User (id) ON UPDATE CASCADE ON DELETE CASCADE, "
		+ "CONSTRAINT devevents_fk FOREIGN KEY (devevents_fk) REFERENCES DevEvents (id) ON UPDATE CASCADE ON DELETE CASCADE);");
	stm.executeUpdate("INSERT INTO UserDevEvents (user_fk, devevents_fk) VALUES (1,1)");
    }

    private static void createUserPost(Statement stm) throws SQLException {
	stm.executeUpdate("DROP TABLE IF EXISTS UserPost");
	stm.executeUpdate("CREATE TABLE UserPost (user_fk INTEGER NOT NULL, post_fk INTEGER NOT NULL, "
		+ "CONSTRAINT user_fk FOREIGN KEY (user_fk) REFERENCES User (id) ON UPDATE CASCADE ON DELETE CASCADE, "
		+ "CONSTRAINT post_fk FOREIGN KEY (post_fk) REFERENCES Post (id) ON UPDATE CASCADE ON DELETE CASCADE);");
    }

    public static void updateDB(String sql) throws SQLException {
	Connection bd = UtilBD.getConection();
	Statement stm = bd.createStatement();
	stm.executeUpdate(sql);
	stm.close();
    }

    public static ResultSet consultDB(String sql) throws SQLException {
	Connection bd = UtilBD.getConection();
	Statement stm = bd.createStatement();
	ResultSet retorno = stm.executeQuery(sql);
	return retorno;
    }
}