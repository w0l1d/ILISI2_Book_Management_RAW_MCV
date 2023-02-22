/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi2.projects.biblio.controler;

import ma.fstm.ilisi2.projects.biblio.model.bo.Livre;

import javax.swing.table.DefaultTableModel;

import static ma.fstm.ilisi2.projects.biblio.model.service.ServiceLivre.getServiceLivre;

/**
 * @author ilisi
 */
public class Bibliotheque {
    private static final String[] columnNames = {
            "ID", "ISBN", "Titre"
    };

    public static boolean ajouterLivre(String is, String tit) {
        return getServiceLivre().createLivre(new Livre(is, tit));
    }

    public static void afficherLives(DefaultTableModel model) {
        model.setDataVector(Bibliotheque.getLivreDataVector(), columnNames);
    }

    public static boolean supprimerLivre(int id) {
        return getServiceLivre().deleteLivre(id);
    }

    public static Object[][] getLivreDataVector() {
        return getServiceLivre().getAllData();
    }

    public static void updateLivre(int id, String isbn, String titre) {
        getServiceLivre().updateLivre(new Livre(id, isbn, titre));
    }
}
