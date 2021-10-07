package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // Creating hashmap to stores count of different types.
        HashMap<String, Integer> desiredOutput = new HashMap<>();
        // Creating a csv reader
        Scanner csvScanner = new Scanner(new File("src/com/company/Person.csv"));

        csvScanner.useDelimiter("\n");

        while (csvScanner.hasNext()) {
            String[] csvLine = csvScanner.nextLine().split(",");
            if (csvLine[4].equalsIgnoreCase("0")) {
                String personType = csvLine[1];
                desiredOutput.put(personType, desiredOutput.getOrDefault(personType, 0) + 1);
            }
        }
        // Getting the keys and printing.
        Set<String> personTypeList = desiredOutput.keySet();
        System.out.println("PersonType \tPersonCount");
        for (String personType : personTypeList)
            if (desiredOutput.get(personType) >= 100)
                System.out.println(personType + "\t\t\t" + desiredOutput.get(personType));
    }


}
