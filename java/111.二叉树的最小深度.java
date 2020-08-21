/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {

 
         //递归 dfs 时间复杂度 O(n)

        //递归结束条件
        if(root == null) return 0;
        //左子树深度
        int lenleft = minDepth(root.left);
        //右子树深度
        int lenright = minDepth(root.right);

        //如果有一个子树深度为零 说明最小深度则为当前有深度子树的深度
        if(lenleft == 0 || lenright == 0){
          return Math.max(lenright,lenleft)+1;
        }else {
            //否则获取最小深度
            return Math.min(lenleft,lenright)+1;
        }
        //数据释放
    }
}
// @lc code=end

