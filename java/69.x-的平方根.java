/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {

        //想法 二分查找

        if(x == 0 || x == 1){
           return x;
        }

        //确定边界
        int left =0,right = x,res = -1;

        while(left<=right){
            //获取中间值
            int mid = left + (right-left)/2;
            if ((long)mid * mid <= x) {
                res = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return res;
    }
}
// @lc code=end

