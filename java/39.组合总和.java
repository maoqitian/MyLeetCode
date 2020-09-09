/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // dfs 回溯 减枝 使用栈 先进后出 每次减枝除去最后不符而的数字 
        //时间复杂度 O(S) (S 为组合长度)
        //想法 每次取出一个与 target 相减 继续在数组中寻找数与 target 相减

        List<List<Integer>> res = new ArrayList<>();

        if(candidates == null) return res;

        dfsCombine(0,new LinkedList<Integer>(),candidates,target,res);
        
        return res;
    }

    void dfsCombine(int index,LinkedList<Integer> stack,int[] candidates, int target,List<List<Integer>> res){

        //递归结束条件
        if(target == 0){
           //如果target 等于零 说明匹配到了合适数组
           res.add(new ArrayList<>(stack));
           return;
        }
        //逻辑处理 进入下层循环

        //遍历数组取数
        //遍历 index 为本分支上一节点的减数下标
        for(int i = index;i< candidates.length;i++){
            
            //如果target  大于等于当前数值  
            if(candidates[i]<=target){
                 //栈中加入当前值 
                stack.addFirst(candidates[i]);
                //目标值减去元素值
                dfsCombine(i,stack,candidates,target-candidates[i],res);
               //回溯删除前面不符合的元素值
                stack.removeFirst();
            }
        }

        //数据 reverse
    }
}
// @lc code=end

