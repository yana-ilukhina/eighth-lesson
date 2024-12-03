package ru.ilukhinayana.hw8;

import java.util.Arrays;

//3. Сортировка слиянием. Напишите программу, которая будет сортировать массив строк по длине слов в них.
public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        int[] buffer1 = Arrays.copyOf(arr, arr.length); //скопировали исходный массив
        int[] buffer2 = new int[arr.length]; //создали новый пустой массив с размерностью исходного
        return mergeSortInner(buffer1, buffer2, 0, arr.length); //запустили алгоритм сортировки слиянием
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) { // проверка на массив длиной 1
            return buffer1;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle); //рекурсивный запуск алгоритма
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = ((sorted1 == buffer1) ? buffer2 : buffer1);
        //пока элементы есть и в первом и во втором массиве
        while (index1 < middle && index2 < endIndex) {
            //если элемент первого массива меньше, чем элемент второго
            if (sorted1[index1] < sorted2[index2]) {
                // в результирующий массив кладем элемент первого массива
                result[destIndex] = sorted1[index1];
                System.out.println(Arrays.toString(result) + " из первого массива меньше он вперед");
                destIndex++;
                index1++;
                //если элемент второго массива меньше, чем элемент первого
            } else {
                // в результирующий массив кладем элемент второго массива
                result[destIndex] = sorted2[index2];
                System.out.println(Arrays.toString(result) + " из второго массива меньше он вперед");
                destIndex++;
                index2++;
            }
        }
        //пока в первом массиве еще остались элементы, кладем их в результирующий массив
        while (index1 < middle) {
            result[destIndex] = sorted1[index1];
            System.out.println(Arrays.toString(result) + " хвост с первого массива");
            destIndex++;
            index1++;
        }
        //пока во втором массиве еще остались элементы, кладем их в результирующий массив
        while (index2 < endIndex) {
            result[destIndex] = sorted2[index2];
            System.out.println(Arrays.toString(result) + " хвост со второго массива");

            destIndex++;
            index2++;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        String[] arrOrig = {"cat", "orange", "elephant", "bird", "me", "airplanee", "visit", "rangeer"};
        int ln = arrOrig.length;
        int[] arr = new int[ln];
        for (int i = 0; i < ln; i++) {
            arr[i] = arrOrig[i].length();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("____________________");
        int[] res = mergeSort(arr);
        System.out.println("____________________");
        System.out.println(Arrays.toString(res));
    }
}
