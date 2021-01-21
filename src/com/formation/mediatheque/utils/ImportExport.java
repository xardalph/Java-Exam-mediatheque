package com.formation.mediatheque.utils;

import com.formation.mediatheque.data.*;

import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;



public class ImportExport {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String name, reference, genreMusic, label, fileName;
        name = "XEU";
        reference = "123AA123";
        genreMusic = "Rap";
        label = "CapitolRecords";
        fileName = "./test.txt";

        //Serialization
        File file = new File(fileName);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        Cd c = new Cd(name, reference, false, genreMusic, label);
        out.writeObject(c);
        out.close();

        //Deserialization
        File file2 =  new File(fileName);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        Object o = in.readObject();
        Cd c2 = null;
        if (o instanceof Cd) {
            c2 = (Cd) o;
            System.out.println(c2);
        }
        in.close();

        
    }
}
