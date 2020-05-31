import java.util.ArrayDeque;
import java.util.Deque;
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
        //添加足以哨兵

        int len = heights.length;
        if(len == 0){
          return 0;
        }

        if(len == 1){
          return heights[0];
        }

        int max = 0;
        int [] newHeights = new int[len+2];
        //加入原数组值
        for(int i =0;i < len;i++){
           newHeights[i+1] = heights[i];
        }

        len = len+2;
        //新哨兵数组赋值
        heights = newHeights;
        //创建栈
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for(int i = 1;i<len;i++){
           while(heights[stack.peekLast()] > heights[i]){
             int height = heights[stack.removeLast()];
             int width = i - stack.peekLast()-1;
             max = Math.max(max,width*height);
           }
           stack.addLast(i);
        }
        
      return max;
        
}
// @lc code=end

