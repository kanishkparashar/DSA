class Solution {
    public int minSwaps(int[] arr) {
        int n=arr.length,k=0;
        for(int x:arr) if(x==1) k++;
        if(k==0) return -1;
        int curr=0;
        for(int i=0;i<k;i++) if(arr[i]==1) curr++;
        int max=curr;
        for(int i=k;i<n;i++){
            if(arr[i]==1) curr++;
            if(arr[i-k]==1) curr--;
            max=Math.max(max,curr);
        }
        return k-max;
    }
}