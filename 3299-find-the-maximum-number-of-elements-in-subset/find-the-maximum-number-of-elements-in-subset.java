class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long,Integer> f=new HashMap<>();
        for(int x:nums)f.put((long)x,f.getOrDefault((long)x,0)+1);
        int ans=1;
        if(f.containsKey(1L)){
            int c=f.get(1L);
            ans=Math.max(ans,c%2==0?c-1:c);
        }
        for(long x:f.keySet()){
            if(x==1)continue;
            long cur=x;
            int len=0;
            while(f.getOrDefault(cur,0)>=2){
                len+=2;
                if(cur>1000000000L/cur){
                    cur=-1;
                    break;
                }
                cur*=cur;
            }
            if(cur!=-1&&f.containsKey(cur))len++;
            else len--;
            ans=Math.max(ans,Math.max(len,1));
        }
        return ans;
    }
}