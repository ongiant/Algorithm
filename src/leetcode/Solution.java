package leetcode;

class Solution extends A{

    public int a(){
        return super.a() + 3;
    }

    public int b(){
        return 10;
    }

    public int c(){
        return 100;
    }

    public static void main(String[] args){
//        int[] a = {4,2,0,3,2,4,3,4};
//        int[] a = {4,2,0,3,2,5};
//        int ans = largestRectangleArea(a);
        System.out.println(new Solution().a());
    }
    public static int largestRectangleArea(int[] heights) {

        int ans = 0;
        int n = heights.length;
        int[] q = new int[n];
        int[] width = new int[n];
        int tt = -1;
        for(int i=0; i<n + 1; i++){
            int w = 0;
            while(tt >= 0 && (i==n || heights[q[tt]] > heights[i])){
                width[q[tt]] += i - q[tt];
                tt--;
            }
            if(i<n){
                width[i] = tt < 0 ? i : i - q[tt] - 1;
                q[++tt] = i;
            }
        }
        for(int i=0; i<n; i++){
            int r = heights[i] * width[i];
            ans = Math.max(ans, r);
        }
        return ans;
    }

}

class A{
    public int a() {
        return b() + c();
    }

    public int  b() {
        return 1;
    }

    public int c() {
        return 2;
    }
}