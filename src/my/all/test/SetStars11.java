package my.all.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SetStars11 {
    public static String setStars(String filename) {
        int star = (int)'*';
        StringBuilder result = new StringBuilder(100);
        try(RandomAccessFile raf = new RandomAccessFile(filename,"rw")) {
            long totalBytes = raf.length();
            for(long i = 9; i<totalBytes; i+=10) {
                raf.seek(i);
                result.append((char)raf.readUnsignedByte());
                raf.seek(i);
                raf.writeByte(star);
            }
        } catch (Throwable e) {
            //System.out.println(e.getClass().getName());
        }
        return result.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(setStars("////"));
        System.out.println(setStars("несуществующий путь/несуществующий файл"));
    }
}
