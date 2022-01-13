package binarysearchtree;

import commons.TreeNode;
import utils.TreeUtils;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElement {
    int k = 0;
    int res = 0;
    int count = 0;

    public static void main(String[] args) {
        TreeNode root = TreeUtils.constructBinaryTree(Arrays.asList(new Integer[]{3, 1, 4, null, 2}));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));

        new KthSmallestElement().kthSmallest1(root, 2, pq);
        System.out.println(pq.poll());
    }

    /*
     * Traverse the bst preorder keep adding to heap
     * when size is more than k remove max element
     * the max at the end is the kth smallest because all the
     * below elements in the heap are smaller to it*/
    private void kthSmallest1(TreeNode root, int k, PriorityQueue<Integer> pq) {
        if (root == null) return;
        pq.add(root.val);

        if (pq.size() > k) pq.poll();

        kthSmallest1(root.left, k, pq);
        kthSmallest1(root.right, k, pq);
    }

    // inorder traversal
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        //return dfs(root);
        dfs2(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        if (k == 0) return left;
        k--;
        if (k == 0) return root.val;
        return dfs(root.right);
    }

    // inorder traversal
    public void dfs2(TreeNode root) {
        if (root == null) return;
        dfs2(root.left);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }
        dfs2(root.right);
    }
}
