import java.util.ArrayList;
import java.util.List;

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

        //中序遍历 左 中 右

        List <Integer> result = new ArrayList<>();

        leftMRight(root,result);
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

