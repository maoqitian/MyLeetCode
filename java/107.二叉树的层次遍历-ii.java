/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {


        //使用队列 层序遍历完在反转 时间浮渣度 O(N)

        List<List<Integer>> tempres = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) return res;

        //使用队列保存 每一层 结点
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            int count = queue.size();
            //保存当前层遍历的值
            List<Integer> templist = new ArrayList<>();
            for(int i = 0;i<count;i++){
               //队列先进先出 
               TreeNode node = queue.removeLast();
               if(node.left !=null) queue.addFirst(node.left);
               if(node.right !=null) queue.addFirst(node.right);
               templist.add(node.val);
            }
            
            //保存每一层结果
            res.add(templist);
        }

        //对结果反转
        for(int i = res.size()-1;i>=0;i--){
           tempres.add(res.get(i));
        }

        return tempres;

    }
}
// @lc code=end

