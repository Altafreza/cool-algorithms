package binarytree.bfs;

import commons.TreeNode;

import java.util.*;

import static utils.TreeUtils.constructBinaryTree;
import static utils.TreeUtils.postorderTraversal;

public class ZigzagTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> q1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> q2 = new LinkedList<TreeNode>();
        boolean asc = true;
        q1.add(root);
        List<Integer> list = new ArrayList<Integer>();
        while (!q1.isEmpty()) {
            TreeNode t = q1.poll();
            if (asc) {
                list.add(t.val);
            } else {
                list.add(0, t.val);
            }

            if (t.left != null) {
                q2.offer(t.left);
            }
            if (t.right != null) {
                q2.offer(t.right);
            }

            if (q1.isEmpty()) {
                result.add(list);
                list = new ArrayList<Integer>();
                LinkedList<TreeNode> temp = q1;
                q1 = q2;
                q2 = temp;
                asc = !asc;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode treeNode = constructBinaryTree(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}));
//        List<Integer> list = postorderTraversal(treeNode);
//        System.out.println(list);
        List<List<Integer>> zigzagLevelOrder = zigzagLevelOrder(treeNode);

    }

}
