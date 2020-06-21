/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //递归 获取路径最大值 分别计算 当前节点 和左右子树相加
        //时间空间复杂度 O(n)
        maxPath(root);
        return maxSum;
    }
    
    //递归处理
    int maxPath(TreeNode node){
        //递归结束条件
        if(node == null){
           return 0;
        }
        //逻辑处理 进入下层循环

        //递归处理左右子树的最大贡献值
        int leftMax = Math.max(maxPath(node.left), 0);
        int rightMax = Math.max(maxPath(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int currMax =  node.val + leftMax + rightMax;
        //数据 reverse
        //更新最大值结果
        maxSum = Math.max(maxSum, currMax);
        //返回节点计算的最大值
        return node.val + Math.max(leftMax, rightMax);
    }
}
// @lc code=end

