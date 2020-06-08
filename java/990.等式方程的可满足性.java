import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=990 lang=java
 *
 * [990] 等式方程的可满足性
 */

// @lc code=start
class Solution {
    public boolean equationsPossible(String[] equations) {

        //并查集 想法 时间复杂度 O(n)
        // 使用 hashmap 实现并查集

        HashMap<Character,Character> map = new HashMap<>();

        //先处理相等的元素
        for (String c : equations) {
            
               char[] chars = c.toCharArray();
               if(chars[1] == '='){  //如果为相等元素      
                char first = chars[0];
                char second = chars[3];
                //如果已经存储
                while(map.containsKey(first)) first = map.get(first);
                while(map.containsKey(second)) second = map.get(second);
                //如果相等符合 跳过
                if(first == second) continue;
                map.put(first,second);
               }
        }
        //处理不相等的
        for (String c : equations) {
            char[] chars = c.toCharArray();
               if(chars[1] == '!'){  //如果为相等元素      
                char first = chars[0];
                char second = chars[3];
                //如果已经存储
                while(map.containsKey(first)) first = map.get(first);
                while(map.containsKey(second)) second = map.get(second);
                //如果字符相等 说明 表达式错误 返回 false
                if(first == second)return false;
               }
        }

        return true;

    }
}
// @lc code=end

