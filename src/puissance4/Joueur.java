/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4;

import java.util.ArrayList;

/**
 *
 * @author alexandremarchand
 */
public class Joueur {
    String nom;
    private String couleur;
    private ArrayList <Jeton> reserveJetons = new ArrayList ();
    private int nombreDesintegrateurs;
    
    public Joueur (String j) { // nom du joueur pris en paramètre pour initialisation 
        nom = j ;
        nombreDesintegrateurs = 0 ;
        
    }
    
    public void affecterCouleur(String couleur ) { // on a généré un accesseur 
        this.couleur = couleur;
    }
    
   public String  lireCouleur () {
       return couleur;
   }
   public int lirenombreDesintegrateurs() { // on ajoute une méthode permettant de lire le nombre de desintegrateur
       return nombreDesintegrateurs ;
   }
           
    public int nombreDeJetons() { 
      return reserveJetons.size() ;}
    
      public void ajouterJeton(Jeton j) { // on a généré un accesseur 
       reserveJetons.add(j) ; }
    
    public Jeton jouerJeton() { //permet d'accéder à la reserve pour jouer ses jetons
        Jeton J;
        J=reserveJetons.get(0); // on recupere la reference objet du jeton
        reserveJetons.remove(0); //on supprime je jeton de la case
        return J ; //on retourne le jeton joué
    }
    
    public void obtenirDesintegrateur () { 
        
        nombreDesintegrateurs=nombreDesintegrateurs + 1 ;
        
    }
    
     public void utiliserDesintegrateur () { 
        
        nombreDesintegrateurs=nombreDesintegrateurs - 1 ;
        
    }
    
   
}
