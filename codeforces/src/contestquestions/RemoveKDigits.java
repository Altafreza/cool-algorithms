package contestquestions;

import java.math.BigInteger;
import java.util.HashMap;

public class RemoveKDigits {
    public String solve(String a, int b) {
        HashMap<String,String> dp = new HashMap<>();
        String res = helper(a, b, 0, dp);

        return String.valueOf(new BigInteger(res));
    }

    public String helper(String a, int b, int i, HashMap<String, String> dp){
        if(i == a.length()) return "0";
        if(b == 0) return a.substring(i);

        if(dp.get(i+"_"+b) != null) return dp.get(i+"_"+b);
        String op1 = a.charAt(i) + helper(a, b, i + 1, dp) ;

        String op2 = helper(a, b - 1, i + 1, dp);
        String ans = "";
        BigInteger bi1 = new BigInteger(op1);
        BigInteger bi2 =new BigInteger(op2);
        if(bi1.compareTo(bi2) == -1 ){
            ans = op1;
        } else ans = op2;

        dp.put(i+"_"+b, ans);
        return ans;
    }
}
