/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {


        //方法一 迭代嵌套 时间复杂度 O(n^2)
        //假定刚开始面积等于零
        // int max = 0;
        // for (int i = 0; i < height.length; i++) {
        //     for (int j = i+1; j < height.length; j++) {
        //         //获取两个较小的高度算出面积
        //         int areMax = (j-i)*Math.min(height[i], height[j]);
                
        //         max = Math.max(max, areMax);
        //     }
        // }

        // return max;


        //方法二 双指针放 头尾指针 往中间夹逼  时间复制度 O(n)
        int max = 0;
        for(int i = 0 ,j = height.length-1; i<j;){
            
            //首先比较两个指针值得比较小高度
            int minHeight = height[i]<height[j] ? height[i++] : height[j--];
            int areMax = (j-i+1)*minHeight; //宽度加1 弥补指针移动的一点
            max = Math.max(max, areMax);  
        }
         return max;

    }
}
// @lc code=end

