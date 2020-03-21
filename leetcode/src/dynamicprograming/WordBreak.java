package dynamicprograming;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak90(String s, ArrayList<String> dict) {
        HashSet<String> set = new HashSet<>(dict);
        // Wrapper required because if not it is always false which is an answer
        // here 3 values are there null, false true;
        Boolean[] dp = new Boolean[s.length()];
        return helper(0, set, s, dp);
    }

    public static boolean helper(int idx, HashSet<String> dict, String s, Boolean[] dp) {
        if (dict.contains(s))
            return true;
        if (dp[idx] != null)
            return dp[idx];

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (dict.contains(sub) && helper(idx + i + 2, dict, s.substring(i + 1), dp)) {
                dp[idx] = true;
                return true;
            }
        }
        dp[idx] = false;
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        // assume s and wordDict are non-empty
        int n = s.length();
        Boolean[] dp = new Boolean[n]; // memo[i] --> S[i...] is breakable or not
        return helper(0, s, new HashSet<String>(wordDict), dp);
    }

    private static boolean helper(int idx, String s, Set<String> wordSet, Boolean[] dp) {
        int n = s.length();
        // accept
        if (idx == n) {
            return true;
        }
        // memoization
        if (dp[idx] != null) { // dp
            return dp[idx];
        }

        for (int i = idx; i < n; ++i) {
            String str = s.substring(idx, i + 1); // substring[idx, i]
            if (wordSet.contains(str) && helper(i + 1, s, wordSet, dp)) {
                dp[idx] = true; // dp
                return true;
            }
        }

        dp[idx] = false; // dp
        return false;
    }

    //direct translation from above top down solution to bottom up
    public static boolean dpWB(String s, Set<String> dict) {
        int n = s.length();
        // dp[i] :: can the string s[i..n] be broken into dict words
        boolean[] dp = new boolean[n + 1];
        dp[s.length()] = true; //
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

    public static boolean wordBreak11(String s, List<String> wordDict) {
        Set<String> dict = new HashSet(wordDict);
        HashMap<String, Boolean> dp = new HashMap<String, Boolean>();
        // return helper(s, dict, dp);
        return dpWB(s, dict);
    }

    public static boolean wordBreak1(String s, List<String> wordDict) {
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


    public static boolean helper(String s, Set<String> dict, HashMap<String, Boolean> dp) {
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

    public static void main(String[] args) {

        // false sub problem is stored in dp is useful
        // be cause it will never be the case that a subproblem will be true and  in turn
        // never have flase subproblem
        System.out.println(wordBreak("catsanddogsk", //true
                new ArrayList<String>(Arrays.asList("cats", "and", "dogs", "k"))));
        System.out.println(wordBreak("aaaaaab", // false case is where dp used
                new ArrayList<String>(Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa",
                        "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"))));
        System.out.println(wordBreak("abbcdd", // true
                new ArrayList<String>(Arrays.asList("a", "bb", "ab", "abc", "cd", "d"))));

        System.out.println(wordBreak("fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami", //true
                new ArrayList<String>(Arrays.asList("kfomka", "hecagbngambii", "anobmnikj", "c", "nnkmfelneemfgcl", "ah", "bgomgohl", "lcbjbg", "ebjfoiddndih", "hjknoamjbfhckb", "eioldlijmmla", "nbekmcnakif", "fgahmihodolmhbi", "gnjfe", "hk", "b", "jbfgm", "ecojceoaejkkoed", "cemodhmbcmgl", "j", "gdcnjj", "kolaijoicbc", "liibjjcini", "lmbenj", "eklingemgdjncaa", "m", "hkh", "fblb", "fk", "nnfkfanaga", "eldjml", "iejn", "gbmjfdooeeko", "jafogijka", "ngnfggojmhclkjd", "bfagnfclg", "imkeobcdidiifbm", "ogeo", "gicjog", "cjnibenelm", "ogoloc", "edciifkaff", "kbeeg", "nebn", "jdd", "aeojhclmdn", "dilbhl", "dkk", "bgmck", "ohgkefkadonafg", "labem", "fheoglj", "gkcanacfjfhogjc", "eglkcddd", "lelelihakeh", "hhjijfiodfi", "enehbibnhfjd", "gkm", "ggj", "ag", "hhhjogk", "lllicdhihn", "goakjjnk", "lhbn", "fhheedadamlnedh", "bin", "cl", "ggjljjjf", "fdcdaobhlhgj", "nijlf", "i", "gaemagobjfc", "dg", "g", "jhlelodgeekj", "hcimohlni", "fdoiohikhacgb", "k", "doiaigclm", "bdfaoncbhfkdbjd", "f", "jaikbciac", "cjgadmfoodmba", "molokllh", "gfkngeebnggo", "lahd", "n", "ehfngoc", "lejfcee", "kofhmoh", "cgda", "de", "kljnicikjeh", "edomdbibhif", "jehdkgmmofihdi", "hifcjkloebel", "gcghgbemjege", "kobhhefbbb", "aaikgaolhllhlm", "akg", "kmmikgkhnn", "dnamfhaf", "mjhj", "ifadcgmgjaa", "acnjehgkflgkd", "bjj", "maihjn", "ojakklhl", "ign", "jhd", "kndkhbebgh", "amljjfeahcdlfdg", "fnboolobch", "gcclgcoaojc", "kfokbbkllmcd", "fec", "dljma", "noa", "cfjie", "fohhemkka", "bfaldajf", "nbk", "kmbnjoalnhki", "ccieabbnlhbjmj", "nmacelialookal", "hdlefnbmgklo", "bfbblofk", "doohocnadd", "klmed", "e", "hkkcmbljlojkghm", "jjiadlgf", "ogadjhambjikce", "bglghjndlk", "gackokkbhj", "oofohdogb", "leiolllnjj", "edekdnibja", "gjhglilocif", "ccfnfjalchc", "gl", "ihee", "cfgccdmecem", "mdmcdgjelhgk", "laboglchdhbk", "ajmiim", "cebhalkngloae", "hgohednmkahdi", "ddiecjnkmgbbei", "ajaengmcdlbk", "kgg", "ndchkjdn", "heklaamafiomea", "ehg", "imelcifnhkae", "hcgadilb", "elndjcodnhcc", "nkjd", "gjnfkogkjeobo", "eolega", "lm", "jddfkfbbbhia", "cddmfeckheeo", "bfnmaalmjdb", "fbcg", "ko", "mojfj", "kk", "bbljjnnikdhg", "l", "calbc", "mkekn", "ejlhdk", "hkebdiebecf", "emhelbbda", "mlba", "ckjmih", "odfacclfl", "lgfjjbgookmnoe", "begnkogf", "gakojeblk", "bfflcmdko", "cfdclljcg", "ho", "fo", "acmi", "oemknmffgcio", "mlkhk", "kfhkndmdojhidg", "ckfcibmnikn", "dgoecamdliaeeoa", "ocealkbbec", "kbmmihb", "ncikad", "hi", "nccjbnldneijc", "hgiccigeehmdl", "dlfmjhmioa", "kmff", "gfhkd", "okiamg", "ekdbamm", "fc", "neg", "cfmo", "ccgahikbbl", "khhoc", "elbg", "cbghbacjbfm", "jkagbmfgemjfg", "ijceidhhajmja", "imibemhdg", "ja", "idkfd", "ndogdkjjkf", "fhic", "ooajkki", "fdnjhh", "ba", "jdlnidngkfffbmi", "jddjfnnjoidcnm", "kghljjikbacd", "idllbbn", "d", "mgkajbnjedeiee", "fbllleanknmoomb", "lom", "kofjmmjm", "mcdlbglonin", "gcnboanh", "fggii", "fdkbmic", "bbiln", "cdjcjhonjgiagkb", "kooenbeoongcle", "cecnlfbaanckdkj", "fejlmog", "fanekdneoaammb", "maojbcegdamn", "bcmanmjdeabdo", "amloj", "adgoej", "jh", "fhf", "cogdljlgek", "o", "joeiajlioggj", "oncal", "lbgg", "elainnbffk", "hbdi", "femcanllndoh", "ke", "hmib", "nagfahhljh", "ibifdlfeechcbal", "knec", "oegfcghlgalcnno", "abiefmjldmln", "mlfglgni", "jkofhjeb", "ifjbneblfldjel", "nahhcimkjhjgb", "cdgkbn", "nnklfbeecgedie", "gmllmjbodhgllc", "hogollongjo", "fmoinacebll", "fkngbganmh", "jgdblmhlmfij", "fkkdjknahamcfb", "aieakdokibj", "hddlcdiailhd", "iajhmg", "jenocgo", "embdib", "dghbmljjogka", "bahcggjgmlf", "fb", "jldkcfom", "mfi", "kdkke", "odhbl", "jin", "kcjmkggcmnami", "kofig", "bid", "ohnohi", "fcbojdgoaoa", "dj", "ifkbmbod", "dhdedohlghk", "nmkeakohicfdjf", "ahbifnnoaldgbj", "egldeibiinoac", "iehfhjjjmil", "bmeimi", "ombngooicknel", "lfdkngobmik", "ifjcjkfnmgjcnmi", "fmf", "aoeaa", "an", "ffgddcjblehhggo", "hijfdcchdilcl", "hacbaamkhblnkk", "najefebghcbkjfl", "hcnnlogjfmmjcma", "njgcogemlnohl", "ihejh", "ej", "ofn", "ggcklj", "omah", "hg", "obk", "giig", "cklna", "lihaiollfnem", "ionlnlhjckf", "cfdlijnmgjoebl", "dloehimen", "acggkacahfhkdne", "iecd", "gn", "odgbnalk", "ahfhcd", "dghlag", "bchfe", "dldblmnbifnmlo", "cffhbijal", "dbddifnojfibha", "mhh", "cjjol", "fed", "bhcnf", "ciiibbedklnnk", "ikniooicmm", "ejf", "ammeennkcdgbjco", "jmhmd",
                        "cek", "bjbhcmda", "kfjmhbf", "chjmmnea", "ifccifn", "naedmco", "iohchafbega", "kjejfhbco", "anlhhhhg"))));
    }

}
