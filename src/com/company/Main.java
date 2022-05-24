package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String filename =null;
        Scanner console=new Scanner(System.in);
        Catalog catalog = new Catalog();
        catalog.addTable("test");
        Table table1 = catalog.getTable("test");
        table1.addColumn("int","f");
        table1.addCell(1,0);
        table1.addCell(2,0);
        table1.addCell(1,0);
        boolean go= true;
        while (go){
            System.out.print("command :");
            String command = console.nextLine();
            switch (command) {
                case "insert":{
                    System.out.print("Table name :");
                    String tname = console.nextLine();
                    Table table=catalog.getTable(tname);
                    table.insert();
                }
                case "addcolumn":{
                    System.out.print("Table name :");
                    String tname = console.nextLine();
                    System.out.print("Column name :");
                    String cname = console.nextLine();
                    System.out.print("Column type :");
                    String type = console.nextLine();
                    Table table=catalog.getTable(tname);
                    table.addColumn(type,cname);
                    break;
                }
                case "showtables":{
                    if (catalog.getSize()>0){
                    System.out.println(catalog.toString());
                    }
                    else {
                        System.out.println("no tables");
                    }
                    break;
                }
                case "describe":{
                    System.out.print("Table name :");
                    String tname = console.nextLine();
                    Table table=catalog.getTable(tname);
                    System.out.println(table.describe());
                    break;
                }
                case "print":{
                    System.out.print("Table name :");
                    String tname = console.nextLine();
                    Table table=catalog.getTable(tname);
                    table.showTable();
                    break;
                }
                case "save":{
                    if(filename==null) {
                        System.out.println("No file opened!");
                        continue;
                    }
                    else{
                        System.out.print("Table name :");
                        String tname = console.nextLine();
                        Table table = catalog.getTable(tname);
                        try {
                            Save.saveTable(tname + ".txt", table);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
                case "save as":
                case "export": {
                    System.out.print("Table name :");
                    String tname = console.nextLine();
                    System.out.print("File name :");
                    String fname = console.nextLine();
                    Table table=catalog.getTable(tname);
                    try {
                        Save.saveTable(fname,table);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "open":{
                    System.out.println("Enter file location: ");
                    filename = console.nextLine();
                    try {
                        catalog=Load.loadCatalog(filename);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println("File opened.");
                    break;
                }
                case "count":{
                    System.out.print("Table name :");
                    String tname = console.nextLine();
                    System.out.print("Column number :");
                    String cnumber = console.nextLine();
                    System.out.print("Search value :");
                    String value = console.nextLine();
                    Table table =catalog.getTable(tname);
                    System.out.println("Count = " + String.valueOf(table.count(value,Integer.parseInt(cnumber))));
                    break;
                }
                case "close":{
                    try {
                        catalog=Load.loadCatalog(filename);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    filename=null;
                    System.out.println("File closed.");
                    break;
                }
                case "import":{
                    System.out.println("Enter file location: ");
                    String filenametemp = console.nextLine();
                    Table table =null;
                    try {
                        table=Load.loadTable(filenametemp);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    catalog.addTable(table,filenametemp);
                    break;
                }
                case "delete":{
                    System.out.print("Table name :");
                    String tname = console.nextLine();
                    System.out.print("Column number :");
                    String cnum = console.nextLine();
                    System.out.print("Search value :");
                    String value = console.nextLine();
                    Table table=catalog.getTable(tname);
                    table.delete(value,Integer.parseInt(cnum));
                    break;
                }
                case "update":{
                    System.out.print("Table name :");
                    String tname = console.nextLine();
                    System.out.print("Column number :");
                    String cnum = console.nextLine();
                    System.out.print("Search value :");
                    String value = console.nextLine();
                    System.out.print("New value :");
                    String newValue = console.nextLine();
                    Table table=catalog.getTable(tname);
                    break;
                }
                case "select":{
                    System.out.print("Table name :");
                    String tname = console.nextLine();
                    System.out.print("Column number :");
                    String cnum = console.nextLine();
                    System.out.print("Search value :");
                    String value = console.nextLine();
                    Table table=catalog.getTable(tname);
                    break;
                }
                case "help":{
                    System.out.println(
                            "import\n"+"insert\n"+"addcolumn\n"+"count\n"+
                                    "showtables\n"+"describe\n"+"print\n"+
                                    "delete\n"+"update\n"+"select"+
                                    "save\n"+"save as\n"+
                                    "export\n"+"open\n"+"close\n"+"exit\n"
                            );
                    break;
                }
                case "exit":{
                    System.out.println("Exiting...");
                    go = false;
                    break;
                }
            }
        }
        console.close();

    }
}
