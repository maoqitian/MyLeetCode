import java.util.Stack;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {

    //算法： 使用两个栈来实现队列，一个栈作为进队列操作 一个栈为队列出队操作,
    //如果出队栈为空则将入队栈所有数据放到出队栈 负负得正 

    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    /** Initialize your data structure here. */
    public MyQueue() {

        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void moveData(){
        if(popStack.isEmpty()){
           while(pushStack.size()>0){
             popStack.push(pushStack.pop());
           }
        }
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
         pushStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        moveData();
        return popStack.pop();

    }
    
    /** Get the front element. */
    public int peek() {
        moveData();
        return popStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
          return pushStack.isEmpty() && popStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

