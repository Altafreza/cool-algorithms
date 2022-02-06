package binarytree.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

// This is for perfect binary tree
public class PopulateRightPointer {

    // inorder recursive
    public  Node connectInorder(Node root) {
        rightSiblingTree(root, null, false);
        return root;
    }

    // inorder traversal
    private  void rightSiblingTree(Node node, Node parent, boolean isLeftChild) {
        if (node == null) return;

        Node left = node.left, right = node.right;

        rightSiblingTree(left, node, true);

        // I am done with my left subtree
        // now dealing with myself
        if (parent == null) node.next = null;
        else  if (isLeftChild) node.next = parent.right;
        else{ // if this node is a right child
            if (parent.next == null) node.next = null; //for right children special case
            else node.next = parent.next.left; // my parent is done because of inorder
            // because parent is inorder predecessor

        }
        rightSiblingTree(right, node, false);
    }
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

