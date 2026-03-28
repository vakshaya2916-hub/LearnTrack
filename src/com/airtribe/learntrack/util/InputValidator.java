package com.airtribe.learntrack.util;

import com.airtribe.learntrack.exception.InvalidInputException;

public class InputValidator {

    // Student input validation
    public static void validateStudentInput(String fn, String ln, String batch) throws InvalidInputException {
        if (fn == null || fn.trim().isEmpty()) throw new InvalidInputException("First name cannot be empty");
        if (ln == null || ln.trim().isEmpty()) throw new InvalidInputException("Last name cannot be empty");
        if (batch == null || batch.trim().isEmpty()) throw new InvalidInputException("Batch cannot be empty");
    }

    // Generic integer input helper
    public static int readInt(java.util.Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter again.");
            }
        }
    }
}