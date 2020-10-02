/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        //想法 递归 如果根节点为空 则 创建一个以 val 为值得节点，否则查找左右子结点
        //看合适的为值放入 时间复杂度 O(n)
        
        //递归 结束条件
        if(root == null) return new TreeNode(val);
        //逻辑处理 进入下层循环 
        if(val < root.val){
            root.left = insertIntoBST(root.left,val);
        }
        if(val > root.val){
            root.right = insertIntoBST(root.right,val);
        }

        return root;
        //数据 reverse
        
    }
}
// @lc code=end

