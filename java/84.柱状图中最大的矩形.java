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
        //使用栈来存储数组对应下标 
        //按从小到大顺序入栈，如果当前入栈元素大于栈顶元素值，则在栈中记录下标
        //否则小于说明可以根据当前高度获取左右边界计算面积 并且比较之前记录的面积比较最大值
    
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <=heights.length;) {
            //首先获取高度当期遍历柱子高度
            int height = heights[i];
            if(stack.isEmpty() || height >= heights[stack.peek()]){//对比高度
              stack.push(i);
              i++;
            }else {
              //计算面积
              //左边界
              int left = stack.isEmpty()? 0 : stack.peek()+1; 
              //右边界
              int right = i -1;
              //高度
              int curHeght = heights[stack.pop()];
              maxArea = Math.max(maxArea, (right-left+1)*height);
            }
        }

        return maxArea;

}
// @lc code=end

