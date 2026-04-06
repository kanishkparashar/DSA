class Node:
	def __init__(self,data,order):
		self.data=data
		self.order=order
		self.left=None
		self.right=None

class Solution:
	def huffmanCodes(self,S,f):
		import heapq
		
		pq=[]
		for i in range(len(f)):
			heapq.heappush(pq,(f[i],i,Node(f[i],i)))
		
		while len(pq)>1:
			f1,o1,n1=heapq.heappop(pq)
			f2,o2,n2=heapq.heappop(pq)
			
			parent=Node(f1+f2,min(o1,o2))
			parent.left=n1
			parent.right=n2
			
			heapq.heappush(pq,(parent.data,parent.order,parent))
		
		res=[]
		
		def dfs(root,s):
			if root.left is None and root.right is None:
				res.append(s if s!="" else "0")
				return
			dfs(root.left,s+"0")
			dfs(root.right,s+"1")
		
		dfs(pq[0][2],"")
		return res