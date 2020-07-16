package my.all.test;

public class Person {
    private String name;
    private int age;
    private String country;

    public Person() {
        country = "RU";
    }

    public Person(String name, int age) {
        this();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    public static void main(String[] args) {
        String nameValue = "Мария";
        Person Samuylova = new Person(nameValue, 37);
        System.out.println(Samuylova.age);
        System.out.println(Samuylova.country);
        System.out.println(Samuylova.name);
    }
}
