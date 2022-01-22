package dynamicprograming.subsetdp;

public class DistinctSubsequence2 {
    public static void main(String[] args) {
        System.out.println(new DistinctSubsequence2().distinctSubseqII("abc"));
    }
    public int distinctSubseqII(String s) {
        return helper(s, 0);
    }

    private int helper(String s, int i) {
        if(i == s.length()) return 1;

        int count = helper(s, i+1) + helper(s, i+1);
        return count;
    }
}
