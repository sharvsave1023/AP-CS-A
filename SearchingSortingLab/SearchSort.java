import java.util.Arrays;
public class SearchSort {
    private int[] nums;

    public SearchSort(int size) {
        nums = new int[size];
        initArray();
    }

    public SearchSort(int[] x) {
        nums = x;
    }

    public void initArray() {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 100 + 1);
        }
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int linearSearch(int key) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public int linearSearchRecur(int key) {
        return linearSearchRecur(key, 0);
    }

    private int linearSearchRecur(int key, int index) {
        if (index == nums.length) {
            return -1;
        }
        if (nums[index] == key) {
            return index;
        }
        return linearSearchRecur(key, index + 1);
    }

    public int binarySearch(int key) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
//        return Arrays.binarySearch(nums, key) >= 0 ? Arrays.binarySearch(nums, key) : -1;
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==key){
                return mid;
            }
            if(nums[mid]>key){
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return -1;
    }

    public int binarySearchRecursive(int key) {
        Arrays.sort(nums);
        return binarySearchRecursive(0, nums.length - 1, key);
    }

    private int binarySearchRecursive(int left, int right, int key) {
        if (left > right)
            return -1;
        int middle = (left + right) / 2;
        if (nums[middle] == key) {
            return middle;
        } else if (key > nums[middle]) {
            return binarySearchRecursive(middle + 1, right, key);
        }
        return binarySearchRecursive(left, middle - 1, key);
    }

    public void bubbleSort(boolean print) {
        boolean swap = false;
        for (int i = 0; i < nums.length - 1; i++) {
            swap = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                    if (print) {
                        System.out.println(Arrays.toString(nums));
                    }
                }
            }
        }
    }

    public void selectionSort(boolean print) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
            if (print) {
                System.out.println(Arrays.toString(nums));
            }
        }
    }

    public void insertionSort(boolean print) {
        for (int i = 1; i < nums.length; ++i) {
            int key = nums[i];
            int x = i - 1;
            while (x >= 0 && nums[x] > key) {
                nums[x + 1] = nums[x];
                x -= 1;
            }
            nums[x + 1] = key;
            if (print) {
                System.out.println(Arrays.toString(nums));
            }
        }
    }

    public void mergeSort(boolean print) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[i] = nums[i];
        }
        breakArr(a, 0,a.length-1,print);
        nums = a;
        if (print){
            System.out.println(Arrays.toString(nums));
        }

    }

    private void mergeSort(int[] a, int left, int mid, int right, boolean print) {
        int leftArr[] = new int[mid - left + 1];

        int rightArr[] = new int[right - mid];

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = a[left + i];
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = a[mid + i + 1];
        }
//        System.out.println(Arrays.toString(leftArr));
//        System.out.println(Arrays.toString(rightArr));
        int i1 = 0;
        int i2 = 0;
        int ind = left;
        while (i1 < leftArr.length && i2 < rightArr.length) {
            if (leftArr[i1] <= rightArr[i2]) {
                a[ind] = leftArr[i1];
                i1++;
            } else {
                a[ind] = rightArr[i2];
                i2++;
            }
            ind++;
        }
        //System.out.println(Arrays.toString(a));
        while (i1 < leftArr.length) {
            a[ind] = leftArr[i1];
            i1++;
            ind++;
        }
        while (i2 < rightArr.length) {
            a[ind] = rightArr[i2];
            i2++;
            ind++;
        }

    }

    public void breakArr(int[] a, int left, int right, boolean print) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            breakArr(a, left, mid, print);
            breakArr(a, mid + 1, right, print);
            mergeSort(a, left, mid, right, print);
        }
    }

}