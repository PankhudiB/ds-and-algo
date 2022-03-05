Tips & Tricks

1. Binary tree problems recursion -> 
   Can be 
   1. Top down
   2. Bottom up

Eg. Max depth of tree can be solved both ways ->

TOP DOWN

      1. return if root is null
      2. if root is a leaf node:
      3.     answer = max(answer, depth)         
      4. maximum_depth(root.left, depth + 1)     
      5. maximum_depth(root.right, depth + 1)    

BOTTOM UP

      1. return 0 if root is null
      2. left_depth = maximum_depth(root.left)
      3. right_depth = maximum_depth(root.right)
      4. return max(left_depth, right_depth) + 1


When you meet a tree problem, ask yourself two questions: 
   1. Can you determine some parameters to help the node know its answer? 
   2. Can you use these parameters and the value of the node itself to determine what should be the parameters passed to its children? 

If the answers are both yes, try to solve this problem using a **_"top-down"_** recursive solution.

Or, you can think of the problem in this way: for a node in a tree, if you know the answer of its children, can you calculate the answer of that node?
If the answer is yes, solving the problem recursively using a **_"bottom up"_** approach might be a good idea.


Reference : https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/534/