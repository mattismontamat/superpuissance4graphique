 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author matti
 */
public class Partie {

    private Joueur[] listeJoueur = new Joueur[2];
    private Joueur joueurCourant = listeJoueur[0];
    private PlateauDeJeu plateau = new PlateauDeJeu();

    public Partie(Joueur j1, Joueur j2) {

        listeJoueur[0] = j1;
        listeJoueur[1] = j2;
        this.plateau = new PlateauDeJeu();

    }

    public void attribuerCouleurAuxJoueurs() {
        double a = Math.random();
        if (a > 0.5) {
            listeJoueur[0].affecterCouleur("jaune");
            listeJoueur[1].affecterCouleur("rouge");
        } else {
            listeJoueur[0].affecterCouleur("rouge");
            listeJoueur[1].affecterCouleur("jaune");

        }

    }

    public void creerEtAffecterJeton(Joueur joueur) {
        for (int i = 0; i < 30; i++) {
             joueur.ajouterJeton(new Jeton(joueur.lireCouleur()));
        
        }
    }

    public void placerTrouNoirEtDesintegrateur() {
        for (int i = 0; i < 3; i++) {
            Random r = new Random();
            int a = r.nextInt(6);
            int b = r.nextInt(7);
            if (plateau.presenceTrouNoir(a, b) == false && plateau.presenceDesintegrateur(a, b) == false) {
                plateau.placerDesintegrateur(a, b);
                plateau.placerTrouNoir(a, b);

            }
        }
        for (int j = 0; j < 2; j++) {
            Random r = new Random();
            int c = r.nextInt(6);
            int d = r.nextInt(7);
            if (plateau.presenceTrouNoir(c, d) == false && plateau.presenceDesintegrateur(c, d) == false) {
                plateau.placerTrouNoir(c, d);
            }
        }
        for (int k = 0; k < 2; k++) {
            Random r = new Random();
            int e = r.nextInt(6);
            int f = r.nextInt(7);
            if (plateau.presenceTrouNoir(e, f) == false && plateau.presenceDesintegrateur(e, f) == false) {
                plateau.placerDesintegrateur(e, f);
            }

        }
    }

    public void initialiserPartie() {
        attribuerCouleurAuxJoueurs(); //on donne une couleur au différents joueurs
        creerEtAffecterJeton(listeJoueur[0]); // on donne les jetons au joueur 1 
        creerEtAffecterJeton(listeJoueur[1]); // on donne les jetons au joueur 2
        placerTrouNoirEtDesintegrateur();

    }

    public void lancerPartie() {

        Scanner sc = new Scanner(System.in); //on  crée un scanner permettant de lire et stocker les infos 
        boolean Partieencours = true;
        int colonne;
        int ligne;
        int i= 0;
        Joueur JoueurCourant;
        int p ;
        // on affiche le plateau sur l'interface netbeans
        // while pas de gagnant : vérfication ,necessaire
        while (Partieencours == true) {
            plateau.afficherGrilleSurConsole();
            p= i%2 ; // seulement 2 résultats possibles : 0 ou 1
            JoueurCourant = listeJoueur[p];
            i=i + 1; // on alterne entre le joueur 1 et le joueur 2
          
             
            System.out.println("joueur 1 que souhaitez vous faire ?\n 1) jouer un jeton\\n 2) récupérer un jeton\\n 3) jouer un désintégrateur" );
            int choix = sc.nextInt(); // l'utilisateur saisit ce qu'il veut faire

            while ((choix > 3) || (choix < 0)) { // on redemande à l'utilisateur se saisir son choix 
                System.out.println("veuillez saisir un choix valide");
                choix = sc.nextInt();
            }

            if (choix == 1) {  // le joueur choisit de placer un jeton
                System.out.println("Sur quellle colonne souhaitez vous placer le jeton ?");
                colonne = sc.nextInt()-1; // penser à boulce while si ,mauvaise saisie
                Jeton jet = JoueurCourant.jouerJeton(); 
               // plateau.ajouterJetonDansColonnes(jet, colonne);
            }

            if (choix == 2) { // le joueur choisit de récuperer un jeton
                System.out.println("Sur quellle colonne souhaitez vous récuperer le jeton ?");
                colonne = sc.nextInt()-1;
                System.out.println("Sur quellle ligne souhaitez vous récupérer le jeton ?");
                ligne = sc.nextInt()-1; 
                plateau.recupererJeton(ligne, colonne);}
            
            if (choix == 3 && JoueurCourant.lirenombreDesintegrateurs()>0 ){
                    JoueurCourant.utiliserDesintegrateur();
                }
            
            
            if (plateau.etreGagnantePourCouleur(JoueurCourant.lireCouleur()) == true )  {
                    Joueur LeGagnant =JoueurCourant;
                    break;
                }

            }

        }

    }
 

