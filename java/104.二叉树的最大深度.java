/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
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
    public int maxDepth(TreeNode root) {

        //方法一 递归 +1 计算值 最深值 时间复杂度 O(n)

        //循环退出条件
        // if(root == null){
        //   return 0;
        // }
        // //逻辑处理调用下层循环
        // return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        // //数据释放

         //广度优先遍历
         //时间复杂度 O(n) 使用队列保存每一层的值
         //遍历完一层深度加一
         if(root == null){
           return 0;
         }

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        //返回值结果深度
        int ans = 0;
        while(!queue.isEmpty()){
             int sum = queue.size();
             while(sum>0){
               TreeNode node = queue.pop();
                if(node.left!=null){
                   queue.addLast(node.left);
                }
                if(node.right!=null){
                  queue.addLast(node.right);
               }
               sum--;
             }
             ans ++;
        }

        return ans;

    }
}
// @lc code=end

