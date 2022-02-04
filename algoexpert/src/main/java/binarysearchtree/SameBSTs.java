package binarysearchtree;

import java.util.ArrayList;
import java.util.List;

// can same bsts be produced by these arrays?
public class SameBSTs {
    public static void main(String[] args) {
        System.out.println(sameBsts( // true
                new int[]{10, 15, 8, 12, 94, 81, 5, 2, 11,},
                new int[]{10, 8, 5, 15, 2, 12, 11, 94, 81}));
    }

    // TC: O(n^2) SC: O(d)
    public static boolean sameBsts(int[] a, int[] b) {
        // Write your code here.
        return sameBsts(a, b, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean sameBsts(int[] a, int[] b, int i, int j, int min, int max) {
        if (i == -1 || j == -1) return i == j;

        if (a[i] != b[j]) return false;

        int ia = getFirstSmallerIdx(a, i, min); // left root in a
        int ib = getFirstSmallerIdx(b, j, min); // left root in b
        int ja = getFirstBiggerOrEqualIdx(a, i, max); // right root in a
        int jb = getFirstBiggerOrEqualIdx(b, j, max); // right root in b

        int curr = a[i];
        boolean leftAreSame =
                sameBsts(a, b, ia, ib, min, curr);
        boolean rightAreSame =
                sameBsts(a, b, ja, jb, curr, max);

        return leftAreSame && rightAreSame;
    }

    private static int getFirstSmallerIdx(int[] z, int n, int min) {
        for (int i = n + 1; i < z.length; i++)
            if (z[i] < z[n] && z[i] >= min) return i;

        return -1;
    }

    private static int getFirstBiggerOrEqualIdx(int[] z, int n, int max) {
        for (int i = n + 1; i < z.length; i++)
            if (z[i] >= z[n] && z[i] < max) return i;

        return -1;
    }

    // TC: O(n^2) SC:  O(n^2)
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        if (arrayOne.size() != arrayTwo.size()) return false;

        if (arrayOne.size() == 0 && arrayTwo.size() == 0) return true;

        if (arrayOne.get(0) != arrayTwo.get(0)) return false;

        List<Integer> lstOne = getSmallerLST(arrayOne);
        List<Integer> lstTwo = getSmallerLST(arrayTwo);
        List<Integer> rstOne = getBiggerOrEqualRST(arrayOne);
        List<Integer> rstTwo = getBiggerOrEqualRST(arrayTwo);

        // compare for left and right subtree
        // whether they make up bsts
        return sameBsts(lstOne, lstTwo) && sameBsts(rstOne, rstTwo);
    }

    private static List<Integer> getSmallerLST(List<Integer> array) {
        int root = array.get(0);
        List<Integer> leftSubTree = new ArrayList<>();

        for (int i = 1; i < array.size(); i++)
            if (root > array.get(i)) leftSubTree.add(array.get(i));

        return leftSubTree;
    }

    private static List<Integer> getBiggerOrEqualRST(List<Integer> array) {
        int root = array.get(0);
        List<Integer> rightSubTree = new ArrayList<>();

        for (int i = 1; i < array.size(); i++)
            if (root <= array.get(i)) rightSubTree.add(array.get(i));

        return rightSubTree;
    }


}
