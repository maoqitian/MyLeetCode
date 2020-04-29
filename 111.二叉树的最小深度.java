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

        //方法一 深度优先 每个节点都遍历一遍 时间复杂度 O(n)
        //递归结束条件
        /** Solution 1: DFS 
 * Key point: 
 * if a node only has one child -> MUST return the depth of the side with child, i.e. MAX(left, right) + 1
 * if a node has two children on both side -> return min depth of two sides, i.e. MIN(left, right) + 1
 * */
         if(root == null){
            return 0;
        }
        //逻辑处理 进入下层递归调用
        int left = minDepth(root.left);

        int right = minDepth(root.right);

        if(left == 0 || right == 0){
           return Math.max(left, right)+1;
        }else{
            return Math.min(left, right)+1;
        }
        //数据释放
    }
}
// @lc code=end

