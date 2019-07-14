package lesson2;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SQLData {
    private static Connection conn;
    private static Statement stmt;

    public void connect(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:lesson2DB.db");
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sqlInsert(String name, String surname, String middleName, String birthday, String position){
        int id, position_id;
        if (name.isEmpty() || surname.isEmpty() || position.isEmpty() || birthday.isEmpty()){
            System.out.println("Имя, фамилия, дата рождения и должность не могут быть пустыми.");
        }
        else {
            try {
                Date birthday_d = new SimpleDateFormat("yyyy-mm-dd").parse(birthday);
                    ResultSet rs = stmt.executeQuery("select max(e.id) id from employee e;");
                    if (rs.next()) {
                        id = rs.getInt("id") + 1;
                    } else {
                        id = 1;
                    }
                    rs = stmt.executeQuery("select p.id from position p where p.position_name = '" + position.toLowerCase().trim() + "';");
                    if (rs.next()) {
                        position_id = rs.getInt("id");
                        rs = stmt.executeQuery("select p.id from employee p where p.name = '" + name + "' and p.surname = '" + surname + "' and middle_name = '" + middleName + "' and birthday = date('" + birthday + "');");
                        if(rs.next()){
                            System.out.println("Сотрудник уже существует");
                        }
                        else {
                            stmt.executeUpdate("insert into employee(id, name, surname, middle_name, birthday, position_id) values (" + id + ", '" + name + "', '" + surname + "', '" + middleName + "', date('" + birthday + "'), " + position_id + ");");
                        }
                    } else {
                        System.out.println("Должности не существует. Доступны следующие должности:");
                        rs = stmt.executeQuery("select p.position_name from position p;");
                        while (rs.next()) {
                            System.out.println(rs.getString("position_name"));
                        }
                    }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sqlUpdate(int id, String name, String surname, String middleName, String birthday, String position){
        int position_id;
        try {
            if (name.isEmpty() || surname.isEmpty() || position.isEmpty() || birthday.isEmpty()){
                System.out.println("Имя, фамилия, дата рождения и должность не могут быть пустыми.");
            }
            else {
                Date birthday_d = new SimpleDateFormat("yyyy-mm-dd").parse(birthday);
                ResultSet rs = stmt.executeQuery("select p.id from position p where p.position_name = '" + position.toLowerCase().trim() + "';");
                if(rs.next()){
                    position_id = rs.getInt("id");
                    stmt.executeUpdate("update employee set name = '" + name + "', surname = '" + surname + "', middle_name = '" + middleName + "', birthday = date('" + birthday + "'), position_id = " + position_id + " where id = " + id + ";");
                }
                else{
                    System.out.println("Должности не существует. Доступны следующие должности:");
                    rs = stmt.executeQuery("select p.position_name from position p;");
                    while(rs.next()){
                        System.out.println(rs.getString("position_name"));
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sqlDelete(int id){
        int position_id;
        try {
                stmt.executeUpdate("delete from employee where id = " + id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void sqlSelect(){
        try {
            ResultSet rs = stmt.executeQuery("select e.id, e.name, e.surname, e.middle_name, e.birthday, p.position_name from employee e inner join position p on e.position_id = p.id ;");
            while(rs.next()){
                System.out.println(rs.getInt("id") + ": " + rs.getString("name") + " " + rs.getString("middle_name") + " " + rs.getString("surname") + ", дата рождения - " + rs.getString("birthday") + ", должность - " + rs.getString("position_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
