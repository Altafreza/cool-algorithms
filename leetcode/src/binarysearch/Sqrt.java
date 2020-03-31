package binarysearch;

public class Sqrt {
    public int mySqrt(int x) {
        long low = 1;
        long high = x;

        // we have to find the greatest answer after which                 _______________
        // the square of the answer would be greater than 'x' ____________.

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sqr = mid * mid;
            if (sqr == x) return (int) mid;

            // mid was not an answer
            // estimation from mid - 1 begins
            if (sqr > x) high = mid - 1;

                //mid was probable answer was left
                // we have to maximze this
            else low = mid + 1;
        }

        return (int) low - 1;
    }

    public int mySqrt2(int a) {
        long low = 1;
        long high = a;
        if (a < 2) return a;
        while (low < high) {
            long mid = (high + low) / 2 + 1;
            if (mid * mid == a) {
                return (int) mid;
            }
            if (mid * mid > a) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        // if we did not find an exact match the high variable is smaller
        //than low and therefore contains the floor value of sqrt.
        return (int) low;
    }
}
