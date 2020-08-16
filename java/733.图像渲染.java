/*
 * @lc app=leetcode.cn id=733 lang=java
 *
 * [733] 图像渲染
 */

// @lc code=start
class Solution {

    int [] dx = new int[]{1,0,0,-1};
    int [] dy = new int[]{0,1,-1,0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        //BFS 广度优先遍历 时间复杂度 O(n * m)
        // int currColor = image[sr][sc];

        // if(currColor == newColor){
        //   return image;
        // }

        // int n = image.length,m = image[0].length;

        // Queue<int[]> queue = new LinkedList<int[]>();

        // queue.add(new int[]{sr,sc});

        // image[sr][sc] = newColor;

        // while(!queue.isEmpty()){
        //     int[] cell = queue.poll();
        //     int x = cell[0],y = cell[1];

        //     for(int i = 0;i< 4;i++){
        //        int mx = x + dx[i],my = y+dy[i];
        //        if(mx >= 0 && mx<n && my >= 0 && my<m && image[mx][my] == currColor){
        //           queue.add(new int[]{mx,my});
        //           image[mx][my] = newColor;
        //        }
        //     }
        // }

        // return image;

        //深度优先 DFS 递归 时间浮渣度 O(n * m)
        int currColor = image[sr][sc];
        if(currColor != newColor){
            dfs(image,sr,sc,currColor,newColor);
        }
        return image;
    }

    void dfs(int[][] image,int x,int y,int color,int newColor){
        //递归结束条件
        if(image[x][y] == color){
           image[x][y] = newColor;
           for(int i = 0;i< 4;i++){
            int mx = x + dx[i],my = y+dy[i];
            if(mx >= 0 && mx<image.length && my >= 0 && my<image[0].length ){
                dfs(image,mx,my,color,newColor);     
                }
            }
        }
    }

}
// @lc code=end

