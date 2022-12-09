/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4;

/**
 *
 * @author alexandremarchand
 */
public class CelluledeGrille {
    Jeton Jetoncourant ;
    boolean avoirTrouNoir ;
    boolean avoirDesintegrateur;
    
    public CelluledeGrille () {
        Jetoncourant = null ;
        avoirTrouNoir = false ;
        avoirDesintegrateur = false ;
        
    }
    
    public boolean presenceJeton()  { // on crée une méthode qui renseigne la présence du jeton dans la cellule
        if  ( Jetoncourant != null ) {
            return true ; }
           
         else { return false ;}
       
        }

    public void affecterJeton(Jeton Jetoncourant) { // on a généré un accesseur permettant d'ajouter le jeton à l'attribut jeton de la classe CelluleDeGrille
        this.Jetoncourant = Jetoncourant;
    }
           
    public String lirecouleurduJeton() { 
        if  ( presenceJeton () == true )
           {  return Jetoncourant.lireCouleur(); } // retourne la couleur du jeton présent dans la cellule, en appelant un attribut de la classe jeton
        else {return "vide";}                      
   }

    public void PlacerTrouNoir() {
        avoirTrouNoir=true; // on passe la valeur de avoirTrouNoir à true
        this.avoirTrouNoir = avoirTrouNoir;
    }
    
     public void supprimerTrouNoir() {
        avoirTrouNoir=false; // on passe la valeur de avoirTrouNoir à true
        this.avoirTrouNoir = avoirTrouNoir;
    }
   
      public boolean presenceTrouNoir()  { // on crée une méthode qui renseigne la présence du trou noir dans la cellule
        if  ( avoirTrouNoir==true ) { // on vérfie la nprésence du trou noir sur la case
            return true ; }
           
         else { return false ;}
       
        }
      
      public Jeton recupererJeton() { // la valeur retournée est une référence objet Jeton
          Jeton jeton_temp ;
          jeton_temp =  Jetoncourant ; //on crée une variable temporaire permettant de stocker la valeur de jeton courant 
          Jetoncourant=null; // on fixe à null la valeur de jeton courant
          return jeton_temp;
          }
     
     public Jeton supprimerJeton() { 
         Jetoncourant=null; // on supprime le jeton actuellement présent dans la cellule lors de la partie
         return Jetoncourant;
     }
      
     public boolean presenceDesintegrateur () { 
        return avoirDesintegrateur; // on renvoit tout simplement la valeur du booléen avoirdesintegrateur, true or false
           
     }

    public void placerDesintegrateur(boolean avoirDesintegrateur) {
        avoirDesintegrateur = true;
        this.avoirDesintegrateur = avoirDesintegrateur;
    }
      public void supprimerDesintegrateur() {
        avoirDesintegrateur=false; // on passe la valeur de avoirTrouNoir à true
        this.avoirDesintegrateur = avoirDesintegrateur;
        
    }
     public void activerTrouNoir() { // permet de mettre en action le trou noir
         supprimerJeton(); //on enlève le jeton de la cellule
         supprimerTrouNoir(); // on supprime le troue noir
     }
     
    @Override
     public String toString() {
         if (presenceJeton()==true) {
             if (Jetoncourant.lireCouleur()== "rouge") { // on réutilise l'attribut lirecouleur
                 return "R"; }
             else { return "J" ; } }
         if (presenceTrouNoir()==true) {
             return"@" ;}
         if (presenceDesintegrateur()==true) {
             return"D" ;  }
         else {  return "." ; }    
         
     }
     
}
