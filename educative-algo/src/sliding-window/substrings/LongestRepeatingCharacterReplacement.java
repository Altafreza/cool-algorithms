package substrings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Optional;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        System.out.println(LongestRepeatingCharacterReplacement.findLength("aabccbb", 2)); //5
        System.out.println(LongestRepeatingCharacterReplacement.findLength("abbcb", 1)); //4
        System.out.println(LongestRepeatingCharacterReplacement.findLength("AABABAA", 1)); //4

    }
    /* a, aa, aab, aaba
    * abab,
    * baba
    * abaa*/

    private static int findLength(String s, int k) {
        int winstart = 0, maxlen = 0;
        Optional<Integer> maxRepeatLetterCount = Optional.of(0);
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int winend = 0; winend < s.length(); winend++) {
            char rightChar = s.charAt(winend);
            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);
            // majority element updated
            maxRepeatLetterCount = freq.values().stream().max(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            // we remove from the lc we are sure that any solution
            // starting from l is not feasible and
            // if I get a feasible solution on 'r' i dont move 'l'
            // for the hope of better
            while (winend - winstart + 1 - maxRepeatLetterCount.get() > k) {
                char left = s.charAt(winstart);
                freq.put(left, freq.get(left) - 1); // leaving the majority/non majority element
                //

                winstart++;
                maxRepeatLetterCount = freq.values().stream().max(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                });
            }

            //capture solution
            maxlen = Math.max(maxlen, winend - winstart + 1);
        }

        return maxlen;

    }

}
