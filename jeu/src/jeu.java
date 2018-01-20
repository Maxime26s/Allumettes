import java.util.Scanner;

/**
 * Created by SimMa1733207 on 2018-01-15.
 */

public class jeu {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int choixLog[][]=new int[2][50];
        int choixJeu=0;
        int choix=0;
        int nbAll=0;
        int modulo=0;
        String nom[]=new String[2];
        boolean gameOn=false;
        boolean multi=false;
        System.out.println("Bienvenue dans le jeu des allumettes !");
        System.out.println("Quel mode de jeu voulez-vous?");
        System.out.println(" 1- 1 Joueur");
        System.out.println(" 2- 2 Joueurs");
        choix=sc.nextInt();
        System.out.print("Joueur 1, veuillez entrer votre nom : ");
        nom[0]=sc.next();
        if(choix==2) {
            multi=true;
            System.out.print("Joueur 2, veuillez entrer votre nom : ");
            nom[1] = sc.next();
        }
        else{
            nom[1]="AI";
        }
        while(true){
            for(int i=0;i<2;i++) {
                for (int j = 0; j < choixLog[i].length; j++) {
                    choixLog[i][j]=0;
                }
            }
            gameOn=true;
            nbAll = (int) (Math.random() * 80 + 20);
            for(int i=0;gameOn==true;i++) {
                for (int j = 0; j < 2; j++) {
                    choixJeu=0;
                    System.out.println("Il reste " + nbAll + " allumettes.");
                    while(choixJeu<1||choixJeu>3) {
                        System.out.println(nom[j] + ", combien d’allumettes (entre 1 et 3) voulez-vous retirer?");
                        if(multi==true||j==0) {
                            choixJeu = sc.nextInt();
                        }
                        else{
                            modulo=nbAll%4;
                            switch(modulo){
                                case 0:
                                    choixJeu=3;
                                    break;
                                case 1:
                                    choixJeu=1;
                                    break;
                                case 2:
                                    choixJeu=1;
                                    break;
                                case 3:
                                    choixJeu=2;
                                    break;
                            }
                            System.out.println(choixJeu);
                        }
                    }
                    choixLog[j][i]=choixJeu;
                    nbAll-=choixJeu;
                    if (nbAll <= 0) {
                        gameOn = false;
                        System.out.println("Il ne reste plus d'allumettes.");
                        if (j == 0) {
                            System.out.println(nom[1] + " remporte la partie !");
                        } else {
                            System.out.println(nom[0] + " remporte la partie !");
                        }
                        j=2;
                    }
                }
            }
            for(int i=0;i<2;i++) {
                System.out.print("Décisions prises par " + nom[i] + " :");
                for (int j = 0; j < choixLog[i].length; j++) {
                    if(choixLog[i][j]!=0) {
                        System.out.print(choixLog[i][j] + ",");
                    }
                }
                System.out.println();
            }
            choix=0;
            while(choix<1||choix>2) {
                System.out.println("Voulez-vous rejouer?");
                System.out.println(" 1- Oui");
                System.out.println(" 2- Non");
                choix = sc.nextInt();
                if (choix == 2) {
                    System.out.println("Merci d’avoir joué au jeu des allumettes, bonne journée !");
                    System.exit(0);
                }
            }
        }
    }
}
