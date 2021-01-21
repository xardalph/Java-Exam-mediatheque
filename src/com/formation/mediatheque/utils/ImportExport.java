package com.formation.mediatheque.utils;

import com.formation.mediatheque.data.*;

import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ImportExport implements Serializable {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String name, reference, genreMusic, label, fileName;
        name = "XEU";
        reference = "123AA123";
        genreMusic = "Rap";
        label = "CapitolRecords";
        fileName = "./test.txt";

        File file = new File(fileName);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        Cd c = new Cd(name, reference, false, genreMusic, label);
        out.writeObject(c);


    }
}
