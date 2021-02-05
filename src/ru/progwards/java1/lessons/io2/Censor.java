package ru.progwards.java1.lessons.io2;
//Создать статический метод public static void censorFile(String inoutFileName, String[] obscene), в котором прочитать файл inoutFileName и заменить слова, содержащиеся в String[] obscene на '*', соответствующие количеству символов в слове, изменения записать в исходный файл. В случае возникновения ошибки, выбросить свое собственное исключение CensorException в котором сохранить - строку, полученную у оригинального exception через метод getMessage() и имя файла, в котором возникла ошибка. В классе перекрыть метод toString(), вернув <имя файла>:<строка ошибки>. Класс CensorException разместить в классе Censor
//
//        Например файл содержит:
//        Java — строго типизированный объектно-ориентированный язык программирования, разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).
//        obscene = {"Java", "Oracle", "Sun", "Microsystems"}
//
//        Должен выдать результат:
//        **** — строго типизированный объектно-ориентированный язык программирования, разработанный компанией *** ************ (в последующем приобретённой компанией ******).

import java.io.*;
import java.util.Scanner;

public class Censor {
    static class CensorException extends RuntimeException {

        String errName;
        String fileName;

        CensorException(String errName, String fileName) {
            this.errName = errName;
            this.fileName = fileName;
        }

        @Override
        public String toString() {
            return errName + ":" + fileName;
        }
    }

    public static String repeatStr(String value, int count) {
        return String.valueOf(value).repeat(Math.max(0, count));
    }

    public static void censorFile(String inoutFileName, String[] obscene) {
        if (inoutFileName == null || inoutFileName.compareTo("") == 0) throw new CensorException("Имя файла передавать обязатльно", inoutFileName);
        if (obscene == null) throw new CensorException("Последовательность слов передавать обязательно", inoutFileName);

        int obLen;
        String[] stars;
        try {
            obLen = obscene.length;
            stars = new String[obLen];
            for (int i = 0; i < obLen; i++) {
                stars[i] = repeatStr("*", obscene[i].length());
            }
        } catch (Exception e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }

        String tmpFileName = inoutFileName + ".tmp";
        String lineSeparator = System.getProperty("line.separator");
        boolean firstLine = true;

        try (FileReader r = new FileReader(inoutFileName); Scanner s = new Scanner(r); FileWriter w = new FileWriter(tmpFileName)) {
            while (s.hasNext()) {
                if (firstLine) {
                    firstLine = false;
                } else {
                    w.write(lineSeparator);
                }
                String str = s.nextLine();
                for (int i = obLen - 1; i >= 0; i--) {
                    str = str.replace(obscene[i], stars[i]);
                }
                w.write(str);
            }
        } catch (IOException e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }
        try {
            File f = new File(inoutFileName);
            f.delete();
            File n = new File(tmpFileName);
            n.renameTo(f);
        } catch (Exception e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }
    }

    public static void main(String[] args) throws IOException {
        FileWriter fileWriter;
        fileWriter = new FileWriter("Censor.txt");
        fileWriter.write("Java — строго типизированный объектно-ориентированный язык программирования, разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).");
        censorFile("Censor.txt", new String[]{"java", "Oracle", "Sun", "Microsystems"});
                fileWriter.close();
    }
}
