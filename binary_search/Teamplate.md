## Binary Search Templates

`Tempalte 1`

- Initial Condition: `left = 0, right = length-1`
- Termination: `left > right`
- Searching Right: `left = mid+1`
- Searching Left: `right = mid-1`
- no post condition
- #####Search Condition can be determined without comparing to the element's neighbors

----------------------------------------------

`Tempalte 2`

- Initial Condition: `left = 0, right = length`
- Termination: `left == right`
- Searching Right: `left = mid+1`
- Searching Left: `right = mid`
- check if left != length && nums[left] is TARGET
- #####Search Condition needs to access the element's immediate right neighbor

---------------------------------------------------------------------
`Tempalte 3`

- Initial Condition: `left = 0, right = length-1`
- Termination: `left+1 == right`
- Searching Right: `left = mid`
- Searching Left: `right = mid`
- check if nums[left] is TARGET
- check if nums[right] is TARGET
- #####Search Condition needs to access element's immediate left and right neighbors

----------------------------------------------------------------------

Really helpful source : https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/935/





