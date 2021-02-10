/*
 * @lc app=leetcode.cn id=567 lang=java
 *
 * [567] 字符串的排列
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        //双指针 时间复杂度 O(n+m+∣Σ∣) 创建 cnt 需要 O(∣Σ∣) 的时间

        int s1len = s1.length();
        int s2len = s2.length();

        int [] count1 = new int[26];
        for(int i = 0;i<s1len;i++){
            --count1[s1.charAt(i) - 'a'];
        }

        int left =0;
        for(int right = 0;right<s2len;++right){
           int x = s2.charAt(right) - 'a';
           ++count1[x];
           while(count1[x] > 0){
            --count1[s2.charAt(left) - 'a'];
            ++left;
           }
           if(right - left+1 == s1len) return true;
        }
        return false;
    }
}
// @lc code=end

