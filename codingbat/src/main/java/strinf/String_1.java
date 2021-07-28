package strinf;

import java.util.ArrayList;
import java.util.List;

public class String_1 {
    public static void main(String[] args) {
        String a = "abcdefghi";
        System.out.println(a);
        System.out.println();
        /*System.out.println(getSubstring(a.toCharArray(), 'f', 'i'));
        System.out.println();
        System.out.println(xToBeforeY(a.toCharArray(), 'b', 'g'));
        System.out.println();
        System.out.println(afterXtoY(a.toCharArray(), 'b', 'h'));
        System.out.println();
        System.out.println(substringWithout(a.toCharArray(), 'c', 'f'));
        System.out.println();*/
        System.out.println(distApart(a.toCharArray(), 4));
    }

    private static List<String> distApart(char[] s, int d) {
        System.out.printf("distApart ::: s: %s -> dist: %d%n", String.valueOf(s), d);
        List<String> res = new ArrayList<>();
        for (int p = 0; p < s.length - d - 1; p++) {
            String a = String.valueOf(s[p]) + String.valueOf(s[p + 5]);
            res.add(a);
        }
        return res;
    }

    private static String substringWithout(char[] s, char x, char y) {
        System.out.println("substringWithout ::: " + x + " " + y);
        int i = 0, j = 0;
        for (int p = 0; p < s.length; p++) {
            if (s[p] == x) {
                i = p;
            } else if (s[p] == y) {
                j = p;
            }
        }
        String res = "";
        for (int p = i + 1; p < j; p++) {
            res += s[p];
        }
        System.out.println("j: " + j + "::: i: " + i);
        int len = j - 1 - i;
        return "str: " + res + " ::: len: " + len;
    }

    static String getSubstring(char[] s, char x, char y) {
        System.out.println("getSubstring ::: " + x + " " + y);
        int i = 0, j = 0;
        for (int p = 0; p < s.length; p++) {
            if (s[p] == x) {
                i = p;
            } else if (s[p] == y) {
                j = p;
            }
        }
        String res = "";
        for (int p = i; p <= j; p++) {
            res += s[p];
        }
        System.out.println("j: " + j + "::: i: " + i);
        int len = j - i + 1;
        return "str: " + res + " ::: len: " + len;
    }


    static String xToBeforeY(char[] s, char x, char y) {
        System.out.println("xToBeforeY ::: " + x + " " + y);
        int i = 0, j = 0;
        for (int p = 0; p < s.length; p++) {
            if (s[p] == x) {
                i = p;
            } else if (s[p] == y) {
                j = p;
            }
        }
        String res = "";
        for (int p = i; p < j; p++) {
            res += s[p];
        }
        System.out.println("j: " + j + "::: i: " + i);
        int len = j - i;
        return "str: " + res + " ::: len: " + len;
    }


    static String afterXtoY(char[] s, char x, char y) {
        System.out.println("afterXtoY ::: " + x + " " + y);
        int i = 0, j = 0;
        for (int p = 0; p < s.length; p++) {
            if (s[p] == x) {
                i = p;
            } else if (s[p] == y) {
                j = p;
            }
        }
        String res = "";
        for (int p = i + 1; p <= j; p++) {
            res += s[p];
        }
        System.out.println("j: " + j + "::: i: " + i);
        int len = j - i;
        return "str: " + res + " ::: len: " + len;
    }
}
