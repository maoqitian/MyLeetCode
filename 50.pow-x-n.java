/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {

        //想法一 暴力破解  时间复杂度 O(n) 超时

        // long N = n;
        // if(N<0){
        //   x = 1/x;
        //   N = - N;
        // }

        // double res =1;

        // for (long i = 0; i < N; i++) {
        //     res*=x;
        // }

        // return res;

        //思路二 分治递归 把总体计算分解 时间复杂度 则为 logn
        // 2^10 = 2^5 * 2^5
        // 2^5 = 2 * 2^2 * 2^2

        //首先判断 n 是否大于0

        if(n<0){
          x = 1/x;
          n = -n;
        }

        return fastPow(x,n);
    }

    /**
     * 递归 分治
     * @param x
     * @param n
     * @return
     */
    double fastPow(double x,int n){
        //递归结束条件
        if( n == 0){
           return 1.0;
        }
        //逻辑处理，进入下层递归
        //获取每一次分治结果
        double resHalf = fastPow(x, n/2);
        //合并 递归分治后数据
        if(n % 2 == 0){ //偶数
           return resHalf * resHalf;
        }else{ //奇数
           return x * resHalf * resHalf;
        }
        //数据释放
    }
}
// @lc code=end

