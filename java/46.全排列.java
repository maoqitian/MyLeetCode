import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {


        //思路 深度优先 递归 dfs + 回溯 时间复杂度：O(n * n!) 其中 n 为序列的长度

        //获取数组长度 也就是树的深度 
        int len = nums.length;
        //返回值
        List<List<Integer>> res = new ArrayList<>();
        
        //如果 数组为空 直接返回
        if(len == 0){
          return res;
        }

        //使用栈记录 枚举的值 也就是 排列的数组 最终转换为list 集合
        Deque<Integer> path = new ArrayDeque<Integer>();
        //使用 boolean 类型数据记录当前位置是否已经记录了 数字
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
       * @param len   数组长度
       * @param res   已经组合好的结果值
       */
      void dfs(int depth,int[] nums,Deque<Integer> path,boolean[] used,int len,List<List<Integer>> res){
           //递归结束条件
           if(len == depth){
             res.add(new ArrayList<>(path));
             return;
           }
           //逻辑处理进入下层递归
           for (int i = 0; i < len; i++) {
               if(used[i]){ //如果当前位置已经使用 则继续选取下一个
                  continue;
               }
             
               path.addLast(nums[i]);
               used[i] = true;
               dfs(depth+1, nums, path, used, len, res);
               //执行回溯操作
               path.removeLast();
               used[i] = false;
               
           }

      }
}
// @lc code=end

