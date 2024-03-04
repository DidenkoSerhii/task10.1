package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class PhoneNumberValidator {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java PhoneNumberValidator <filename>");
            System.exit(1);
        }

        String filename = args[0];
        printValidPhoneNumbers(filename);
    }

    private static void printValidPhoneNumbers(String filename) {
        String line;
        String phoneRegex1 = "\\((\\d{3})\\) \\d{3}-\\d{4}";
        String phoneRegex2 = "\\d{3}-\\d{3}-\\d{4}";

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((line = reader.readLine()) != null) {
                if (line.matches(phoneRegex1) || line.matches(phoneRegex2)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}