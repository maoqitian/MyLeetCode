/*
 * @lc app=leetcode.cn id=845 lang=java
 *
 * [845] 数组中的最长山脉
 */

// @lc code=start
class Solution {
    public int longestMountain(int[] A) {

        //左右扩散 时间复杂度 O(n)

        if(A.length < 3){
           return 0;
        } 
        
        int left = 0,right = 0,res = 0;
        //遍历枚举 山顶
        for(int i = 1; i< A.length;i++){
            if(A[i] > A[i-1]){
               if(i < 2 || A[i-1] <=A[i-2]){
                  right = 1;
               }
               right++;
               left = 0;
            }else if(A[i] < A[i-1]){
                left++;
                if(right>0){
                    res = Math.max(res,left+right);
                }
            }else{
                left = 0;
                right = 0;
            }
        }
        return res;
    }
}
// @lc code=end

