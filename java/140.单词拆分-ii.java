/*
 * @lc app=leetcode.cn id=140 lang=java
 *
 * [140] 单词拆分 II
 */

// @lc code=start
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        //动态规划 开始判断是否有与 #139 题类似
        Set<String> wordDictSet = new HashSet(wordDict);

        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j, i))){
                  dp[i] = true;
                  break;
                }
            }
        }
       // 回溯算法搜索所有符合条件的解
       List<String> res = new ArrayList<>();

       if(dp[len]){
            //如果有符合条件的解
            Deque<String> path = new ArrayDeque<>();
            dfs(s,len,wordDictSet,dp,path,res);
       }

       return res;
    }
 /**
     * s[0:len) 如果可以拆分成 wordSet 中的单词，把递归求解的结果加入 res 中
     *
     * @param s
     * @param len     长度为 len 的 s 的前缀子串
     * @param wordDictSet 单词集合，已经加入哈希表
     * @param dp      预处理得到的 dp 数组
     * @param path    从叶子结点到根结点的路径
     * @param res     保存所有结果的变量
     */
    void dfs(String s, int len, Set<String> wordDictSet, boolean[] dp, Deque<String> path, List<String> res){
         //递归结束条件
         if(len == 0){
             //存入结果
            res.add(String.join(" ",path));
         }
         //逻辑处理，进入下层循环
         for(int i = len-1;i>=0;i--){
            String range = s.substring(i,len);
            if(wordDictSet.contains(range)&& dp[i]){
                path.addFirst(range);
                dfs(s,i,wordDictSet,dp,path,res);
                //回溯
                path.removeFirst();
            }
         }
         //数据reverse
    }
}
// @lc code=end

