/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode currNode = null;
    public TreeNode sortedListToBST(ListNode head) {
        //递归 中序遍历 时间复杂度 O(n)
        //先计算链表长度 然后递归构造, 二分查找 中间值二根节点 左边为左子树 右边为右子树

        if(head == null) return null;

        int len = 0;
        currNode = head;
        while(head !=null){
            len++;
            head = head.next;
        }

        return buildBST(0,len-1);
    }

    TreeNode buildBST(int left,int right){
        //递归结束条件
        if(left > right) return null;

        int mid = left+ (right - left) /2;
        //逻辑处理 进入下层循环
        TreeNode leftNode = buildBST(left,mid -1);

        TreeNode root = new TreeNode(currNode.val);

        root.left = leftNode;

        currNode = currNode.next;
        root.right = buildBST(mid+1,right);

        return root;
        // 数据 reverse

    }

}
// @lc code=end

