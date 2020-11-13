package greedy;

public class aditiconsulting {
    public static void main(String[] args) {
        System.out.println("as");
        Integer a = 10, b = 20;

        a += b; //30
        b = a - b; // 10
        a = a - b; //20


        //swap(a, b);

        // 101 011 5 4
//        a = a ^ b; //010
//        a ^ a; // 111

        String s = "cricketermuddassir", q ="cognizantmuddassirjava";

        int[][] dp = new int[s.length() + 1][q.length() + 1];
        // ""  "asdad"
        for(int i = 1; i < s.length(); i++){
            for(int j = 1; j < q.length(); j++){
                if(s.charAt(i) == q.charAt(j)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[s.length()][q.length()]);

        //System.out.println(a + " " + b);
    }

    private static void swap(Integer a, Integer b) {

    }
}
