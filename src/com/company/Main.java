package com.company;

import java.io.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader fr = new BufferedReader(new FileReader("src//uzumaki.txt"))) {
            int k = 0;
            String text = "";
            while ((k = fr.read()) != -1) {
                text += (char) k;
            }
            int val = text.indexOf("//");
            int val2 = text.indexOf("\n",val);
            StringBuffer sb = new StringBuffer(text);
            sb.delete(val, val2);
            int val3 = sb.indexOf("/*");
            int val4 = sb.lastIndexOf("*/");
            StringBuffer kb = new StringBuffer(sb);
            kb.delete(val3, val4 + 2);
            System.out.println(kb);
            try (FileWriter fww = new FileWriter("src//uzumaki2.txt");
                 BufferedWriter ad = new BufferedWriter(fww)){
                ad.write(kb.toString());
            } catch (IOException ex){
                System.out.println("Error");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}