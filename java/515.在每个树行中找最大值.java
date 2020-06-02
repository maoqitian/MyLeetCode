import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
    public List<Integer> largestValues(TreeNode root) {

        //二叉树层序遍历 队列辅助 时间复杂度 O(N)
        
        List<Integer> res = new ArrayList<>();

        if(root == null){
          return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        //当队列的值不为空，说明当前行有结点

        while(!queue.isEmpty()){
            //当前层结点最大值
            int max = Integer.MIN_VALUE;
            int countNode = queue.size();
            for (int i = 0; i <countNode ; i++) {
                if(queue.peek().left !=null){
                   queue.add(queue.peek().left);
                }
                if(queue.peek().right !=null){
                    queue.add(queue.peek().right);
                }
                max = Math.max(queue.poll().val, max);
            }
            //保存当前层最大值
            res.add(max);
        }

        return res;

    }
}
// @lc code=end

