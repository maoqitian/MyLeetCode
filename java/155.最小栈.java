import java.util.Stack;

/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 */

// @lc code=start
class MinStack {


    //解法一 使用两个栈来实现 一个栈保证正常的输入输出，另一个栈保证获取最小的元素 数据同步
    
    Stack<Integer> stack ;

    Stack<Integer> minStack;


    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        //两个栈数据同步增加
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek()>x){
            //如果最小栈为空或者元素大于当前元素则加入当前元素
            minStack.add(x);
        }else{
          //否则加入栈顶元素，保证栈顶元素是最小的
          minStack.add(minStack.peek());
        }
    }
    
    public void pop() {
        //数据出栈同步减少
        if(!stack.isEmpty())
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();

    }
    
    public int getMin() {
       return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

