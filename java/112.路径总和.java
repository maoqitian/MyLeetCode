/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int sum) {

        // dfs 深度优先 是否复杂度 O(n)
        // if(root == null) return false;

        // //左右子树为空 判断是否等于 target
        // if(root.left == null && root.right == null) return root.val == sum;
        // //继续判断左右子树
        // return hasPathSum(root.left,sum - root.val) || hasPathSum(root.right,sum - root.val);

         //方法二 BFS 队列先进先出 时间复杂度 O(n)

         if(root == null) return false;

         LinkedList<TreeNode> queue = new LinkedList<>();
 
         queue.addFirst(root);
 
         while(!queue.isEmpty()){
             int count = queue.size();
             for(int i = 0;i<count;i++){
                 TreeNode node = queue.removeLast();
                 //如果当前值等于 sum 并且没有左右子节点 说明符合
                 if(node.val == sum && node.left == null && node.right == null){
                    return true;
                 }
 
                 if(node.left != null){
                    node.left.val += node.val; 
                     queue.addFirst(node.left);
                 } 
                 if(node.right != null){
                    node.right.val += node.val; 
                     queue.addFirst(node.right);
                 } 
             }
         }
         return false;
    }
}
// @lc code=end

