package com.test.leetcode.tree;

import com.alibaba.fastjson.JSON;
import jdk.nashorn.internal.objects.annotations.Getter;

public class TreeBuilder {

    public static LevelOrderTree.TreeNode buildTree() {
        //3,9,20,5,13,15,7
        LevelOrderTree.TreeNode root1 = new LevelOrderTree.TreeNode(3);
        LevelOrderTree.TreeNode root2 = new LevelOrderTree.TreeNode(9);
        LevelOrderTree.TreeNode root21 = new LevelOrderTree.TreeNode(5);
        LevelOrderTree.TreeNode root22 = new LevelOrderTree.TreeNode(13);
        LevelOrderTree.TreeNode root3 = new LevelOrderTree.TreeNode(20);
        LevelOrderTree.TreeNode root4 = new LevelOrderTree.TreeNode(15);
        LevelOrderTree.TreeNode root5 = new LevelOrderTree.TreeNode(7);
        root1.left = root2;
        root1.right = root3;
        root2.left = root21;
        root2.right = root22;
        root3.left = root4;
        root3.right = root5;

        return root1;
    }

    public static void sout(Object o) {
        System.out.println(JSON.toJSONString(o));
    }

    public static class TreeNode {
        int val;
        LevelOrderTree.TreeNode left;
        LevelOrderTree.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, LevelOrderTree.TreeNode left, LevelOrderTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
