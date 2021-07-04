package model.persist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//baixem el connector de MYSQl amb JDBC de la web https://dev.mysql.com/downloads/connector/j/ en l' opció: PLATFORM INDEPENDENT
//AFEGIM EL .JAR QUE HI HA DINS a la categoria de Libraries
//també afegirem per més endavant les llibreries internes que té NetBeans de jstl
public final class DBConnect {

    // attributes
    
    // PROVEN
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";//driver library
    private static final String BD_URL = "jdbc:mysql://localhost/friendship?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";//connection string
    private static final String USUARI = "root";
    private static final String PASSWORD = "rootroot";
    
    // HOME
//    private static final String DRIVER = "com.mysql.jdbc.Driver";//driver library
    // És una configuracio necessaria per a que funcioni en totes les BBDD.
//    private static final String CONFIG ="?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
//    private static final String BD_URL = "jdbc:mysql://localhost/friendship";//connection string
//    private static final String USUARI = "m7";
//    private static final String PASSWORD = "m7";

    private static DBConnect instance = null;
    
    private DBConnect() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * <strong>getInstance()</strong>
     * gets an unique instance of DBConnect.
     *
     * @return an instance of DBConnect.
     */
    public static DBConnect getInstance() {
        if (instance == null) {
            instance = new DBConnect();
        }
        return instance;
    }

    /**
     * <strong>getConnection()</strong>
     * establishes a connection to the database.
     *
     * @return Connection to database.
     * @throws SQLException if connection error occurs.
     */
    public Connection getConnection() throws SQLException {
        Connection c = DriverManager.getConnection(BD_URL, USUARI, PASSWORD);
        return c;
    }

}
