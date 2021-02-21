public class recursion1_3 {
    public static void main(String[] args) {
        System.out.println(xMethod(5));
        System.out.println(yMethod(5));
    }

    private static long yMethod(int n) {
        int sum=1;
        for (int i = 0; i <n ; i++) {
            sum*=2;
        }
        return sum;
    }

    private static long xMethod(int n) {
        if (n==0)
            return 1;
        else
            return 2*xMethod(n-1);
    }
}
