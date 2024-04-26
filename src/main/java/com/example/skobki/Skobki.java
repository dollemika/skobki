package com.example.skobki;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Skobki {

    ArrayList<Character> onlybrackets;
    ArrayList<Character> allbrackets;
    public Skobki() {
        onlybrackets = new ArrayList<Character>();
        allbrackets = new ArrayList<Character>();
    }



    public int check() {
        onlybrackets.clear();
        int count = 0;
        for (char y : allbrackets){
            if (y == '[' || y == '(' || y == '{'){
                onlybrackets.add(y);
                continue;
            }
            if (onlybrackets.isEmpty())
                continue;
            if (y == ']' && onlybrackets.getLast() != '['){count++; continue;}
                //return false;
            if (y == ')' && onlybrackets.getLast() != '('){count++; continue;}
               // return false;
            if (y == '}' && onlybrackets.getLast() != '{'){count++; continue;}
               // return false;
            onlybrackets.removeLast();
        }
        if (!onlybrackets.isEmpty()) count++;
        return count;
    }
    public void readFromFile(String fname) throws FileNotFoundException {
        allbrackets.clear();
        Scanner scanner = new Scanner(new File(fname));
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            char[] x = s.toCharArray();
            for (char y : x){
                if (y == '[' || y == '(' || y == '{' || y == ']' || y == ')' || y == '}')
                    allbrackets.add(y);
            }
        }
        scanner.close();
    }
}
