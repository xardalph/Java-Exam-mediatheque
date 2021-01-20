package com.formation.mediatheque;

import com.formation.mediatheque.Exceptions.ParameterException;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello World");

        CommandLineParameters Parameters = new CommandLineParameters(args);

        try{
            Parameters.assertParametersAreValid();
        }
        catch (ParameterException e){
            System.out.printf("Incorrect parameters : %s", e);
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
C'est quoi les caract�ritique propre � chaque objets ? ont met ce qu'on veux ?
Ont met ce qu'on  veux
ref et titre commun

Pourquoi 1 et 2  pour l'import export ? ont peux pas mettre des vrai options nomm�e ?
Oui MAIS � mettre dans le mail

Aucun moyen d'int�ragir avec la base de donn�es dans l'application ?
pas d'outils pour emprunter un livre ou le rendre � faire ?
Rien d'autre � faire, il faut qu'on puisse importer plusieurs fois de suite les donn�es (un id auto increment)


Possible d'envoyer un repo github plut�t qu'une archive ?
GitHub possible partager avec acigithub


 */