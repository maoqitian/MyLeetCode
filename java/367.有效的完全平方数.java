/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {

        //想法 二分查找 时间复杂度 O（logn）
        // if (num < 2) {
        //     return true;
        //   }
        // long left =2,right =num/2,mult,mid;
        // while(left <= right){

        //     mid = left+(right-left)/2;
            
        //     mult = mid*mid;

        //     if(mult == num) return true;

        //     if(mult > num ){
        //       right = mid-1;
        //     }else {
        //       left = mid+1;
        //     }
        // }

        // return false;

        //方法二 牛顿迭代法 曲线递增 没搞懂 时间复杂度 O（logn）

         if (num < 2) return true;

         long x  = num/2;
         while(x*x>num){
             x = (x + num/x)/2;
         }

         return (x*x == num);
          
        
    }
}
// @lc code=end

