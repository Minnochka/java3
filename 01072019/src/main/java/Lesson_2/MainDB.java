package Lesson_2;

import java.sql.*;

public class MainDB {

    private static Connection conn;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void main(String[] args) throws SQLException {

        try {
            connection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // работа с БД
       // ResultSet rs = stmt.executeQuery("SELECT id, name, score FROM students; DROP TABLE STUDENT");

//        ResultSetMetaData rsmd = rs.getMetaData();
//
//        for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
//            System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnType(i));
//        }



//        while (rs.next()) {
//            System.out.println(rs.getString("id") + " " + rs.getString("name") + " " + rs.getInt(3));
//        }

//        stmt.executeUpdate("CREATE TABLE students (" +
//                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                "name TEXT," +
//                "score TEXT)");


//        long t = System.currentTimeMillis();
//
//        conn.setAutoCommit(false);
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 100; j++) {
//                stmt.addBatch("INSERT INTO students (name, score)\n" +
//                        "VALUES ('unknow', 20)");
//            }
//            stmt.executeBatch();
//            conn.commit();
//            conn.setAutoCommit(false);
//        }

        //conn.setAutoCommit(true);

//        System.out.println(System.currentTimeMillis() - t);


//        pstmt = conn.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?);");
//
//        for (int i = 0; i < 10; i++) {
//            pstmt.setString(1, "Bob" + i);
//            pstmt.setInt(2, i);
//            pstmt.addBatch();
//        }
//
//        pstmt.executeBatch();


        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob1', 10);");
        Savepoint sp = conn.setSavepoint();
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob2', 20);");
        conn.rollback(sp);
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 30);");
        //conn.setAutoCommit(true);
       // disconect();
    }

    public static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
        stmt = conn.createStatement();
    }

    public static void disconect() throws SQLException {
        conn.close();
    }

}
