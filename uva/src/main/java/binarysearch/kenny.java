package binarysearch;

public class kenny {
    int a = 0;

    public void somefun(kenny k){
        k.a = 20;
    }
    public static void main(String[] args) {
        kenny k = new kenny();
        k.a = 10;
        kenny k1 = new kenny();
        k1.a = 5;

        k.somefun(k1);
        int b = k1.a;
    }
}
