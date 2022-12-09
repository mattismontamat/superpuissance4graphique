/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4;

/**
 *
 * @author matti
 */
public class PlateauDeJeu {

    CelluledeGrille grille[][] = new CelluledeGrille [6][7] ; // on initialise un tableau de cases vides

    public PlateauDeJeu() { // constructeur qui initialise les cases du tableau

        for (int i = 0; i < 6; i++) { // on parcours le nombre de ligne 
            for (int j = 0; j < 7; j++) { // on parcours le nombre de colonnes
                grille[i][j] = new CelluledeGrille(); // on associe à chaque case du tableau une "CelluledeGrille"
            }

        }
    }

    public boolean ajouterJetonDansColonnes(Joueur joueurCourant, int indice) {
       // int ligne = 0;
       // for (int i = 0; i < 6; i++) {  // boucle "pour" qui traverse toute les lignes
          //  if (grille[5-i][indice].presenceJeton() == false) { //on utilise un attribut de la classe CelluledeGrille afin de savoir s'il est possible de placer un jeton
                //grille[5-i][indice].affecterJeton(jet); // on affecte le jeton à la cellule de grille afin de mettre à jour notre plateau
                //ligne = i; //on associe à ligne la valeur de la ligne correspondante

               // break; // dès qu'un jeton est affecté, on arrete la boucle 

           // }

       // }
        //return ligne;
        if (GrilleRemplie()==true)return false;

        int i=0;
        while (grille[i][indice].Jetoncourant != null){
            i++;
        }
        Jeton un_jeton = joueurCourant.jouerJeton();
        grille[i][indice].Jetoncourant = un_jeton;
        if(grille[i][indice].presenceDesintegrateur()){
            grille[i][indice].placerDesintegrateur(true);
            joueurCourant.obtenirDesintegrateur();
        }
        if(grille[i][indice].presenceTrouNoir()){
            grille[i][indice].activerTrouNoir();
        }
        return true;
        
        }
   

    public boolean GrilleRemplie() {
        for (int i = 0; i < 6; i++) { // on parcours le nombre de ligne 
            for (int j = 0; i < 7; i++) { // on parcours le nombre de colonnes
                if (grille[i][j].presenceJeton() == false) {

                    return false;

                }

            }
        }
        return true;
    }

    public void afficherGrilleSurConsole() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(grille[i][j]+ " ");
            }
            System.out.println(" "+ (i+1));//retour a la ligne
        }
        System.out.println("");
        System.out.println("1 2 3 4 5 6 7");
    }

    public boolean presenceJeton(int x, int y) {
        if (grille[x][y].presenceJeton() == true) {
            return true;
        } else {
            return false;
        }
    }

    public String lireCouleurDuJeton(int x, int y) {
        if (presenceJeton(x, y) == true) {
            return grille[x][y].lirecouleurduJeton();
        }
        else {
            return "vide";
        }

    }
    
    public boolean ligneGagnantePourCouleur(String couleur){
        for (int i=0 ; i<5;i++){ // on parcourt les 5 lignes 
            for (int j=0;j<3;j++){ // on parcourt seulement 3 colonnes
                if (grille[i][j].lirecouleurduJeton().equals(couleur) && grille[i][j+1].lirecouleurduJeton().equals(couleur) && (grille[i][j+2].lirecouleurduJeton().equals(couleur)&& grille[i][j+3].lirecouleurduJeton().equals(couleur))){
                    return true; // on vérifie pour chacune des cases compris dans ce mini tableau si la condition de victoire est rempli
                }
            }
       }
       return false; 
    }
    public boolean coloneGagnantePourCouleur(String couleur){
        for (int i=0 ; i<2;i++){ // on parcourt seulement 2 lignes 
            for (int j=0;j<6;j++){ // on parcourt les 6 colonnes 
                if (grille[i][j].lirecouleurduJeton().equals(couleur) && grille[i+1][j].lirecouleurduJeton().equals(couleur) && (grille[i+2][j].lirecouleurduJeton().equals(couleur)&& grille[i+3][j].lirecouleurduJeton().equals(couleur))){
                    return true; // on vérifie pour chacune des cases compris dans ce mini tableau si la condition de victoire est rempli
                }
            }
        }
       return false; 
    }
    public boolean diagonaleMontanteGagnantePourCouleur(String couleur){
       for (int i=0 ; i<2;i++){
            for (int j=0;j<3;j++){
                if (grille[i][j].lirecouleurduJeton().equals(couleur) && grille[i+1][j+1].lirecouleurduJeton().equals(couleur) && (grille[i+2][j+2].lirecouleurduJeton().equals(couleur)&& grille[i+3][j+3].lirecouleurduJeton().equals(couleur))){
                    return true;  // on vérifie pour chacune des cases compris dans ce mini tableau si la condition de victoire est rempli
                }
            }
        }
       return false;  
    }
    public boolean diagonaleDescendanteligneGagnantePourCouleur(String couleur){
       for (int i=3 ; i<5;i++){
            for (int j=0;j<3;j++){
                if (grille[i][j].lirecouleurduJeton().equals(couleur) && grille[i-1][j+1].lirecouleurduJeton().equals(couleur) && (grille[i-2][j+2].lirecouleurduJeton().equals(couleur)&& grille[i-3][j+3].lirecouleurduJeton().equals(couleur))){
                    return true; // on vérifie pour chacune des cases compris dans ce mini tableau si la condition de victoire est rempli
                }
            }
        }
       return false;  
    }
    
    public boolean etreGagnantePourCouleur(String coul){
        if (ligneGagnantePourCouleur(coul)==true || coloneGagnantePourCouleur(coul) || diagonaleMontanteGagnantePourCouleur(coul) || diagonaleDescendanteligneGagnantePourCouleur(coul)){
           return true;
        }
        return false;
    }
    
    public boolean colonneRemplie(int m){
        if(grille[5][m].presenceJeton()==true){ // on se place sur la 5èeme ligne et la m colonne pour vérifier si il y a un jeton. Si il y en a un, alors la colonne est remplie
            return true;
        }
        return false;
    } 
    public Jeton tasserColonne (int col) {
        for (int i =0; i<6;i++){
            if (grille[i][col].presenceJeton()==false){
            grille[i+1][col]= grille[i][col];
                    }
        }
        return null;
        
        
    }
    public void placerTrouNoir (int l, int c){
       grille[l][c].PlacerTrouNoir();  
    }
    
    public void supprimerTrouNoir (int l, int c){
        grille[l][c].supprimerTrouNoir();
    }
    public boolean presenceTrouNoir (int l, int c ){
      return grille[l][c].presenceTrouNoir()==true;
    }
    
    public void placerDesintegrateur (int l, int c){
        grille[l][c].placerDesintegrateur(true);
    }
    public boolean presenceDesintegrateur (int l, int c ){
      if (grille[l][c].presenceDesintegrateur()==true){
          return true;
      }
      return false;
    }
    public void supprimerDesintegrateur(int l, int c){
       grille[l][c].supprimerDesintegrateur();
    }
    
    public void supprimerJeton (int l, int c){
        grille[l][c].supprimerJeton();
    }
    
    public void recupererJeton (int l, int c){
        grille[l][c].recupererJeton();
    }
    
   
    
    
    
}

