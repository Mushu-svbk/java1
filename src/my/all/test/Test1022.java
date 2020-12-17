package my.all.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Test1022 {
//    public static void test2(String filename) throws IOException {
//        try {
//            FileWriter writer = new FileWriter(filename, false);
//            System.out.println("File processing");
//            writer.close();
//        } catch (IOException e) {
//            System.out.println("File not found");
//        }
//    }

    public static String test(String filename) throws IOException {
        try {
            filename.toString();
            return "File processing";
        } catch (NullPointerException e) {
            throw new IOException("File not found");
        }
    }

    private int lineCount(String filename) throws IOException {
        int result = 0;
        try {
            FileReader doc = new FileReader(filename);
            Scanner scan = new Scanner(doc);
            while (scan.hasNextLine()) {
                String str = scan.nextLine();
                result++;
            }
            scan.close();
            doc.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("файл не найден");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {

    }

}
