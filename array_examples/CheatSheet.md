## Array CheatSheet

1. if in place modification is required in the array ==> Something like shift right OR merge 2 array into the 1st array ==> Start modifying from right to left - so that elements are not lost
---------
2. finding missing element in an unsorted arr - O(n) - and without using extra memory
   1. lets say 1 < arr[i] < n 
   2. use the input array itself as hash -- where index is the key 
   3. `nums[nums[i]]` --> mark the position as something like -ve
   4. so in 2nd iteration --> whatever is positive - that index is untouched
   5. REFER -> array_examples/FindFirstMissingPositiveNumber.java
---------