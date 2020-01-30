package com.redhat.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Counts number of words across files specified as arguments.
 *
 */
public class WordCounter
{
    public static void main( String[] args ) {
        Map<String, Integer> words = processFiles(args);

        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println(entry.getKey() +": " + entry.getValue());
        }
    }

    public static Map<String, Integer> processFiles(String[] args) {
        Map<String, Integer> words = new HashMap<>();

        for (String arg : args) {
            try (BufferedReader br = new BufferedReader(new FileReader(arg))) {
                String line;

                while (null != (line = br.readLine())) {
                    String[] string = line.toLowerCase().split("[^\\p{L}]+");

                    for (String word : string) {
                        if (!word.isEmpty()) {
                            words.put(word, words.getOrDefault(word, 0) + 1);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return words;
    }
}
