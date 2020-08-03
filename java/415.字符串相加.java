/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        //迭代 
        //进位 遍历字符串指针
        int carry = 0, i = num1.length()-1,j = num2.length()-1;
        
        StringBuilder s = new StringBuilder();

        while(i >=0 || j >=0 || carry!=0){
           
            if(i>=0) carry += num1.charAt(i--) - '0';
            if(j>=0) carry += num2.charAt(j--) - '0';
            //字符串拼接
            s.append(carry%10);
            //获取进位
            carry = carry/10;
        }


        return s.reverse().toString();


    }
}
// @lc code=end

