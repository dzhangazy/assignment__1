<<<<<<< HEAD
# Assignment 1 – Divide & Conquer Algorithms

## 📌 Реализованные алгоритмы
- MergeSort (Θ(n log n), Master theorem Case 2)
- QuickSort с рандомным pivot (среднее Θ(n log n), глубина стека O(log n))
- Deterministic Select (Median of Medians, Θ(n))
- Closest Pair of Points (Θ(n log n), Master theorem Case 2)

## 📊 Метрики
Собирали:
- Время выполнения (ns)
- Количество сравнений
- Аллокации
- Максимальная глубина рекурсии

## 🧮 Анализ рекурсий
- **MergeSort**: T(n) = 2T(n/2) + Θ(n) → Master theorem Case 2 → Θ(n log n)  
- **QuickSort**: T(n) = T(k) + T(n-k-1) + Θ(n), в среднем k ≈ n/2 → ожидаемое Θ(n log n)  
- **Deterministic Select**: T(n) = T(n/5) + T(7n/10) + Θ(n) → Akra–Bazzi → Θ(n)  
- **Closest Pair**: T(n) = 2T(n/2) + Θ(n) → Master theorem Case 2 → Θ(n log n)

## 📈 Результаты экспериментов
<img width="753" height="406" alt="Снимок экрана 2025-09-28 180001" src="https://github.com/user-attachments/assets/4f35700c-ded0-488b-a3ff-5e9f6b7686f9" />


## 📉 Графики
<img width="1653" height="993" alt="Рисунок2" src="https://github.com/user-attachments/assets/2e343c8e-0ea7-4433-bae7-fec6a8a72698" />
<img width="1653" height="993" alt="Рисунок1" src="https://github.com/user-attachments/assets/afbd0718-0cf1-48be-b23b-e96e6a58c159" />
<img width="1653" height="993" alt="Рисунок3" src="https://github.com/user-attachments/assets/215eeca8-8d28-4d0f-95ac-fc95029e8a2c" />
<img width="1653" height="993" alt="Рисунок4" src="https://github.com/user-attachments/assets/58da9c30-cba1-42ad-a3ad-d76d29157be1" />



## ✅ Выводы
- Теоретическая асимптотика подтверждается экспериментами.  
- MergeSort стабилен по глубине рекурсии (~ log n).  
- QuickSort показывает разные глубины на разных массивах, но в среднем O(log n).  
- Deterministic Select работает линейно, но с большим коэффициентом.  
- Closest Pair соответствует Θ(n log n).  
=======
# assignment__1
>>>>>>> f2acc19 (Initial commit)
