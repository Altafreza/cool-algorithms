package learningstatic;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Car {
    // all instance of Car will have the same list in it
    // it is initialized only once
    static ArrayList<Car> CAR_LIST = new ArrayList<>();

    String name;
    public Car(String name){
        this.name = name;
        CAR_LIST.add(this);
    }
    public static void main(String[] args) {

    }
}
