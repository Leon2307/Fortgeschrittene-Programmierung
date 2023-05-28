package Sortieralgorithmen;

public class Mergesort {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("\nSortiert: ");
        for (int i : sort(arr)) {
            System.out.print(i + " ");
        }
    }

    public static int[] sort(int[] arr) {

        if (arr.length == 1) {
            return arr;
        }

        // Linke Teilliste sortieren
        int[] arr1 = new int[arr.length / 2];
        for (int i = 0; i < arr.length / 2; i++) {
            arr1[i] = arr[i];
        }
        arr1 = sort(arr1);

        // Rechte Teilliste sortieren
        int[] arr2 = new int[arr.length - arr1.length];
        int l = arr.length - arr1.length;
        for (int i = 0; i < l; i++) {
            arr2[i] = arr[arr1.length + i];
        }
        arr2 = sort(arr2);

        // Zusammenfügen
        int lIndex = 0;
        int rIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (lIndex < arr1.length && rIndex < arr2.length) {
                arr[i] = Math.min(arr1[lIndex], arr2[rIndex]);
                if (arr[i] == arr1[lIndex]) {
                    lIndex++;
                } else {
                    rIndex++;
                }
            } else if (lIndex < arr1.length) {
                arr[i] = arr1[lIndex];
                lIndex++;
            } else if (rIndex < arr2.length) {
                arr[i] = arr2[rIndex];
                rIndex++;
            }
        }

        return arr;
    }
}
