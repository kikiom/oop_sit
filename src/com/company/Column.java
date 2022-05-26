package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Column implements Serializable {

    private final String type;
    private final String name;
    private List <String> strings;
    private List <Integer> integers;
    private List <Double> doubles;

    public Column(String type, String name, int size) {
        this.type = type;
        this.name = name;
        switch (type) {
            case "string":
                strings = new ArrayList<>();
                for (int i =0;i<size;i++)
                {
                    strings.add(null);
                }
                break;
            case "int":
                integers = new ArrayList<>();
                for (int i =0;i<size;i++)
                {
                    integers.add(null);
                }
                break;
            case "double":
                doubles = new ArrayList<>();
                for (int i =0;i<size;i++)
                {
                    doubles.add(null);
                }
                break;
        }
    }

    public String getType() {
        return type;
    }

    public List<String> getStrings() {
        return strings;
    }

    public List<Integer> getIntegers() {
        return integers;
    }

    public List<Double> getDoubles() {
        return doubles;
    }

    public void addString(String data,int index){
        if (data!=null)strings.set(index,data);
    }

    public void addInteger(int data,int index){
       integers.set(index,data);
    }

    public void addDouble(double data,int index){
       doubles.set(index,data);
    }

    public void addString(String data){
        if (data != null)strings.add(data);
        else strings.add("NULL");
    }

    public void addInteger(Integer data){
        if (data != null)integers.add(data);
        else integers.add(0);
    }

    public void addDouble(Double data){
        if (data != null)doubles.add(data);
        else doubles.add(0.0);
    }

    public int count(String data){
        int i=0;
        switch (type) {
            case "string":
                for (String current : strings)
                {
                    if (current.equals(data))i++;
                }
                break;
            case "int":
                for (Integer current : integers)
                {
                    if (current.equals(Integer.parseInt(data)))i++;
                }
                break;
            case "double":
                for (Double current : doubles)
                {
                    if (current.equals(Double.parseDouble(data)))i++;
                }
                break;
        }
        return i;
    }

    public List<Integer> search(String data){
        List<Integer> i =new ArrayList<>();
        int index =0;
        switch (type) {
            case "string":
                for (String current : strings)
                {
                    if (current.equals(data)){
                        i.add(index++,strings.indexOf(current));
                    }
                }
                break;
            case "int":
                for (Integer current : integers)
                {
                    if (current.equals(Integer.parseInt(data))){
                        i.add(index++,integers.indexOf(current));
                    }
                }
                break;
            case "double":
                for (Double current : doubles)
                {
                    if (current.equals(Double.parseDouble(data))){
                        i.add(index++,doubles.indexOf(current));
                    }
                }
                break;
        }
        return i;
    }

    public void showString(int index){
       String current = strings.get(index);
            if(current!=null)
                System.out.print(current);
            else
                System.out.print("NULL");
    }

    public void showDouble(int index){
        Double current = doubles.get(index);
        if(current!=0.0)
                System.out.print(current);
            else
                System.out.print("NULL");
    }

    public void showInt(int index){
            Integer current = integers.get(index);
                if(current!=0)
                    System.out.print(current);
                else
                    System.out.print("NULL");
    }

    public void showStringCell(int index){
            if(strings.get(index)!=null)
                System.out.print(strings.get(index));
            else
                System.out.print("NULL");
    }

    public void showDoubleCell(int index){
            if(doubles.get(index)!=null)
                System.out.print(doubles.get(index));
            else
                System.out.print("NULL");

    }

    public void showIntCell(int index){
            if(integers.get(index)!=null)
                System.out.print(integers.get(index));
            else
                System.out.print("NULL");

    }

    public int getSize(){
        int size = 0;
        switch (type) {
            case "string":
                size= strings.size();
                break;
            case "int":
                size=integers.size();
                break;
            case "double":
                size=doubles.size();
                break;
        }
        return size;
    }

    public void delete(List<Integer> indexes){
        switch (type) {
            case "string":
                for (int index:indexes) {
                    strings.remove(index);
                }
                break;
            case "int":
                for (int index:indexes) {
                    integers.remove(index);
                }
                break;
            case "double":
                for (int index:indexes) {
                    doubles.remove(index);
                }
                break;
        }
    }

    @Override
    public String toString() {
        return "Column{" +
                "type='" + type + '\'' +
                ", name='" + name +
                '}';
    }

    public void changeCellValue(int index, String data){
        switch (type){
            case "string":{
                strings.set(index,data);
                break;
            }
            case "int":{
                integers.set(index,Integer.parseInt(data));
                break;
            }
            case "double":{
                doubles.set(index,Double.parseDouble(data));
                break;
            }
        }
    }
}
