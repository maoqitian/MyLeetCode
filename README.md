> LeetCode lean

## LeetCode Algorithm

| # | Title | Solution | Difficulty |
|---| ----- | -------- | ---------- |
|297|[Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | [Java](./java/297.二叉树的序列化与反序列化.java)|Hard|
|206|[Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/) | [Java](./java/206.反转链表.java)|Easy|
|145|[Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/) | [Java](./java/145.二叉树的后序遍历.java)|Hard|
|144|[Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/) | [Java](./java/144.二叉树的前序遍历.java)|Medium|
|111|[Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/) | [Java](./java/111.二叉树的最小深度.java)|Easy|
|110|[Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/) | [Java](./java/110.平衡二叉树.java)|Easy|
|107|[binary-tree-level-order-traversal-ii(二叉树的层次遍历-ii)](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/) | [Java](./java/107.二叉树的层次遍历-ii.java)|Easy|
|104|[Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | [Java](./java/104.二叉树的最大深度.java)|Easy|
|102|[Binary Tree Level Order Traversal(二叉树的层序遍历)](https://leetcode.com/problems/binary-tree-level-order-traversal/) | [Java](./jjava/102.二叉树的层序遍历.java)|Medium|
|100|[Symmetric Tree](https://leetcode.com/problems/symmetric-tree/) | [Java](./java/100.相同的树.java)|Easy|
|94|[Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/) | [Java](./java/94.二叉树的中序遍历.java)|Medium|
|70|[Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) | [Java](./java/70.爬楼梯.java)|Easy|
|66|[Plus One](https://leetcode.com/problems/plus-one/) | [Java](./java/66.加一.java)|Easy|
|50|[Pow(x, n)](https://leetcode.com/problems/powx-n/) | [Java](./java/50.pow-x-n.java)|Medium|
|43|[Multiply Strings](https://leetcode.com/problems/multiply-strings/) | [Java](./java/43.字符串相乘.java)|Medium|
|42|[Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/) | [Java](./java/42.接雨水.java)|Hard|
|35|[Search Insert Position](https://leetcode.com/problems/search-insert-position/) | [Java](./java/35.搜索插入位置.java)|Easy|
|33|[Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/) | [Java](./java/33.搜索旋转排序数组.java)|Medium|
|26|[Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/) | [Java](./java/26.删除排序数组中的重复项.java)|Easy|
|25|[Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/) | [Java](./java/25.k-个一组翻转链表.java)|Hard|
|24|[Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/) | [Java](./java/24.两两交换链表中的节点.java)|Medium|
|22|[Generate Parentheses](https://leetcode.com/problems/generate-parentheses/) | [Java](./java/22.括号生成.java)|Medium|
|21|[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) | [Java](./java/21.合并两个有序链表.java)|Easy|
|20|[Valid Parentheses](https://leetcode.com/problems/valid-parentheses/) | [Java](./java/20.有效的括号.java)|Easy|
|17|[Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | [Java](./java/17.电话号码的字母组合.java)|Medium|
|15|[3Sum](https://leetcode.com/problems/3sum/) | [Java](./java/15.三数之和.java)|Medium|
|14|[Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/) | [Java](./java/14.最长公共前缀.java)|Easy|
|11|[Container With Most Water](https://leetcode.com/problems/container-with-most-water/) | [Java](./java/11.盛最多水的容器.java)|Medium|
|9|[Palindrome Number](https://leetcode.com/problems/palindrome-number/) | [Java](./java/9.回文数.java)|Easy|
|7|[Reverse Integer](https://leetcode.com/problems/reverse-integer/) | [Java](./java/7.整数反转.java)|Easy|
|5|[Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/) | [Java](./java/5.最长回文子串.java)|Medium|
|4|[Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/) | [Java](./java/4.寻找两个正序数组的中位数.java)|Hard|
|3|[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | [Java](./java/3.无重复字符的最长子串.java)|Medium|
|2|[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) | [Java](./java/2.两数相加.java)|Medium|
|1|[Two Sum](https://leetcode.com/problems/two-sum/) | [Java](./java/1.两数之和.java)|Easy|


# 算法思想
## 最基本算法

### if / else (判断)
### for while (循环、迭代)
### recursion (递归)

- 递归本质也是循环，是通过函数体来进行的循环

#### 解题思路

1. 写出循环退出条件
2. 处理逻辑
3. 调用函数本身进入下一层递归
4. 数据释放

#### 递归模板代码


```
## Java
public void recur(int level, int param) { 
  // terminator 递归终结条件
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 处理当前递归层逻辑
  process(level, param); 
  // drill down  调用下一层递归
  recur( level: level + 1, newParam); 
  // restore current status 清理当前层状态
 
}
```

## 数据结构优化思想

- 找重复部分,执行 for while (循环、迭代)或者recursion (递归)
- 提升数据结构维度（比如一维变成二维）
- 空间换时间
 

# 基本数据结构

## 数组

###
- 由类型相同的数据元素构成的有序集合

### 操作时间复杂度
- 查找时间复杂度 O(1)
- 增删时间复杂度度 O(n)
- 头尾添加时间复杂度可以看做是 O(1)


## 链表

- 单链表每个节点只包含一个指针域，也就是指向后继结点
- 根据链表的结点所含指针个数、指针指向和指针连接方式，可将链表分为单链表、循环链表、双向链表、二叉链表、十字链表、邻接表、邻接多重表等。其中单链表、循环链表、双向链表用于实现线性表的链式存储结构，而其他类型链表多用于实现树和图等非线性结构。

### 操作时间复杂度

- 查找时间复杂度 O(n)
- 增删时间复杂度度 O(1)

### 实现（Java）

```
class LinkedList { 
    Node head; // head of list 
  
    /* Linked list Node*/
    class Node { 
        int data; 
        Node next; 
  
        // Constructor to create a new node 
        // Next is by default initialized 
        // as null 
        Node(int d) { data = d; } 
    } 
}
```
