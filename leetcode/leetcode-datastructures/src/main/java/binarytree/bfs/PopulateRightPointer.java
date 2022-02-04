package binarytree.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

// This is for perfect binary tree
public class PopulateRightPointer {


    // O(1) space
    public Node connect(Node root) {
        // init row var
        Node temp = root; // since root is to be returned

        while (temp != null) { // iterating each row
            Node curr = temp; // init col var
            while (curr != null) { // iter
                if (curr.left != null) curr.left.next = curr.right; // parent doing for kid
                // level after the root level already has the next pointer set
                if (curr.right != null && curr.next != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            temp = temp.left;

        }
        return root;
    }

    // O(n) space
    public Node connect2(Node root) {
        Deque<Node> q = new ArrayDeque<>();
        if (root == null) return null;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            while (size > 0) {
                Node curr = q.remove();
                if (size == 1) curr.next = null;
                else curr.next = q.peek();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                size--;
            }

        }

        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}

