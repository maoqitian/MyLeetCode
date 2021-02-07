import java.util.*

//请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）。
//
// 实现 MyStack 类： 
//
// 
// void push(int x) 将元素 x 压入栈顶。 
// int pop() 移除并返回栈顶元素。 
// int top() 返回栈顶元素。 
// boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 注意： 
//
// 
// 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。 
// 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 2, 2, false]
//
//解释：
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // 返回 2
//myStack.pop(); // 返回 2
//myStack.empty(); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x <= 9 
// 最多调用100 次 push、pop、top 和 empty 
// 每次调用 pop 和 top 都保证栈不为空 
// 
//
// 
//
// 进阶：你能否实现每种操作的均摊时间复杂度为 O(1) 的栈？换句话说，执行 n 个操作的总时间复杂度 O(n) ，尽管其中某个操作可能需要比其他操作更长的
//时间。你可以使用两个以上的队列。 
// Related Topics 栈 设计 
// 👍 274 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class MyStack() {

    //算法：使用两个队列来模拟栈，只保证一个队列有数据，有数据操作则出队整个有数据队列到另一个队列


    /** Initialize your data structure here. */

    var data1:LinkedList<Int> = LinkedList<Int>()
    var data2:LinkedList<Int> = LinkedList<Int>()


    /** Push element x onto stack. */
    fun push(x: Int) {

        if(!data1.isEmpty()){
            data1.addLast(x)
        }else{
            data2.addLast(x)
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    //栈先进后出
    fun pop(): Int {
        return if(!data1.isEmpty()){
            //将data1 数据放入 date2 留下一个便是队列最后一个数 也就是模拟栈顶的数
            while (data1.size>1){
                data2.addLast(data1.removeFirst())
            }
            data1.removeFirst()
        }else{
            while (data2.size>1){
                data1.addLast(data2.removeFirst())
            }
            data2.removeFirst()
        }
    }

    /** Get the top element. */
    fun top(): Int {
        var top = 0
        if(!data1.isEmpty()){
            //将data1 数据放入 date2 留下一个便是队列最后一个数 也就是模拟栈顶的数
            while (data1.size>1){
                data2.addLast(data1.removeFirst())
            }
            top = data1.removeFirst()
            data2.addLast(top)
        }else{
            while (data2.size>1){
                data1.addLast(data2.removeFirst())
            }
            top = data2.removeFirst()
            data1.addLast(top)
        }
        return top
    }

    /** Returns whether the stack is empty. */
    fun empty(): Boolean {
       return data1.isEmpty() && data2.isEmpty()
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */
//leetcode submit region end(Prohibit modification and deletion)
