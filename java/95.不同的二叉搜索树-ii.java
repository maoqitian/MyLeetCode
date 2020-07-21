import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {


        //递归 
        if(n == 0) return new ArrayList<TreeNode>();

        return generateBinaryTrees(1,n);
        
    }
    List<TreeNode> generateBinaryTrees(int start,int end){
        List<TreeNode> res = new ArrayList<>();

        //递归结束条件
        if(start > end) {
            res.add(null);
            return res;
        }
        //逻辑处理 进入下层循环

        //枚举可行根节点
        for (int i = start; i <= end; i++) {
            //获取所有可行的左子树集合
            List<TreeNode> leftTrees = generateBinaryTrees(start,i-1);
            //获取所有可行的右子树集合
            List<TreeNode> rightTrees = generateBinaryTrees(i+1,end);

            //从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (TreeNode leftNode : leftTrees) {
                for (TreeNode rightNode : rightTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    res.add(node);
                }
            }
        }

        return res;
        //数据 reverse
    }

}
// @lc code=end

