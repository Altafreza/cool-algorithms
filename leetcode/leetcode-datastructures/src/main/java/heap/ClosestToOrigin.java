package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosestToOrigin {
    public static int[][] kClosest1(int[][] points, int K) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > K)
                heap.poll();
        }

        return heap.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
      /*  System.out.println(kClosest1(new int[]{
                {1, 3}, {-2, 2}
        }), 1);*/
    }

    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<ArrayList<Integer>> heap = new PriorityQueue<>(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                double dist1 = Math.sqrt(Math.pow(o1.get(0), 2) + Math.pow(o1.get(1), 2));
                double dist2 = Math.sqrt(Math.pow(o2.get(0), 2) + Math.pow(o2.get(1), 2));
                return Double.compare(dist1, dist2);
            }
        });
        heap.addAll(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < B; i++) {
            res.add(heap.poll());
        }
        return res;
    }

    public int[][] kClosest(int[][] a, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double dist1 = Math.sqrt(Math.pow(o1[0], 2) + Math.pow(o1[1], 2));
                double dist2 = Math.sqrt(Math.pow(o2[0], 2) + Math.pow(o2[1], 2));
                return Double.compare(dist1, dist2);
            }
        });
        heap.addAll(Arrays.asList(a));
        int[][] res = new int[a.length][a[0].length];
        for (int i = 0; i < k; i++) {
            res[i] = (heap.poll());
        }
        return res;
    }
}
