package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Load {
    public static Table loadTable(String filename) throws IOException,ClassNotFoundException {

        Table table = null;
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Creating new file.");
            file.createNewFile();
        }

        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        table = (Table) objectInputStream.readObject();
        System.out.println("File loaded.");
        objectInputStream.close();
        return table;
    }
    public static Catalog loadCatalog(String filename) throws IOException,ClassNotFoundException {

        Catalog catalog = null;
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Creating new file.");
            file.createNewFile();
        }

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        catalog = (Catalog) ois.readObject();
        System.out.println("File opened.");
        ois.close();
        return catalog;
    }
}
