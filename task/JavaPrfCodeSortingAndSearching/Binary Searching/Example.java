import java.util.Arrays;

class Demo{

    public static void generateRandomArray(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
    }

    public  static int binarySearchNormal(int[] arr,int target) {
        int start = 0;
        int end  = arr.length-1;
        while (start <= end) {
            int mid = (end+start) / 2;
            if (arr[mid] == target) return mid;
            else if (target > arr[mid]) {
                start = mid++;
            } else {
                end = mid--;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int [] arr ,int target,int start,int end){
        int mid = (start+end)/2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) end = mid--;
        else start++;
        return binarySearchRecursive(arr,target,start,end);
    }

    public static void main(String[] args) {
        int[] numbers = new int[20];

        // Generate random array
        generateRandomArray(numbers);

        // Print array
        System.out.println(Arrays.toString(numbers));

        // search item in array
        int target = 4;
        int index = binarySearchNormal(numbers, target);
//        int index = binarySearchRecursive(numbers,target,0,numbers.length);
        System.out.println("Index of "+target+" is "+index);

    }
}
