package array;

import java.util.Arrays;
import java.util.List;

public class MoveElementsToEnd {
    public static void main(String[] args) {
        System.out.println(moveElementToEnd(Arrays.asList(2, 1, 4, 2, 3, 2), 2));

    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int l = 0, r = array.size() - 1;

        while (l < r) {
            while (l < r && array.get(r) == toMove)
                r--;
            if (array.get(l) == toMove) {
                swap(l, r, array);
            }
            l++;
        }
        return array;

    }

    public static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }
}
