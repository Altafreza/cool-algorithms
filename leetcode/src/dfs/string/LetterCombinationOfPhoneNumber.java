package dfs.string;

import java.util.*;

public class LetterCombinationOfPhoneNumber {
    HashMap<Character, List<Character>> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        if (digits.length() == 0) return new ArrayList<>();

        helper(map, digits.toCharArray(), 0, new StringBuilder());
        return res;
    }

    private void helper(HashMap<Character, List<Character>> map, char[] digits, int pos, StringBuilder sb) {
        if (pos == digits.length) {
            res.add(sb.toString());
            return;
        }

        char ch = digits[pos];
        List<Character> letters = map.get(ch);

        for (int i = 0; i < letters.size(); i++) {
            helper(map, digits, pos + 1, sb.append(letters.get(i)));
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public static void main(String[] args) {
        new LetterCombinationOfPhoneNumber().letterCombinations("23");
        int a = 0;
        System.out.println("asmjd");
    }
}
