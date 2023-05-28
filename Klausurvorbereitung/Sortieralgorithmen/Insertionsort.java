package Sortieralgorithmen;

public class Insertionsort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        for (int i : sort(arr)) {
            System.out.println(i);
        }
    }

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int smallestIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[smallestIndex])
                    smallestIndex = j;

            }
            int tmp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = tmp;

        }
        return arr;
    }
}
