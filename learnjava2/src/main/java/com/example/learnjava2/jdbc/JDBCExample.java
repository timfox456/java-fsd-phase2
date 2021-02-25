package com.example.learnjava2.jdbc;

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
}
