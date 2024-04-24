package com.bilgeadam;

import java.sql.*;

public class InsertAndSelect {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://localhost:5432/Veritabani_adi";
        String  kullanici_adi = "postgres";  //postgresql kullanıcı adi
        String sifre = "root"; //postgresql şifresi

        try{
            Connection connection = DriverManager.getConnection(jdbcURL,kullanici_adi,sifre);

            //TABLO OLUŞTURMA
//            String createSQL = "CREATE TABLE public.tablo_adi (name character varying(255),surname character varying(255))";
//            PreparedStatement createStatment = connection.prepareStatement(createSQL);
//            createStatment.executeQuery();

            //(INSERT İŞLEMİ) TABLO İÇİ DEĞER ATAMA
            String insertSQL = "INSERT INTO public.tablo_adi(\n" +
                    "\tname, surname)\n" +
                    "\tVALUES (?, ?);";

            //insertSQL değişkeninin bir sql kodu olduğunu tnımladığımız yer
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL);

//            insertStatement.setString(1,"hakyemez");
//            insertStatement.setString(2,"hakan");
//            int affectedRows = insertStatement.executeUpdate();
//            System.out.println("INSERT işlemi  sonucunda etkilenen satir sayisi : " + affectedRows);


            //SELECT ISLEMI
            String selecSQL = "SELECT * FROM tablo_adi";
            PreparedStatement selectStatement = connection.prepareStatement(selecSQL);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()){
                String sutun1Degeri = resultSet.getString("name");
                String sutun2Degeri = resultSet.getString("surname");
                System.out.println("Name : " +sutun1Degeri + "\n" + "Surname : " + sutun2Degeri + "\n");
            }

            connection.close();

        }catch(SQLException e){
            e.printStackTrace();
        }


        



    }
}