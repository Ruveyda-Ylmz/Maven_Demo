package com.bilgeadam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExample {
    public static void main(String[] args) throws SQLException {
        String jdbcURL = "jdbc:postgresql://localhost:5432/Veritabani_adi";
        String kullanici_adi = "postgres";  //postgresql kullanıcı adi
        String sifre = "root"; //postgresql şifresi
        try{
            Connection connection = DriverManager.getConnection(jdbcURL,kullanici_adi,sifre);

            //UPDATE İŞLEMİ (soy isimi uyuşan kişinin adını değiştir)
            String updateSQL  = "UPDATE tablo_adi SET name=? WHERE surname = ?";
            PreparedStatement updateStatment = connection.prepareStatement(updateSQL);
            updateStatment.setString(1,"hakyer");
            updateStatment.setString(2,"hakan");
            int afectedRows = updateStatment.executeUpdate();
            System.out.println("UPDATE işlem sonucunda etrkilenen satır sayısı : " + afectedRows);
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
