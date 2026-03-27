class Solution {
    public boolean areSimilar(int[][] mat,int k){
        int m=mat.length,n=mat[0].length;
        k%=n;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int nj;
                if(i%2==0) nj=(j+k)%n;
                else nj=(j-k%n+n)%n;
                if(mat[i][j]!=mat[i][nj]) return false;
            }
        }
        return true;
    }
}