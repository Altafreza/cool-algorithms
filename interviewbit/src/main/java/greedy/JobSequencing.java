package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class JobSequencing {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2, 1, 2, 1, 3}, new int[]{100, 19, 27, 25, 15}));
    }

    private static int maxProfit(int[] a, int[] b) {
        Node[] arr = new Node[a.length];
        int maxDeadline = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            arr[i] = new Node(a[i], b[i]);
            maxDeadline = Math.max(maxDeadline, a[i]);
        }

        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.b - o1.b;
            }
        });

        int res = 0;
        int[] jobs = new int[maxDeadline + 1];

        for(Node n : arr){
            for(int i = n.a; i >= 1; i--){
                if(jobs[i] == 0){
                    jobs[i] = 1;
                    res += n.b;
                    break;
                }
            }
        }

        return res;
    }

     public static class Node {
        //deadline profit
        int a, b;

        Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
