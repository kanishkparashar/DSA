class Solution{
    public String decodeCiphertext(String encodedText,int rows){
        if(rows==0)return "";
        int n=encodedText.length(),cols=n/rows;
        char[][] m=new char[rows][cols];
        int k=0;
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                m[i][j]=encodedText.charAt(k++);
        StringBuilder sb=new StringBuilder();
        for(int c=0;c<cols;c++){
            int i=0,j=c;
            while(i<rows&&j<cols){
                sb.append(m[i][j]);
                i++;j++;
            }
        }
        int end=sb.length()-1;
        while(end>=0&&sb.charAt(end)==' ')end--;
        return sb.substring(0,end+1);
    }
}