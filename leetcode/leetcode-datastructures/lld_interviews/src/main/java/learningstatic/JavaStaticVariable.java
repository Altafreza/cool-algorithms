package learningstatic;

import java.util.ArrayList;
import java.util.List;

class Being {

    public static int count;
}

class Cat extends Being {

    public Cat() {
        count++;
    }
}

class Dog extends Being {

    public Dog() {
        count++;
    }
}

class Donkey extends Being {

    public Donkey() {
        count++;
    }
}

public class JavaStaticVariable {

    public static void main(String[] args) {

        List<Being> beings = new ArrayList<>();

        beings.add(new Cat());
        beings.add(new Cat());
        beings.add(new Cat());
        beings.add(new Dog());
        beings.add(new Donkey());

        int nOfBeings = Being.count;

        System.out.format("There are %d beings %n", nOfBeings);
    }
}