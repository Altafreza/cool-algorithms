package sliding_window;

public class Heighs {
    private static Heighs INS;

    private Heighs() {

    }

    public static Heighs getINS(){
        synchronized (Heighs.class) {
            if (INS == null) {
                return new Heighs();
            }
            return INS;
        }
    }
}
