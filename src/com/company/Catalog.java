package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {

    private List<Table> tables=new ArrayList<>();
    private List<String> address = new ArrayList<>();

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public Table  getTable(String name){
        Table table = null;
        for (Table current : tables){
         if (name.equals(current.getName()))
             table = current;
        }
        return table;
    }

    public int getSize(){
        return tables.size();
    }

    public void addTable(String name){
        int i =tables.size();
        tables.add(i,new Table(name));
        address.add(i,(name+".txt"));
    }

    public void addTable(Table table,String name){
        if (!checkUnicq(table.getName())){
            int i =tables.size();
            tables.add(i,table);
            address.add(i,(name));
        }
    }

    public boolean checkUnicq(String name){
        boolean exsits =false;
        for (Table current :tables)
        {
            if (current.getName().equals(name)) {
                exsits = true;
                break;
            }
        }
        return exsits;
    }

    public void rename(String oldName, String newName){
        boolean check=true;
        if (!oldName.equals(newName)){
            for (Table current : tables){
                if (current.getName().equals(newName)) {
                    check = false;
                    break;
                }
            }
            if (check){
                for (Table current : tables){
                    if (current.getName().equals(oldName)){
                        current.setName(newName);
                    }
                }
            }
            else System.out.println("Already exist table with that name");
        }
    }

    @Override
    public String toString() {
        StringBuilder content= new StringBuilder("\ntable= ");
        for (int i=0;i<tables.size();i++){
            content.append(tables.get(i).getName());
            content.append("\taddress= ").append(address.get(i));
        }
        return "Catalog{" + content + '}';
    }
}
