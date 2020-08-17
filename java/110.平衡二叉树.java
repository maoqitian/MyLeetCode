/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
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
    public boolean isBalanced(TreeNode root) {

        //后续遍历 时间复杂度 O(n)

        //如果树为空 则返回true
        if(root == null ) return true;
        return treeHeight(root) != -1;
    }

    //如果不为平衡二叉树 返回 -1 否则返回高度较深子树高度
    int treeHeight(TreeNode root){
        //递归结束条件
        if(root == null) return 0;
        //逻辑处理 进入下层循环
        int left = treeHeight(root.left);
        if(left == -1) return -1;
        int right = treeHeight(root.right);
        if(right == -1) return -1;
        //计算高度差
        if(Math.abs(left - right) > 1) return -1;
        else 
        return Math.max(left,right)+1;
        // 数据 reverse
    }
}
// @lc code=end

