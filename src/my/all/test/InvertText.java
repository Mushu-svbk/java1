package my.all.test;

public class InvertText {
    public static String invertWords(String sentence) {
        String[] splitted = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = splitted.length - 1; i >= 0; i--) {
            result.append(splitted[i]);
            if (i > 0) result.append('.');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(invertWords("Буря мглою небо кроет"));
    }
}
