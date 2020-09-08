/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {


        //使用队列 层序遍历完在反转 时间浮渣度 O(N)
        LinkedList<List<Integer>> result = new LinkedList<>();

        if(root == null) return res;

        //使用队列保存 每一层 结点
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            int count = queue.size();
            //保存当前层遍历的值
            List<Integer> templist = new ArrayList<>();
            for(int i = 0;i<count;i++){
               //队列先进先出 
               TreeNode node = queue.removeLast();
               if(node.left !=null) queue.addFirst(node.left);
               if(node.right !=null) queue.addFirst(node.right);
               templist.add(node.val);
            }
            
            //保存每一层结果 并加入到结果第一位 相当于反转
            res.addFirst(templist);
        }
        return res;

    }
}
// @lc code=end

