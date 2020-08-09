/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原IP地址
 */

// @lc code=start
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        //dfs  
        dfs(s,0,0,"",res);
        return res; 
    }

    void dfs(String s,int index,int matchlen,String path,List<String> res){

        //递归结束条件
        if(matchlen == s.length()){ //匹配长度等于字符串长度
           if(index == 4) res.add(path.substring(1));
           return;
        }
        //逻辑处理 进入下层循环
        if(index>4) return;//超过每位的长度
        if(s.charAt(matchlen) == '0') {
                    //匹配到对应分割地址
            dfs(s,index+1,matchlen+1,path+".0",res);
        }else{
            for(int i = matchlen,t=0;i<s.length();i++){
               t = (int)t*10 + s.charAt(i)-'0';
               if(t<256) dfs(s,index+1,i+1,path+"."+String.valueOf(t),res);
               else break;
            }
        }

        //数据 reverse
        
    }
}
// @lc code=end

