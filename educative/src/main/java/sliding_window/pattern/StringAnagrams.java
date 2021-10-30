package sliding_window.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StringAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        int l = 0, matches = 0;
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : p.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for (int r = 0; r < s.length(); r++) {
            char rc = s.charAt(r);
            if (freq.containsKey(rc)) {
                freq.put(rc, freq.get(rc) - 1);
                if (freq.get(rc) == 0) {
                    matches++; // this char is fully available
                }
            }

            // capture answer
            if (matches == freq.size()) {
                res.add(l);
            }

            // feasibility failing
            // moving to new answer
            if (r - l + 1 >= p.length()) {
                char lc = s.charAt(l);
                l++;
                if (freq.containsKey(lc)) {
                    if (freq.get(lc) == 0) { // this char made a comeback
                        matches--; // its flag is subtracted from the count
                    }
                    freq.put(lc, freq.get(lc) + 1);// next solution will have this char in answer
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc"); // [0, 6]
    }
}
