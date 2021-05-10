package com.test.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeByPreMid extends TreeBuilder {

    private Map<Integer, Integer> inOrderMap;

    /**
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        inOrderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return buildChildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }


    public TreeNode buildChildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;

        int preRoot = preLeft;
        TreeNode root = new TreeNode(preorder[preRoot]);

        int inRoot = inOrderMap.get(preorder[preRoot]);
        int leftTreeCount = inRoot - inLeft;

        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = buildChildTree(preorder, inorder, preLeft + 1, preLeft + leftTreeCount, inLeft, inRoot - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = buildChildTree(preorder, inorder, preLeft + leftTreeCount + 1, preRight, inRoot + 1, inRight);
        return root;
    }


    public static TreeNode getLeft(int[] preorder, int[] inorder, int preRootIndex, int inRootIndex, int leftCount, int rightCount) {
        if (leftCount <= 1 && rightCount <= 1) return null;

        TreeNode root = new TreeNode(preorder[preRootIndex]);

        int newPreRootIndex = preRootIndex + 1;
        int newInRootIndex = getInOrderMap(inorder).get(preorder[newPreRootIndex]);
        int newRightCount = inRootIndex - newInRootIndex;
        int newLeftCount = newInRootIndex;

        TreeNode left = getLeft(preorder, inorder, newPreRootIndex, newInRootIndex, newLeftCount, newRightCount);

        return root;

    }


    public static Map<Integer, Integer> getInOrderMap(int[] inOder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOder.length; i++) {
            map.put(inOder[i], i);
        }
        return map;
    }


}
