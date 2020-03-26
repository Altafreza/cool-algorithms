package stack;

import java.util.ArrayList;
import java.util.List;

class MinStackList {
    List<Long> stack;
    Long currMin;

    /**
     * initialize your data structure here.
     */
    public MinStackList() {
        stack = new ArrayList<>();
        currMin = 0L;
    }


    public void push(int x) {
        if (stack.isEmpty()) currMin = Long.valueOf(x);
        if (x < currMin) {
            stack.add(Long.valueOf(x - currMin + x));
            this.currMin = Long.valueOf(x);
        } else {

            stack.add(Long.valueOf(x));
        }
    }

    public void pop() {
        Long top = stack.remove(stack.size() - 1);
        if (top < currMin) {
            currMin = 2 * currMin - top;
        }
    }

    public int top() {
        Long peek = stack.get(stack.size() - 1);
        if (peek < currMin) return currMin.intValue();
        return peek.intValue();
    }

    public int getMin() {
        return this.currMin.intValue();
    }
}
