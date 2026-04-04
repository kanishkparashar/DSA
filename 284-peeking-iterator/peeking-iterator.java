class PeekingIterator implements Iterator<Integer>{
    Iterator<Integer> it;
    Integer next;
    public PeekingIterator(Iterator<Integer> iterator){
        it=iterator;
        next=it.hasNext()?it.next():null;
    }
    public Integer peek(){
        return next;
    }
    public Integer next(){
        Integer res=next;
        next=it.hasNext()?it.next():null;
        return res;
    }
    public boolean hasNext(){
        return next!=null;
    }
}