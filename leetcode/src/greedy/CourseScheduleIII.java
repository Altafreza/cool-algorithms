package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * find the maximum courses whcich can be taken
 * given array of (duration, deadline)*/
public class CourseScheduleIII {
    // sort array on the basis of deadline
    // for each course
    // two options
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        // max heap to store duration
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int prevfinTime = 0;
        for (int[] a : courses) {
            if (prevfinTime + a[0] <= a[1]) { // non overlapping
                heap.add(a[0]);
                prevfinTime += a[0];
                // in case of overlap :: meaning fin + duration > deadline
                // so we will replace this course with the course with max duration
                // so that going forward we have more time for other courses
            } else if (!heap.isEmpty()) {
                Integer maxDuration = heap.peek();
                if (maxDuration > a[0]) {
                    heap.poll();

                    heap.add(a[0]);
                    prevfinTime = prevfinTime - maxDuration + a[0];
                }
            }
        }
        return heap.size();
    }

}
