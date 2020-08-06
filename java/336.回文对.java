/*
 * @lc app=leetcode.cn id=336 lang=java
 *
 * [336] 回文对
 */

// @lc code=start
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> res = new ArrayList<>();
        if(words == null || words.length<2) return res;

        //想法一 暴力求解 时间复杂度 O(n^2 * m) m 为字符串平均长度 超出时间限制

        // for(int i =0;i<words.length;i++){
        //     for(int j =0;j<words.length;j++){
                
        //         if(i!=j&& isValid(words[i]+words[j])){
        //             List<Integer> item = new ArrayList<>();
        //             item.add(i);
        //             item.add(j);
        //             res.add(item);
        //         }
        //     }
        // }
        
        //想法二 hashmap 表优化
        //存放字符串值和index
        HashMap<String,Integer> map = new HashMap<>();
        for(int i =0;i<words.length;i++) map.put(words[i],i);

        for(int i =0;i<words.length;i++){
           for(int j =0;j<=words[i].length();j++){// "j <= words[i].length()"
              String str1 = words[i].substring(0,j);
              String str2 = words[i].substring(j);
              if(isValid(str1)){
                String str2re = new StringBuilder(str2).reverse().toString();
                if(map.containsKey(str2re) && map.get(str2re) != i){
                    List<Integer> item = new ArrayList<>();
                                 item.add(map.get(str2re));
                                 item.add(i);
                                 res.add(item);
                }
              }

              if(isValid(str2)){
                String str1re = new StringBuilder(str1).reverse().toString();
                if(map.containsKey(str1re) && map.get(str1re) != i&&str2.length()!=0){
                    List<Integer> item = new ArrayList<>();
                                 item.add(i);
                                 item.add(map.get(str1re));
                                 res.add(item);
                }
              }
              
           }
        }
        return res;
    }
    //判断字符串是否是回文串
    boolean isValid(String s){

        int left = 0,right = s.length()-1;
        while(left <= right){
            if(s.charAt(left) == s.charAt(right)){
               left++;
               right--;
            }else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

