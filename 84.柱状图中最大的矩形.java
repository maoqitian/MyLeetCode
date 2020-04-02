import java.util.Stack;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {

        //暴力法一：嵌套循环遍历 前两层循环找到对应的 时间复杂度 O(n^3)

        // int maxArea = 0;
        // for (int i = 0; i < heights.length; i++) {
        //     for (int j = i; j < heights.length; j++) {
        //         //定义最小高度值
        //         int height = Integer.MAX_VALUE;
        //         //分别枚举i-j 范围内最小柱子高度 算出面积
        //         for (int k = i; k <= j; k++) 
        //             height = Math.min(height, heights[k]);
        //             maxArea = Math.max(maxArea, (height * (j-i+1)));
                
        //     }
        // }
        // return maxArea;

        //方法二 前一段柱子最小求出当前柱子最小 优化暴力算法 O(n^2)
        
        // int maxArea = 0;
        // for (int i = 0; i < heights.length; i++) {
        //     //定义最小高度值
        //     int height = Integer.MAX_VALUE;
        //     for (int j = i; j < heights.length; j++) {
        //          //对比前一个最小值
        //             height = Math.min(height, heights[j]);
        //             maxArea = Math.max(maxArea, (height * (j-i+1)));
                
        //     }
        // }
        // return maxArea;        
        
        //方法三 使用栈来处理 时间复杂度 O(n)
        //栈中存放放元素由小到大排列 进栈元素大于栈顶元素则出栈计算面积

        Stack<Integer> stack = new Stack<>();
        //先压如一个最小元素 给定都是非负数
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while(stack.peek()!=-1 && heights[stack.peek()]>= heights[i])
                maxArea = Math.max(maxArea, heights[stack.peek()]*(i - stack.peek() -1));
                stack.push(i);
            
        }
        //最后查看栈中剩余没出栈元素 比较面积
        while(stack.peek()!=-1){
            maxArea = Math.max(maxArea, heights[stack.pop()]*(heights.length - stack.peek() -1));
        }
        return maxArea;

}
// @lc code=end

