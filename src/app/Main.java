package app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] numbers = new int[15];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100);
        }

        System.out.println("Початковий вигляд масиву: " + Arrays.toString(numbers));

        insertionSort(numbers);

        System.out.println("Відсортований масив: " + Arrays.toString(numbers));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число для пошуку: ");
        int target = scanner.nextInt();

        int targetIndex = binarySearch(numbers, target);

        if (targetIndex == -1) {
            System.out.println("Введеного числа немає в масиві.");
        } else {
            System.out.printf("Індекс числа %d у відсортованому масиві: %d\n", target, targetIndex);
        }
    }
}