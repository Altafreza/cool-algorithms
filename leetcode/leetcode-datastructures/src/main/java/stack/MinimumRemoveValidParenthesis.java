package stack;

import java.util.Stack;

public class MinimumRemoveValidParenthesis {
    public static void main(String[] args) {
        new MinimumRemoveValidParenthesis().minRemoveToMakeValid("))((");
    }

    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> st = new Stack();
        int i = 0;
        while (i < sb.length()) {
            if (sb.charAt(i) == '(') st.add(i);
            if (sb.charAt(i) == ')') {
                if (!st.empty() && st.peek() >= 0) st.pop();
                else {
                    sb.deleteCharAt(i);
                    continue;
                }
            }
            i++;
        }
        while (!st.empty())
            sb.deleteCharAt(st.pop());
        return sb.toString();
    }
}
