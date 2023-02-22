/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi2.projects.biblio.model.service;

import ma.fstm.ilisi2.projects.biblio.model.bo.Livre;
import ma.fstm.ilisi2.projects.biblio.model.dao.DAOLivre;

import javax.swing.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

/**
 * @author ilisi
 */
public class ServiceLivre {
   DAOLivre daoLivre;
   private static ServiceLivre instance = null;

   private ServiceLivre() {
      this.daoLivre = new DAOLivre();
   }


   public static ServiceLivre getServiceLivre() {
      if (Objects.isNull(instance))
         instance = new ServiceLivre();
      return instance;
   }

   public boolean validate(Livre L) {
      return L.getIsbn().length() >= 5;
   }


   public boolean createLivre(Livre livre) {
      if (!validate(livre))
         return false;
      return daoLivre.create(livre);
   }

   public Collection<Livre> getAll() {
      return daoLivre.retreive();
   }

   public Object[][] getAllData() {
      Collection<Livre> livres = getAll();
      Object[][] data = new Object[livres.size()][3];
      List<Object[]> objects = livres.stream().map(l -> new Object[]{l.getId(), l.getIsbn(), l.getTitre()}).toList();
      return objects.toArray(data);
   }

   public boolean deleteLivre(int id) {
      return daoLivre.delete(new Livre(id, "", ""));
   }

   public void updateLivre(Livre livre) {
      daoLivre.update(livre);
   }
}
