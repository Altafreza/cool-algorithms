package binarytree.bfs;

public class PopulateRightPointer2 {
    public Node connect1(Node root) {
        // init row var
        Node temp = root; // since root is to be returned

        while (temp != null) { // iterating each row
            Node curr = temp; // init col var
            Node prev = null;
            Node rowHead = null; // we have to hold on to(keep in mem) the first node of the row
            //for iteration to continue unlike for perfect tree where temp = temp.left
            while (curr != null) { // iter
                if (curr.left != null) {
                    if (prev != null) { // means we have a prev node a left/right in the same row
                        prev.next = curr.left; // coz curr.right is not null its the new prev
                    } else {
                        rowHead = curr.left;
                    }
                    prev = curr.left;

                }
                if (curr.right != null) {
                    if (prev != null) {
                        prev.next = curr.right; // set the prev pointer to curr.right
                    } else {
                        rowHead = curr.right; // if prev is null yet meaning the curr.next is the head of the next level
                    }
                    prev = curr.right; // coz curr.right is not null its the new prev
                }
                curr = curr.next;
            }
            temp = rowHead;
        }
        return root;
    }

    //based on level order traversal
    public Node connect(Node root) {

        Node head = null; //head of the next level
        Node prev = null; //the leading node on the next level
        Node cur = root;  //current node of current level

        while (cur != null) {

            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }

            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
        return root;
    }
}
