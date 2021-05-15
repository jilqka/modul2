import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Binary_12_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] list={-1,3,5,6,8,9};
        int sum=2;
        System.out.println(hasPair_BruteForce(list,sum));
    }
    public static boolean hasPair_BruteForce(int[] list, int sum){
        //O(n^2)
        for (int i = 0; i <list.length ; i++) {
            for (int j = i+1; j <list.length ; j++) {
                if (list[i]+list[j]==sum){
                    return true;
                }
            }
        }
        return false;
    }
    //O(nlog(n)
    public static boolean hasPair_BinarySearch(int[] list, int sum){
        for (int i = 0; i <list.length ; i++) {
            if (BinarySearch.binarySearch(list,sum-list[i])>0){
                return true;
            }
        }
        return false;
    }
    //O(n)
    public static boolean hasPair_fromBottomToEnd(int[] list, int sum){
        int lastIndex=list.length-1;
        int firstIndex=0;
        while (lastIndex>firstIndex){
            int currentSum=list[lastIndex]+list[firstIndex];
            if (currentSum>sum){
                lastIndex--;
            }
            else if (currentSum<sum){
                firstIndex++;
            }
            else {
                return true;
            }
        }
        return false;
    }
    //O(n)
    public static boolean hasPair_HashSet(int[] list, int sum){
        Set<Integer> rests=new HashSet<Integer>();
        for (int i = 0; i <list.length ; i++) {
            if (rests.contains(list[i])){
                return true;
            }
            rests.add(sum-list[i]);
        }
        return false;
    }



}
