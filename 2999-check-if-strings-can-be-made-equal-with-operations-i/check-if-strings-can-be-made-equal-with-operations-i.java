class Solution {
    public boolean canBeEqual(String s1,String s2){
        char[] a=s1.toCharArray();
        char[] b=s2.toCharArray();

        if(!match(a[0],a[2],b[0],b[2])) return false;
        if(!match(a[1],a[3],b[1],b[3])) return false;

        return true;
    }

    boolean match(char x1,char x2,char y1,char y2){
        return (x1==y1&&x2==y2)||(x1==y2&&x2==y1);
    }
}