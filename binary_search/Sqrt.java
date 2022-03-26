package binary_search;

class Sqrt {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            long num = (long) mid * mid;
            if (num > x) right = mid - 1;
            else if (num < x) left = mid + 1;
            else return mid;
        }
        return right;
    }
}