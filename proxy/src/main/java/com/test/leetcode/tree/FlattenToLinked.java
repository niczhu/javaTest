package com.test.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class FlattenToLinked extends TreeBuilder {

    public static void main(String[] args) {
        doFL1();
        childTreeRight();
    }

    public static void childTreeRight() {
        // 子树的最右边node
        TreeNode root = buildTree();
        TreeNode curr = root;

        while (curr != null) {
            System.out.println("root while");
            if (curr.left != null) {
                TreeNode left = curr.left;

                // 左子树最后右一节点next
                TreeNode predecessor  = left;
                while (predecessor .right != null) {
                    predecessor  = predecessor .right;
                }
                predecessor.right = curr.right;

                curr.left = null;
                curr.right = left;
            }
            // 核心
            curr = curr.right;
        }

        System.out.println(root.right.right.val);

    }

    // 法一
    public static void doFL1() {
        TreeNode treeNode = buildTree();
        List<TreeNode> rest = new ArrayList<>();
        flatten1(treeNode, rest);

        for (int i = rest.size() - 1; i > 0; i--) {
            TreeNode rightNode = rest.get(i);
            TreeNode left = rest.get(i - 1);
            left.right = rightNode;
        }

        for (TreeNode node : rest) {
            if (node != null) {
                int val = -1;
                if (node.right != null) {
                    val = node.right.val;
                } else {
                    val = -1;
                }
                System.out.println(node.val + " -> right _>" + val);
            }
        }
    }

    public static void flatten1(TreeNode root, List<TreeNode> list) {
        if (null != root) {
            list.add(root);
            flatten1(root.left, list);
            flatten1(root.right, list);
        }
    }

}
