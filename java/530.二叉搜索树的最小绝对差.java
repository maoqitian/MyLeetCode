/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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

    int res = Integer.MAX_VALUE;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        //中序遍历 时间复杂度 O(n)

        dfs(root);
        
        return res;
    }

    void dfs(TreeNode root){
        //递归结束条件
        if(root == null) return;

        //逻辑处理 进入下层循环
        dfs(root.left);

        if(pre == -1){
            pre = root.val;
        }else {
            res = Math.min(res,root.val - pre);
            //获取父节点值 继续递归
            pre = root.val;
        }

        dfs(root.right);
        //数据reverse
    }
}
// @lc code=end

