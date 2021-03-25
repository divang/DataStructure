class PathWithMinimumEffort_BackTracking {
    public int minimumEffortPath(int[][] heights) {
        if(heights[0].length ==1) return 0;
        dfs(heights, 0,0,0);
        return minHop == Integer.MAX_VALUE ? 0: minHop;
    }
    
    int minHop = Integer.MAX_VALUE;
    
    public void dfs(int[][] heights, int i, int j, int routeMaxHop) {
        
        if(i == heights.length -1 && j == heights[0].length -1) {
            if(routeMaxHop < minHop) minHop = routeMaxHop;
            return;
        }
        
        if(i<0 || i>= heights.length) return;
        else if(j<0 || j >= heights[0].length) return;
        
        if(heights[i][j] < 0 || heights[i][j] > 1000000) return;    
        
        int curHeight = heights[i][j];
        heights[i][j] = -curHeight;
        
        goUp(heights, i-1, j, curHeight, routeMaxHop);
        goUp(heights, i+1, j, curHeight, routeMaxHop);
        goUp(heights, i, j-1, curHeight, routeMaxHop);
        goUp(heights, i, j+1, curHeight, routeMaxHop); 
        heights[i][j] = curHeight;
        
    }
    
    public void goUp(int[][] heights, int i, int j, int curHeight, int routeMaxHop) {
        
        if(i>=0 && i< heights.length && j>=0 && j< heights[0].length && heights[i][j] >0) {
            int curHop = Math.abs(heights[i][j] - curHeight);
           // System.out.println("Current Height: "+curHeight + " next point-" + heights[i][j] + " ("+i+","+j+") hop: " + curHop);
            dfs(heights, i, j, Math.max(routeMaxHop, curHop));

        }
    }
}
