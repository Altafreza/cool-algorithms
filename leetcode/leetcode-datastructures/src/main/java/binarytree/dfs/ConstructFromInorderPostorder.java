package binarytree.dfs;

import commons.TreeNode;

import java.util.HashMap;

public class ConstructFromInorderPostorder {
    int postIdx = 0; //Global Index

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> idxMap = new HashMap<>();
        int n = inorder.length;
        postIdx = n - 1;
        for (int i = 0; i < n; i++) {
            idxMap.put(inorder[i], i);
        }

        return buildTree(inorder, postorder, 0, n - 1, idxMap);
    }

    // post order traversal ||
    public TreeNode buildTree(int[] inorder, int[] postorder, int start, int end,
                              HashMap<Integer, Integer> idxMap) {
        if (start > end) return null;


        Integer rootVal = postorder[postIdx];
        TreeNode root = new TreeNode(rootVal);
        postIdx--; // backward iteration
        // right subrtree is built
        root.right = buildTree(inorder, postorder, idxMap.get(rootVal) + 1, end, idxMap);
        // left subrtree is built
        root.left = buildTree(inorder, postorder, start, idxMap.get(rootVal) - 1, idxMap);

        return root;
    }
}
