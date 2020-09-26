/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        //方法一  dfs 时间复杂度 O(n) 前序遍历

        // dfs(root, sum);
        // return res;

        //方法二 BFS 队列先进先出 时间复杂度 O(n)

        List<List<Integer>> res = new ArrayList<>();
        //如果节点为空直接返回
        if (root == null)
            return res;
        //使用两个队列，一个存储结点，一个存储从更结点到当前节点的路径
        Queue<TreeNode> queueNode = new LinkedList<>();
        Queue<List<Integer>> queueList = new LinkedList<>();
        //根节点入队
        queueNode.add(root);
        //根节点的路径入队
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        queueList.add(list);

        while (!queueNode.isEmpty()) {
            //当前节点出队
            TreeNode node = queueNode.poll();
            //当前节点的路径出队
            List<Integer> tempList = queueList.poll();
            if (node.left == null && node.right == null && node.val == sum) {
                //如果满足条件，就把路径存储到res中
                res.add(tempList);
            }
            //左子节点不为空，左子节点和路径入队
            if (node.left != null) {
                tempList.add(node.left.val);
                queueList.add(new ArrayList<>(tempList));
                node.left.val += node.val;
                queueNode.add(node.left);
                tempList.remove(tempList.size() - 1);
            }
            //右子节点不为空，右子节点和路径入队
            if (node.right != null) {
                tempList.add(node.right.val);
                queueList.add(new ArrayList<>(tempList));
                node.right.val += node.val;
                queueNode.add(node.right);
            }
        }
        return res;
    }

    void dfs(TreeNode root, int sum){
       //递归结束条件
       if(root == null) return;
       //逻辑处理 进入下层循环
       path.add(root.val);
       sum -= root.val;
       //如果左右节点为空 并且 sum = 0 说明已经找到到了想要的数组
       if(root.left == null && root.right == null && sum == 0){
         res.add(new ArrayList<>(path));
         }

       dfs(root.left,sum);
       dfs(root.right,sum);

       //数据 reverse
       //当前值不符合删除
       path.remove(path.size()-1);
    }

    
}
// @lc code=end

