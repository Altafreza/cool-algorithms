package two_pointer;

public class RemoveDuplicates {
    public static int remove(int[] num) {
        int nextNonDuplicate = 1;
        for (int i = 1; i < num.length; i++) {
            if (num[i] != num[nextNonDuplicate - 1]) {
                num[nextNonDuplicate] = num[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.println(remove(nums));
    }
}
