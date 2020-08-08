/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
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

    //定义 之前结点记录 和需要交换值的节点
    TreeNode pre,first,second;
    public void recoverTree(TreeNode root) {

        // 中序遍历 搜索二叉树  打印的值应该是顺序递增数组
        dfs(root);
        swapTreeVal(first,second);
    }

    //中序遍历
    void dfs(TreeNode root){

        //递归结束条件 
        if(root == null) return;
        //逻辑处理 进入下层循环
        if(root.left != null) dfs(root.left);

        //是否需要记录值不按顺序结点
        if(pre!= null && root.val < pre.val){
            if(first == null) first = pre;
            second = root;
        }
        pre = root;

        if(root.right != null) dfs(root.right);
        // 数据 reverse
          
    }

    //交换两个 结点的值
    void swapTreeVal(TreeNode node1,TreeNode node2){
        if(node1 != null && node2!= null){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }
    }
}
// @lc code=end

