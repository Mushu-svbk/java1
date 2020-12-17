package ru.progwards.java1.lessons.io1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName) {
        int result = 0;
        int errorReturn = -1;

        try (FileReader f = new FileReader(fileName); Scanner s = new Scanner(f)) {
            while (s.hasNextLine()) {
                String str = s.nextLine();
               if (str.isEmpty()) result++;
            }
        } catch (IOException e) {
            result = errorReturn;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter = new FileWriter("LineCount.txt");
        fileWriter.write("Проверка на пустые строки.\n");
        fileWriter.write("\n");
        fileWriter.write("\n");
        fileWriter.write("\n");
        fileWriter.write("\n");
        fileWriter.write("\n");
        fileWriter.write("The end!");
        fileWriter.close();
        System.out.println(calcEmpty("LineCount.txt"));
        System.out.println(calcEmpty("Line-Count.txt"));
    }
}
