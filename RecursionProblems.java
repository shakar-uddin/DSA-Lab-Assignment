public class RecursionProblems {

    public static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int sum(int[] arr, int i) {
        if (i == arr.length) return 0;
        return arr[i] + sum(arr, i + 1);
    }

    public static boolean sorted(int[] arr, int i) {
        if (i == arr.length - 1) return true;
        return arr[i] <= arr[i + 1] && sorted(arr, i + 1);
    }

    public static int min(int[] arr, int i) {
        if (i == arr.length - 1) return arr[i];
        int nextMin = min(arr, i + 1);
        if (arr[i] < nextMin) {
            return arr[i];
        } else {
            return nextMin;
        }
    }

    public static int max(int[] arr, int i) {
        if (i == arr.length - 1) return arr[i];
        int nextMax = max(arr, i + 1);
        if (arr[i] > nextMax) {
            return arr[i];
        } else {
            return nextMax;
        }
    }

    public static void main(String[] args) {

        System.out.println("Factorial of 5 = " + factorial(5));
        System.out.println("Fibonacci at position 6 = " + fibonacci(6));

        int[] arr1 = {2, 4, 6, 8};
        System.out.println("Sum of array = " + sum(arr1, 0));

        int[] arr2 = {3, 5, 7, 9};
        System.out.println("Array is sorted? " + sorted(arr2, 0));

        int[] arr3 = {3, 5, 2, 8, 1};
        System.out.println("Minimum = " + min(arr3, 0));
        System.out.println("Maximum = " + max(arr3, 0));
    }
}
