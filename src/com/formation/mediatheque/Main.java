package com.formation.mediatheque;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello World");

        CommandLineParameters Parameters = new CommandLineParameters(args);
        boolean toto = Parameters.assertParametersAreValid();
        if (!Parameters.assertParametersAreValid())
        {
            System.out.println("Log parameter and db parameter are required.");
            exit(3);
        }


        if (Parameters.getParameters().containsKey(CommandLineParameters.IMPORT_KEY) ) {

            ImportData(Parameters);
        }
        else if (Parameters.getParameters().containsKey(CommandLineParameters.EXPORT_KEY)){

            ExportData(Parameters);
        }

    }


    private static void ImportData(CommandLineParameters Parameters){

    }
    private static void ExportData(CommandLineParameters Parameters){

    }
}


/*
Qestions :
C'est quoi les caractéritique propre à chaque objets ? ont met ce qu'on veux ?


Pourquoi 1 et 2  pour l'import export ? ont peux pas mettre des vrai options nommée ?


Aucun moyen d'intéragir avec la base de données dans l'application ?
pas d'outils pour emprunter un livre ou le rendre à faire ?

Possible d'envoyer un repo github plutôt qu'une archive ?

 */