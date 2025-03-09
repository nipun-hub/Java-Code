import javax.naming.PartialResultException;
import java.util.Arrays;

class Example {

    // bubbleSort
    public static void bubbleSort(int[] arr) {
        System.out.print("Unsorted array : ");
        System.out.println(Arrays.toString(arr));
        while (true) {
            boolean isSort = false;
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) break;
                int temp = arr[i];
                if (arr[i] > arr[i + 1]) {
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSort = true;
                }
            }
            if (!isSort) break;
        }
        System.out.print("sorted array : ");
        System.out.println(Arrays.toString(arr));
    }


    // selection sort
    public static void selectionSort(int[] ar) {
        System.out.print("Unsorted array : ");
        System.out.println(Arrays.toString(ar));

        int lastUnsoldIndex = ar.length - 1;

        while (lastUnsoldIndex > 0) {
            int lagestIndex = 0;
            for (int currentIndex = 1; currentIndex <= lastUnsoldIndex; currentIndex++) {
                if (ar[currentIndex] > ar[lagestIndex]) lagestIndex = currentIndex;
            }
            int temp = ar[lastUnsoldIndex];
            ar[lastUnsoldIndex] = ar[lagestIndex];
            ar[lagestIndex] = temp;
            lastUnsoldIndex--;
        }


        System.out.print("Sorted array : ");
        System.out.println(Arrays.toString(ar));
    }

    // insertion sort
    public static void insertionSort(int[] ar) {
        System.out.print("Unsorted array : ");
        System.out.println(Arrays.toString(ar));

        for (int i = 1; i < ar.length; i++) {
            int temp = ar[i];
            int b = i - 1;
            while (b >= 0 && temp < ar[b]) {
                ar[b + 1] = ar[b];
                b--;
            }
            ar[b + 1] = temp;
        }

        System.out.print("Sorted array : ");
        System.out.println(Arrays.toString(ar));
    }

    public static int linerSearch(int[] arr, int search) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] ar, int search) {
        int min = 0;
        int max = ar.length - 1;
        while (min <= max) {
            int middle = min + (max - min) / 2;
            int value = ar[middle];
            if (value < search) min = middle + 1;
            else if (value > search) max = middle - 1;
            else return middle;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {23, 1, 43, 77, 23, 9, 4, 76, 2, 43};

//        array sort

        System.out.print("Unsorted array : " + Arrays.toString(arr));


//        bubbleSort(arr);
//        selectionSort(arr);
        insertionSort(arr);

        System.out.print("sorted array : " + Arrays.toString(arr));


//        array search

//        Liner Search
        System.out.println(linerSearch(arr, 76));

//        Binary Search
        System.out.println(binarySearch(arr, 1));
    }
}
