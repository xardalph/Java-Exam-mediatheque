package com.formation.mediatheque.utils;

import com.formation.mediatheque.DBManager.DBManager;
import com.formation.mediatheque.abstraite.commonEntity;
import com.formation.mediatheque.data.*;

import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;
import java.util.Vector;


public class ImportExport {
    /**
     * Permet d'importer depuis un fichier
     * @param fileName
     * @return Vector<commonEntity>
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Vector<commonEntity> importFromFile(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream in2 = new ObjectInputStream(
                Files.newInputStream(Paths.get(fileName), StandardOpenOption.READ));

        Vector<commonEntity> fileContent = (Vector<commonEntity>)in2.readObject();
        return fileContent;
    }

    /**
     * Permet d'exporter depuis un fichier
     * @param fileName
     * @param commonEntityList
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void exportToFile(String fileName, Vector<commonEntity> commonEntityList) throws IOException, ClassNotFoundException {
        ObjectOutputStream out2 = new ObjectOutputStream(
                Files.newOutputStream(Paths.get(fileName), StandardOpenOption.CREATE));

        out2.writeObject(commonEntityList);
        out2.close();

    }

    /**
     * Créer un vecteur et ajoute tout les medias de la base
     * @param dbManager
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Vector<commonEntity> createVector(DBManager dbManager) throws IOException, ClassNotFoundException, SQLException {
        Vector<commonEntity> vector = new Vector<>();
        vector.addAll(dbManager.getAllDvd());
        vector.addAll(dbManager.getAllCd());
        vector.addAll(dbManager.getAllLivre());
        vector.addAll(dbManager.getAllMagazine());

        return vector;
    }
}
