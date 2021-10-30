package sliding_window.substring;

import java.util.HashMap;

public class LongestSubstringAtmostKDistinctChars {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("araaci", 2));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        // frequency array to store the freq of each char in the window

        HashMap<Character, Integer> winFreq = new HashMap<Character, Integer>();
        int winstart = 0, maxlen = 0;

        for (int winend = 0; winend < s.length(); winend++) {
            char right = s.charAt(winend);
            winFreq.put(right, winFreq.getOrDefault(right, 0) + 1);

            // we keep removing from the freq until there are k distinct chars
            // the ques is to have k distinct chars so it can happen that rc
            // is not destroying the 'k' distinctivity of substring
            // so removing all untill  'k' distinctivity is achieved
            // because all those are not feasible solutions as well
            while (winFreq.size() > k) {
                char left = s.charAt(winstart);
                winFreq.put(left, winFreq.get(left) - 1);
                if (winFreq.get(left) == 0) {
                    winFreq.remove(left);
                }
                winstart++;
            }

            maxlen = Math.max(maxlen, winend - winstart + 1);
        }
        return maxlen;
    }
}
