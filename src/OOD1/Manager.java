package OOD1;

public class Manager extends Employee {
    Manager(String name, String id, int age) {
        super(name, id, age);
    }

    public void xxx() {
//        System.out.println("Name: " + name + "; Age: " + age + ";ID: " + id);
        System.out.println("Salary: " + salary);
        printInfo();

        Employee e = new Employee("Andy", "123", 26);
//        System.out.println("Name: " + e.name + "; Age: " + e.age + ";ID: " + e.id);

        Manager m = new Manager("Andylee", "124", 27);
//        System.out.println("Name: " + m.name + "; Age: " + m.age + ";ID: " + m.id);

    }
}
