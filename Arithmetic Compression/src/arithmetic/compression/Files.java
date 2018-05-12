/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arithmetic.compression;

/**
 *
 * @author abis
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

 
import java.util.Formatter;
 
 
public class Files {
    //////////////////////////////////////////////////////////
     
     
    private static Scanner file;
    private static Formatter output;
 
    public static String readCompress(String path) {
        try {
            file = new Scanner(new File(path));
        } catch (Exception e) {
            System.out.println("File isn't found !!");
        }
        String res = "";
        while (file.hasNext()) {
            res += file.next();
        }
        file.close();
        return res;
    }
 
    public static void writeCompress(ArrayList<String> character, ArrayList<Double> prob, double result, int length, String path) 
    {
        try {
            output = new Formatter(path);
            System.out.println("Succesfully Compressed");
        } catch (Exception e) {
            System.out.println("Failure !!");
        }
        String s = "";
        s += result + " ";
        output.format(s);
        s = "";
        s += length + " ";
        output.format(s);
        for (int i = 0; i < character.size(); i++) {
            s = "";
            s += character.get(i);
            s += " ";
            s += prob.get(i);
            if (i == character.size() - 1) {
                output.format(s);
            } else {
                s += " ";
                output.format(s);
            }
        }
        output.close();
    }
     
    public static void writeDecompress(String data, String path) {
        try {
            output = new Formatter(path);
            System.out.println("Succesfully decompressed");
        } catch (Exception e) {
            System.out.println("Failure !!");
        }
        output.format(data);
        output.close();
    }
     
    public static void readDecompress(String path, double data, int len,
            ArrayList<String> c, ArrayList<Double> d) {
        try {
            file = new Scanner(new File(path));
        } catch (Exception e) {
            System.out.println("File isn't found !!");
        }
        data += Double.parseDouble(file.next());
        len += Integer.parseInt(file.next());
        while (file.hasNext()) {
            c.add(file.next());
            d.add(Double.parseDouble(file.next()));
        }
        file.close();
        ArithmeticCompression obj = new ArithmeticCompression();
        obj.decompression(d, c, data, len, path);
    }
     
    public static String editPath(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            res += s.charAt(i);
            if (s.charAt(i) == '\\') {
                res += '\\';
            }
        }
        return res;
    }
}
