package OOD1;

public class Employee {
    private final String name;
    private final String id;
    private int age;

    protected int salary;
    protected int level;

    Employee(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("Name: " + name + "; Age: " + age + ";ID: " + id);
    }


}
