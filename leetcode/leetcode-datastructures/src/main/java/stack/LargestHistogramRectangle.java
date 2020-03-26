package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestHistogramRectangle {
    public static int largestRectangleArea(int[] a) {
        Deque<Integer> s = new ArrayDeque<>();
        if (a == null || a.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= a.length; i++) {
            int right = (i == a.length) ? -1 : a[i];
            while (!s.isEmpty() && a[s.peek()] >= right) {
                int curr = a[s.pop()]; //height of current rectangle
                int firstSmallerRight = i; //index of first H out of bound on the right

                if (s.isEmpty()) {
                    // everything to the right of curr is taller
                    // so horizontal length == firstSmallerRight - 1
                    max = Math.max(max, firstSmallerRight * curr);
                } else {
                    //index of first H out of bound on the left
                    int firstSmallerLeft = s.peek();
                    max = Math.max(max, curr * (firstSmallerRight - firstSmallerLeft - 1));
                }
            }
            s.push(i);
        }


        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{1, 1}));
    }
}
