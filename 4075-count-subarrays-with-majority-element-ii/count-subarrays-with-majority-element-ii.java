class Solution{
    public long countMajoritySubarrays(int[] nums,int target){
        int n=nums.length;
        int[] bit=new int[2*n+5];
        int off=n+2;
        int pre=0;
        long ans=0;
        add(bit,off,1);
        for(int x:nums){
            pre+=x==target?1:-1;
            ans+=sum(bit,pre+off-1);
            add(bit,pre+off,1);
        }
        return ans;
    }
    void add(int[] bit,int i,int v){
        while(i<bit.length){
            bit[i]+=v;
            i+=i&-i;
        }
    }
    int sum(int[] bit,int i){
        int s=0;
        while(i>0){
            s+=bit[i];
            i-=i&-i;
        }
        return s;
    }
}