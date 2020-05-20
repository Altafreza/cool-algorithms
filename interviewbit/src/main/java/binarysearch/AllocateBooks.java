package binarysearch;

public class AllocateBooks {
    public static int books(int[] pages, int b) {
        if (b > pages.length) {
            return -1;
        }
        int low = 0, high = 0;
        for (int i = 0; i < pages.length; i++) {
            low = Math.max(low, pages[i]);
            high += pages[i];
        }
        low -= 1;
        while (high - low > 1) {
            int mid = (low + high) / 2;
            if (isPossible(pages, b, mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

    private static boolean isPossible(int[] books, int b, int curr) {
        int students = 1;
        int sum = 0;
        for (Integer book : books) {
            if (book > curr) return false;
            if (sum + book > curr) {
                students++;
                sum = book;
                if (students > b) return false;
            } else {
                sum += book;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        books(new int[]{12, 34, 67, 90}, 2);
    }
}