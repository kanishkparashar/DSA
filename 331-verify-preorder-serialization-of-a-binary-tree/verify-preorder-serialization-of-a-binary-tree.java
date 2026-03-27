class Solution {
    public boolean isValidSerialization(String preorder){
        String[] arr=preorder.split(",");
        int slots=1;
        for(String s:arr){
            if(slots==0) return false;
            if(s.equals("#")) slots--;
            else{
                slots--;
                slots+=2;
            }
        }
        return slots==0;
    }
}