package heap;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumRopeCost {
    public class Solution {
        public int solve(int[] A) {
            PriorityQueue<Integer> heap = new PriorityQueue<>();
            int sum = 0;
            for(int a : A){
                heap.add(a);
            }
            while(!heap.isEmpty()){
                sum += heap.poll() + heap.poll();
            }
            return  sum;
        }
    }

}
