package ru.ilukhinayana.hw8;

import java.util.Arrays;
//1. Сортировка пузырьком. У вас есть список студентов и их средние баллы.
// Необходимо отсортировать список по убыванию среднего балла.
public class BubbleSort { // нормально что сначала пишется доп метод, а потом метод Main?

    public static String[][] bubbleSort(String[][] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                float currElem = Float.parseFloat(arr[j][1]);
                float nextElem = Float.parseFloat(arr[j + 1][1]);
                if (nextElem > currElem) {
                    String swap0 = arr[j][0]; // в запасную переменную
                    String swap1 = arr[j][1];
                    arr[j][0] = arr[j + 1][0]; // меняем два элемента назад
                    arr[j][1] = arr[j + 1][1];
                    arr[j + 1][0] = swap0; // меняем два элемента вперед
                    arr[j + 1][1] = swap1;
                    var stringRepresentation = Arrays.deepToString(arr);
                    System.out.println(stringRepresentation);
                }
            }
        }
        return arr; // почему надо возвращать двойной массив, а одинарный массив возвращать не надо? Как в примере школы
    }

    public static void main(String[] args) {
        String[][] twoDimArray = new String[3][2];
        twoDimArray[0][0] = "Петров";
        twoDimArray[0][1] = "3.7";
        twoDimArray[1][0] = "Иванов";
        twoDimArray[1][1] = "4.5";
        twoDimArray[2][0] = "Козлов";
        twoDimArray[2][1] = "5.0";

        var stringRepresentation = Arrays.deepToString(twoDimArray);
        System.out.println(stringRepresentation);
        System.out.println("____________________");
        String[][] arr2 = bubbleSort(twoDimArray); // вызов метода сортировки
        System.out.println("____________________");
        var stringRep2 = Arrays.deepToString(arr2);
        System.out.println(stringRep2);
    }
}
