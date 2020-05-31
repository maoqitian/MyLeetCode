import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;


/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {

        //想法一 递归 时间复杂度 O(n)

        //return check(root,root);

        // 想法二 迭代 二叉树 层序遍历 时间复杂度 O(n)
        //队列辅助

        if(root == null){
           return true;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        
        linkedList.add(root.left);
        linkedList.add(root.right);

        while(!linkedList.isEmpty()){
            TreeNode n1 = linkedList.pop();
            TreeNode n2 = linkedList.pop();

            if(n1 == null && n2 == null) continue;
            if(n1 == null || n2 == null || n1.val != n2.val) return false;

            linkedList.add(n1.left);
            linkedList.add(n2.right);
            linkedList.add(n1.right);
            linkedList.add(n2.left);
        }
        return true;
    }

    /**
     * 两个指针递归 判断值
     * @param left 左指针
     * @param right 右指针
     * @return
     */
    boolean check(TreeNode left,TreeNode right){
        //递归结束条件
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null){
          return false;
        }
        //进入下层递归
        return left.val == right.val && check(left.left, right.right)&& check(right.left, left.right);
        //数据 reverse

    }
}
// @lc code=end

