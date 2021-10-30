package substrings;

import java.util.HashMap;

// longest substring with no repeating characters
public class NonRepeatingSubstring {
    public static int lengthOfLongestSubstring(String s) {

        // stores the char pos of the chars inside the window
        HashMap<Character, Integer> charPos = new HashMap<Character, Integer>();
        int l = 0, maxlen = 0;

        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);


            // because all those are not feasible solutions as well
            // we start the new solution after the earlier occurance of rc
            // or the current start point of the solution
            if (charPos.containsKey(rc)) {
                l = Math.max(charPos.get(rc) + 1, l); // earlier occurance or the
                // larger of the two
            }
            // and store the new start position
            charPos.put(rc, r);
            // solution using the curr left and right
            maxlen = Math.max(maxlen, r - l + 1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("tmmzuxt");
    }
}
