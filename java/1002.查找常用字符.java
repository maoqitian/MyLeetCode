/*
 * @lc app=leetcode.cn id=1002 lang=java
 *
 * [1002] 查找常用字符
 */

// @lc code=start
class Solution {
    public List<String> commonChars(String[] A) {

        //使用 HashMap 暴力破解
        List<String> res = new ArrayList<>();
        if(A == null || A.length == 0) return res;
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(Character c : A[0].toCharArray()){
            //先记录第一个字符串作为后续对比
            map.put(c,map.getOrDefault(c,0)+1);
        }

        //遍历剩余字符串 进行匹配

        for(int i = 1;i<A.length;i++ ){
            HashMap<Character,Integer> map2 = new HashMap<>();
            //当前字符串长度
            String str = A[i];

            for(Character c : str.toCharArray()){
                if(map.containsKey(c)){
                    //记录最小出现次数
                    map2.put(c,Math.min(map2.getOrDefault(c,0)+1,map.get(c)));
                }
            }
            
            //赋值结果方便或许组成返回值
            map = map2;
        }

        for(Character c: map.keySet()){

            //获取出现最小次数
            int count = map.get(c);

            for(int i = 0;i<count;i++){
                res.add(String.valueOf(c));
            }

        }

        return res;
    }
}
// @lc code=end

