/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
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
    public int rob(TreeNode root) {

        //二叉树层序遍历 计算 奇数行 和偶数行的值 但是左右两边上下节点也是算相隔的 层序遍历不能解决本题
        // if(root == null) return 0;
        // LinkedList<TreeNode> queue = new LinkedList<>();
        // queue.add(root);

        // int res = 0;

        // int sumOdd = 0;
        // int sumEven = 0;

        // int index = 0;

        // while(!queue.isEmpty()){
        //     int count = queue.size();
        //     for(int i = 0; i < count; i++){
        //         TreeNode currNode = queue.removeFirst(); 
        //        if(currNode.left !=null){
        //           queue.add(currNode.left);
        //        }
        //        if(currNode.right !=null){
        //         queue.add(currNode.right);
        //        }
        //      //累积和
        //      if(index % 2 !=0 ){
        //          //奇数
        //          sumOdd = sumOdd + currNode.val;
        //      }else {
        //          //偶数
        //          sumEven = sumEven + currNode.val;
        //      }
        //   }
        //   // 层指针
        //   index++;
        // }
        // res = Math.max(sumOdd,sumEven);
        // return res;

        //DFS递归 时间复杂度 O(n)
        int[] rootStatus = dfs(root);
        
        return Math.max(rootStatus[0],rootStatus[1]);
    }

    int [] dfs(TreeNode root){

        //递归结束条件

        if(root == null ) return new int[]{0,0};
        //逻辑处理 进入下层循环
        //左子树遍历
        int[] left = dfs(root.left);
        //右子树遍历
        int[] right = dfs(root.right);
        //当前可选
        int select = root.val + left[1]+right[1];

        int noselect = Math.max(left[0],left[1])+ Math.max(right[0],right[1]);

        return new int[]{select,noselect};
        // 数据 reverse

    }
}
// @lc code=end

