class Solution{
	public int[] sortByBits(int[] arr){

		Integer[] a=new Integer[arr.length];
        for(int i=0;i<arr.length;i++)
			a[i]=arr[i];

		java.util.Arrays.sort(a,(x,y)->{
			int p=Integer.bitCount(x);
			int q=Integer.bitCount(y);

			if(p==q)
				return x-y;

			return p-q;
		});

		for(int i=0;i<arr.length;i++)
			arr[i]=a[i];

		return arr;
	}
}