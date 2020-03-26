package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


class MinStack {
    Deque<Long> stack;
    Long currMin;

    public MinStack() {
        stack = new ArrayDeque<>();
        currMin = 0L;
    }

    public static void main(String[] args) {
        /*["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
          [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]*/
        MinStack m = new MinStack();
        m.push(2147483646);
        m.push(2147483646);
        m.push(2147483647);
        System.out.println(m.top());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        m.push(2147483647);
        System.out.println(m.top());
        System.out.println(m.getMin());
        m.push(-2147483648);
        System.out.println(m.top());
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());

    }



    /*
     * Store the previous min in the current push(x)
     * since x is new min,
     */
    public void push(int x) {
        if (stack.isEmpty()) currMin = Long.valueOf(x);
        if (x < currMin) {
            stack.push(Long.valueOf(x - currMin + x));
            this.currMin = Long.valueOf(x);
        } else {
            stack.push(Long.valueOf(x));
        }
    }

    // Pop requires assigning currMin
    public void pop() {
        Long top = stack.pop();
        if (top < currMin) { // this will only store the prev minimum
            // because it has the masked prev min value in it
            // maskedval = 2*val - old_min
            //
            currMin = 2 * currMin - top;
        }
    }

    public int top() {
        Long peek = stack.peek();
        if (peek < currMin) return currMin.intValue();
        return peek.intValue();
    }

    public int getMin() {
        return this.currMin.intValue();
    }
}
