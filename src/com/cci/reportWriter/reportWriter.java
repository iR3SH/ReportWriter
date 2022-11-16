package com.cci.reportWriter;

import com.cci.logger.Logger;
import com.cci.reportWriter.classes.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class reportWriter {

    private static Logger _logger;
    public final static String SautLigne = "\r\n";
    /*
        Méthode Main avec choix du type de rapport
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        _logger = new Logger();

        System.out.println("Bienvenue dans ReportWriter !" + SautLigne
                + "Quel mode souhaitez-vous utiliser ?" + SautLigne + SautLigne
                + "1- Exercice 1 à 3"+ SautLigne
                + "2- Exercice 1 à 3 avec intégration console"+ SautLigne
                + "3- Rapport d'objets personnalisé" + SautLigne
        );

        boolean finish = false;
        int choice = 0;

        while(!finish)
        {
            try {
                choice = scanner.nextInt();
                finish = true;
            }
            catch (NumberFormatException ex)
            {
                _logger.Log(ex);
            }
        }

        switch (choice)
        {
            case 1 -> initTest();
            case 2 -> initConsole();
            case 3 -> initTestPerso();
        }
    }

    /*
        Ajout de la possibilité de générer un rapport selon un objet personnalisé
     */
    public static void initTestPerso()
    {
        try {
            ArrayList<AnonymObject> allObjects = new ArrayList<>();
            boolean allFinished = false;
            Scanner scanner = new Scanner(System.in);

            // Phase 1 création d'un objet personnalisé
            while (!allFinished) {

                ArrayList<ArrayList<String>> donnes = new ArrayList<>();
                boolean finished = false;
                String titleObject;

                System.out.println("Quel est le titre de l'objet que vous voulez créer ?" + SautLigne);

                titleObject = scanner.next();

                // Phase 2 création des champs pour l'objet personnalisé
                while (!finished) {

                    ArrayList<String> stringDonnees = new ArrayList<>();

                    // Stade 1 définir le nom du champ
                    System.out.println("Quel est le nom du champ que vous voulez saisir ?" + SautLigne);
                    stringDonnees.add(scanner.next());

                    // Stade 2 définir le type
                    System.out.println("Quel est le type du champ que vous voulez saisir ?" + SautLigne
                            + "1- Salaire Mensuel" + SautLigne
                            + "2- Salaire Journalier" + SautLigne
                            + "3- Prix" + SautLigne
                            + "4- Texte" + SautLigne
                            + "5- Nombre" + SautLigne
                    );

                    boolean correct = false;
                    int choice = 0;

                    while (!correct) {
                        try {
                            choice = scanner.nextInt();
                            correct = true;
                        } catch (NumberFormatException ex) {
                            System.out.println("Vous n'avez pas saisi un chiffre valide.");
                        }
                    }

                    switch (choice) {
                        case 1 -> stringDonnees.add("1");
                        case 2 -> stringDonnees.add("2");
                        case 3 -> stringDonnees.add("3");
                        case 4 -> stringDonnees.add("4");
                        case 5 -> stringDonnees.add("5");
                    }

                    // Stade 3 ajouter la valeur du champ
                    System.out.println("Entrez la valeur de ce champ :" + SautLigne);

                    stringDonnees.add(scanner.next());

                    System.out.println("Voulez-vous ajoutez un autre champ ?" + SautLigne
                            + "1- Oui" + SautLigne
                            + "2- Non" + SautLigne
                    );

                    correct = false;

                    while (!correct) {
                        try {
                            choice = scanner.nextInt();
                            correct = true;
                        } catch (NumberFormatException ex) {
                            System.out.println("Vous n'avez pas entré un nombre valide" + SautLigne);
                        }
                    }

                    donnes.add(stringDonnees);

                    if (choice == 2) {
                        allObjects.add(new AnonymObject(titleObject, donnes));
                        finished = true;
                    }
                }
                int choice = 0;

                System.out.println("Voulez-vous ajoutez un autre Objet ?" + SautLigne
                        + "1- Oui" + SautLigne
                        + "2- Non" + SautLigne
                );

                boolean correct = false;

                while (!correct) {
                    try {
                        choice = scanner.nextInt();
                        correct = true;
                    } catch (NumberFormatException ex) {
                        System.out.println("Vous n'avez pas entré un nombre valide" + SautLigne);
                    }
                }

                if (choice == 2) {
                    reportPerso(allObjects);
                    allFinished = true;
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(SautLigne + "Une exception a été généré" + SautLigne);
            _logger.Log(ex);
        }
    }

    /*
        Initialisation des testes d'impression
     */
    public static void initTest()
    {
        Employe employe1 = new Employe("John", "Lenon", 30, 20);
        Employe employe2 = new Employe("Richard", "Lelon", 20, 15);

        Student student1 = new Student("Manson", "Bridge", "Suzuhan HighSchool");
        Student student2 = new Student("Testo", "Pesto", "Suzuhan HighSchool");

        SubContractor subContractor1 = new SubContractor("Samuel", "Jackson", 20);
        SubContractor subContractor2 = new SubContractor("Liam", "Folie", 50);

        ArrayList<Worker> workers = new ArrayList<>();

        // Ajout des workers
        workers.add(employe1);
        workers.add(employe2);
        workers.add(student1);
        workers.add(student2);
        workers.add(subContractor1);
        workers.add(subContractor2);

        // Test d'impression des données
        reportPart1(workers);
        reportPartWeb(workers);
    }
    /*
        Usage console de l'application pour ajouter des données selon l'envie
     */
    public static void initConsole()
    {
        try {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Worker> workers = new ArrayList<>();
            boolean addedFinished = false;

            while (!addedFinished) {
                System.out.println("""
                        Quel type de Worker voulez-vous ajouter ?\r
                        1- Employe\r
                        2- subContractor\r
                        3- Student\r
                        4- Glace\r
                        \r
                        \r
                        Entrez le nombre correspondant à votre choix..."""
                );
                boolean reroll = false;
                while(!reroll) {
                    try {
                        int choice = Integer.parseInt(scanner.next());

                        switch (choice) {
                            case 1 -> {
                                System.out.println("Prénom ?");
                                String prenom = scanner.next();

                                System.out.println("Nom ?");
                                String nom = scanner.next();

                                System.out.println("Salaire Mensuel ?");
                                int salaire = scanner.nextInt();

                                System.out.println("Nombre de jours de congés restant ?");
                                int nbConges = scanner.nextInt();

                                workers.add(new Employe(prenom, nom, salaire, nbConges));

                                System.out.println(prenom + " " + nom + " a bien été ajouté !");
                                reroll = true;
                            }
                            case 2 -> {
                                System.out.println("Prénom ?");
                                String prenom = scanner.next();

                                System.out.println("Nom ?");
                                String nom = scanner.next();

                                System.out.println("Salaire Mensuel ?");
                                int salaire = scanner.nextInt();

                                workers.add(new SubContractor(prenom, nom, salaire));

                                System.out.println(prenom + " " + nom + " a bien été ajouté !");
                                reroll = true;
                            }
                            case 3 -> {
                                System.out.println("Prénom ?");
                                String prenom = scanner.next();

                                System.out.println("Nom ?");
                                String nom = scanner.next();

                                System.out.println("Nom de l'Ecole ?");
                                String ecole = scanner.next();

                                workers.add(new Student(prenom, nom, ecole));

                                System.out.println(prenom + " " + nom + " a bien été ajouté !");
                                reroll = true;
                            }
                            case 4 -> {
                                System.out.println("Parfum ?");
                                String parfum = scanner.next();

                                System.out.println("Prix ?");
                                float prix = scanner.nextFloat();

                                workers.add(new Glaces(parfum, prix));

                                System.out.println("La Glace " + parfum + " a bien été ajouté !");
                                reroll = true;
                            }
                            default -> System.out.println("Vous n'avez pas entré un nombre valide" + SautLigne);
                        }
                    }
                    catch (Exception ex)
                    {
                        System.out.println("Vous n'avez pas entré un nombre valide" + SautLigne);
                    }
                }
                boolean correct = false;
                int choice = 0;
                System.out.println("""
                        Voulez-vous ajouté autre chose ?\r
                        1- Oui\r
                        2- Non\r
                        """);
                while(!correct)
                {
                    try
                    {
                        choice = scanner.nextInt();
                        correct = true;
                    }
                    catch (NumberFormatException ex)
                    {
                        System.out.println("Vous n'avez pas entré un nombre valide" + SautLigne);
                    }
                }
                if (choice == 2) {
                    addedFinished = true;
                }
            }

            System.out.println("""
                    Quel mode de print voulez-vous effectuer ?\r
                    1- Normal\r
                    2- Web\r
                    """);
            int choice = 0;
            boolean correct = false;
            while(!correct) {
                try {
                    choice = scanner.nextInt();
                    correct = true;
                }
                catch (NumberFormatException ex)
                {
                    System.out.println("Vous n'avez pas entré un nombre valide" + SautLigne);
                }
            }

            if (choice == 1) {
                reportPart1(workers);
            } else {
                reportPartWeb(workers);
            }
        }
        catch(Exception ex)
        {
            _logger.Log(ex);
        }
    }
    /*
        Création du Rapport avec Objets Personnalisés
     */
    public static void reportPerso(ArrayList<AnonymObject> anonymObject)
    {
        StringBuilder stringBuilder = new StringBuilder();

        for(AnonymObject object : anonymObject)
        {
            stringBuilder.append(object.toStringBuilder().toString());
        }

        File file = new File("ReportPerso.txt");
        createFileAndWrite(file, stringBuilder);
    }
    /*
        Impression du Rapport de la partie 1
     */
    public static void reportPart1(ArrayList<Worker> workers)
    {
        int pageNumber = 0;
        StringBuilder builder = new StringBuilder();

        builder.append("Great Report").append(SautLigne).append("------------").append(SautLigne);

        for (int i = 0; i < workers.size(); i++)
        {
            if(i % 3 == 0 && i != 0)
            {
                pageNumber++;
                builder.append(SautLigne).append("Page ").append(pageNumber).append(SautLigne).append(SautLigne);
            }
            // Ajout du print du Worker
            builder.append(workers.get(i).toString()).append(SautLigne).append(SautLigne);
        }

        // Incrémentation du numéro de la page
        pageNumber++;

        builder.append(SautLigne).append("Page ").append(pageNumber);

        // Création du nouveau fichier et Impression
        File file = new File("Report.txt");
        createFileAndWrite(file, builder);
    }
    /*
        Impression du Rapport de la partie 2
     */
    public static void reportPartWeb(ArrayList<Worker> workers)
    {
        StringBuilder builder = new StringBuilder();

        builder.append("Great Report").append(SautLigne).append("------------").append(SautLigne);

        for (int i = 0; i < workers.size(); i++) {
            if (i % 2 == 0 && i != 0) {
                builder.append(SautLigne).append("Consume more, and you will so much more happy! ").append(SautLigne).append(SautLigne);
            }
            builder.append(workers.get(i).toString()).append(SautLigne).append(SautLigne);
        }

        builder.append(SautLigne).append("Consume more, and you will so much more happy! ");

        // Création du nouveau fichier et Impression
        File file = new File("ReportWeb.txt");
        createFileAndWrite(file, builder);
    }
    /*
        Création du fichier de Rapport
     */
    public static void createFileAndWrite(File file, StringBuilder builder)
    {
        try
        {
            if(file.createNewFile())
            {
                System.out.println("file created "+file.getCanonicalPath());
            }
            else
            {
                System.out.println("File already exist at location: "+file.getCanonicalPath());
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(builder.toString());
            fileWriter.close();
        }
        catch (IOException ex)
        {
            _logger.Log(ex);
        }
        System.out.println(builder);
    }
}
