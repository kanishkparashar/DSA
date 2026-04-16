class Solution{
    public int myAtoi(String s){
        int i=0,n=s.length(),sign=1;
        long res=0;
        while(i<n&&s.charAt(i)==' ') i++;
        if(i<n&&(s.charAt(i)=='+'||s.charAt(i)=='-')){
            if(s.charAt(i)=='-') sign=-1;
            i++;
        }
        while(i<n&&Character.isDigit(s.charAt(i))){
            int d=s.charAt(i)-'0';
            res=res*10+d;
            if(sign==1&&res>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign==-1&&-res<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)(sign*res);
    }
}