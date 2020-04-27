import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

import apple.laf.JRSUIUtils.Tree;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
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
public class Codec {

    //算法 前序遍历二叉树 每个节点使用"," 隔开，空节点则使用 null 代替
    //反序列化 使用 队列存储对应字符串再恢复 树结构

    private static final String spliter = ",";
    private static final String NULL = "null";


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        buildSerializeString(root,stringBuilder);
        return stringBuilder.toString();
    }
    /**
     * 中序遍历拼接字符串 递归
     * @param root 递归树
     * @param stringBuilder 字符串拼接
     */
    void buildSerializeString(TreeNode root,StringBuilder stringBuilder){

        if(root == null){
          stringBuilder.append(NULL).append(spliter);
        }else{
        stringBuilder.append(root.val).append(spliter);
        buildSerializeString(root.left, stringBuilder);
        buildSerializeString(root.right, stringBuilder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addAll(Arrays.asList(data.split(spliter)));
        return deserializeTree(linkedList);
    }

    /**
     * 递归恢复树结构 继续使用中序遍历恢复 队列先进先出
     * @param linkedList
     * @return
     */
    TreeNode deserializeTree(LinkedList<String> linkedList){

          String val = linkedList.remove();
          //递归结束条件
          if(NULL.equals(val)){
             return null;
          }else{
          //逻辑处理 进入下层递归
          TreeNode treeNode = new TreeNode(Integer.valueOf(val));
          treeNode.left = deserializeTree(linkedList);
          treeNode.right = deserializeTree(linkedList);
          return treeNode;
          }
          //数据释放
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

