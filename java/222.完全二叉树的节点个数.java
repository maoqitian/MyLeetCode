/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    public int countNodes(TreeNode root) {

        //不管深度优先广度优先 时间复杂度 O(n)
        //方法一 ：不利用完全二叉树特点 直接DFS
        //递归结束条件
        // if(root == null) return 0;
        // //逻辑处理 进入下层循环
        // int left = countNodes(root.left);
        // int right = countNodes(root.right);
        // return left+right+1;//加上当前节点的值
        
        //广度优先 
        if(root == null) return 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res =0;
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0; i < count;i++){
               TreeNode tempNode =  queue.removeLast();
               res++;
               if(tempNode.left!=null) queue.add(tempNode.left);
               if(tempNode.right!=null) queue.add(tempNode.right);
            }
        }
        return res;
    }
}
// @lc code=end

