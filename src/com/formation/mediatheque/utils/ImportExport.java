package com.formation.mediatheque.utils;

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
import java.util.Vector;


public class ImportExport {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String name, reference, genreMusic, label, fileName;
        name = "XEU";
        reference = "123AA123";
        genreMusic = "Rap";
        label = "CapitolRecords";
        fileName = "./test";

        /*
        //Serialization
        File file = new File(fileName);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        Cd c = new Cd(name, reference, false, genreMusic, label);
        out.writeObject(c);
        out.close();

        //Deserialization
        File file2 =  new File(fileName);
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
        Object o =  in.readObject();

        Cd c2 = null;
        if (o instanceof Cd) {
            c2 = (Cd) o;
            System.out.println(c2.toString());
        }
        in.close();

        //Cd c2 = (Cd)in.readObject() ;
        //System.out.println(c2) ;
        */

        Cd c = new Cd(name, reference, false, genreMusic, label);
        Cd c1 = new Cd(reference+"1", name+"1", false, genreMusic+"1", label+"1");
        Cd c2 = new Cd(reference+"2", name+"2", false, genreMusic+"2", label+"2");
        Dvd dvd = new Dvd(name, reference, false, genreMusic, label);
        Dvd dvd1 = new Dvd(reference+"1", name+"1", false, genreMusic+"1", label+"1");
        Dvd dvd2 = new Dvd(reference+"2", name+"2", false, genreMusic+"2", label+"2");
        Livre l = new Livre(name, reference, false, genreMusic, label);
        Livre l1 = new Livre(reference+"1", name+"1", false, genreMusic+"1", label+"1");
        Livre l2 = new Livre(reference+"2", name+"2", false, genreMusic+"2", label+"2");
        Magazine m = new Magazine(name, reference, genreMusic, label);
        Magazine m1 = new Magazine(reference+"1", name+"1",genreMusic+"1", label+"1");
        Magazine m2 = new Magazine(reference+"2", name+"2", genreMusic+"2", label+"2");



        ObjectOutputStream out2 = new ObjectOutputStream(
                Files.newOutputStream(Paths.get(fileName+"2.txt"), StandardOpenOption.CREATE));

        Vector<commonEntity> v = new Vector<commonEntity>();
        /*
        foreach Cd in
        foreach Dvd in
        foreach Magazine in
        foreach Livre in
        */

        v.add(c);
        v.add(c1);
        v.add(c2);
        v.add(dvd);
        v.add(dvd1);
        v.add(dvd2);
        v.add(l);
        v.add(l1);
        v.add(l2);
        v.add(m);
        v.add(m1);
        v.add(m2);
        out2.writeObject(v);
        out2.close();

        ObjectInputStream in2 = new ObjectInputStream(
                Files.newInputStream(Paths.get(fileName+"2.txt"), StandardOpenOption.READ));

        v = (Vector<commonEntity>)in2.readObject();
        System.out.println(v);
        in2.close();

    }
}
