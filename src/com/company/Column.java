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

    public void addString(String data){
        strings.add(data);
    }

    public void addInteger(int data){
        integers.add(data);
    }

    public void addDouble(double data){
        doubles.add(data);
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
    public void showString(){
        for (String current : strings) {
            System.out.println(current);
        }
    }

    public void showDouble(){
        for (Double current : doubles) {
            System.out.println(current);
        }
    }

    public void showInt(){
            for (Integer current : integers) {
                System.out.println(current);
            }

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
}
