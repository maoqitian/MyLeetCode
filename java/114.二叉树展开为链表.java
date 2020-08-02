/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    public void flatten(TreeNode root) {

        //前序遍历 递归 时间复杂度 O(n)

        List<TreeNode> list = new ArrayList<>();

        //前序遍历 中左右
        preTree(root,list);

        //遍历前序遍历的集合 将 每个节点指向右子树

        for(int i = 1;i< list.size();i++){
            TreeNode pre = list.get(i-1);
            TreeNode curr = list.get(i);
            pre.left = null;
            pre.right = curr;
        }
        
    }


    void preTree(TreeNode root,List<TreeNode> list){
        //递归结束条件 

        if(root !=null){
        // 逻辑处理 进入下层循环
          list.add(root);
          preTree(root.left,list);
          preTree(root.right,list);
        }

    }
}
// @lc code=end

