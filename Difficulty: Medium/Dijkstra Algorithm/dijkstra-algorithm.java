import java.util.*;

class Solution {
    public int[] dijkstra(int V,int[][] edges,int src){
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());

        for(int[] e:edges){
            adj.get(e[0]).add(new Pair(e[1],e[2]));
            adj.get(e[1]).add(new Pair(e[0],e[2]));
        }

        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.w-b.w);
        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            int node=cur.v;
            int d=cur.w;

            if(d>dist[node]) continue;

            for(Pair nei:adj.get(node)){
                int v=nei.v;
                int wt=nei.w;

                if(dist[node]+wt<dist[v]){
                    dist[v]=dist[node]+wt;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }

        return dist;
    }
}

class Pair{
    int v,w;
    Pair(int v,int w){
        this.v=v;
        this.w=w;
    }
}