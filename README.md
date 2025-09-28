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
<img width="598" height="358" alt="Снимок экрана 2025-09-28 175519" src="https://github.com/user-attachments/assets/00aa23c8-3bb7-4ec1-8267-b8ee45c8da3c" />
<img width="596" height="350" alt="Снимок экрана 2025-09-28 175431" src="https://github.com/user-attachments/assets/32f73d8b-4f04-48db-b392-c9f5e38b2338" />
<img width="596" height="355" alt="Снимок экрана 2025-09-28 175415" src="https://github.com/user-attachments/assets/a7da8b94-6a43-44b5-8903-0c0402d3a872" />
<img width="595" height="349" alt="Снимок экрана 2025-09-28 175353" src="https://github.com/user-attachments/assets/2d797d77-ce59-48f1-a2fd-8e748e3ee1a2" />




## ✅ Выводы
- Теоретическая асимптотика подтверждается экспериментами.  
- MergeSort стабилен по глубине рекурсии (~ log n).  
- QuickSort показывает разные глубины на разных массивах, но в среднем O(log n).  
- Deterministic Select работает линейно, но с большим коэффициентом.  
- Closest Pair соответствует Θ(n log n).  
