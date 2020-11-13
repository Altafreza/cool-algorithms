package greedy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class Rakutentest {
/*
    a,a,b,b,b,c,c,d,d,d,d
    Expected Result -
    a,a,c,c,b,b,b,d,d,d,d
*/

    public static void main(String[] args) {
//        System.out.println("hbasdh");
        StringBuilder sb = new StringBuilder(null);
        //StringUtils
        sb.append("adbsh");
        System.out.println(sb.toString());
        String s = "aabbbccdddd";
        TreeMap<Character, Integer> map = new TreeMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        TreeMap<Character, Integer> characterIntegerTreeMap = sortOnFreq(map);
        characterIntegerTreeMap.putAll(map);
        //for()
    }

    public static TreeMap<Character, Integer> sortOnFreq(TreeMap<Character, Integer> map){
        TreeMap<Character, Integer> temp = new TreeMap<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                if(map.get(o1) == map.get(o2)){
                    return o1.compareTo(o2);
                }
                return map.get(o1) - map.get(o2);
            }
        });
        return temp;
    }
}
