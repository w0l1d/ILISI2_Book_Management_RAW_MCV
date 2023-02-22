/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi2.projects.biblio.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;

/**
 * @author ilisi
 */
public class Connexion {

   private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
   private static final String DB_URL = "jdbc:mariadb://192.168.100.174/db";

   //  Database credentials
   private static final String USER = "root";
   private static final String PASS = "";
   private static Connection con = null;

   public static Connection getConnection() {

      if (Objects.isNull(con)) {
         try {
            //STEP 2: Register JDBC driver
            Class.forName("org.mariadb.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            con = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/projet-test", USER, PASS);
            System.out.println("Connected database successfully...");
         } catch (Exception e) {
            System.err.println(e);
         }
      }
      return con;
   }
}
