/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        //二叉树层序遍历 时间复杂度 O(n)
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;

        //使用队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<count;i++){
               TreeNode node = queue.removeLast();
               if(node.left!=null) queue.addFirst(node.left);
               if(node.right!=null) queue.addFirst(node.right);
               temp.add(node.val);
            }
            if(level % 2 != 0){
                //奇数行 反转
                Collections.reverse(temp);
            }
            level++;
            res.add(temp);
        }
        return res;
    }
}
// @lc code=end

