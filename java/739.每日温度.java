import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] T) {

        // 使用栈来解决 比较栈顶元素与迭代值，大于栈顶取出栈顶元素 都在入栈

        LinkedList<Integer> stack = new LinkedList<>();
        int [] res = new int[T.length]; 

        for (int i = 0; i < T.length; i++) {
            while(!stack.isEmpty()&& T[i] > T[stack.peekLast()]){
              int index = stack.pollLast();
              res[index] = i - index;
            }
            stack.addLast(i);
        }

        return res;

    }
}
// @lc code=end

