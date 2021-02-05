package ru.progwards.java1.lessons.io2;
//Создать класс Translator - переводчик, который будет переводить предложения с одного языка на другой
//
//        2.1 Конструктор Translator(String[] inLang, String[] outLang), где inLang и outLang - массивы слов на разных языках, например русском и английском. Сохранить значения параметров в приватных свойствах класса
//
//        2.2  Метод public String translate(String sentence), в котором найти слова, содержащиеся в sentence и в inLang и заменить их на соответствующие в outLang. Пунктуация должна быть соблюдена (скопирована из оригинальной строки). При этом надо соблюсти заглавные буквы, если они были в оригинальном тексте. В inLang и outLang все слова хранятся в нижнем регистре.
//
//        Например, фраза
//        "Hello World!" будет переведена как "Привет Мир!"
//        при наличии слов "hello", "world" в inLang и "привет", "мир" в outLang

public class Translator {
    private final String[] inLang;
    private final String[] outLang;

    Translator(String[] inLang, String[] outLang) {
        this.inLang = inLang;
        this.outLang = outLang;
    }

    public String translate(String sentence) { // если есть готовый словарь файл, можно попробовать задать поиск слова по словарю и сделать подмену. В случае поиска города, как в лекции
        String[] arSen = sentence.split(" ");
        StringBuilder temp = new StringBuilder();
        for (String s : arSen) {
            StringBuilder str = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    str.append(c);
                }
            }
            str = new StringBuilder(str.toString().toLowerCase());
            if (str.toString().equals("")) {
                temp.append(s).append(" ");
            } else {
                for (int j = 0; j < inLang.length; j++) {
                    if (str.toString().equals(inLang[j])) {
                        String next;
                        if (s.substring(0, 1).equals(s.substring(0, 1).toUpperCase())) {
                            next = outLang[j].substring(0, 1).toUpperCase() + outLang[j].substring(1);
                        } else {
                            next = outLang[j];
                        }
                        if (str.length() == s.length()) {
                            temp.append(next).append(" ");
                        } else {
                            int substr = s.length() - (s.length() - str.length());
                            temp.append(next).append(s.substring(substr)).append(" ");
                        }
                    }
                }
            }
        }
        temp = new StringBuilder(temp.toString().trim());
        return temp.toString();
    }

    public static void main(String[] args) {
        String[] inLang = {"mən", "səni", "sevirəm"};
        String[] outLang = {"я", "люблю", "тебя"};
        String sentence = "Mən səni sevirəm!";
        Translator translator = new Translator(inLang, outLang);
        System.out.println((sentence));
        System.out.println(translator.translate(sentence));
    }
}

