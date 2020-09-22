/*
 * @lc app=leetcode.cn id=968 lang=java
 *
 * [968] 监控二叉树
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
    int res =0;
    public int minCameraCover(TreeNode root) {

        //确定子树状态 时间复杂度 O(n)

        return (dfs(root) < 1 ? 1:0) + res;

    }

    int dfs(TreeNode root){
        //递归结束条件
        if(root == null) return 2;
        //逻辑处理 进入下层循环

        int left = dfs(root.left),right = dfs(root.right);

        //有左右子树
        if(left == 0 || right == 0){
            res++;
            return 1;
        }

        return left ==1 || right == 1? 2 : 0;

    }
}
// @lc code=end

