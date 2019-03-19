package javafx_demo;

import java.sql.*;

public class Connector {
    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final static String JDBC_URL = "jdbc:mysql://localhost:3306/t1806e";
    final static String JDBC_USER = "root";
    final static String JDBC_PASS = "";

    public Connection conn;
    public Statement statement;

    public Connector(){
        try {
            Class.forName(Connector.JDBC_DRIVER);
            Connection connection = DriverManager.getConnection(Connector.JDBC_URL,Connector.JDBC_USER,Connector.JDBC_PASS);


            this.conn =connection;
            Statement stt = conn.createStatement();
            this.statement = stt;
            System.out.println("connecting");

        }catch (ClassNotFoundException e){
            System.out.println("exception 1");
        }
        catch (SQLException e){
            System.out.println("exception 2");
        }
    }

    public ResultSet getQuery(String sql){
        ResultSet rs = null;
        try {
            rs = this.statement.executeQuery(sql);

        }catch (SQLException e){}
        return rs;
    }

    public boolean getUpdate(String sql){
        try {
            this.statement.executeUpdate(sql);
            return true;
        }catch (SQLException e){

        }
        return false;
    }

}
