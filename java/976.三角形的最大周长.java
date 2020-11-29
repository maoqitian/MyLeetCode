/*
 * @lc app=leetcode.cn id=976 lang=java
 *
 * [976] 三角形的最大周长
 */

// @lc code=start
class Solution {
    public int largestPerimeter(int[] A) {

        //排序 从后面开始枚举 O(NlogN)

        Arrays.sort(A);
        if(A.length<3) return 0;
        
        //从后往前遍历获取

        for(int i =  A.length -1 ;i>=2;i--){
           if(A[i-2]+A[i-1] > A[i]){
               //两边之和大于第三边
               return A[i-2]+A[i-1] + A[i];
           }
        }

        return 0;


    }
}
// @lc code=end

