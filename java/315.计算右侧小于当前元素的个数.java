import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */

// @lc code=start
class Solution {

       private int[] index;
        private int[] helper;
        private int[] count;

    public List<Integer> countSmaller(int[] nums) {


        //两个循环暴力解决 时间复杂度 O(n^2) 超时

        // if(nums.length == 0 || nums == null) return new ArrayList<Integer>();
        // int currCount = 0;
        // List<Integer> res = new ArrayList<>();
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i+1; j < nums.length; j++) {
        //         if(nums[i]>nums[j]){
        //            currCount += 1;
        //         }
        //     }
        //     res.add(currCount);
        //     currCount = 0;
        // }

        // return res;

        
        List<Integer> res = new ArrayList<>(nums.length);

    index = new int[nums.length];
    helper = new int[nums.length];
    count = new int[nums.length];
    for (int i = 0; i < index.length; i++) {
      index[i] = i;
    }

    merge(nums, 0, nums.length - 1);

    for (int i = 0; i < count.length; i++) {
      res.add(i, count[i]);
    }
    return res;
    }

    void merge(int[] nums,int s,int e){
        
        if (s == e || s > e) return;
    int mid = (s + e) >> 1;

    if (s < mid) {
      merge(nums, s, mid);
    }

    if (mid + 1 < e) {
      merge(nums, mid + 1, e);
    }

    int i = s, j = mid + 1;
    int hi = s;
    while (i <= mid && j <= e) {
      if (nums[index[i]] <= nums[index[j]]) {
        // 右侧出
        helper[hi++] = index[j++];
      } else {
        // 左侧出 计数
        count[index[i]] += e - j + 1;
        helper[hi++] = index[i++];
      }
    }

    while (i <= mid) {
      //左侧出
      helper[hi++] = index[i++];
    }

    while (j <= e) {
      // 右侧出
      helper[hi++] = index[j++];
    }

    for (int k = s; k <= e; k++) {
      index[k] = helper[k];
    }
  

    }


}
// @lc code=end

