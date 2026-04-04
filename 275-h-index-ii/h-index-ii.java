class Solution{
    public int hIndex(int[] c){
        int n=c.length,l=0,r=n-1;
        while(l<=r){
            int m=(l+r)/2;
            if(c[m]>=n-m)r=m-1;
            else l=m+1;
        }
        return n-l;
    }
}