public class recursion4_2 {
    public static void main(String[] args) {
        System.out.println("Sum is " + xMethod(5));
        System.out.println("Sum is " + yMethod(5));
    }

    private static int xMethod(int n) {
       return xMethod(n,1);
    }

    private static int xMethod(int n, int result) {
        if (n == 1) {
            return result;
        } else {
            return xMethod(n - 1,result+n);
        }
    }

    //iterativno
    private static int yMethod(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
