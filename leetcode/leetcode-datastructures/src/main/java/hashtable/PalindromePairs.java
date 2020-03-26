package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {
    public static List<List<Integer>> palindromePairs(String[] words)
    {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (words == null || words.length == 0)
            return res;

        //build the map save the key-val pairs: String - idx
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++)
            map.put(words[i], i);

        //special cases: "" can be combine with any palindrome string
        if (map.containsKey(""))
        {
            int idx = map.get("");
            for (int i = 0; i < words.length; i++)
            {
                if (isPalindrome(words[i], 0, words[i].length()-1))
                {
                    if (i == idx) continue;		// can not be itself
                    res.add(Arrays.asList(idx, i));
                    res.add(Arrays.asList(i, idx));
                }
            }
        }

        //find all string and reverse string pairs
        for (int i = 0; i < words.length; i++)
        {
            String reverse = reverseStr(words[i]);
            if (map.containsKey(reverse))
            {
                int found = map.get(reverse);
                if (found == i) continue;
                res.add(Arrays.asList(i, found));
            }
        }

        //find the pair s1, s2 that
        //case1 : s1[0:cut] is palindrome and s1[cut+1:] = reverse(s2) => (s2, s1)
        //case2 : s1[cut+1:] is palindrome and s1[0:cut] = reverse(s2) => (s1, s2)
        for (int i = 0; i < words.length; i++)
        {
            String word = words[i];
            for(int cut = 1; cut < word.length(); cut++)
            {
                if(isPalindrome(word, 0, cut-1))
                {
                    String reverse = reverseStr(word.substring(cut));
                    if(map.containsKey(reverse)){
                        int found = map.get(reverse);
                        if(found == i) continue;
                        res.add(Arrays.asList(found, i));
                    }
                }

                if(isPalindrome(word, cut, word.length()-1))
                {
                    String reverse = reverseStr(word.substring(0, cut));
                    if(map.containsKey(reverse)){
                        int found = map.get(reverse);
                        if(found == i) continue;
                        res.add(Arrays.asList(i, found));
                    }
                }
            }
        }

        return res;
    }

    private static String reverseStr(String str)
    {
        StringBuilder sb= new StringBuilder(str);
        return sb.reverse().toString();
    }

    private static boolean isPalindrome(String word, int i, int j)
    {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"}));
    }
}
class Solution {
    public static ArrayList<ArrayList<Integer>> palindromePairs(ArrayList<String> words) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int k = 0; k < words.size(); k++) {
            String s = words.get(k);
            map.put(s, k);
        }

        for (int k = 0; k < words.size(); k++) {
            String s = words.get(k);
            if (isPalindrome(s) && map.containsKey("")) {
                int j = map.get("");
                if(j != k){
                    res.add(new ArrayList<>(Arrays.asList(k, j)));
                    res.add(new ArrayList<>(Arrays.asList(j, k)));}
            }
            for (int i = 0; i < s.length(); i++) {
                StringBuilder sub = new StringBuilder(s.substring(0, i + 1));
                Integer j = map.get(sub.reverse().toString());
                if (j != null && j != k && isPalindrome(s.substring(i + 1))) {
                    //if (!res.contains(Arrays.asList(k, j)))
                    res.add(new ArrayList<>(Arrays.asList(k, j)));
                }
                StringBuilder sub1 = new StringBuilder(s.substring(i));
                Integer l = map.get(sub1.reverse().toString());
                if (l != null && l != k && isPalindrome(s.substring(0, i))) {
                    if (!res.contains(Arrays.asList(l, k)))
                        res.add(new ArrayList<>(Arrays.asList(l, k)));
                }
            }
        }
        return res;
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }

        }

        return true;
    }

}
