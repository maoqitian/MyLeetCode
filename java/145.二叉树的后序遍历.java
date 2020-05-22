import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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
    public List<Integer> postorderTraversal(TreeNode root) {

        //方法一  递归 时间复杂度 O(n)

        // List<Integer> result = new ArrayList<>();

        // postorderTree(root,result);

        // return result;
        
        // 方法二 使用栈 时间复杂度 O(n)

        LinkedList<TreeNode> stack = new LinkedList<>();

        LinkedList<Integer> result = new LinkedList<>();

        TreeNode curr = root;

        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
               stack.push(curr);
               result.addFirst(curr.val);
               curr = curr.right;
            }else{
               curr = stack.pop();
               curr = curr.left; 
            }
            
        }

        return result;

    }

    void postorderTree(TreeNode root, List<Integer> result){

        if(root!=null){
           if(root.left!=null){
            postorderTree(root.left, result);
           }
           if(root.right!=null){
            postorderTree(root.right, result);
           }
           result.add(root.val);
        }
          
    }
}
// @lc code=end

