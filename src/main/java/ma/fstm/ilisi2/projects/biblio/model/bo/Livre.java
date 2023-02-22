/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi2.projects.biblio.model.bo;

/**
 * @author ilisi
 */
public class Livre {
   private int id;
   private String isbn;
   private String titre;

   public Livre(int id, String isbn, String titre) {
      this.id = id;
      this.isbn = isbn;
      this.titre = titre;
   }

   public Livre(String isbn, String titre) {
      this(0, isbn, titre);
   }


   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getIsbn() {
      return isbn;
   }

   public void setIsbn(String isbn) {
      this.isbn = isbn;
   }

   public String getTitre() {
      return titre;
   }

   public void setTitre(String titre) {
      this.titre = titre;
   }


}
