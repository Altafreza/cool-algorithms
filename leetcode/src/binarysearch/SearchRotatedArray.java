package binarysearch;

import java.util.List;

public class SearchRotatedArray {
    // DO NOT MODIFY THE LIST
    public int search(final List<Integer> a, int b) {
        int low = 0, high = a.size() - 1;
        int pivot = 0;
        if (a.get(0) < a.get(a.size() - 1)) return binarySearch(a, 0, a.size() - 1, b);
        // 9 10 13 1 2 3 4 5 6
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a.get(mid) > a.get(mid + 1)) {
                pivot = mid + 1;
                break;
            } else if (a.get(0) < a.get(mid)) low = mid + 1;
            else high = mid - 1;
        }
        if (pivot > 0 && b >= a.get(0) && b <= a.get(pivot - 1)) {
            return binarySearch(a, 0, pivot - 1, b);
        } else {
            return binarySearch(a, pivot, a.size() - 1, b);
        }
    }

    private int binarySearch(final List<Integer> a, int low, int high, int b) {

        while (low <= high) {
            int mid = (low + high) / 2;
            if (a.get(mid) == b) return mid;
            else if (a.get(mid) < b) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
