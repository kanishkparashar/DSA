class Solution{
    public int largestAltitude(int[] gain){
        int alt=0;
        int ans=0;

        for(int x:gain){
            alt+=x;
            ans=Math.max(ans,alt);
        }

        return ans;
    }
}