package com.formation.mediatheque;

import com.formation.mediatheque.Exceptions.InvalidConfigurationFileException;
import com.formation.mediatheque.Exceptions.ParameterException;
import com.formation.mediatheque.DBManager.DBManager;
import com.formation.mediatheque.abstraite.commonEntity;
import com.formation.mediatheque.utils.CommandLineParameters;
import com.formation.mediatheque.utils.ImportExport;
import com.formation.mediatheque.utils.LogToFile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
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
                ImportData(Parameters, dbManager);
                logger.Log.info("end of import");
            } else if (Parameters.getParametersMap().containsKey(CommandLineParameters.EXPORT_KEY)) {
                logger.Log.info("start of export");
                ExportData(Parameters, dbManager);
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

    private static void ImportData(CommandLineParameters Parameters,  DBManager dbManager) throws IOException, ClassNotFoundException, InvocationTargetException, SQLException, IllegalAccessException, NoSuchMethodException {
        Vector<commonEntity> importFromFile = ImportExport.importFromFile(Parameters.getImport());

        for (commonEntity object : importFromFile) {
            dbManager.create(object);
        }
    }

    private static void ExportData(CommandLineParameters Parameters, DBManager dbManager) throws SQLException, IOException, ClassNotFoundException {
        Vector<commonEntity> exported = ImportExport.createVector(dbManager);
        ImportExport.exportToFile(Parameters.getExport(), exported);
    }
}