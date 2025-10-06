package com.example.mipt2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    // Regex: count sentences
    public int countSentences(String text) {
        if (text == null || text.isEmpty()) return 0;
        Pattern pattern = Pattern.compile("\\.");
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }

    // Regex: count numbers
    public int countNumbers(String text) {
        if (text == null || text.isEmpty()) return 0;
        Pattern pattern = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }

    // Without regex: count words
    public int countWords(String text) {
        if (text == null || text.isEmpty()) return 0;
        int count = 0;
        boolean inWord = false;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            boolean separator = (c == ' ' || c == ',' || c == '.');
            if (!separator && !inWord) {
                count++;
                inWord = true;
            } else if (separator) {
                inWord = false;
            }
        }
        return count;
    }

    // Without regex: punctuation marks (spaces, commas, dots)
    public int countPunctuationMarks(String text) {
        if (text == null || text.isEmpty()) return 0;
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == ' ' || c == ',' || c == '.') count++;
        }
        return count;
    }
}
