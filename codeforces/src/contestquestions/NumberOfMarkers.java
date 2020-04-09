package contestquestions;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberOfMarkers {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = 0, y = 0;
            Set<Integer> res = new HashSet<>();
            for (int j = 0; j < n; j++) {
                x = sc.nextInt();
                y = sc.nextInt();
                for (int k = x; k <= y; k++) {
                    res.add(k);
                }

            }
            System.out.println(res.size());
        }
    }
}
