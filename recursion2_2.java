public class recursion2_2 {
    public static void main(String[] args) {
        System.out.println(dec2Bin(13));
    }

    private static String dec2Bin(int n) {
        if (n==1){
            return "1";
        }
        return dec2Bin(n/2)+n%2;
    }
}
