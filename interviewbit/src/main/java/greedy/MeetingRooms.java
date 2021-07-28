package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
    public static int solve(int[][] intervals) {
        if (intervals == null || intervals.length < 1)
            return 1;
        //Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(); //heap

        for (int i = 0; i < intervals.length; i++) {
            if (!pq.isEmpty() && pq.peek() <= intervals[i][0]) {
                pq.remove();
            }
            pq.add(intervals[i][1]);
        }


        return pq.size();
    }

    public static void main(String[] args) {
        System.out.println(solve(new int[][]{{1, 18}, {18, 23}, {15, 29}, {4, 15}, {2, 11}, {12, 13}}));
    }
}
