package dynamicprograming.stringdp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreakII {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String>[] dp = new List[s.length()];
        return helper(0, s, new HashSet<String>(wordDict), dp);
    }

    private static List<String> helper(int idx, String s, HashSet<String> dict, List<String>[] dp) {

        List<String> curr = new ArrayList<>();
        if (idx == s.length()) {
            curr.add("");
            return curr;
        }
        if (dp[idx] != null) return dp[idx];

        // suppose if there 3 word broken answer from this point idx
        // *1*it will store all of the so that the previous answer will add all thee suffiixes to the sub
        // that's brilliant
        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i + 1);
            if (dict.contains(sub)) {
                List<String> suffixWords = helper(i + 1, s, dict, dp);
                for (String suffx : suffixWords) {
                    // *1* this was what me self talking about
                    curr.add(sub + (!suffx.equals("") ? " " + suffx : suffx));
                }

            }
        }
        dp[idx] = curr;
        return curr;
    }
}
