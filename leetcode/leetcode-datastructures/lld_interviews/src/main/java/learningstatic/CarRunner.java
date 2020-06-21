package learningstatic;

public class CarRunner {
    public static void main(String[] args) {
        Car c1 = new Car("Ferrari");
        Car c2 = new Car("Buggati");
        for(Car c : Car.CAR_LIST){
            System.out.println(c.name);
        }
    }
}
