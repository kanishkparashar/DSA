class Solution:
	def maxValue(self, nums):
		n=len(nums)
		suf=[0]*n
		ans=[0]*n
		
		suf[n-1]=nums[n-1]
		
		for i in range(n-2,-1,-1):
			suf[i]=min(suf[i+1],nums[i])
		
		l=0
		mx=nums[0]
		
		for i in range(n-1):
			mx=max(mx,nums[i])
			
			if mx<=suf[i+1]:
				for j in range(l,i+1):
					ans[j]=mx
				
				l=i+1
				mx=nums[l]
		
		mx=max(nums[l:])
		
		for i in range(l,n):
			ans[i]=mx
		
		return ans