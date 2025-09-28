# Assignment 1 – Divide & Conquer Algorithms

## Overview
This repository contains implementations of classic divide-and-conquer algorithms with safe recursion patterns, along with metrics collection and analysis.

---

## Algorithms and Recurrences

### MergeSort
- **Method:** Divide-and-conquer, splits array in half, merges linearly.  
- **Recurrence:** T(n) = 2T(n/2) + Θ(n)  
- **Analysis:** Master Theorem Case 2 ⇒ Θ(n log n)  
- **Notes:** Reusable buffer reduces allocations; cut-off to insertion sort improves cache efficiency.

### QuickSort (Randomized)
- **Method:** Partition around a random pivot; recurse on smaller side, iterate on larger.  
- **Recurrence (average):** T(n) = T(n/2) + Θ(n)  
- **Analysis:** Akra–Bazzi intuition ⇒ Θ(n log n) average, O(n²) worst-case prevented by random pivot.  
- **Notes:** Recursion depth bounded by ≈ 2 log₂ n.

### Deterministic Select (Median-of-Medians)
- **Method:** Group by 5, pick median of medians as pivot, recurse only into the required side.  
- **Recurrence:** T(n) = T(n/5) + T(7n/10) + Θ(n)  
- **Analysis:** Akra–Bazzi ⇒ Θ(n) worst-case linear selection.  
- **Notes:** In-place partitioning; recursion on smaller side minimizes stack depth.

### Closest Pair of Points
- **Method:** Sort by x, recursively solve left/right halves, merge using strip (scan 7–8 neighbors by y).  
- **Recurrence:** T(n) = 2T(n/2) + Θ(n)  
- **Analysis:** Master Theorem Case 2 ⇒ Θ(n log n)  
- **Notes:** Small-n brute-force for arrays ≤ 2000; y-sorted merge reduces comparisons.

---

## Architecture Notes
- **Recursion control:** Smaller-side recursion to bound stack usage.  
- **Memory:** MergeSort reuses buffer; cut-offs improve cache efficiency.  
- **Metrics:** Time, recursion depth, comparisons/allocations collected into CSV files.

---

## Metrics & Plots
Example screenshots / graphs (to be added to `results/` folder):
<img width="753" height="406" alt="Снимок экрана 2025-09-28 180001" src="https://github.com/user-attachments/assets/e128fb37-651d-4142-8ce9-cf28349fea74" />

<img width="1653" height="993" alt="Рисунок1" src="https://github.com/user-attachments/assets/573e6550-2540-484c-9300-7c2d1a7e13b4" />
<img width="1653" height="993" alt="Рисунок2" src="https://github.com/user-attachments/assets/5012dd6e-a0da-4342-9245-55b92cc55ad3" />
<img width="1653" height="993" alt="Рисунок3" src="https://github.com/user-attachments/assets/204762ea-1861-4a6d-8f22-dd4f5db8652b" />
<img width="1653" height="993" alt="Рисунок4" src="https://github.com/user-attachments/assets/a4902990-b681-4fad-b507-1facebca5be4" />

---

## Summary
- Theory and measurements mostly align.  
- QuickSort and MergeSort show small deviations due to memory access patterns and small-n cut-offs.  
- Deterministic Select achieves linear performance as expected.  
- Closest Pair behaves as Θ(n log n) and is validated against brute-force on small inputs.
