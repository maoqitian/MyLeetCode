/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
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

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {

        //二叉搜索树 中序遍历 相当于一个单调递增序列
        // 逆序 后序遍历则相当于单调递减 ,记录每次和赋值 时间复杂度 O(n)

        if(root!=null){
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left); 
        }

        return root;
        
    }
}
// @lc code=end

