/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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

    //记录当前众数值
    List<Integer> mList = new ArrayList<>();

    int curent = 0;//表示当前节点的值
    int count = 0;//表示当前节点的数量
    int maxCount = 0;//最大的重复数量

    public int[] findMode(TreeNode root) {

        //中序遍历二叉树 得到的是一个单调递增有序序列 则说明如果有相同的值则一定会连续出现
        //时间复杂度 O(n)

        inorderTree(root);
        
        int [] res = new int[mList.size()];
        //构造结果
        for(int i = 0;i<mList.size();i++){

            res[i] = mList.get(i);
        }

        return res;
    }

    void inorderTree(TreeNode root){
        //递归结束条件
        if(root == null) return;
        //逻辑处理 进入下层循环
        //中序遍历 二叉树 左中右
        inorderTree(root.left);

        //值处理
        if(root.val == curent){
            //如果值相等 累计
            count++;
        }else{
            //否则更新值 ,初始化累计
            curent = root.val;
            count = 1;
        }

        if(count == maxCount){
            //当前累计 等于累计最大值 加入数组
            mList.add(root.val);
        }else if(count > maxCount){
            //超过最大值
            mList.clear();
            mList.add(root.val);
            maxCount = count;
        }

        inorderTree(root.right);
        //数据 reverse

    }
}
// @lc code=end

