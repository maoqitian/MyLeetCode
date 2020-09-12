/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
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
    public List<Double> averageOfLevels(TreeNode root) {

        //同理 二叉树层序遍历 使用队列先进先出 时间复杂度 O(n)

        List<Double> res = new ArrayList<>();

        if(root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            int count = queue.size();
            double sum = 0;
            for(int i =0;i<count;i++){
                TreeNode node = queue.removeLast();
                if(node.left!=null) queue.addFirst(node.left);
                if(node.right!=null) queue.addFirst(node.right);
                sum += node.val;
            }
            //计算当前层平均值
            sum = sum/count;
            //保存当前层结果
            res.add(sum);
        }

        return res;
    }
}
// @lc code=end

