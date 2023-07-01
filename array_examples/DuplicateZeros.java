package array_examples;

public class DuplicateZeros {
    class Solution {
        public void duplicateZeros(int[] arr) {
            int start = 0;
            int end = arr.length-1;

            int[] duplicate = new int[arr.length];
            for(int i=0; i<arr.length; i++) {
                duplicate[i] = arr[i];
            }

            while(start <= end){
                if (arr[start] == 0 && start!= end) {
                    end--;
                }
                start++;
            }

            if (end == arr.length-1) return;

            System.out.println("end: "+end);

            int dupliItr = 0;
            int arrI = 0;

            while(dupliItr <= end) {
                if(duplicate[dupliItr] != 0) {
                    arr[arrI] = duplicate[dupliItr];
                } else if (duplicate[dupliItr] == 0){
                    arr[arrI] = 0;
                    if (arrI+1 < arr.length) {
                        arr[arrI+1] = 0;
                        arrI++;
                    }
                    else {
                        break;
                    }

                }
                dupliItr++;
                arrI++;
            }
        }
    }
}
