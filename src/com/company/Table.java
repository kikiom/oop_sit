package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table implements Serializable {

    private String name;
    private List<Column> columns = new ArrayList<>();

    public Table(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public void addColumn(String type, String name){
        int size = 0;
        if (columns.size()>0){
            size = columns.get(0).getSize();
        }
        columns.add(new Column(type, name, size));
    }

    public void addCell(int data , int num_column){
        Column column = columns.get(num_column);
        column.addInteger(data);
    }

    public void addCell(String data , int num_column){
        Column column = columns.get(num_column);
        column.addString(data);
    }

    public void addCell(double data , int num_column){
        Column column = columns.get(num_column);
        column.addDouble(data);
    }

    public void showTable(){
        boolean go= true;
        boolean last =false;
        Scanner console=new Scanner(System.in);
        int i = 0;
        while (go){
            if(!last){
                for (Column current : columns)
                switch (current.getType()) {
                        case "string":
                            current.showString(i);
                            System.out.print(" | ");
                            break;
                        case "int":
                            current.showInt(i);
                            System.out.print(" | ");
                            break;
                        case "double":
                            current.showDouble(i);
                            System.out.print(" | ");
                            break;
                }
            }
            System.out.print("\nnext | previous | exit\npage command :");
            String command = console.nextLine();
            switch (command) {
                case "next":{
                    Column test = columns.get(0);
                    if(i+1<test.getSize())i++;
                    else {
                        System.out.println("no more pages");
                        last=true;
                    }
                    break;
                }
                case "previous":{
                    if(i-1>0)i--;
                    break;
                }
                case "exit":{
                    go = false;
                    break;
                }
            }
        }
    }

    public String describe(){
        StringBuilder content= new StringBuilder("\n");
        for (Column column : columns) {
            content.append(column.toString());
        }
        return String.valueOf(content);
    }

    public int getSize(){
        return columns.size();
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void insert(){
        Scanner console=new Scanner(System.in);
        for (Column current : columns){
            switch (current.getType()) {
                case "string":
                    System.out.print("string input data :");
                    String datastring = console.nextLine();
                    if (!datastring.equals("null"))
                    {
                        current.addString(datastring);
                    }
                    else current.addString(null);
                    break;
                case "int":
                    System.out.print("integer input data :");
                    String dataint = console.nextLine();
                    if (!dataint.equals("null"))
                    {
                        current.addInteger(Integer.parseInt(dataint));
                    }
                    else current.addInteger(null);
                    break;
                case "double":
                    System.out.print("double input data :");
                    String datadouble = console.nextLine();
                    if (!datadouble.equals("null"))
                    {
                        current.addDouble(Double.parseDouble(datadouble));
                    }
                    else current.addDouble(null);
                    break;
            }
        }
    }

    public int count(String data, int index){
        return columns.get(index).count(data);
    }

    public void delete(String data, int index){
        List<Integer> i =columns.get(index).search(data);
        for (Column current :columns){
            current.delete(i);
        }
    }

    public void update(String data, int index, String newData,int newIndex){
        List<Integer> indexes =columns.get(index).search(data);
        if (indexes.size()!=0){
            for (int i:indexes){
                columns.get(newIndex).changeCellValue(i,newData);
            }
        }

    }

    public void select(String data, int index){
        List<Integer> indexes = columns.get(index).search(data);
        Scanner console = new Scanner(System.in);
        if (indexes.size()!=0) {
            int i = 0;
            boolean go = true;
            boolean last =false;
            while (go) {
                if (!last){
                for (Column current : columns)
                    switch (current.getType()) {
                        case "string":
                            current.showStringCell(indexes.get(i));
                            System.out.print(" | ");
                            break;
                        case "int":
                            current.showIntCell(indexes.get(i));
                            System.out.print(" | ");
                            break;
                        case "double":
                            current.showDoubleCell(indexes.get(i));
                            System.out.print(" | ");
                            break;
                    }
                }
                System.out.print("\nnext | previous | exit\npage command :");
                String command = console.nextLine();
                switch (command) {
                    case "next": {
                        if (i+1 < indexes.size()) i++;
                        else {
                            System.out.println("no more pages");
                            last=true;
                        }
                        break;
                    }
                    case "previous": {
                        if (i-1 > 0) i--;
                        break;
                    }
                    case "exit": {
                        go = false;
                        break;
                    }
                }
            }
        }
    }
}
