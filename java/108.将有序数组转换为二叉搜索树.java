
/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
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
    public TreeNode sortedArrayToBST(int[] nums) {

        //中序遍历 构造二叉树 递归 时间复杂度 O(n)

        return buildTree(nums,0,nums.length-1);

    }

    TreeNode buildTree(int[] nums,int left,int right){
        
        //递归结束条件
        if(left > right){
            return null;
        } 
        //逻辑处理 进入下层循环
        int mid = (left+right)/2;

        //以中间值左边数字作为根节点
        TreeNode treeNode = new TreeNode(nums[mid]);

        treeNode.left = buildTree(nums, left, mid-1);
        treeNode.right = buildTree(nums, mid+1, right);

        //数据 reverse

        return treeNode;
    }
}
// @lc code=end

