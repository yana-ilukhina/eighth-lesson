package ru.ilukhinayana.hw8;

import java.util.Arrays;

// 5. Сортировка выбором. Вы - учитель математики и хотите написать программу, которая будет помогать вашим ученикам
// сортировать список формул по сложности. Каждая формула представляет собой строку, содержащую числа, знаки операций
// (+, -, *, /) и скобки. Сложность формулы определяется числом операций, которые нужно выполнить, чтобы вычислить
// ее значение. Напишите программу, которая будет сортировать список формул по возрастанию сложности.
public class SelectionSort {
    public static void selectionSort(int[] arr, String[] arrOrig) {
        for (int i = 0; i < arr.length; i++) {
            int poz = i; //poz - индекс наименьшего элемента
            int min = arr[i]; //min - наименьший элемент (значение)
            for (int j = i + 1; j < arr.length; j++) { //цикл выбора наименьшего элемента
                if (arr[j] < min) {
                    poz = j;
                    min = arr[j];
                }
            }
            //меняем местами наименьший с arr[i]
            arr[poz] = arr[i]; // большое откидываем назад
            String swap = arrOrig[poz];
            arrOrig[poz] = arrOrig[i];
            arr[i] = min; // маленькое ставим ближе к началу
            arrOrig[i] = swap;
            System.out.println(Arrays.toString(arrOrig) + " " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        String[] arrOrig = new String[6];
        arrOrig[0] = "5+6+32+11=54";
        arrOrig[1] = "5+6+32=43";
        arrOrig[2] = "1+1=2";
        arrOrig[3] = "(3+5)*4*21=483";
        arrOrig[4] = "((21-20)*(32-30))/2=1";
        arrOrig[5] = "1*2*3=6";
        int[] arr = new int[arrOrig.length];
        for (int i = 0; i < arrOrig.length; i++) {
            for (int j = 0; j < arrOrig[i].length(); j++) {
                if (arrOrig[i].charAt(j) == '+' || arrOrig[i].charAt(j) == '-' || arrOrig[i].charAt(j) == '*' ||
                        arrOrig[i].charAt(j) == '/') {
                    arr[i]++;
                }
            }
        }
        System.out.println(Arrays.toString(arrOrig));
        System.out.println(Arrays.toString(arr));
        System.out.println("____________________");
        selectionSort(arr, arrOrig);
        System.out.println("____________________");
        System.out.println(Arrays.toString(arrOrig));
        System.out.println(Arrays.toString(arr));
    }
}
