package com.bilgeadam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteExample {
    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/Veritabani_adi";
        String kullanici_adi = "postgres";  //postgresql kullanıcı adi
        String sifre = "root"; //postgresql şifresi

        try{
            Connection connection = DriverManager.getConnection(jdbcURL,kullanici_adi,sifre);
            String deleteSQL = "DELETE FROM  tablo_adi WHERE name = ?";
            PreparedStatement deleteStatment = connection.prepareStatement(deleteSQL);
            deleteStatment.setString(1,"abuzer");
            int affenctedRows = deleteStatment.executeUpdate();
            System.out.println("DELETE işlemi sonucunda etkilenen satır sayısı : " + affenctedRows);
        }catch (SQLException e){
            e.printStackTrace();

        }
    }
}
