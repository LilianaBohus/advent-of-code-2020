package day2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Day2 {
    public static void main(String[] args) throws IOException {
        System.out.println(getNumberOfCorrectPasswordsPart1(parseData(readData())));
        System.out.println(getNumberOfCorrectPasswordsPart2(parseData(readData())));
    }


    private static int getNumberOfCorrectPasswordsPart1(List<PasswordEntry> passwordEntries) {
        int count = 0;
        for (PasswordEntry passwordEntry : passwordEntries) {
            long occurrences = passwordEntry.password.chars().filter(character -> character == passwordEntry.character).count();
            if (passwordEntry.lowerLimit <= occurrences && passwordEntry.upperLimit >= occurrences){
                count++;
            }
        }
        return count;
    }

    private static int getNumberOfCorrectPasswordsPart2(List<PasswordEntry> passwordEntries) {
        int count = 0;
        for (PasswordEntry passwordEntry : passwordEntries) {
            if (charAtFirstPosition(passwordEntry) ^ charAtLastPosition(passwordEntry)){
                count++;
            }
        }
        return count;
    }

    private static boolean charAtFirstPosition(PasswordEntry passwordEntry) {
        return passwordEntry.password.charAt(passwordEntry.lowerLimit-1) == passwordEntry.character;
    }

    private static boolean charAtLastPosition(PasswordEntry passwordEntry) {
        return passwordEntry.password.charAt(passwordEntry.upperLimit-1) == passwordEntry.character;
    }

    private static List<PasswordEntry> parseData(List<String> records) {
        List<PasswordEntry> passwordEntries = new ArrayList<>();
        // Format: {lowerLimit}-{upperLimit} {character}: {password}
        for (String record: records) {
            PasswordEntry passwordEntry = new PasswordEntry();
            passwordEntry.lowerLimit = Integer.parseInt(record.substring(0, record.indexOf("-")));
            passwordEntry.upperLimit = Integer.parseInt(record.substring(record.indexOf("-")+1, record.indexOf(" ")));
            passwordEntry.character = record.substring(record.indexOf(" ")+1, record.indexOf(":")).charAt(0);
            passwordEntry.password = record.substring(record.indexOf(": ")+2);
            passwordEntries.add(passwordEntry);
        }
        return passwordEntries;
    }

    private static List<String> readData() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input/day2.txt")));
        String line;
        List<String> records = new ArrayList<>();
        while ( (line = br.readLine()) != null){
             records.add(line.strip());
        }
        return records;
    }

    private static class PasswordEntry{
        int lowerLimit;
        int upperLimit;
        char character;
        String password;
    }
}
