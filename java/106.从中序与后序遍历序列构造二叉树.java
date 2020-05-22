import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // 根据后续遍历特征 根节点必定在 后续遍历数组的最后一个元素 时间复杂度 O(n)
        //由中序遍历特点 根节点 必在数组中部 其左边元素是左子树节点 右边为全部右子树节点
    //使用HashMap 存储中序遍历数组 方便获取使用 

     HashMap<Integer,Integer> map = new HashMap<>();

     for (int i = 0; i < inorder.length; i++) {
        map.put(inorder[i], i);
       }
      return buildRealTree(postorder.length-1,0,inorder.length-1,inorder,postorder,map);
    }
    /**
     * 
     * @param postend 后续遍历数组最后一位数 index 第一次指向树的根节点
     * @param inStart 中序遍历数组开始 index
     * @param inEnd   中序遍历最后一位数 index
     * @param inorder 中序遍历数组
     * @param postorder 后续遍历数组
     * @param map 存储中序 数组 index map 空间换时间
     * @return
     */
    TreeNode buildRealTree(int postend,int inStart,int inEnd,int[] inorder,int[] postorder,HashMap<Integer,Integer> map){
         
         //递归结束条件
         if(postend >= postorder.length || inStart > inEnd){
           
            return null;
        }
         //逻辑处理 进入下层递归
         //根据后续遍历的节点从最后一个往前取  每一个相当于根节点 确定左右子树
         TreeNode root = new TreeNode(postorder[postend]);
         //获取当前根节点值获取 index 
         int rootIndex = 0;
         rootIndex = map.get(root.val);
         //后续遍历中 倒数第三个为左子树根节点
         root.left = buildRealTree(postend+rootIndex-inEnd-1,inStart,rootIndex -1,inorder,postorder,map);
         //倒数第二个为右子树根节点
         root.right = buildRealTree(postend -1 ,rootIndex +1 ,inEnd,inorder,postorder,map);

         return root;
         //数据释放


    }
}
// @lc code=end

