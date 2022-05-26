package sorting;


public class QuickSort {


    void sort(int arr[]) {
        qsort(arr, 0, arr.length - 1);
    }

    //select pivot -> during partition -> find the right place of pivot
    // recursively do it for the 2 sublists

    void qsort(int arr[], int lo, int hi) {
        // base case -> when list is empty (lo > high) or has single element -> (lo == high)
        if (lo < hi) {
            int p = partition(arr, lo, hi);
            qsort(arr, lo, p - 1);
            qsort(arr, p + 1, hi);
        }
    }

    int partition(int arr[], int lo, int hi) {

        int pivot = arr[hi];  //last element is considered pivot -> lets find its right place
        int i = lo;

        for (int j = lo; j < hi; j++) {
            if (arr[j] < pivot) {              // i is like maintaining which was the first element we saw greater than pivot
                int temp = arr[i];             // and whenever we find any ele smaller than pivot
                arr[i] = arr[j];               // that ele will also be surely less than the ith ele
                arr[j] = temp;                 // so lets swap encountered smaller ele with that ith ele
                i++;
            }
        }

        int temp = arr[i];                  // in the end -> ith <--> pivot  
        arr[i] = arr[hi];
        arr[hi] = temp;
        return i;
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        QuickSort ob = new QuickSort();
        int arr[] = {64, 25, 12, 22, 11};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
}
