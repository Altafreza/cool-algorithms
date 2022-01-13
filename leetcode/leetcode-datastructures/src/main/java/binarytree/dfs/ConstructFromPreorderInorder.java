package binarytree.dfs;

import commons.TreeNode;

import java.util.HashMap;

public class ConstructFromPreorderInorder {
    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> idxMap = new HashMap<>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            idxMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, n - 1, idxMap);
    }

    //post order traversal // bottom up
    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end, HashMap<Integer, Integer> idxMap) {
        if (start > end) return null;

        Integer rootVal = preorder[preIdx];
        TreeNode root = new TreeNode(rootVal);
        preIdx++; // forward iteration
        // left subrtree is built
        root.left = buildTree(preorder, inorder, start, idxMap.get(rootVal) - 1, idxMap);
        // right subrtree is built
        root.right = buildTree(preorder, inorder, idxMap.get(rootVal) + 1, end, idxMap);

        return root;
    }
}
