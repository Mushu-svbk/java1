package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharFilter {
    private static String deleteFilterChars (String string, String filter) {
        StringBuilder stringBuilder = new StringBuilder();
        int s = string.length();
        for (int i = 0; i < s; i++) {
            if (filter.indexOf(string.charAt(i)) < 0)
                stringBuilder.append(string.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void filterFile(String inFileName, String outFileName, String filter) {
        try (
                FileReader fileReader = new FileReader(inFileName);
                Scanner scanner = new Scanner(fileReader);
                FileWriter fileWriter = new FileWriter(outFileName)
        ) {
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                str = deleteFilterChars(str,filter);
                fileWriter.write(str);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter;
        fileWriter = new FileWriter("CharFilter.txt");
        fileWriter.write("Java — строго типизированный объектно-ориентированный язык программирования, разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).");
        fileWriter.close();

        fileWriter = new FileWriter("CharFilter0.txt");
        filterFile("CharFilter.txt",
                "CharFilterO.txt", " -,.()");
        fileWriter.close();

        FileReader reader = new FileReader("CharFilter.txt");
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()){
            String strFromFile = scanner.nextLine();
            System.out.println(strFromFile);
        }
        reader.close();

        FileReader reader2 = new FileReader("CharFilterO.txt");
        Scanner scanner2 = new Scanner(reader2);
        while (scanner2.hasNextLine()){
            String strFromFile = scanner2.nextLine();
            System.out.println(strFromFile);
        }
        reader2.close();
    }
}
