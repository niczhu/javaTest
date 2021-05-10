package com.test.leetcode.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层序遍历
 */
public class LevelOrderTree extends TreeBuilder {
    public static void main(String[] args) {
        Integer[] root = new Integer[]{3, 9, 20, null, null, 15, 7};

        TreeNode treeNode = buildTree();

        List<List<Integer>> lists = levelOrder(treeNode);

        sout(lists);

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rest = new ArrayList<>();
        if (root == null) return rest;  // 注意点

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);

        while (!q.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int len = q.size();      // 注意这里必须把size先取到再放到for中，不能 i< q.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = q.poll();
                levelList.add(cur.val);

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }

            rest.add(levelList);
        }
        return rest;
    }

    public static TreeNode getTree() {
        //3,9,20,null,null,15,7
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(20);
        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(7);
        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;

        return root1;
    }


    public TreeNode toBeTree(Integer[] arr) {
        if (null == arr) {
            return null;
        }
        int log = (int) Math.log(arr.length + 1);

        int index = 1;
        TreeNode root = new TreeNode();
        root.val = arr[0];

        for (int i = 0; i < log; i++) {
            int count = 1 << i;
            for (int j = 1; j <= arr.length; j++) {
                if (j > count) break;

                root.left = new TreeNode(arr[j]);
                root.right = new TreeNode(arr[j + 1]);

                count++;
            }
        }

        return null;
    }

}
