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

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        table = (Table) ois.readObject();
        System.out.println("File opened.");
        ois.close();
        System.out.println(table.toString());
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
        System.out.println(catalog.toString());
        return catalog;
    }
}
