package com.company;


import java.io.*;
import java.util.List;

abstract class Save{

    public static void saveTable(String filename, Table table) throws IOException {
        File file= new File(filename);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if(!file.exists()) file.createNewFile();

        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(table);
        System.out.println("File successfully saved!");
        objectOutputStream.close();
    }
    public static void saveCatalog(Catalog catalog) throws IOException {
        File file= new File("catalog.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if(!file.exists()) file.createNewFile();

        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(catalog);
        System.out.println("File successfully saved!");
        objectOutputStream.close();
    }

}