/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {

        //方法一 递归 +1 计算值 最深值 时间复杂度 O(n)

        //循环退出条件
        if(root == null){
            return 0;
        }
        //逻辑处理 进入一层递归 

        int leftHeight = maxDepth(root.left);

        int rightHeight = maxDepth(root.right);
        //返回最大值
        return Math.max(leftHeight, rightHeight)+1;
        //数据释放

    }
}
// @lc code=end

