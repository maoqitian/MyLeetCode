/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {

        //方法一 暴力破解 嵌套迭代 时间复杂度 O(n^2)
        /*int max =0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                //变量获取 值求 面积
                int maxArea = (j-i)*Math.min(height[i], height[j]);
                max = Math.max(max,maxArea);

            }
        }
        return max;*/

        //方法二 取边界值 获取往中间移动 一次迭代 时间复杂度 O(n)
        int max =0 ;
        for ( int i = 0, j = height.length-1;i<j;) {
            //获取高度较小的
            int mheight = height[i]<height[j] ? height[i++]:height[j--];
            int maxArea = (j-i+1)*mheight;
            max = Math.max(max,maxArea);

        }
        return max;
    }
}
// @lc code=end

