package ru.ilukhinayana.hw8;

import java.util.Arrays;

public class QuickSort {
    //2. Быстрая сортировка. Напишите программу, которая будет сортировать список строк в алфавитном порядке

    public static void quickSort(String[] arr, int low, int high) {
        if (arr.length == 0 || low >= high) return; //завершить, если массив пуст или уже нечего делить

        int middle = low + (high - low) / 2; //выбираем опорный элемент
        int border = arr[middle].charAt(0);
        int i = low, j = high; //разделяем на подмассивы и меняем местами
        while (i <= j) {
            while (arr[i].charAt(0) < border) {
                i++;
            }
            while (arr[j].charAt(0) > border) {
                j--;
            }
            if (i <= j) {
                String swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
                i++;
                j--;
                System.out.println(Arrays.toString(arr));
            }
        }

        if (low < j) quickSort(arr, low, j); //рекурсия для сортировки левой и правой части
        if (high > i) quickSort(arr, i, high);
    }

    public static void main(String[] args) {
        String[] arr = {"apple", "orange", "grape", "bananan", "mandarin", "pineapple", "banana"};
        System.out.println(Arrays.toString(arr));
        System.out.println("____________________");
        quickSort(arr, 0, arr.length - 1);
        System.out.println("____________________");
        System.out.println(Arrays.toString(arr)); // увы через quick sort не особо получается отсортировать больше чем по одной букве
    }
}
