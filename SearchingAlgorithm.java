public class SearchingAlgorithms {
    // Iterative Binary Search
    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // not found
    }
    // Recursive Binary Search
    public static int binarySearchRecursive(int[] arr, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, mid + 1, right, target);
        } else {
            return binarySearchRecursive(arr, left, mid - 1, target);
        }
    }

    // Recursive Linear Search
    public static int linearSearchRecursive(int[] arr, int index, int target) {
        if (index >= arr.length) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        }

        return linearSearchRecursive(arr, index + 1, target);
    }

    //Minimum recursively
    public static int findMinRecursive(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }

        return Math.min(arr[index], findMinRecursive(arr, index + 1));
    }

    //Maximum recursively
    public static int findMaxRecursive(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index];
        }

        return Math.max(arr[index], findMaxRecursive(arr, index + 1));
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 12, 20, 25, 30};

        System.out.println("Array: {3, 8, 12, 20, 25, 30}");

        //Iterative Binary Search
        int target1 = 20;
        int idx1 = binarySearchIterative(arr, target1);
        System.out.println("\nIterative Binary Search for " + target1 + ": Index = " + idx1);

        //Recursive Binary Search
        int target2 = 25;
        int idx2 = binarySearchRecursive(arr, 0, arr.length - 1, target2);
        System.out.println("Recursive Binary Search for " + target2 + ": Index = " + idx2);

        //Recursive Linear Search
        int target3 = 12;
        int idx3 = linearSearchRecursive(arr, 0, target3);
        System.out.println("Recursive Linear Search for " + target3 + ": Index = " + idx3);

        //Minimum and Maximum
        int min = findMinRecursive(arr, 0);
        int max = findMaxRecursive(arr, 0);
        System.out.println("Minimum (recursive) = " + min);
        System.out.println("Maximum (recursive) = " + max);
    }
}
