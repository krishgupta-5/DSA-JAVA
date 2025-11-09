package BinarySearch;

public abstract class PS01 {
    public static void main(String[] args) {
        int[] arr = {20,19,18,14,11,9,6,4,3,1};
        int target = 6;
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                System.out.println("Found at index: " + mid);
                return;
            } else if (arr[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("Not found");
    }
}
