/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {

        //单调栈  遍历一次 时间复杂度 O(n)
        Stack<Integer> stack = new Stack<>();

        int max = 0;
        //保证栈中有元素
        stack.push(-1);

        for(int i = 0;i<s.length();i++){
           if(s.charAt(i) == '('){
              //记录下标
              stack.push(i);
           }else {
               //匹配
               stack.pop();
               if(stack.isEmpty()){
                 //记录当前下标
                 stack.push(i);
               }else{
                   //更新最大值
                   max = Math.max(max,i - stack.peek());
               }
           }
        }

        return max;

    }
}
// @lc code=end

