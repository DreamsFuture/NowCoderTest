package SortAlgrithom;
//快速排序也是递推实习的



import java.util.Random;

public class QuickSortPartition {
	
	
	//随意选择一个数字，任意都可以，所以都一样，那就选择最后一个，然后把大的数字放到arr[pviotIndex]数字的左边，小的放右边
	static int partition1(int[] arr, int start, int end, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, end);
        int storeIndex = start;
        for (int i = start; i < end; ++i) {
            if(arr[i] < pivot) {
                swap(arr, i, storeIndex);
                ++storeIndex;
            }
        }
        swap(arr, storeIndex, end);
        return storeIndex;
    }

    static int partition2(int[] arr, int start, int end, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, end);
        int i = start, j = end;
        while (i < j) {
            while(i < j && arr[i] <= pivot) ++i;
            while(i < j && arr[j] >= pivot) --j;
            if(i < j) swap(arr, i, j);
        }
        swap(arr, i, end);
        return i;
    }
    
    
    //快速排序也是用递归实现的
    static void qsort1(int[] arr, int start, int end) {
        if (start < end)
        {
            int p = partition1(arr, start, end, end);
            qsort1(arr, start, p - 1);
            qsort1(arr, p + 1, end);
        }
    }

    static void qsort2(int[] arr, int start, int end) {
        if (start < end)
        {
            int p = partition2(arr, start, end, end);
            qsort2(arr, start, p - 1);
            qsort2(arr, p + 1, end);
        }
    }

    static void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
        ++count;
    }

    public static void main(String[] args) {
//        int[] arr = new int[] {7, 9, 4, 6, 10, 2, 8, 5, 1};
//        int[] arr = new int[] {8, 1, 3, 9, 2, 4, 1, 9, 8, 7, 5};
        Random random = new Random();
        int[] arr = createRandomArray(random, 100);
        for (int i = 0; i < 50; ++i) {
            int[] copy = new int[100];
            System.arraycopy(arr, 0, copy, 0, 100);
            count = 0;
            start = System.nanoTime();
            qsort1(copy, 0, copy.length - 1);
            System.out.println("count: " + count + ", useTime: " + (System.nanoTime() - start));
        }
        for (int i = 0; i < 50; ++i) {
            int[] copy = new int[100];
            System.arraycopy(arr, 0, copy, 0, 100);
            count = 0;
            start = System.nanoTime();
            qsort2(copy, 0, copy.length - 1);
            System.out.println("count: " + count + ", useTime: " + (System.nanoTime() - start));
        }
    }

    private static int count = 0;
    private static long start = 0L;

    private static int[] createRandomArray(Random random, int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; ++i) {
            arr[i] = random.nextInt(size);
        }
        return arr;
    }

	
	
	
}
