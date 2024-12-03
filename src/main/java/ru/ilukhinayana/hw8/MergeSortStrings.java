package ru.ilukhinayana.hw8;

import java.util.Arrays;

public class MergeSortStrings {
    //3. Сортировка слиянием. Напишите программу, которая будет сортировать массив строк по длине слов в них.
    public static void main(String[] args) {
        String[] words = {"banana", "apple", "kiwi", "pear", "pineapple", "grape", "orange", "bob"};
        System.out.println("Исходный массив: " + Arrays.toString(words));
        mergeSort(words, 0, words.length - 1);
        System.out.println("Отсортированный массив: " + Arrays.toString(words));
    }

    public static void mergeSort(String[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid); // Сортируем левую половину
            mergeSort(array, mid + 1, right); // Сортируем правую половину
            merge(array, left, mid, right); // Объединяем отсортированные половины
        }
    }

    public static void merge(String[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        // Создаем временные массивы
        String[] L = new String[n1];
        String[] R = new String[n2];
        // Копируем данные во временные массивы
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[mid + 1 + j];
        }
        // Начальные индексы первого и второго подмассивов
        int i = 0, j = 0;
        // Индекс для объединенного массива
        int k = left;
        // Объединяем временные массивы
        while (i < n1 && j < n2) {
            if (L[i].length() <= R[j].length()) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Копируем оставшиеся элементы, если есть
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}

