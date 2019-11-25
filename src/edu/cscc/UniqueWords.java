package edu.cscc;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.invoke.StringConcatException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Utility to process a document to into sorted set of unique words
 * @author student name
 */
public class UniqueWords {
    /**
     * Read file one line at a time
     * Break input String into words
     * Store unique words sorted into alphabetic order
     * @param myfile input file
     * @return sorted set of unique words
     */
    public static Set<String> processDocument(File myfile) {
        TreeSet<String> book = new TreeSet<>();
        try (Scanner input = new Scanner(myfile);){
            while (input.hasNext()){
                String str = input.nextLine();
                String[] s = tokenize(str);
                for (String salah : s){
                    book.add(salah);
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Cannot access file " );
        }
        return book;
    }
    /**
     * Remove all punctuation and numbers from String
     * Tokenize - break into individual words
     * Convert all words to lower case
     * @param str initial non-null String
     * @return array of words from initial String
     */
    public static String[] tokenize(String str) {
        str = str.replaceAll("[^a-zA-Z \n]"," ");
        String[] tok = str.split(" ");
        for (int i=0; i<tok.length; ++i) {
            tok[i] = tok[i].toLowerCase();
        }
        return tok;
    }
}
