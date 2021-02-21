public class recursion1_4 {
    public static void main(String[] args) {
        System.out.println(xMethod(2,6));
        System.out.println(yMethod(2,6));
    }

    private static int yMethod(int num, int degree) {
       int sum=1;
        for (int i = 1; i <=degree ; i++) {
            sum*=num;
        }
        return sum;
    }

    private static int xMethod(int num, int degree) {
        if (degree==0){
            return num=1;
        }
        else
            return num*xMethod(num,degree-1);
    }
}
