class Solution{
    static int countStrings(int n){
        int[]zero=new int[n+1];
        int[]one=new int[n+1];
        zero[1]=1;
        one[1]=1;
        for(int i=2;i<=n;i++){
            zero[i]=zero[i-1]+one[i-1];
            one[i]=zero[i-1];
        }
        return zero[n]+one[n];
    }
}