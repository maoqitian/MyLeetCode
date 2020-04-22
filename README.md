> LeetCode lean

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