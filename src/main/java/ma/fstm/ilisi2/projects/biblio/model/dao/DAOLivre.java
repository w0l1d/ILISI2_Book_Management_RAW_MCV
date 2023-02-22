/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi2.projects.biblio.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

import ma.fstm.ilisi2.projects.biblio.model.bo.Livre;

import static ma.fstm.ilisi2.projects.biblio.model.dao.Connexion.getConnection;

/**
 * @author ilisi
 */
public class DAOLivre implements IDAOLivre {

   @Override
   public boolean create(Livre L) {
      String sql = " insert into livres values (null, ?, ?)";
      PreparedStatement preparedStmt = null;
      try {
         preparedStmt = getConnection().prepareStatement(sql);
         preparedStmt.setString(1, L.getIsbn());
         preparedStmt.setString(2, L.getTitre());
         preparedStmt.executeUpdate();
         return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return false;
   }

   @Override
   public Collection<Livre> retreive() {
      Vector<Livre> livres = new Vector<>();
      try {
         ResultSet rst = getConnection().createStatement().executeQuery("select * from livres");
         while (rst.next()) {
            livres.add(new Livre(rst.getInt(1), rst.getString(2), rst.getString(3)));
         }
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
      return livres;
   }

   @Override
   public boolean update(Livre L) {
      String sql = " update livres set isbn = ?, titre = ? where id = ? ";
      PreparedStatement preparedStmt;
      try {
         preparedStmt = getConnection().prepareStatement(sql);
         preparedStmt.setString(1, L.getIsbn());
         preparedStmt.setString(2, L.getTitre());
         preparedStmt.setInt(3, L.getId());
         preparedStmt.executeUpdate();
         return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return false;
   }

   @Override
   public boolean delete(Livre L) {
      String sql = " delete from livres where id = ? ";
      PreparedStatement preparedStmt;
      try {
         preparedStmt = getConnection().prepareStatement(sql);
         preparedStmt.setInt(1, L.getId());
         preparedStmt.executeUpdate();
         return true;
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return false;
   }

}
