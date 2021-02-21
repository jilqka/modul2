public class Recursion1 {
    public static void main(String[] args) {
        System.out.println("Sum is "+ xMethod(5));
        System.out.println("Sum is "+ yMethod(10));
    }

    private static int xMethod(int n) {
        if(n==1){
            return 1;
        }
        else {
        return n+xMethod(n-1);
        }
    }
    //iterativno
    private static int yMethod(int n){
        int sum=0;
        for (int i = 0; i <= n; i++) {
            sum+=i;
        }
        return sum;
    }
}
