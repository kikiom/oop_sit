package com.company;


import java.io.*;


abstract class Save{

    public static void saveTable(String filename, Table table) throws IOException {
        File file= new File(filename);
        if(!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(table);
        System.out.println("File successfully saved!");
        objectOutputStream.close();
    }

    public static void saveTable(File file, Table table) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(table);
        System.out.println("File successfully saved!");
        objectOutputStream.close();
    }

    public static void saveCatalog(File file, Catalog catalog) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(catalog);
        System.out.println("File successfully saved!");
        objectOutputStream.close();
    }
}