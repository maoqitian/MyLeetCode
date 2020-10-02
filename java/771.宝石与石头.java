/*
 * @lc app=leetcode.cn id=771 lang=java
 *
 * [771] 宝石与石头
 */

// @lc code=start
class Solution {
    public int numJewelsInStones(String J, String S) {

          //方法一 暴力遍历 时间复杂度 O(m*n) m n 为 J S 字符串长度
        //   int res = 0;

        //   for(int i = 0;i<J.length();i++){
        //     for(int j = 0 ; j < S.length();j++){
        //          if(J.charAt(i) == S.charAt(j)){
        //             res++;
        //          }
        //     }
        //   }

        //   return res;

          //方法二 HashSet 优化 时间复杂度 O(m+n)

          int res = 0;
          HashSet<Character> set = new HashSet<>();

          for(int i = 0;i<J.length();i++){
            set.add(J.charAt(i));
          }

          for(int j = 0 ; j < S.length();j++){
            if(set.contains(S.charAt(j))){
               res++;
            }
       }

       return res;



    }
}
// @lc code=end

