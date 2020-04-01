import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {

    //算法：使用两个队列来模拟栈，只保证一个队列有数据，有数据操作则出队整个有数据队列到另一个队列


    Queue<Integer> data1;
    Queue<Integer> data2;

    /** Initialize your data structure here. */
    public MyStack() {
        //使用linkedlist 来实现队列
        data1 = new LinkedList<>();
        data2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        //添加操作
        if(!data1.isEmpty()){
           data1.offer(x);
        }else{
            data2.offer(x);
        }

    }
    
    /** Removes the element on top of the stack and returns that element. */
    //栈先进后出
    public int pop() {
        //数据出队 加入另一个空队列 保留最后一个做出队操作 
        if(!data1.isEmpty()){
          while(data1.size()>1){
             data2.offer(data1.poll());
          }
          return data1.poll();
        }else {
            while(data2.size()>1){
                data1.offer(data2.poll());
             }
             return data2.poll();
        }
    }
    
    /** Get the top element. */
    public int top() {
        int top = 0;
        if(!data1.isEmpty()){
            while(data1.size()>1){
                data2.offer(data1.poll());
             }
             top = data1.poll();
             data2.offer(top);
        }else{
            while(data2.size()>1){
                data1.offer(data2.poll());
             }
             top = data2.poll();
             data1.offer(top);
        }
        return top;

    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return data1.isEmpty() && data2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

