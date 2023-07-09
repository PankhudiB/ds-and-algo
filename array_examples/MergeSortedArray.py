from typing import List

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        if m == 0:
            for i in range(len(nums2)):
                nums1[i] = nums2[i]
            return
        if n == 0:
            return

        p1 = m -1
        p2 = len(nums2) - 1
        out = len(nums1) - 1

        while(p2 >= 0 and p1 >= 0):
            if(nums1[p1] > nums2[p2]):
                nums1[out] = nums1[p1]
                p1-=1
            else:
                nums1[out] = nums2[p2]
                p2-=1
            out -=1

        if (p1<0):
            while p2 >= 0:
                nums1[out] = nums2[p2]
                p2 -=1
                out-=1
            return
        if (p2<0):
            return

sol = Solution()
a = [1,2,3,0,0,0]
b = [2,5,6]
print(a)
sol.merge(a,3,b,3)
print(a)