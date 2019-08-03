package Test;


import java.sql.*;

public class MainDB {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void main(String[] args) {
        try {
            connect();

//            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob1', 10);");
//            Savepoint spl = connection.setSavepoint();
//            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob2', 20);");
//            connection.rollback(spl);
//            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 30);");

//            long t = System.currentTimeMillis();
//            connection.setAutoCommit(false);
//            pstmt = connection.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?);");
//            for (int i = 0; i < 1000; i++) {
//                pstmt.setString(1, "Bob" + (i + 1));
//                pstmt.setInt(2, 20 + (i * 10) % 90);
//                pstmt.addBatch();
//            }
//            pstmt.executeBatch();
//            connection.setAutoCommit(true);
//            System.out.println(System.currentTimeMillis() - t);

//            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students (" +
//                    "id INTEGER  PRIMARY KEY AUTOINCREMENT," +
//                    "name TEXT," +
//                    "score INTEGER )");
            //stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob4', 100)");
        //    stmt.executeUpdate("DROP TABLE IF EXISTS students");

           // ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE id > 1");

//            ResultSetMetaData rsmd = rs.getMetaData();
//            for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
//                System.out.println(rsmd.getColumnName(i));
//            }

//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + " " + rs.getString("name"));
//            }
            // методы по работе с БД
   //         stmt.executeUpdate("DELETE FROM students");
//            connection.setAutoCommit(false);
//            long t = System.currentTimeMillis();
//            for (int i = 0; i < 1000; i++) {
//              //  stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('unknow', 100)");
//                stmt.addBatch("INSERT INTO students (name, score) VALUES ('unknow', 100)");
//            }
//            stmt.executeBatch();
//            System.out.println(System.currentTimeMillis() - t);
//            connection.setAutoCommit(true);

        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
          //  disconnect();
        }
    }
//DESKTOP-I18VI7M\SQLEXPRESS
//    connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" +
//            "databaseName=MyDB;integratedSecurity=true;");
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;" +
                "databaseName=MyDB;integratedSecurity=true;");
        stmt = connection.createStatement();
//        Class.forName("org.sqlite.JDBC");
//        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
//        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
