package com.test.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest extends TreeBuilder {

    public static void main(String[] args) {
        TreeNode root = buildTree();
        List<Integer> rest = new ArrayList<>();
        kthSmallest(root, rest);

        sout(rest);
    }

    // BST二叉搜索树  左 小于 右
    // bst 中序排列访问生成自增数组
    public static List<Integer> kthSmallest(TreeNode root, List<Integer> rest) {
        if (root == null) return rest;
        kthSmallest(root.left, rest);
        rest.add(root.val);
        kthSmallest(root.right, rest);
        return rest;
    }

}
