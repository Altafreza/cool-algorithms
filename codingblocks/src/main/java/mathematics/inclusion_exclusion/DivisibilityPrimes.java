package mathematics.inclusion_exclusion;

import java.util.Scanner;

// All the numbers less than 1000 which are divisible by
// all the primes less than 20
public class DivisibilityPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19};

        long subsets = (1 << 8) - 1;
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            long ans = 0;
            for (int i = 1; i <= subsets; i++) {
                long denom = 1l;

                long setBits = Integer.bitCount(i);
                for (int j = 0; j <= 7; j++) {
                    if ((i & (1 << j)) != 0) {
                        denom = denom * primes[j];
                    }
                }

                if ((setBits & 1) == 1) {
                    ans += n / denom;
                } else {
                    ans -= n / denom;
                }
            }
            System.out.println(ans);
        }
    }

}
