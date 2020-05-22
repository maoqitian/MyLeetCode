import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {

        // 方法一 中序遍历 时间复杂度 O(n) 

      //   List <Integer> result = new ArrayList<>();

      //   leftMRight(root,result);
      //   return result;

        //方法二 迭代 使用栈存储每个节点 时间复杂度 O(n)

        Stack<TreeNode> stack = new Stack<>();
        List <Integer> result = new ArrayList<>();

        //当前记录的节点 node

        TreeNode curr = root;

        while(curr!=null || !stack.isEmpty()){
           //如果左子树不为空
           if(curr!=null){
               stack.push(curr);
               curr = curr.left;
           }else{
            //遍历完成左子树 从栈中取出继续遍历操作   
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
           }
        }

         return result; 
    }

    void leftMRight(TreeNode root , List<Integer> result){
            if(root !=null){
               if(root.left != null){
                  leftMRight(root.left, result);
               }
               result.add(root.val);
               if(root.right !=null){
                  leftMRight(root.right, result);
               }
            }
    }
}
// @lc code=end

