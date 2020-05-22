import java.util.Stack;

/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {

       //方法一 暴力暴力破解 分别获取左右边界最小值减去当前值看是否会有多出面积进行累加
       //时间复杂度 O(n^2)
    //    int result = 0;
    //      //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
    //    for (int i = 1; i < height.length-1; i++) { //从第二个数开始遍历
    //        int left = 0;
    //        int right = 0;
    //        //找到左边界最小值
    //        for (int j = i-1; j >= 0 ; j--) {
    //            left = Math.max(left, height[j]); 
    //        }    
    //        //找到右边界最小值
    //        for (int j = i+1; j < height.length; j++) {
    //          right = Math.max(right, height[j]); 
    //        }
    //        int min = Math.min(left, right);
    //        //只有较小的一段大于当前列的高度才会有水
    //         if(min >height[i]){
    //            result = result + min - height[i];
    //         }
    //    }

    //    return result;


       //方法2 使用栈 
       
       //利用栈来存储对应遍历的数组下标 当前下标值小于栈顶元素值，则入栈，移动指针继续遍历。（能够积水）
       //当前下标值大于栈顶元素，则出栈计算 
       //时间复杂度 O(n)

       int  result = 0;

       Stack<Integer> stack = new Stack<>();
       //指针
       int current = 0;

       while(current < height.length){
          //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
          while(!stack.isEmpty() && height[current] > height[stack.peek()]){
              int h = height[stack.peek()];
              stack.pop();
              
              if(stack.isEmpty()){
                 break;
              }
              //两个柱子间距离
              int dist = current - stack.peek() -1;
              //获取较小高度
              int min = Math.min(height[stack.peek()], height[current]);
              result = result + dist *(min - h);
          }
          //否则存储当前下标 移动指针
          stack.push(current);
          current ++ ;

       }

       return result;

    }
}
// @lc code=end

