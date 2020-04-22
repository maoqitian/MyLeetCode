import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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

    private double pre = -Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {

        //方法1 使用递归 中序遍历二叉树 时间复杂度 O(n)

        return validBST(root);
    }

    boolean validBST(TreeNode root){
        //递归四步骤
        //递归结束条件
        if(root == null){
           return true;
        }
        //逻辑处理 调用下一层递归
        if(!validBST(root.left)){
           return false;
        }

        if(root.val <= pre){ //如果小于前一个数 说明不是BST
            return false;
        }else{
            pre = root.val;
        }
        if(!validBST(root.right)){
            return false;
         }
         return true;
        //清理数据
    }
}
// @lc code=end

