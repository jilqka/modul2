import java.util.Arrays;

public class recursion4_4 {
    public static void main(String[] args) {
        int[] list={1,4,2,5};
        System.out.println(average(list,4));
    }

    private static double average(int[] array, int n) {
        return sum(array,n,0);
    }

    private static double sum(int[] array, int n,int result) {
        if (n == 0) {
            return result;
        } else {
        return sum(array,n-1,result+array[n-1]);
        }
    }
}
