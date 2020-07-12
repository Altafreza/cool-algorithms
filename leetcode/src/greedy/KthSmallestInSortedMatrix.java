package greedy;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}};

        System.out.println(kthSmallest(a, 6));

    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        // in max heap of size k
        // the max element is the kth smallest element
        // because all the k -1 elements are smaller than it and
        //  the array is populated
        // meaning at the end on k smallest elements are left
        // out of which max is the kth smallest
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                heap.add(matrix[i][j]);
                if (heap.size() > k) {
                    heap.poll();
                }
            }
        }
        return heap.peek();
    }
}
