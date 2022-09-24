package lk.ijse.thogakade.main;

import java.sql.*;

public class ThogaKade {

    public static void main(String args[]) {
        String SQL = "Select * From Customer";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ThogaKade", "root", "mysql");
            Statement stm = conn.createStatement();
            ResultSet rst = stm.executeQuery(SQL);
            while (rst.next()) { //move first row
                String id = rst.getString("id");
                String name = rst.getString("name");
                String address = rst.getString("Address");
                double salary = rst.getDouble("salary");
                System.out.println(id + "\t" + name + "\t" + address + "\t" + salary);
            }

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found...");
            System.out.println(ex.getMessage());
            return;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
