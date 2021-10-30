package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class MMain {
    public static void main(String[] args) {
        Employe e1 = new Employe(1, "e1", 12);
        Employe e2 = new Employe(2, "e2", 12);
        Employe e3 = new Employe(3, "e3", 12);
        Employe e4 = new Employe(3, "e4", 12);
        System.out.println(e3.hashCode() + " " + e4.hashCode());
        Map<Employe, String> map = new HashMap<>();

        map.put(e1, e1.name);
        map.put(e2, e2.name);
        map.put(e3, e3.name);
        map.put(e4, e4.name);
        map.put(new Employe(2, "new", 123), "new name");

        //        map.put(e4, e4.name);

    }
}
