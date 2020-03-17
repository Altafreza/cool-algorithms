package dynamicprograming;

import java.util.*;

public class WordBreak {
    public int wordBreak(String s, ArrayList<String> dict) {
        HashSet<String> set = new HashSet<>(dict);
        // Wrapper required because if not it is always false which is an answer
        // here 3 values are there null, false true;
        Boolean[] dp = new Boolean[s.length()];
        return helper(0, set, s, dp) ? 1 : 0;
    }

    public boolean helper(int idx, HashSet<String> dict, String s, Boolean[] dp) {
        if (dict.contains(s))
            return true;
        if (dp[idx] != null)
            return dp[idx];

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (dict.contains(sub) && helper(i + 1, dict, s.substring(i + 1), dp)) {
                dp[idx] = true;
                return true;
            }
        }
        dp[idx] = false;
        return false;
    }

    class Solution {
        public boolean wordBreak90(String s, List<String> wordDict) {
            // assume s and wordDict are non-empty
            int n = s.length();
            Boolean[] memo = new Boolean[n]; // memo[i] --> S[i...] is breakable or not
            return backtracking(0, s, new HashSet<String>(wordDict), memo);
        }

        private boolean backtracking(int depth, String s, Set<String> wordSet, Boolean[] memo) {
            int n = s.length();
            // accept
            if (depth == n) {
                return true;
            }
            // memoization
            if (memo[depth] != null) { // memo
                return memo[depth];
            }

            for (int i = depth; i < n; ++i) {
                String str = s.substring(depth, i + 1); // substring[depth, i]
                if (wordSet.contains(str) && backtracking(i + 1, s, wordSet, memo)) {
                    memo[depth] = true; // memo
                    return true;
                }
            }

            memo[depth] = false; // memo
            return false;
        }

        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> dict = new HashSet(wordDict);
            HashMap<String, Boolean> dp = new HashMap<String, Boolean>();
            // return helper(s, dict, dp);
            return dpWB(s, dict);
        }

        public boolean wordBreak1(String s, List<String> wordDict) {
            HashSet<String> set = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 0; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    String sub = s.substring(j, i);
                    if (set.contains(sub) && dp[j])
                        dp[i] = true;
                }
            }

            return dp[s.length()];
        }

        public boolean dpWB(String s, Set<String> dict) {
            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[s.length()] = true;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j <= n; j++) {
                    String sub = s.substring(i, j);
                    if (dict.contains(sub) && dp[j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[0];
        }

        public boolean helper(String s, Set<String> dict, HashMap<String, Boolean> dp) {
            if (s.length() == 0)
                return true;
            if (dp.containsKey(s)) {
                return dp.get(s);
            }

            for (int i = 0; i < s.length(); i++) {
                String left = s.substring(0, i);
                String right = s.substring(i);
                if (dict.contains(right) && helper(left, dict, dp)) {
                    dp.put(s, true);
                    return true;
                }
            }
            dp.put(s, false);
            return false;
        }
    }

}
