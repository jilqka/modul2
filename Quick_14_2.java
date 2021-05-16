public class Quick_14_2 {
        public static void main(String[] args) {
            // TODO Auto-generated method stub

            int n = 50000;
            int[] arrB = new int[n];
            int[] arrM = new int[n];
            int[] arrS = new int[n];
            int[] arrQ = new int[n];

            for(int i = 0; i < n; i++) {
                int element = (int) (Math.random()*1000);
                arrB[i] = element;
                arrM[i] = element;
                arrS[i] = element;
                arrQ[i] = element;

            }

            long timeB = 0, timeS = 0, timeM = 0, timeQ = 0;

            long currentTime = System.currentTimeMillis();
            BubbleSort.bubbleSort(arrB);
            timeB = System.currentTimeMillis() - currentTime;

            currentTime = System.currentTimeMillis();
            SelectionSort.selectionSort(arrS);
            timeS = System.currentTimeMillis() - currentTime;

            currentTime = System.currentTimeMillis();
            MergeSort.mergeSort(arrM);
            timeM = System.currentTimeMillis() - currentTime;

            currentTime = System.currentTimeMillis();
            QuickSort.quickSort(arrQ);
            timeQ = System.currentTimeMillis() - currentTime;

            System.out.printf("%-12s%-7s%-10s%-7s%-7s%n", "Array Size", "Bubble", "Selection", "Merge", "Quick");
            System.out.printf("%-12d%-7d%-10d%-7d%-7d%n", n, timeB, timeS, timeM, timeQ);
        }

    }

