import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        //分治算法 递归 时间复杂度 O(n * 2^n)

        List<List<Integer>> res = new ArrayList<>();

        if(nums.length == 0){
          return res;
        }

        dfs(0,nums,new ArrayList<Integer>(),res);
        
        return res;

    }

    /**
     * 
     * @param index 当前层 指向遍历 index
     * @param nums  传入可取数据的数组
     * @param list  保存当前层结果
     * @param res   最终递归返回值
     */
    void dfs(int index , int[] nums,List<Integer> list,List<List<Integer>> res){

        //递归结束条件
        if(index == nums.length){ //表示遍历到了最深层 获取返回结果
           res.add(new ArrayList<>(list));
           return;
        }
        //逻辑处理 进入下层递归

        //如果当前层不选数字
        dfs(index+1, nums, list, res);
        //如果当前层选数据
        list.add(nums[index]);
        dfs(index+1, nums, list, res);
        //数据reverse
        //删除本层选取结果
        list.remove(list.size()-1);

    }
}
// @lc code=end

