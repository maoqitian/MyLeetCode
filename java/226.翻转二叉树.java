import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
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
    public TreeNode invertTree(TreeNode root) {

        //想法一 递归后序遍历二叉树替换值 时间复杂度 O(n)
        
        //递归四步骤
        //结束递归条件
        
        if(root == null){
           return null;
        }

        // 逻辑处理 进入下一层递归 
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        
        return root;
        
    }
}
// @lc code=end

