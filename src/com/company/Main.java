package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String filename_table =null;
        String filename_catalog =null;
        File file = null;
        Scanner console=new Scanner(System.in);
        Catalog catalog = new Catalog();
        Table table1 = new Table("test");
        catalog.addTable(table1,"test.txt");
        table1.addColumn("int","kon");
        table1.addColumn("string","n");
        table1.addColumn("double","f");
        table1.addCell(1,0);
        table1.addCell(2,0);
        table1.addCell("sad",1);
        table1.addCell(null,1);
        table1.addCell(1231.12,2);
        table1.addCell(0.0,2);
        Table table2 = new Table("oop");
        catalog.addTable(table2,"oop.txt");
        table2.addColumn("int","hdc");
        table2.addCell(23,0);
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
                    break;
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
                    if(filename_table==null) {
                        System.out.println("No file opened!");
                        continue;
                    }
                    else{
                        System.out.print("Table name :");
                        String tname = console.nextLine();
                        Table table = catalog.getTable(tname);
                        try {
                            Save.saveTable(file, table);
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
                    filename_table = console.nextLine();
                    file = new File(filename_table);
                    if (!file.exists()) {
                        System.out.println("No file with this path.");
                        filename_table =null;
                    }
                    else System.out.println("File opened.");
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
                    System.out.println("Count = " +table.count(value,Integer.parseInt(cnumber)));
                    break;
                }
                case "close":{
                    filename_table=null;
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
                    System.out.println("deleted");
                    break;
                }
                case "update":{
                    System.out.print("Table name :");
                    String tname = console.nextLine();
                    System.out.print("Column number :");
                    String cnum = console.nextLine();
                    System.out.print("Search value :");
                    String value = console.nextLine();
                    System.out.print("Target number :");
                    String ctargetnum = console.nextLine();
                    System.out.print("New value :");
                    String newValue = console.nextLine();
                    Table table=catalog.getTable(tname);
                    table.update(value,Integer.parseInt(cnum),newValue,Integer.parseInt(ctargetnum));
                    System.out.println("updated");
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
                    table.select(value,Integer.parseInt(cnum));
                    break;
                }
                case "save catalog":
                {
                    System.out.print("File path :");
                    filename_catalog = console.nextLine();
                    File file_catalog=new File(filename_catalog);
                    try {
                        Save.saveCatalog(file_catalog,catalog);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "load catalog":
                {
                    System.out.print("File path :");
                    filename_catalog = console.nextLine();
                    try {
                        catalog=Load.loadCatalog(filename_catalog);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case "rename":
                {
                    System.out.print("Old table name:");
                    String oldTName= console.nextLine();
                    System.out.print("New table name:");
                    String newTName= console.nextLine();
                    catalog.rename(oldTName,newTName);
                    break;
                }
                case "help":{
                    System.out.println(
                            "import - imports a new table in the catalog from a file\n"+
                            "insert - inserts a new row in the corresponding table\n"+
                            "addcolumn - add a new column\n"+
                            "count - finds the number of rows in the table, whose column, contain the given value\n"+
                            "showtables - displays a list of all loaded tables names\n"+
                            "describe - displays information about the column types of given table \n"+
                            "print - displays all rows in a table\n"+
                            "rename - renames a table\n"+
                            "delete - deletes all rows in the table whose column <search column n> contains the value <search column value>\n"+
                            "update - updates the data in a given column \n"+
                            "select - displays all rows with value in the given column\n"+
                            "save - save table to a file given in open\n"+
                            "save as - save table in the given file\n"+
                            "export - export table in the given file\n"+
                            "save catalog - saves catalog to file\n"+
                            "load catalog - loads catalog form a file onto the existing catalog\n"+
                            "open - opens file for table\n"+
                            "close - closes the files \n"+
                            "exit\n"
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
