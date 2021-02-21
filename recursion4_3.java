public class recursion4_3 {
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
//tail
    private static int xMethod(int num, int degree){
        return xMethod(num,degree,1);
    }
    private static int xMethod(int num, int degree, int result) {
        if (degree==0){
            return result;
        }
        else
            return xMethod(num,degree-1,result*num);
}
}