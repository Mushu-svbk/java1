package my.all.test;

public class TTest4_2_3 {

        static String textGrade(int grade) {
            if (grade < 0) return "не определено";
            if (grade == 0) return "не оценено";
            if (grade <= 20) return "очень плохо";
            if (grade <= 40) return "плохо";
            if (grade <= 60) return "удовлетворительно";
            if (grade <= 80) return "хорошо";
            if (grade <= 100) return "отлично";

            return "не определено";
        }

        public static void main(String[] args) {
            System.out.println(textGrade(45));
        }
}
