/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
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
    public int sumNumbers(TreeNode root) {

        //方法一 深度优先遍历 时间复杂度 O(n)

        //return dfs(root,0);

        //方法二 广度优先遍历
        // 两个队列 分别存放结点 和 结点对应数字
        if(root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> queueSum = new LinkedList<>();

        int sum = 0;
        queue.add(root);
        queueSum.add(root.val);

        //二叉树层序遍历
        while(!queue.isEmpty()){
            TreeNode node = queue.removeLast();
            int currNum = queueSum.removeLast();
            TreeNode left = node.left,right = node.right;
            if(left == null && right == null){
               sum += currNum;
            }else{

                if(left!=null){
                    queue.addFirst(left);
                    queueSum.addFirst(currNum*10+left.val);
                }

                if(right!=null){
                    queue.addFirst(right);
                    queueSum.addFirst(currNum*10+right.val);
                }

            }
        }

        return sum;

    }

    int dfs(TreeNode root,int preSum){
        //递归结束条件
        if(root == null) return 0; 
        //逻辑处理 进入下层循环
        int sum = root.val + preSum*10;

        if(root.left == null && root.right == null){
          //如果没有左右结点
          return sum;
        }else {
            //继续向下遍历
          return dfs(root.left,sum) + dfs(root.right,sum);
        }
        //数据 reverse
    }
}
// @lc code=end

