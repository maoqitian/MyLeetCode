/*
 * @lc app=leetcode.cn id=1018 lang=java
 *
 * [1018] 可被 5 整除的二进制前缀
 */

// @lc code=start
class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {

        List<Boolean> res =new ArrayList<>();

        int num = 0;
        for(int i : A){
           num = num << 1;
           num +=i;
           num %= 10;
           res.add(num % 5 == 0);
        }

        return res;
    }
}
// @lc code=end

