package contestquestions;

import java.util.HashMap;
import java.util.Objects;
import java.util.logging.Handler;

public class Employee {
    int i;
    String name;

    public Employee(int i, String name) {
        this.i = i;
        this.name = name;
    }

//    @Override

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return i == employee.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
//    public int hashCode() {
//        return i;
//    }
//
//    public boolean equals(Object o) {
//        Employee e = (Employee) o;
//        return e.i == this.i;
//    }

    public static void main(String[] args) {
        HashMap<Employee, String> map = new HashMap<>();
        Employee e1 = new Employee(1, "e1");

        Employee e2 = new Employee(2, "e2");
        Employee e3 = new Employee(2, "e3");
        map.put(e1, e1.name);
        map.put(e2, e2.name);
        map.put(e3, e3.name);

    }
}
