package array_examples;

class CountMaximumProfitable {
    public static void main(String[] args) {
        System.out.println("Result : " + countMaximumProfitableGroups(new int[]{1,4,2,3}));
//        System.out.println("Result : " + countMaximumProfitableGroups(new int[]{2, 3, 2}));
//        System.out.println("Result : " + countMaximumProfitableGroups(new int[]{1, 5, 2}));
    }

    static long countMaximumProfitableGroups(int[] stockPrices) {
        int count = stockPrices.length;
        int n = stockPrices.length;
        int[] maxSoFar = maxToLeft(stockPrices, n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
//                System.out.println(i + "," + j + "=" + stockPrices[i] + "," + stockPrices[j]);
                if (stockPrices[i] >= maxSoFar[j] || stockPrices[j] >= maxSoFar[j]) {
//                    System.out.println("max =" + maxSoFar[j]);
                    count++;
                }
            }
        }
        return count;
    }

    private static int[] maxToLeft(int[] arr, int n) {
        System.out.print("[");
        int[] maxSoFar = new int[n];
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            int localMax = Math.max(arr[i], max);
            System.out.print(localMax + ",");
            maxSoFar[i] = localMax;
        }
        System.out.println("]");
        return maxSoFar;
    }
}

