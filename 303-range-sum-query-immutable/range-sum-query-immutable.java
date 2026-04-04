class NumArray{
    int[] p;
    public NumArray(int[] nums){
        int n=nums.length;
        p=new int[n+1];
        for(int i=0;i<n;i++)p[i+1]=p[i]+nums[i];
    }
    public int sumRange(int l,int r){
        return p[r+1]-p[l];
    }
}