/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        //方法一 hashmap
        //一次遍历 时间复杂度 O(n)
        if(nums.length <= 1) return false;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i =0;i<nums.length-1;i++){
           if(map.containsKey(nums[i])){
               return true;
           }else{
               map.put(nums[i],1);
           }
        }

        return false;

        //方法二
        //一次遍历 时间复杂度 O(nlogn)
        if(nums.length <= 1) return false;
        //HashMap<Integer,Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int i =0;i<nums.length-1;i++){
           if(nums[i] == nums[i+1]) return true;
        }

        return false;


    }
}
// @lc code=end

