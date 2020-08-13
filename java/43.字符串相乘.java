/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
          
        //先乘 后相加 时间复杂度 O(m*n)

        int m = num1.length(),n = num2.length();

        int[] pos = new int[m+n];

        for(int i = m-1;i>=0;i--){

            for(int j = n-1;j>=0;j--){
                //获取当前乘积
                int cur = (num1.charAt(i) - '0')*(num2.charAt(j)-'0');

                int p1 = i+j,p2 = i+j+1;
                int sum = cur + pos[p2];

                //10位
                pos[p1] += sum/10;
                //个位
                pos[p2] = sum%10; 
            }
        }
        //拼接结果
        StringBuilder s = new StringBuilder();
        for(int p : pos){
          if(!(s.length() == 0 && p == 0)){
              s.append(p);
          }
        }

        return s.length() == 0? "0": s.toString();
    }
}
// @lc code=end

