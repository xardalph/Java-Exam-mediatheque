package com.formation.mediatheque;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello World");
        CommandLineParameters Parameters = new CommandLineParameters(args);
        System.out.println(Parameters.getParameters().get(CommandLineParameters.IMPORT_KEY) );

        if (Parameters.getParameters().get(CommandLineParameters.IMPORT_KEY) ) {

            ImportData(Parameters);
        }
        else if (Parameters.getParameters().get(CommandLineParameters.EXPORT_KEY)){

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


Pourquoi 1 et 2 ? ont peux pas mettre des vrai options nommée ?


Aucun moyen d'intéragir avec la base de données dans l'application ?
pas d'outils pour emprunter un livre ou le rendre à faire ?

Possible d'envoyer un repo github plutôt qu'une archive ?

 */