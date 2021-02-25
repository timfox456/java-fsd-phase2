package com.example.learnjava2.jdbc;

import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCExample {

    private String url = "jdbc:mysql://localhost:3306/db_example";
    private String userName = "springuser";
    private String passWord = "ThePassword";


    public void TestConnection() {
        DBConnection conn = null;
        try {
            conn = new DBConnection(url, userName, passWord);
            System.out.println("DB Connection initialized");

            conn.closeConnection();
            System.out.println("DB Connection closed.");
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
        finally {
            if (conn != null) {
                try {

                    conn.closeConnection();
                }
                catch (Exception ex) {
                    System.err.println(ex);
                }
            }
        }
    }

    public void TestSelect()
    {
        DBConnection conn = null;

        try {
            conn = new DBConnection(url, userName, passWord);
            System.out.println("DB Connection initialized");

            Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rst = stmt.executeQuery("select * from user");

            while (rst.next()) {
                System.out.println(rst.getInt("id") + ", " + rst.getString("name"));
            }

            stmt.close();



            conn.closeConnection();
            System.out.println("DB Connection closed.");
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
        finally {
            if (conn != null) {
                try {

                    conn.closeConnection();
                }
                catch (Exception ex) {
                    System.err.println(ex);
                }
            }
        }
    }


    public void TestCreate()
    {
        DBConnection conn = null;

        try {
            conn = new DBConnection(url, userName, passWord);
            System.out.println("DB Connection initialized");

            Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            stmt.executeUpdate("CREATE TABLE user (\n" +
                    "  `id` int NOT NULL,\n" +
                    "  `email` varchar(255) DEFAULT NULL,\n" +
                    "  `name` varchar(255) DEFAULT NULL,\n" +
                    "  `password` varchar(255) DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`id`)\n" +
                    ")");


            stmt.close();



            conn.closeConnection();
            System.out.println("DB Connection closed.");
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
        finally {
            if (conn != null) {
                try {

                    conn.closeConnection();
                }
                catch (Exception ex) {
                    System.err.println(ex);
                }
            }
        }
    }
}
