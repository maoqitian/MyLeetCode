/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
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

        //方法一 搜索二叉树 左子树小于根节点 右子树大于根节点 时间复杂度 O(n)

        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right,p,q);
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left,p,q);
        
        //自身为公共祖先
        return root;

        //方法二 可以使用 #236 题方法解 但是没有用到 搜索二叉树特性 时间复杂度 O(n)
        //递归结束条件 
        if(root == null || root == p || root == q) return root;
        //逻辑 处理进入下层循环

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        return left == null ? right : right == null ? left : root;

        //数据 reverse


        
    }
}
// @lc code=end

