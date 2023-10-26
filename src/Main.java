import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menuGame();
    }

    private static void menuGame() {
        Scanner scan = new Scanner(System.in);
        String choixUtilisateur;
        int choixNumerique = 0, compteurJeux = 0;

        do {

            System.out.println("""
                **** Menu ****
                1)  Jouer
                2)  Explication du jeu
                3)  Voir le nombre de fois jouer
                4)  Arrêter le jeu"""
            );

            System.out.println("\n Veuillez selectionner le numéro de votre menu?");
            choixUtilisateur = scan.nextLine();

            try {
                choixNumerique = Integer.parseInt(choixUtilisateur);
            } catch (Exception e) {
                System.out.println("Veuillez entre le NOMBRE ENTIER entre 1 et 5 !");
                menuGame();
            }

            switch (choixNumerique) {
                case 1 :
                    lancerJeu();
                    compteurJeux++;
                    break;
                case 2 :
                    explicationJeu();
                    break;
                case 3 :
                    nombreFoisJoueur(compteurJeux);
                    break;
                case 4 :
                    messageFinMenu();
                    break;
                default:
                    System.out.println("Veuillez entrer le numéro qui se trouve entre 1 et 5 !");
            }

        }while(choixNumerique != 4);
    }

    private static void lancerJeu(){
        Scanner scan = new Scanner(System.in);
        char[] motDuPendu;
        char lettreUtilisateur;
        int compteur = 0, indiceLettre = 0;

        System.out.println("Entrez le mot pour que votre adversaire puisse le trouver");
        motDuPendu = scan.nextLine().toCharArray();

        int longeurMotDuPendu = motDuPendu.length;
        char[] motDuPendUtilisateur = new char [longeurMotDuPendu];

        do {
            System.out.println("\n Veuillez entrez une lettre");
            lettreUtilisateur = scan.nextLine().charAt(0);

            for (char c : motDuPendu) {
                if (lettreUtilisateur == c) {
                    motDuPendUtilisateur[indiceLettre] = c;
                }
                indiceLettre++;
            }

            afficheLeMot(motDuPendUtilisateur);

            compteur++;
            indiceLettre=0;

            String motDuPendString = String.valueOf(motDuPendu);
            String motDuPendUtilisateurString = String.valueOf(motDuPendUtilisateur);

            if(Objects.equals(motDuPendString, motDuPendUtilisateurString)){
                break;
            }

        }while(compteur < (motDuPendu.length+6));

        messageFinJeu(compteur, motDuPendu);
    }


    private static void explicationJeu(){
        System.out.println("""
            ********** MODE D´EMPLOIE **********
            Le premier joueur doit entrez un mot à l'abris du regard de son adversaire
            Ensuite, le deuxième joueur doit essayer de trouver le mot que l'adversaire à mis
            Le deuxième joueur doit écrire qu'une seule lettre  à la fois jusqu'a obtenir\s
            la bonne réponse que l'adversaire à mis

            Bon amusement !\
        """);
    }

    private static void nombreFoisJoueur(int compteurJeux){
        System.out.println("Vous avez joueur "+compteurJeux+" fois");
    }

    private static void messageFinJeu(int compteur, char[] motDuPendu) {
        if(compteur <(motDuPendu.length+5)){
            System.out.println("\n Bravo, vous avez trouvé le mot: ");
            for(char mot: motDuPendu){
                System.out.print(mot);
            }
            System.out.println("\n");
        }else{
            System.out.println("\n Malheureusement, vous n'avez pas trouvé ce mot:");
            for(char mot: motDuPendu){
                System.out.print(mot);
            }
            System.out.println("\n");
        }
    }

    private static void messageFinMenu() {
        System.out.println("\n Merci d'avoir jouer à notre du mot pendu");
    }

    private static void afficheLeMot(char[] motDuPendUtilisateur){
        for(char motUilisateur : motDuPendUtilisateur){
            System.out.print(motUilisateur);
        }
    }

}