/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        //不能重复 则需要更多剪枝 条件
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null) return res;
        //先排序好数组 关键
        Arrays.sort(candidates);

        dfsCombine(target,0,candidates,new LinkedList<Integer>(),res);

        return res;

    }

    void dfsCombine(int target,int index,int[] candidates,LinkedList<Integer> stack,List<List<Integer>> res){

        //递归结束条件
        if(target == 0){
            res.add(new ArrayList<>(stack));
            return;
        }
        //逻辑处理 进入下层循环

        for(int i = index;i<candidates.length;i++){

            //如果当前减去candidates[i] 已经小于零 则后面的值不用考虑
            if(target - candidates[i]<0) break;
            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            stack.addLast(candidates[i]);
            dfsCombine(target-candidates[i],i+1,candidates,stack,res);

            //回溯
            stack.removeLast();

        }
        //数据 reverse

    }
}
// @lc code=end

