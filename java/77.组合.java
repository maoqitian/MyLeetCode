import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {

    //时间复杂度 O(( k n)×k)

    public List<List<Integer>> combine(int n, int k) {
    //返回结果
    
     List<List<Integer>> res = new ArrayList<List<Integer>>();

     backdfs(1,n,k,new ArrayList<Integer>(),res);

     return res;
    }

    /**
     * 
     * @param first 遍历数组的起始值
     * @param n 遍历范围
     * @param k   剩余获取元素值
     * @param curr 当前结果集合
     * @param curr 结果集合
     */
    private  void backdfs(int first,int n,int k,List<Integer> curr,List<List<Integer>> res){

        //递归结束条件
        if(curr.size() == k){
           res.add(new ArrayList<>(curr));
           return;
        }
        //逻辑处理 进入下层循环 回溯

        for (int i = first; i <= n; i++) {
            //加入元素
            curr.add(i);
            //根据当前 i 进入下层循环
            backdfs(i+1, n, k, curr, res);
            //回溯 删除数组最后一个元素
            curr.remove(curr.size() -1);
        }

    }
}
// @lc code=end

