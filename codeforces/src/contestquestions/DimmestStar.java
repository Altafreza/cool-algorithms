package contestquestions;

import java.util.*;

class DimmestStar {
    static Integer res = 0;
    static Integer maxLev = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            Map<Integer, List<Integer>> adj = new HashMap<>();
            int x = 0, y = 0;
            for (int j = 0; j < n - 1; j++) {
                x = sc.nextInt();
                y = sc.nextInt();

                if (adj.get(x) == null)
                    adj.put(x, new ArrayList<>());
                adj.get(x).add(y);
            }
            int b = sc.nextInt();
            findDimmest(adj, b, 0);
            System.out.println(res);
        }
    }

    private static Integer findDimmest1(Map<Integer, List<Integer>> adj, int b, int lev) {

        Integer res = 0;
        Integer maxLev = Integer.MIN_VALUE;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.push(b);

        while (!dq.isEmpty()) {
            Integer pop = dq.pop();
            if (lev > maxLev) {
                res = pop;
                maxLev = lev;
            }
            if (adj.get(pop) == null) {
                continue;
            }
            lev++;
            for (int x : adj.get(pop)) {
                dq.push(x);
            }
        }

        return res;

    }

    private static void findDimmest(Map<Integer, List<Integer>> adj, int b, int lev) {
        if (lev >= maxLev) {
            res = b;
            maxLev = lev;
        }
        if (adj.get(b) == null) return;


        for (int x : adj.get(b)) {
            findDimmest(adj, x, lev + 1);
        }


    }
}
