package binary_search;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {
        System.out.println("found: " + searchInSortedRotatedArray(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println("found: " + searchInSortedRotatedArray1PassAlgo(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println("found: " + searchInSortedRotatedArray1PassAlgo(new int[]{3, 1}, 1));
        System.out.println("found: " + searchInSortedRotatedArray1PassAlgo(new int[]{5, 1, 3}, 3));
    }

    public static int searchInSortedRotatedArray(int[] arr, int target) {
        int n = arr.length;
        if (n == 1) return arr[0] == target ? 0 : -1;
        int rotatedAt = rotationIndex(arr);
        if (rotatedAt == 0) {
            return search(arr, target, 0, n - 1);
        } else if (target < arr[0]) {
            return search(arr, target, rotatedAt, n - 1);
        }
        return search(arr, target, 0, rotatedAt);

    }

    private static int rotationIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) return mid + 1;
            if (arr[mid] > arr[left]) {
                left = mid + 1;
            } else {
                right = mid + 1;
            }
        }
        return 0;
    }

    private static int search(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static int searchInSortedRotatedArray1PassAlgo(int[] arr, int target) {
        int n = arr.length;
        if (n == 1) return arr[0] == target ? 0 : -1;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] >= arr[left]) {                            //increasing L --> Mid (sorted side on left)
                if (arr[left] <= target && target < arr[mid]) {     // see whether target lies within L <-> Mid
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
