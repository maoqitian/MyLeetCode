import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        //字符串匹配 动态规划 时间复杂度 O(n^2)

         /*
        动态规划算法，dp[i]表示s前i个字符能否拆分
        转移方程：dp[j] = dp[i] && check(s[i+1, j]);
        check(s[i+1, j])就是判断i+1到j这一段字符是否能够拆分
        其实，调整遍历顺序，这等价于s[i+1, j]是否是wordDict中的元素
        这个举个例子就很容易理解。
        假如wordDict=["apple", "pen", "code"],s = "applepencode";
        dp[8] = dp[5] + check("pen")
        翻译一下：前八位能否拆分取决于前五位能否拆分，加上五到八位是否属于字典
        （注意：i的顺序是从j-1 -> 0哦~
        */

        //d[i]表示子数组(0,i)能否从字典中分割成单词。所以d[0]表示子数组(0,0)(空字符串)是否可以分段，当然答案是肯定的。
        //布尔数组的默认值为false。因此我们需要使d[0]为真。

        Set<String> wordDictSet = new HashSet(wordDict);

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j, i))){
                  dp[i] = true;
                  break;
                }
            }
        }
      
        return dp[s.length()];
    }
}
// @lc code=end

