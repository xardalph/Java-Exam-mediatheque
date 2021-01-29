package com.formation.mediatheque;

import com.formation.mediatheque.Exceptions.InvalidConfigurationFileException;
import com.formation.mediatheque.Exceptions.ParameterException;
import com.formation.mediatheque.DBManager.DBManager;
import com.formation.mediatheque.abstraite.commonEntity;
import com.formation.mediatheque.data.Cd;
import com.formation.mediatheque.data.Dvd;
import com.formation.mediatheque.utils.CommandLineParameters;
import com.formation.mediatheque.utils.ImportExport;
import com.formation.mediatheque.utils.LogToFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        CommandLineParameters Parameters = new CommandLineParameters(args);

        try {
            Parameters.assertParametersAreValid();
            Parameters.GetConfiguration();
            LogToFile logger = new LogToFile(Parameters.getParameters(CommandLineParameters.LOG_KEY));
            DBManager dbManager = new DBManager(Parameters);

            if (Parameters.getParametersMap().containsKey(CommandLineParameters.IMPORT_KEY)) {
                logger.Log.info("start of import");
                ImportData(Parameters, dbManager, logger);
                logger.Log.info("end of import");
            } else if (Parameters.getParametersMap().containsKey(CommandLineParameters.EXPORT_KEY)) {
                logger.Log.info("start of export");
                ExportData(Parameters, dbManager, logger);
                logger.Log.info("end of export");
            }
            logger.Log.info("end of script");
        } catch (ParameterException e) {
            System.out.printf("Incorrect parameters : %s", e);
            exit(3);
        } catch (IOException e) {
            System.out.printf("can't acces parameter file : %s", e);
            exit(3);
        } catch (InvalidConfigurationFileException e) {
            System.out.printf("Invalid Configuration : %s", e);
            exit(3);
        } catch (Exception e) {
            System.out.printf("UNKNOWN ERROR, please check : %s", e);
            e.printStackTrace();
            exit(3);
        }


    }


    private static void ImportData(CommandLineParameters Parameters,  DBManager dbManager, LogToFile logger) throws IOException, ClassNotFoundException, InvocationTargetException, SQLException, IllegalAccessException, NoSuchMethodException {
        Vector<commonEntity> importFromFile = ImportExport.importFromFile(Parameters.getImport());

        for (commonEntity object : importFromFile) {
            dbManager.create(object);
        }


    }

    private static void ExportData(CommandLineParameters Parameters, DBManager dbManager, LogToFile logger) throws SQLException, IOException, ClassNotFoundException {
        Vector<commonEntity> exported = ImportExport.createVector(dbManager);
        logger.Log.info("number of object to import : " + exported.size());
        ImportExport.exportToFile(Parameters.getExport(), exported);
    }
}


/*
Questions :

C'est quoi les caractéritiques propre à chaque objets ? on met ce qu'on veut ?
On met ce qu'on  veux
ref et titre commun

Pourquoi 1 et 2  pour l'import export ? ont peux pas mettre des vrai options nommée ?
Oui MAIS à mettre dans le mail

Aucun moyen d'intéragir avec la base de données dans l'application ?
pas d'outils pour emprunter un livre ou le rendre à faire ?
Rien d'autre à faire, il faut qu'on puisse importer plusieurs fois de suite les données (un id auto increment)


Possible d'envoyer un repo github plutôt qu'une archive ?
GitHub possible partager avec acigithub

*/
/*

// TODO : A noter dans le mail : ont supporte les espaces dans les noms des fichiers, ca peux être un bon différenciateur si d'autres ne les gères pas correctement. Base de données mariadb et pas oracle ou ms

// TODO : DB manager générique -> DONE pour le create (est-ce que le reste est nécessaire ?)
// TODO : creation base -> Done, le script fonctionne sur un mariadb
// TODO : gitignore dbstring et logs docker-compose
// TODO : Import export en json en parametre une liste d'objet qui hérite de toto, et le séréalize en json
// TODO : faire les méthodes toString pour toutes les classes

 */