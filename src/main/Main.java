package main;

import java.io.*;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        double [][] arr = readFile();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("\n");
        }

        double [] minLine = lineMin(arr);
        System.out.println("\nSor minimumok: ");
        for (int i = 0; i < minLine.length; i++) {
            System.out.print(minLine[i] + "  ");
        }

        System.out.println("\nOszlop maximumok: ");
        double [] maxCoulum = columnMax(arr);
        for (int i = 0; i < maxCoulum.length; i++) {
            System.out.print(maxCoulum[i] + " ");
        }

        System.out.println();

        System.out.println("\nA sorminimumok közül a legnagyobb: " + findMax(minLine));
        System.out.println("Az oszlopmaximumok közül a legkisebb: " + findMin(maxCoulum));

        if(findMin(maxCoulum) == findMax(minLine)){
            System.out.println("A mátrixnak van nyeregpontja.");
        }else System.out.println("A mátrixnak nincs nyeregpontja.");

    }

    public static double[][] readFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader("adatok.txt")));
        int rows = 4;
        int columns = 4;
        double [][] myArray = new double[rows][columns];
        while(sc.hasNextLine()) {
            for (int i=0; i<myArray.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j=0; j<line.length; j++) {
                    myArray[i][j] = Double.parseDouble(line[j]);
                }
            }
        }
       // System.out.println(Arrays.deepToString(myArray));
        return myArray;
    }

    public static double[] lineMin(double[][] arr){
        double [] minArr = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            double min = arr[i][0];
            for (int j = 0; j < arr[i].length; j++) {
                    if(arr[i][j] < min){
                        min = arr[i][j];
                    }
            }
            minArr[i] = min;
        }
        return minArr;
    }

    public static double[] columnMax(double[][] arr){
        double [] maxArr = new double[arr.length];

        for (int i = 0; i < arr.length; i++) {
            double max = arr[0][i];
            for (int j = 0; j < arr[i].length; j++) {
                    if(arr[j][i] > max){
                        max = arr[j][i];
                    }
            }
            maxArr[i] = max;
        }
        return maxArr;
    }

    public static double findMin(double [] arr){
        double min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    public static double findMax(double [] arr){
        double max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}

