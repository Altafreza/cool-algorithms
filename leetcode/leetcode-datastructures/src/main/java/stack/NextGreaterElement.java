package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class NextGreaterElement {
    public static void main(String[] args) {
        System.out.println(new NextGreaterElement().nextGrearterElements(new int[]{2, 1, 3}).toString());
        new NextGreaterElement().nextGreaterElementLeetcode(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }

    public int[] nextGrearterElements(int[] a) {
        Deque<Integer> s = new ArrayDeque<>();
        int[] res = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                res[i] = -1;
                s.push(a[i]);
                continue;
            }
            while (!s.isEmpty() && s.peek() <= a[i]) s.pop();
            res[i] = s.peek();
            s.push(a[i]);
        }
        return res;
    }

    // next greater element of the elements of 'query' in 'a'
    // 'query' is a subset of 'a'
    public int[] nextGreaterElementLeetcode(int[] query, int[] a) {
        Deque<Integer> s = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[query.length];
        for (int i = a.length - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                map.put(a[i], -1);
                s.push(a[i]);
                continue;
            }

            while (!s.isEmpty() && s.peek() <= a[i]) s.pop();
            if (s.isEmpty()) map.put(a[i], -1);
            else map.put(a[i], s.peek());

            s.push(a[i]);
        }

        for (int i = 0; i < query.length; i++) {
            res[i] = map.get(query[i]);
        }
        return res;
    }
}
