import java.util.HashMap;


/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {


        // 想法 递归  时间复杂度 O(n)
        

        // 根据前续遍历特征 根节点必定在前序遍历数组 第一个元素
        //由中序遍历特点 根节点 必在数组中部 其左边元素是左子树节点 右边为全部右子树节点

        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i],i);
        }

        return buildRealTree(0, 0, inorder.length - 1, preorder, inorder,map);
    }
    /**
     * 
     * @param preStart 前序遍历开始 index
     * @param inStart  中序遍历开始 index
     * @param inEnd    中序遍历最后一个元素下标
     * @param preorder 前序遍历数组
     * @param inorder  中序遍历数组
     * @param map 存储中序 数组 index map 空间换时间
     * @return
     */
    TreeNode buildRealTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder,HashMap<Integer,Integer> map){
       
        //递归结束条件
        if(preStart > preorder.length -1 || inStart > inEnd){
           
            return null;
        }
        //逻辑处理进入下层递归

        //新建一个Tree 节点 
        TreeNode root = new TreeNode(preorder[preStart]);
        //遍历中序数组查看是否存在对应的数据 获取它的 index
        int rootIndex = 0;
        rootIndex = map.get(root.val);
        
        //左子树构建 
        root.left = buildRealTree(preStart+1, inStart, rootIndex-1, preorder, inorder,map);
        //右子树构建
        root.right = buildRealTree(preStart+rootIndex -inStart+1, rootIndex+1, inEnd, preorder, inorder,map);

        return root;
        //数据释放
    }
    
}
// @lc code=end

