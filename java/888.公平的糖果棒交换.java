/*
 * @lc app=leetcode.cn id=888 lang=java
 *
 * [888] 公平的糖果棒交换
 */

// @lc code=start
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {

        int sumA = 0;
        int sumB = 0;

        for(int temp :A){
           sumA += temp;
        }
        for(int temp :B){
            sumB += temp;
         }

         int gap = (sumA - sumB)/2;

         HashSet<Integer> set = new HashSet<>();
         for(int temp :A){
            set.add(temp);
         }

         for(int b : B){
            int a = gap + b;
            if(set.contains(a)){
               return new int[]{a,b};
            }
         }

         return new int[]{-1,-1};

    }
}
// @lc code=end

