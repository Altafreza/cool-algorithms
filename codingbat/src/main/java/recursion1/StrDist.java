package recursion1;

public class StrDist {
    public static int strDist(String str, String sub) {
        if (str.length() < sub.length())
            return 0;

        if (str.substring(0, sub.length()).equals(sub) &&
                str.substring(str.length() - sub.length()).equals(sub))
            return str.length();

        if (!str.substring(0, sub.length()).equals(sub))
            return strDist(str.substring(1), sub);

        return strDist(str.substring(0, str.length() - 1), sub);
    }
    public int strDist1(String str, String sub) {
        if (str.length() < sub.length()) {
            return 0;
        }
        if (str.startsWith(sub)) {
            if (str.endsWith(sub)) {
                return str.length();
            } else {
                return strDist(str.substring(0, str.length() - 1), sub);
            }
        } else {
            return strDist(str.substring(1), sub);
        }
    }
    public static void main(String[] args) {
        System.out.println(strDist("catcowcat", "cat"));
        System.out.println(strDist("catcowcat", "cow"));
        System.out.println(strDist("cccatcowcatxx", "cat"));
    }
}
