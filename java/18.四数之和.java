/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        //双指针  时间复杂度 O(n^3)

        List<List<Integer>> res = new ArrayList<>();

        int length = nums.length;

        //排序好数组
        Arrays.sort(nums);
        
        if(length == 0) return res;

        for(int a = 0; a < length-3;a++){//开头指针
           //相等跳过当前数
           if(a > 0 && nums[a] == nums[a-1]) continue;

           for(int d = length-1; d > a+2;d-- ){ //末尾指针
               //相等跳过当前数
              if(d < length-1 && nums[d] == nums[d+1]) continue;
              //确定另外两数index
              int b = a+1;
              int c = d-1;
              //当前和最小值
              int min = nums[a] + nums[d] + nums[b] + nums[b+1];
              if(min > target) continue;
              //当前和最大值
              int max = nums[a] + nums[d] + nums[c-1] + nums[c];
              //不在当前范围 
              if(max < target) break;

              while(c > b){
                  //继续以 c b 为指针寻找
                int sum=nums[a]+nums[b]+nums[c]+nums[d];

                if (sum>target)c--;
                    else if (sum<target)b++;
                    else{
                        res.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
                        while (c>b&&nums[b]==nums[b+1])b++;
                        while (c>b&&nums[c]==nums[c-1])c--;
                        b++;
                        c--;
                    }
              }
           }
        }  

        return res;
    }
}
// @lc code=end

