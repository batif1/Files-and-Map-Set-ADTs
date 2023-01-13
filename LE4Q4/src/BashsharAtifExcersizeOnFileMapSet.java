import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;
public class BashsharAtifExcersizeOnFileMapSet {
    public static void main(String[] args) {
        //C:\SE2205\batif_LabExcercise4\LE4Q4  - Text file path
        MyHeader(4,1);

        File file = new File("C:\\SE2205\\batif_LabExcercise4\\LE4Q4\\SE2205Students.txt");
        try {
            Scanner sc = new Scanner(file);
            TreeMap<String,Integer> lastNameMap = new TreeMap<String,Integer>();
            TreeMap<String,Integer> firstNameMap = new TreeMap<String,Integer>();


            while (sc.hasNextLine()){
                String [] namesInLine = sc.nextLine().split("[ ]");  //We want the first word in the line
                String lastNames = namesInLine[0];
                String firstNames = namesInLine[namesInLine.length-1];
                String key = lastNames;
                String key2 = firstNames;

                    if (lastNameMap.get(key) == null) {
                        lastNameMap.put(key, 1);
                    } else {
                        int count = lastNameMap.get(key).intValue();
                        count++;
                        lastNameMap.put(key, count);
                    }

                    if (firstNameMap.get(key2) == null){
                        firstNameMap.put(key2,1);
                    }else{
                        int count2= firstNameMap.get(key2).intValue();
                        count2++;
                        firstNameMap.put(key2,count2);
                    }
        }
            Set<Map.Entry<String, Integer>> entrySet = lastNameMap.entrySet();
            Map.Entry<String,Integer>[] entryArray = entrySet.toArray(new Map.Entry[entrySet.size()]);
            System.out.println("List of the Number of students with the same Last Names:");
            System.out.println(" Last-name numbers\n" +
                    "----------------------------------------");


            for (int i = 0; i< entryArray.length; i++){
                if(entryArray[i].getValue()>1) {
                    String output = String.format("%12s" + "      " + entryArray[i].getValue() ,entryArray[i].getKey());
                    System.out.println(output);
                }
            }

            Set<Map.Entry<String, Integer>> entrySet2 = firstNameMap.entrySet();
            Map.Entry<String,Integer>[] entryArray2 = entrySet2.toArray(new Map.Entry[entrySet2.size()]);
            System.out.println("List of Number of students with the same First Names:");
            System.out.println(" First-name numbers\n" +
                    "----------------------------------------");


            for (int i = 0; i< entryArray2.length; i++){
                if(entryArray2[i].getValue()>1) {
                    String output = String.format("%12s" + "      " + entryArray2[i].getValue() ,entryArray2[i].getKey());
                    System.out.println(output);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }


        MyFooter(4,1);


    }


        public static void MyFooter(int labE_number, int q_number) {
            System.out.println("_____________________________________________________________________");
            System.out.println("Completion of Assignment " + "Lab Excersize " + labE_number + "Q" + q_number + " is successful!");
            System.out.println("Signing off - Bashshar Atif.");

        }

        public static void MyHeader(int labE_number, int q_number) {
            System.out.println("______________________________________________________________________________________________________________________________________");
            System.out.println("Lab Excersize " + labE_number + "Q" + q_number);
            System.out.println("Prepared By: Bashshar Atif");
            System.out.println("Student Number: 251219057");
            System.out.println("The goal of this exercise to is to create and understand a tree map abstract data type!");
            System.out.println("______________________________________________________________________________________________________________________________________");

        }
}
