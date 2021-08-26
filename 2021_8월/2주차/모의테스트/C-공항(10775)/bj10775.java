import java.util.Scanner;

public class bj10775 {
	
	static int[] parent = new int[100001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1;i<=N;i++) {
			parent[i] = i;
		}
		int answer = 0;
		
		int M = sc.nextInt();
		for(int i=0;i<M;i++) {
			int airplane = sc.nextInt();
			if(airplane > N) break;
			if(find(airplane)==0) break;
			else answer++;
			union(airplane);
		}
		System.out.println(answer);
	}
	
	public static int find(int x) {
		if(parent[x]==x) return x;
		else return parent[x] = find(parent[x]); 
	}
	
	public static void union(int x) {
		x = find(x);
		parent[x] = x-1;
	}
}