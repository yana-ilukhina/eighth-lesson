package ru.ilukhinayana.hw8;

import java.util.Arrays;

public class InsertionSort {
    //4. Сортировка вставками. Напишите программу, которая будет сортировать список слов по количеству гласных букв в слове.
    public static void insertionSort(int[] arr, String[] arrOrig) {
        int j;
        // Сортировку начинаем со второго элемента, тк считается, что первый элемент уже отсортирован
        for (int i = 1; i < arr.length; i++) {
            //сохраняем ссылку на индекс предыдущего элемента
            int swap = arr[i];
            String swapOrig = arrOrig[i];
            for (j = i; j > 0 && swap < arr[j - 1]; j--) {
                //элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
                arr[j] = arr[j - 1];
                arrOrig[j] = arrOrig[j - 1]; // сначала растягивает-перетягивает (дублирует) больший элемент в сторону
            }                                  // он задваивается, но ничего страшного
            arr[j] = swap;
            arrOrig[j] = swapOrig;              // когда достигло своего места, маленький перекрывает последний дубляж. Становится всё правильно
            System.out.println(Arrays.toString(arrOrig) + " " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        String[] arrOrig = {"cat", "orange", "elephant", "bird", "airplane", "duck"};
        int ln = arrOrig.length;
        int[] arr = new int[ln];
        for (int i = 0; i < ln; i++) {
            for (int j = 0; j < arrOrig[i].length(); j++) {
                if (arrOrig[i].charAt(j) == 'a' || arrOrig[i].charAt(j) == 'e' || arrOrig[i].charAt(j) == 'i' ||
                        arrOrig[i].charAt(j) == 'o' || arrOrig[i].charAt(j) == 'u' || arrOrig[i].charAt(j) == 'y') {
                    arr[i]++;
                }
            }
        }
        System.out.println(Arrays.toString(arrOrig));
        System.out.println(Arrays.toString(arr));
        System.out.println("____________________");
        insertionSort(arr, arrOrig);
        System.out.println("____________________");
        System.out.println(Arrays.toString(arrOrig));
        System.out.println(Arrays.toString(arr));
    }
}
