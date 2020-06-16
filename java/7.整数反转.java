/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {

        if(x == Integer.MAX_VALUE) return 0;
        //定义符号变量
        // int neg = x<0 ? -1:1;

        // x = x*neg;
        
        // //返回值
        // int ret = 0;

        // while(x > 0){
        //   int n = ret;
        //   n= n*10;
        //   n= n + (x%10);
        //   x=x/10;
        //   //溢出
        //   if(n/10 != ret) return 0;
          
        //   ret = n ;
        // }
        // return ret*neg;

        int res = 0;
         
        while(x!=0){
          int tail = x % 10;
          int newRes = res*10 + tail;
          if((newRes-tail)/10 != res) return 0; //溢出

          res = newRes;
          //继续反转下一位
          x = x/10;
        }
        return res;
    }
}
// @lc code=end

