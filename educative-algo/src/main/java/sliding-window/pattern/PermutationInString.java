package pattern;

import java.util.HashMap;

public class PermutationInString {
    public static boolean checkInclusion(String p, String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : p.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int l = 0, matched = 0;

        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            if (freq.containsKey(rc)) {
                freq.put(rc, freq.getOrDefault(rc, 0) - 1);
                if (freq.get(rc) == 0) {
                    matched++; // exhausting the pattern chars in the curr 'r' walk
                }
            }


            // capture solution
            if (matched == freq.size()) {
                return true;
            }

            // check feasibility of curr window
            // and go ahead for new solution
            if (r - l + 1 >= p.length()) {
                char lc = s.charAt(l);
                l++;
                if (freq.containsKey(lc)) { // if lc is thrown out of the win
                    if (freq.get(lc) == 0) {
                        matched--; // lc has not matched  so putting it back to the pattern map
                    }
                    freq.put(lc, freq.getOrDefault(lc, 0) + 1);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        checkInclusion("ab", "eidboaoo"); // false
    }
}
