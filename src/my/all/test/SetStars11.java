package my.all.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SetStars11 {
    static String setStars(String filename) throws FileNotFoundException {
        int star = '*';
        StringBuilder result = new StringBuilder(100);
        try(RandomAccessFile raf = new RandomAccessFile(filename,"rw")) {
            long totalBytes = raf.length();
            for(long i = 9; i<totalBytes; i+=10) {
                raf.seek(i);
                result.append((char)raf.readUnsignedByte());
                raf.seek(i);
                raf.writeByte(star);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getClass().getName());
        } catch (IOException e) {
            throw new RuntimeException("несуществующий путь/несуществующий файл");
        }
        return result.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(setStars("////"));
    }
}
