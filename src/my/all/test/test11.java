package my.all.test;

import java.io.IOException;
import java.util.Scanner;

public class test11 {
    public static void doExceptions(int n) throws Throwable {
        Throwable suppressed = null;
        try {
            System.out.println("doExceptions 1");
            if (n == 0)
                throw new Exception("Exception in try");
            System.out.println("doExceptions 2");
        } catch (Throwable t) {
            suppressed = t;
            throw t;
        } finally {
            try {
                throw new Exception("Exception in finally");
            } catch (Throwable t) {
                if (suppressed != null)
                    t.addSuppressed(suppressed);
                throw t;
            }
        }
    }

    public void doSomething(int n) throws IOException {
    }

    public void test(int n) throws IOException {
        try {
            doSomething(n);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            System.out.println("finally executed");

        }
    }

    public void scanLines() {
        try(Scanner scanner = new Scanner(System.in)) {
            String line, lineLow;
            while (true) {
                line = scanner.nextLine();
                lineLow = line.toLowerCase();
                if (lineLow.contains("привет")) System.out.println("Здравствуйте!");
                else if (lineLow.contains("как дела")) System.out.println("Хорошо");
                else if (lineLow.contains("/stop")) return;
                else System.out.println(line);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            doExceptions(1);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            for (Throwable t: e.getSuppressed())
                System.out.println(t.getMessage() + " (suppressed)");
        }
    }
}
