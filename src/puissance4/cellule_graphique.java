/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author matti
 */
public class cellule_graphique extends JButton {

    CelluledeGrille celluleAssociée;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_des = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_jetJ = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_jetR = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));

    public cellule_graphique(CelluledeGrille uneCellule) {
        celluleAssociée = uneCellule;
    }

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        if (celluleAssociée.presenceTrouNoir() == true) {
            setIcon(img_trouNoir);
        } else if (celluleAssociée.presenceDesintegrateur() == true) {
            setIcon(img_des);

        } else {
            String couleur_jeton = celluleAssociée.lirecouleurduJeton();
            switch (couleur_jeton) {
                case "R":
                    setIcon(img_jetR);
                    break;
                case "J":
                    setIcon(img_jetJ);
                    break;
                case "vide":
                    setIcon(img_vide);
                    break;

            }
        }
        

    }

}
