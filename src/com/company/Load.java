package com.company;

import java.io.*;

public class Load {
    public static Table loadTable(String filename) throws IOException,ClassNotFoundException {
        Table table = null;
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
            Save.saveTable(file,table);
            System.out.println("Noting to read");
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
            System.out.println("No file");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        catalog = (Catalog) objectInputStream.readObject();
        System.out.println("File loaded.");
        objectInputStream.close();
        return catalog;
    }
}
