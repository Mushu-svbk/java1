package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Coder {
    public static char[] codeFile(String inFileName, String outFileName, char[] code, String logName) {
        try {
            try (FileReader reader = new FileReader(inFileName)) {
                try (FileWriter writer = new FileWriter(outFileName, true)) {
                    int symbol;
                    while ((symbol = reader.read()) != -1) {
                        writer.write(code[symbol]);
                    }
                }
            }

        } catch (Exception e) {
            try {
                try (FileWriter writer = new FileWriter(logName)) {
                    writer.write(e.getMessage());
                }
            } catch (IOException e2) {
                throw new RuntimeException("Невозможно создать файл");
            }
        }
        return code;
    }

    public static void main(String[] args) {
        char[] code = new char[256];
        //for (int i = 0; i < 256; i++) code[i] = (char)i;
        for (int i = 0; i < 256; i++) code[i] = (char) (Character.isDigit((char) i) ? i + 1 : i);
        System.out.println(codeFile(String.valueOf(2),String.valueOf(4), code,String.valueOf(33)));
    }
}
