/*
 * @lc app=leetcode.cn id=216 lang=java
 *
 * [216] 组合总和 III
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        //dfs 递归回溯 时间复杂度 O(k)

        List<List<Integer>> res = new ArrayList<>();

        dfsCombine(n,1,k,new ArrayList<>(),res);

        return res;
    }

    void dfsCombine(int target,int index,int k,List<Integer> list,List<List<Integer>> res){

        //递归结束条件
        if( list.size() == k||target<=0){ //再往下找也没意义 减少不必要的递归
            if(target == 0 && list.size() == k){
                //符合题目给出条件
                res.add(new ArrayList<>(list));
                return;
             }
        }
        
        //逻辑处理 进入下层循环
        for(int i = index;i<=9;i++){
            
            list.add(i);

            //不能重复 index = i+1
            dfsCombine(target-i,i+1,k,list,res);
            //不满足 回溯
            list.remove(list.size()-1);
        }
        //数据reverse
    }
}
// @lc code=end

