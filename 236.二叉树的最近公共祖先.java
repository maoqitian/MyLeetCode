import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //思路1 递归 时间复杂度 O(n)
        
        //递归退出条件
        //如果当前节点为null 或者等于需要寻找节点， 直接返回结束递归
        if(root == null || root == p || root == q){
           return root;
        }
        // 逻辑处理 进入下层递归
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        return left == null ? right : right == null ? left : root;
        // 数据释放



        
    }
}
// @lc code=end

