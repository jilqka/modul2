public class recursion1_2 {
    public static void main(String[] args) {
        xMethod(1234567);
        System.out.println();
        yMethod(1872727);
    }

    private static void yMethod(int n) {
        while(n!=0){
            System.out.print(n%10);
            n/=10;
        }
    }

    private static void xMethod(int n) {
        if (n>0){
            System.out.print(n%10);
            xMethod(n/10);
        }
    }
}
