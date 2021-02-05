package ru.progwards.java1.lessons.io2;

//Создать статический метод public static String format(String phone), который форматирует телефон под формат +7(999)111-2233, входящий формат может быть различным:
//        - 79991112233
//        - 8(999)111-22-33
//        - 8 999 111 22 33
//
//        формальное задание на форматирование:
//        - выделить все цифры, отбросить все разделители
//        - проверить что цифр в номере 11 или 10, в противном случае выбросить исключение
//        - убрать спереди 8
//        - добавить, если нужно +7
//        - отформатировать под выходной шаблон

import java.io.IOException;

public class PhoneNumber {
    public static String format(String phone) throws RuntimeException {
        String numbers = phone.replaceAll("[^\\d]", "");
        int pnum = numbers.length();
        if (pnum < 10 || pnum > 11) throw new RuntimeException("Проверьте количество цифр. Телефонный номер должен содержать 10 или 11 цифр");
        else {
            return "+" + (numbers.charAt(0) == '8' ? "7" : numbers.substring(0, 1))
                    + "(" + numbers.substring(1, 4) + ")"
                    + numbers.substring(4, 7) + "-" + numbers.substring(7);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(format("8(945)388-83-29"));
        System.out.println(format("8 945 421 21 86"));
        System.out.println(format("8450 3 70 0 4 23"));
    }
}
