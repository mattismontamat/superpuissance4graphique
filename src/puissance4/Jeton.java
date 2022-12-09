/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4;

/**
 *
 * @author matti
 */
public class Jeton {

    private String couleur;

    public Jeton(String coul) { // constructeur jeton
        couleur = coul;
    }

    public String lireCouleur() {
        return couleur;
    }

 
    @Override
    public String toString() {
        String a;
       
        if (couleur == "rouge") {
            a = "R";
            return a;
        } else {
            a = "J";
            return a;
        }
    }

}
