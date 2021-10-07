import java.util.Scanner;

public class BJ_9020_이홍준{
    static boolean[] prime;
    final static int SIZE = 10001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        prime = new boolean[SIZE];
        prime[0] = true;
        prime[1] = true;
        for(int i = 2 ; i < Math.sqrt(SIZE) ; i++){
            if(prime[i]) continue;
            for(int j = i+i ; j< SIZE; j+=i){
                prime[j] = true;
            }
        }
        int T = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for(int test_case = 0 ; test_case<T ; test_case++){
            int n = Integer.parseInt(sc.nextLine());
            int left = n/2;
            int right = n/2;
            int a = left;
            int b = right;
            outer :for(int i = left ; i >= 2; i--){
                if(prime[i]) continue;
                for(int j = right; j< n ; j++){
                    if(prime[j]) continue;
                    if(i+j==n){
                        a = i;
                        b = j;
                        break outer;
                    }
                    if(i+j>n) break;
                }
            }
            sb.append(a+" "+b+"\n");
        }
        System.out.println(sb);
    }
}
