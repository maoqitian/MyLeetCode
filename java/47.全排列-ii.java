import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {


        //思路 深度优先 递归 dfs + 回溯 加入判断条件 减枝 间复杂度：O(n * n!) 其中 n 为序列的长度

        List<List<Integer>> res = new ArrayList<>();

        int len = nums.length;

        if(nums.length == 0){
           return res;
        }
        //首先对原始数组进行排序
        Arrays.sort(nums);
        //使用栈来存放对应取出排放的数据组合 
        Deque<Integer> path = new ArrayDeque<Integer>();
        //存放当前组合位置是否已经有对应的数据数组
        boolean[] used = new boolean[len];
        
        dfs(0,nums,path,used,len,res);

        return res;

    }
      /**
       * 
       * @param depth 当前组合树深度
       * @param nums  需要组合的数组
       * @param path  存放的组合栈
       * @param used  位置是否已经使用的数组
       * @param len   待获取组合的数组长度
       * @param res   已经组合好的结果值
       */
    void dfs(int depth,int[] nums,Deque<Integer> path,boolean[] used,int len,List<List<Integer>> res){

        //递归结束条件
        if(depth == len){ //如果此时树层级深度 等于 数组长度 到底
           res.add(new ArrayList<>(path));
           return;
        }

        for (int i = 0; i < len; i++) {
            if(used[i]){ //如果当前位置已经使用
               continue;
            }
            //进行减枝 操作 去重

            if(i>0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }

            //记录当前数组
            path.addLast(nums[i]);
            //该位置已经使用
            used[i] = true;
            //进入下层递归
            dfs(depth+1, nums, path, used, len, res);

            //回溯 相当于前面的逆向操作 回退
            path.removeLast();
            used[i] = false;
            
        }
    }
}
// @lc code=end

