class NestedIterator implements Iterator<Integer>{
    Stack<Iterator<NestedInteger>> st;
    Integer nextVal;

    public NestedIterator(List<NestedInteger> nestedList){
        st=new Stack<>();
        st.push(nestedList.iterator());
    }

    public Integer next(){
        return nextVal;
    }

    public boolean hasNext(){
        while(!st.isEmpty()){
            Iterator<NestedInteger> it=st.peek();
            if(!it.hasNext()){
                st.pop();
                continue;
            }
            NestedInteger ni=it.next();
            if(ni.isInteger()){
                nextVal=ni.getInteger();
                return true;
            }else{
                st.push(ni.getList().iterator());
            }
        }
        return false;
    }
}