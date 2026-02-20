class Solution{
    public String makeLargestSpecial(String s){
        java.util.List<String> parts=new java.util.ArrayList<>();
        int count=0,start=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')count++;
            else count--;
            if(count==0){
                String inner=s.substring(start+1,i);
                String solved=makeLargestSpecial(inner);
                parts.add("1"+solved+"0");
                start=i+1;
            }
        }
        java.util.Collections.sort(parts,java.util.Collections.reverseOrder());
        StringBuilder ans=new StringBuilder();
        for(String p:parts)ans.append(p);
        return ans.toString();
    }
}