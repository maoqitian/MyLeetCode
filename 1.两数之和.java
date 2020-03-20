import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //方法一 暴力破解 迭代嵌套 时间复杂度 O (n^2)
        // int[] a = new int[2];
        // for(int i =0 ; i<= nums.length-1;i ++){
        //    for(int j = i+1;j<= nums.length;j ++){
        //       if(nums[i]+nums[j] == target){
        //         a[0] = nums[i];
        //         a[1] = nums[j];
        //         return a;
        //       }
        //    }
        // }
        //return a;

        //方法二 一次迭代 使用 hashmap 记录

        HashMap<Integer,Integer> hashMap =new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
          int a = target - nums[i];
          
          if(hashMap.containsKey(a)){
            return new int[]{hashMap.get(a),i};
          }
          hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
// @lc code=end

