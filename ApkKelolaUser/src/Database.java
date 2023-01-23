/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Toyib
 */
import java.sql.*;

public class Database {
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/aplikasi_kelola_user";
    private final static String USER = "root";
    private final static String PWD = "";
    
    public static Connection con;
    
    public static  void koneksi(){
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("koneksi sukses");
        } catch (Exception e) {
            System.out.println("Error koneksi" + e.getMessage());
        }
    }
    
     public static ResultSet ambilData(String query){
         ResultSet rs = null;
         try {
             Statement st = con.createStatement();
             rs = st.executeQuery(query);
         } catch (Exception e) {
             System.out.println("Error query: " + e.getMessage());
         }
         return rs;
     }
     
     public static void eksekusi(String sql){
         try {
             Statement st = con.createStatement();
             st.executeUpdate(sql);
         } catch (Exception e) {
             System.out.println("Error sql: "+e);
         }
     }
     
}
