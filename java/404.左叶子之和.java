/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
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
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        //方法一 dfs 深度优先遍历 时间复杂度 O(n)
        // dfs(root,false);
        // return res;

        //广度优先遍历 bfs 使用队列 当前节点有左节点 计算和 有有右节点保存到队列
        //时间复杂度 O(n) 

        if(root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i =0;i<size;i++){
                TreeNode node = queue.removeLast();
                //如果有左子树 累计值
                if(node.left!=null) {
                    if(node.left.left ==null && node.left.right == null) {
                        res = res+ node.left.val;
                    }else{
                        queue.addFirst(node.left);
                    }
                }
                //有右子树加入队列下一轮遍历
                if(node.right!=null) {
                    queue.addFirst(node.right);
                }
            }
        }

        return res;

    }

    //isleft 是否为左子树标记
    void dfs(TreeNode root,boolean isLeft){

        //递归结束条件
        if(root == null) return;
        //逻辑处理 进入下层循环
        if(root.left == null && root.right == null && isLeft ){
            //当前为左子节点 并且没有左右子树
            res += root.val;
        }

        dfs(root.left,true);
        dfs(root.right,false);

        //数据 reverse

    }
}
// @lc code=end

