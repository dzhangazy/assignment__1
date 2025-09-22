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
(Вставь таблицу из CSV)

| Алгоритм              | n=1000 | n=5000 | n=10000 | n=20000 |
|------------------------|--------|--------|---------|---------|
| MergeSort (time, ns)   |        |        |         |         |
| QuickSort (time, ns)   |        |        |         |         |
| Deterministic Select   |        |        |         |         |
| Closest Pair (time, ns)|        |        |         |         |

## 📉 Графики
*(сюда вставить скриншоты графиков из Excel/Sheets)*

## ✅ Выводы
- Теоретическая асимптотика подтверждается экспериментами.  
- MergeSort стабилен по глубине рекурсии (~ log n).  
- QuickSort показывает разные глубины на разных массивах, но в среднем O(log n).  
- Deterministic Select работает линейно, но с большим коэффициентом.  
- Closest Pair соответствует Θ(n log n).  
