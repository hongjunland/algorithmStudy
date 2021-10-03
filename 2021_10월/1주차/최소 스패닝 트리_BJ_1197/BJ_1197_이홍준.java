package com.company;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_1197_이홍준 {
    static int V;
    static int E;
    static int[] minEdge;
    static int[] parent;
    static int find(int num){
        if(num==parent[num]) return num;
        return parent[num] = find(parent[num]);
    }
    static boolean union(int a, int b){
        int aRoot = parent[a];
        int bRoot = parent[b];
        if(aRoot==bRoot) return false;
        parent[bRoot] = aRoot;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        minEdge = new int[V+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int result = 0;
        parent = new int[V+1];
        for(int i = 1 ; i <= V ; i++)  {
            parent[i] = i;
            minEdge[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            int w = sc.nextInt();
            pq.offer(new Edge(f,t,w));
        }
        while (!pq.isEmpty()){
            Edge edge = pq.poll();
            int from = edge.from;
            int to = edge.to;
            int w = edge.weight;
            if(find(from)!=find(to)){
                union(from,to);
                result+=w;
            }
        }
        System.out.println(result);
    }
    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(weight,o.weight);
        }
    }
}
