public class Runner{
    public static int[] scramble(int[] arr){
        for (int i = 0; i < arr.length; i++) {
           int index = (int) (Math.random() * arr.length);
           int temp = arr[i];
           arr[i] = arr[index];
           arr[index] = temp;
       }
        return arr;
    }

    public static void main(String args[]){
        int[] values = {1,5,2,45,60,394,3959,2,4,59,293};
        SearchSort test = new SearchSort(values);

        //Linear Search
        System.out.println(test.linearSearch(10));
        //Recursive Linear Search
        System.out.println(test.linearSearchRecur(45));
        //Binary Search
        System.out.println(test.binarySearch(10));
        //Recursive Binary Search
        System.out.println(test.binarySearchRecursive(10));

        //Selection Sort
        SearchSort test2 = new SearchSort(scramble(values));
        System.out.println();
        test2.selectionSort(true);

        //Insertion Sort
        SearchSort test3 = new SearchSort(scramble(values));
        System.out.println();
        test3.insertionSort(true);

        //Merge Sort
        SearchSort test4 = new SearchSort(scramble(values));
        System.out.println();
        test4.mergeSort(true);

        //Bubble Sort
        SearchSort test5 = new SearchSort(scramble(values));
        System.out.println();
        test5.bubbleSort(true);
    }
}
