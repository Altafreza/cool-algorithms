package binarysearch;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.next().equals(".")) {
            FunFin.a.add(78);
            FunFin f = new FunFin();
            f.sonFunc();
            System.out.println(FunFin.a.size());

        }
    }
}
