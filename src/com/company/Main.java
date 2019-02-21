package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();

    
    
    public static void main(String[] args) {
        new Main();
    }
    
    public Main() {
        String line;
        String[] words;

        int max = Collections.max(map.values());;


        System.out.println(map);
        while ((line = indata.fileReadLine()) != null) {
            // Remove anything that's not a letter or space
            line = line.replaceAll("[^a-zA-Z ]","")
                    .toLowerCase().trim();
           
            // Don't process lines with no characters
            if (line.isEmpty()) {
                continue;
            }
            
            // Split string over one or more spaces
            words = line.split(" +");
            
            // Look for each word in the map
            for (String word : words) {
                // This word isn't yet a key, init count to 1
                if (!Main.map.containsKey(word)) {
                    Main.map.put(word, 1);
                }
                else {
                    // Increment count using word as key
                    Main.map.put(word, Main.map.get(word) + 1);
                }

            }

            // Loop over entries in the map, getting each key/value pair
            for (Map.Entry<String, Integer> entry : Main.map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }


            //map.entrySet().stream().filter(entry -> entry.getValue() == max).map(entry -> entry.getKey()).collect(Collectors.toList());
        }

    }
    public static List<String> getKeysWithMaxValue(Map<String, Integer> map){
        final List<String> resultList = new ArrayList<String>();
        int currentMaxValuevalue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() > currentMaxValuevalue){
                resultList.clear();
                resultList.add(entry.getKey());
                currentMaxValuevalue = entry.getValue();
            } else if (entry.getValue() == currentMaxValuevalue){
                resultList.add(entry.getKey());
            }
        }
        return resultList;
    }
    
}