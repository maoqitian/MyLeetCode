import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {

        //方法一  递归 时间复杂度 O(n)

        List<Integer> result = new ArrayList<>();

        preorderTree(root,result);

        return result;

    }

    void preorderTree(TreeNode root, List<Integer> result){

        if(root!=null){
           result.add(root.val);
           if(root.left!=null){
             preorderTree(root.left, result);
           }
           if(root.right!=null){
             preorderTree(root.right, result);
           }
        }
          
    }
}
// @lc code=end

