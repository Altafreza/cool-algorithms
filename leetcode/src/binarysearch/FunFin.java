package binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunFin {
    static List<Integer> a = new ArrayList<>();
    int b = 98;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FunFin f;
        while (!scanner.next().equals(".")) {
            f = new FunFin();
            f.sonFunc();
            System.out.println(FunFin.a.size());

        }
    }

    public void sonFunc() {
        a.add(55);
        b = 66;
        System.out.println(a);
    }
}
