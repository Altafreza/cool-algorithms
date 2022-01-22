package binarytree.dfs;

import commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        rightSideView(root, 0, res);
        return res;
    }

    public void rightSideView(TreeNode root, int level, ArrayList list) {
        if (root == null) return;

        if (list.size() == level)
            list.add(root.val);

        rightSideView(root.right, level + 1, list);
        rightSideView(root.left, level + 1, list);
    }
}
