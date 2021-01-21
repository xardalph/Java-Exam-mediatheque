package com.formation.mediatheque;

import com.formation.mediatheque.Exceptions.InvalidConfigurationFileException;
import com.formation.mediatheque.Exceptions.ParameterException;
import com.formation.mediatheque.DBManager.DBManager;
import com.formation.mediatheque.data.Cd;
import com.formation.mediatheque.data.Dvd;
import com.formation.mediatheque.utils.CommandLineParameters;
import com.formation.mediatheque.utils.LogToFile;

import java.io.IOException;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("hello World");

        CommandLineParameters Parameters = new CommandLineParameters(args);

        try {
            Parameters.assertParametersAreValid();
            Parameters.GetConfiguration();
        } catch (ParameterException e) {
            System.out.printf("Incorrect parameters : %s", e);
            exit(3);
        } catch (IOException e){
            System.out.printf("can't acces parameter file : %s", e);
            exit(3);
        } catch (InvalidConfigurationFileException e) {
            System.out.printf("Invalid Configuration : %s", e);
            exit(3);
        }
        Dvd dvd = new Dvd("heise","heibfue",false,"gneigfberubfeu","gneigqsqaaaaaaaaaafeu");
        System.out.println(dvd.getReference());

        try {
            LogToFile logger = new LogToFile(Parameters.getParameters(CommandLineParameters.LOG_KEY));
            DBManager dbManager = new DBManager(Parameters);
            dbManager.create(dvd);
        }
        catch(IOException e){
            System.out.printf("Error openning file : %s", e);
            exit(3);
        }
        catch(Exception e){
            System.out.printf("UNKNOWN ERROR, please check : %s", e);
            e.printStackTrace();
            exit(3);
        }



        //DBManager dbManager = new DBManager(Parameters.getDbString());


/*
        if (Parameters.getParameters().containsKey(CommandLineParameters.IMPORT_KEY) ) {

            ImportData(Parameters);
        }
        else if (Parameters.getParameters().containsKey(CommandLineParameters.EXPORT_KEY)){

            ExportData(Parameters);
        }

 */

    }


    private static void ImportData(CommandLineParameters Parameters) {

    }

    private static void ExportData(CommandLineParameters Parameters) {

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
// TODO : A noter dans le mail : ont supporte les espaces dans les noms des fichiers, ca peux �tre un bon diff�renciateur si d'autres ne les g�res pas correctement

// TODO : DB manager g�n�rique
// TODO : creation base
// TODO : gitignore dbstring et logs docker-compose
// TODO : Import export en json en parametre une liste d'objet qui h�rite de toto, et le s�r�alize en json


 */