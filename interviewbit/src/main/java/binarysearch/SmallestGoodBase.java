package binarysearch;

import java.math.BigInteger;

public class SmallestGoodBase {
    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);

        for (int m = (int) (Math.log(num + 1) / Math.log(2)); m > 2; m--) {
            long l = (long) (Math.pow(num + 1, 1.0 / m));
            long r = (long) (Math.pow(num, 1.0 / (m - 1)));

            while (l <= r) {
                long mid = l + ((r - l) >> 1);
                long f = 0L;
                for (int i = 0; i < m; i++, f = f * mid + 1) ;

                if (num == f) {
                    return String.valueOf(mid);
                } else if (num < f) {
                    r = mid - 1;
                } else { // when mid is too small
                    l = mid + 1;
                }
            }
        }

        return String.valueOf(num - 1);
    }

    public String solve(String n) {
        long num = Long.valueOf(n);
        // when m = 2 for given i
        // n = 2^i - 1 therefore i = log(n+1) (base2)
        int bits = (int) (Math.log(num + 1) / Math.log(2));

        for (int i = bits; i > 1; i--) {
            long lo = 2, hi = num - 1;

            while (lo <= hi) {
                long mid = lo + (hi - lo) / 2;
                int check = checkBase(mid, i, num);
                if (check == 0) return "" + mid;

                if (check == -1) { // when mid is too small
                    lo = mid + 1;
                } else hi = mid - 1;
            }
        }

        return "";

    }

    public int checkBase(long base, int bits, long n) {
        BigInteger lhs = BigInteger.valueOf(base).pow(bits).subtract(BigInteger.ONE);
        BigInteger rhs = BigInteger.valueOf(n).multiply(BigInteger.valueOf(base).subtract(BigInteger.ONE));


        return lhs.compareTo(rhs);
    }
}
