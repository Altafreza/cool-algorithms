package two_pointer;

// return number of 'n'  to be removes from an unsorted array
public class RemoveElementUnsorted {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 6, 3, 10, 9, 3};
        System.out.println(remove(nums, 3));
    }

    public static int remove(int[] arr, int n) {
        int next = 0; // 'n' is pushd towards the start of the array

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != n) { // swap element found
                arr[next] = arr[i];
                next++;
            }
        }
        return next;
    }
}
