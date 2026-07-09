# Binary Search Scenario Answer

The astronomer example is a classic binary-search use case because the star-brightness entries are already sorted.

## What to do

- Use binary search to find a target brightness in `O(log n)`.
- If the catalog is rotated because of a glitch, use a rotated-array binary search or first find the rotation point.
- If the same brightness appears multiple times, use boundary binary searches to get the first and last occurrence.
- To find the minimum brightness in a rotated sorted catalog, return the element at the rotation point.

## Why this works

- Binary search halves the search space at every step.
- That gives logarithmic time instead of scanning all 10 million entries.

## File mapping

- `Problem01_RotationPointAndRotatedSearch.java`
- `Problem02_PeakElement.java`
- `Problem03_SearchTargetIn2DSortedMatrix.java`
- `Problem04_FirstAndLastOccurrence.java`

