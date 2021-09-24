import java.util.Scanner;

public class BJ_4948_이홍준{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true){
            int num = sc.nextInt();
            if(num==0) break;
            int result = prime(num);
            sb.append(result+"\n");
        }
        System.out.println(sb);
    }
    public static int prime(int n){
        boolean[] isNotPrime = new boolean[n*2+1];
        isNotPrime[1] = true;
        for(int i = 1 ; i <= n*2;i++){
            if(isNotPrime[i]) continue;
            if(i<2) continue;
            for(int j = i+i ; j<=n*2; j+=i){
                if(isNotPrime[j]) continue;
                isNotPrime[j] = true;
            }
        }
        int cnt=0;
        for(int i = n+1 ; i <= 2*n; i++){
            if(!isNotPrime[i]) cnt++;
        }
        return cnt;
    }
}