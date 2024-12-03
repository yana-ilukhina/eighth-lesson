package ru.ilukhinayana.hw8;

import java.util.Arrays;

public class _Main {
    //public static void main(String[] args) {System.out.println("Hello world!");}

    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j + 1] < arr[j]) {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
    }

    public static void main(String args[]) {
        int[] arr = {12, 6, 4, 1, 15, 10};
        System.out.println(Arrays.toString(arr));
        System.out.println("____________________");
        bubbleSort(arr);
        System.out.println("____________________");
        System.out.println(Arrays.toString(arr));
    }
}