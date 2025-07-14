public class trappingwater {
    public static int trappedWater(int[] heights){
        int n = heights.length;

        //Calculate Left Max array 
        int[] leftMax = new int[n];
        leftMax[0]=heights[0];
        
        for(int i = 1 ; i < n ; i++){
            leftMax[i] = Math.max(heights[i],leftMax[i-1]);
            
        }
        
        //Calculate Right Max array 
        int[] rightMax = new int[n];
        rightMax[n-1]=heights[n-1];
        
        for(int i = n-2 ; i >= 0 ; i--){
            rightMax[i] = Math.max(heights[i],rightMax[i+1]);
            
        }
        
        //loop
        int trappedWater=0;
        for(int i = 0 ; i<n ; i++){
            int waterLevel = Math.min(leftMax[i],rightMax[i]);
            trappedWater += waterLevel-heights[i]; 
        }
        return trappedWater;
    }
    public static void main(String[] args) {
        int[] heights = {4,2,0,6,3,2,5};
        System.out.println(trappedWater(heights));
    }
}
