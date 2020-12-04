/*
 * @lc app=leetcode.cn id=204 lang=java
 *
 * [204] 计数质数
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        //计算过程 gif
        //https://assets.leetcode.com/static_assets/public/images/solutions/Sieve_of_Eratosthenes_animation.gif
        //时间复杂度 O(n)

        boolean[] notPrimes = new boolean[n];
        int res = 0;
        //从2 开始遍历
        for(int i = 2;i < n ; i++){
           if(notPrimes[i] == false){
               //质数计数
               res++;
              for(int j = 2;j*i< n ;j++){
                //剩余位置计算不是质数
                notPrimes[i*j] = true;
              }
           }
        }
        return res;
    }
}
// @lc code=end

