public class recursive2_1 {
    public static void main(String[] args) {
        System.out.println(even(20));
        System.out.println(even(-5));
        System.out.println(odd(12));
        System.out.println(odd(17));
    }

    private static boolean odd(int n) {
        if (n<0){
            return even(-n);
        }
        else if (n==1){
            return true;
        }
        else if (n==0){
            return false;
        }
        return odd(n-2);
    }

    private static boolean even(int n) {
         if (n==0){
            return true;
        }
        else if (n==1){
            return false;
        }
        else if (n<0){
            return even(-n);
         }
            return even(n-2);


    }
}
