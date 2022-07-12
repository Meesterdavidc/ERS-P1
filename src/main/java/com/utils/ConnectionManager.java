package com.utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionManager {
    public static ConnectionManager connectionManager;
    public static Connection connection;

    private ConnectionManager() {
    }
    private ConnectionManager getconnectionManager(){
        if (connectionManager== null) {
            connectionManager = new ConnectionManager();
        }
        return connectionManager;

    }
    public static Connection getConnection(){
        if (connection== null){
            connection= connect();

        }
        return connection;
    }
    public static Connection connect() {
        try {
            Properties props = new Properties();
            FileReader filereader = new FileReader("/Users/chaly/Documents/Revature/Electronic_Reimbursment_System" +
                    "/src/main/resources/JDBC.properties");
            props.load(filereader);

            String connectionURL;
            StringBuilder sb= new StringBuilder();
            sb.append("jdbc:postgresql://");
            sb.append(props.get("hostname"));
            sb.append(":");
            sb.append(props.get("port"));
            sb.append("/");
            sb.append(props.get("database"));

            connectionURL=sb.toString();
            String user= String.valueOf(props.getProperty("user"));
            String password= String.valueOf((props.getProperty("password")));
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(connectionURL,user,password);


            System.out.println(connection.getClientInfo().toString()+
                    "This is to confirm the connection was made");
        } catch (Exception e) {
            System.out.println("Error in the Connection"+e.getMessage());
        }
        return connection;
    }
    public static void main(String[]args){
        ConnectionManager.getConnection();
    }
}

