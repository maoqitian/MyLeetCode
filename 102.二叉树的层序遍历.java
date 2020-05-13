import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {


           //思路 二叉树的层序遍历 通用思路为使用 队列，利用队列先进先出特点保存每一行的结点，遍历之后出队

           List<List<Integer>> res = new ArrayList<>();

           if(root == null){
              return res;
           }
           //存储没层结点队列
           Queue<TreeNode> queueNodes = new LinkedList<>();
           //把当前根节点加入队列
           queueNodes.add(root);

           //遍历队列节点

           while(!queueNodes.isEmpty()){
               //获取当前层级有多少个节点
               int count = queueNodes.size();
               //保存当前遍历节点值得 list
               List<Integer> temp = new ArrayList<>();
               //根据队列中的数据 遍历获取节点值
               for (int i = 0; i < count; i++) {
                   //当前节点是否有左右子节点
                   if(queueNodes.peek().left !=null){
                     queueNodes.offer(queueNodes.peek().left);
                   }
                   if(queueNodes.peek().right !=null){
                    queueNodes.offer(queueNodes.peek().right);
                  }
                  //保存当前节点行元素值数组
                  temp.add(queueNodes.poll().val);
               }
               //保存每一层节点数组
               res.add(temp);
           }

            return res;
    }
}
// @lc code=end

