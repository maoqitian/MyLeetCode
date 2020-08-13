/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {

        //递归
        //递归结束条件
        if(n == 1) return "1"; 

        StringBuilder s = new StringBuilder();
        String str = countAndSay(n-1);

        int length = str.length();

        int a = 0;

        for(int i =1;i< length+1;i++){
           if(i == length){
             return s.append(i -a).append(str.charAt(a)).toString();
           }else if(str.charAt(i)!=str.charAt(a)){

               s.append(i-a).append(str.charAt(a));
               a = i;
           }
        }

        return s.toString();
    }
}
// @lc code=end

