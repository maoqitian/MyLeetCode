/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    public List<String> binaryTreePaths(TreeNode root) {

        // 深度优先 前序遍历二叉树 时间复杂度 O(n^2)

        List<String> res = new ArrayList<>();

        if(root == null)return res;

        dfs(new StringBuilder(),root,res);
        return res;
    }

    void dfs(StringBuilder s,TreeNode root,List<String> res){
        //递归结束条件
         if(root == null) return;
        //逻辑处理 进入下层循环
        s.append(root.val);
        //如果已经没有左右子树 则该路径走完
         if(root.left == null && root.right == null){
             res.add(s.toString());
             return;
         }
         //否则继续递归
         dfs(new StringBuilder(s.toString()).append("->"),root.left,res);
         dfs(new StringBuilder(s.toString()).append("->"),root.right,res);

    }
}
// @lc code=end

