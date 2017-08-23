package NowCoder;
import java.util.Scanner;
public class DynamicPlanning2 {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n=0 , k=0, d=0;
        int[] array = null;

        while(cin.hasNextInt())
        {
            n = cin.nextInt();
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = cin.nextInt();
            }
            k = cin.nextInt();
            d = cin.nextInt();
        }

        System.out.println(computeBestK(array, k , d));
    }

    public static long computeBestK(int[] array, int k, int d) {

        if(array.length == 0 || k == 0 || d ==0)
            return 0;
        if(array.length == 1 && k == 1 )
            return array[0];

        if(array.length >1 && k >=1 )
        {
            long max = Long.MIN_VALUE;

            for (int i = k-1; i < array.length; i++) {
                long maxEndByCurrent = computeMaxEndBy(array, k, d, i);
                if( max < maxEndByCurrent)
                    max = maxEndByCurrent;
            }
            return max;

        }
        else
        {
            System.out.println("input case error");
            return -1;
        }
    }

    private static long computeMaxEndBy(int[] array, int k, int d, int end) {
        if(k == 1)
            return array[end];

        long max = Long.MIN_VALUE;

        for (int j = 1; j <= d && (end-j)>=0 &&  (end-j)>= (k-1)-1; j++) {
            //(end-j)>= (k-1)-1 是需要保证在向前寻找的时候，结尾元素之前至少还需要有k-1个元素，否则元素数目不够
            long res1 = array[end] * computeMaxEndBy(array, k-1, d, end-j);   ;
            long res2 = array[end] * computeMinEndBy(array, k-1, d, end-j);

            long larger = res1 > res2 ? res1: res2;

            if(max < larger)
                max = larger;
        }

        return max;
    }

    private static long computeMinEndBy(int[] array, int k, int d, int end) {
        if(k == 1)
            return array[end];

        long min = Long.MAX_VALUE;
        for( int j =1 ; j <= d && (end-j)>=0 && (end-j)>= (k-1)-1; j++)
            //(end-j)>= (k-1)-1 是需要保证在向前寻找的时候，结尾元素之前至少还需要有k-1个元素，否则元素数目不够
        {
            long res1 = array[end] * computeMaxEndBy(array, k-1, d, end-j);   ;
            long res2 = array[end] * computeMinEndBy(array, k-1, d, end-j);

            long smaller = res1 < res2 ? res1: res2;

            if(min > smaller)
                min = smaller;
        }
        if( min == Long.MAX_VALUE)
            System.out.println("k"+k+"d"+d+"end"+end);

        return min;
    }

}