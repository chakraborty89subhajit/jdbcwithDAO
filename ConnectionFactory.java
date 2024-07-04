package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    String driverClassName = "com.mysql.cj.jdbc.Driver";
    String connectionUrl = "jdbc:mysql://localhost:3306/mydb";
    String dbUser = "root";
    String dbPassword = "project";

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
           // con = null;
            con = DriverManager.getConnection(connectionUrl, dbUser, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static ConnectionFactory getInstance(){
        if(connectionFactory==null){
            connectionFactory=new ConnectionFactory();
        }
       return connectionFactory;
    }

}
