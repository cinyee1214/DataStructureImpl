package Practice;

public class ClassicalBinarySearch {
    private int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0, end = array.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    private int getClosestElement(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0, end = array.length - 1;

        while (start + 1 < end) {

            int mid = start + (end - start) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return Math.abs(array[start] - target) < Math.abs(array[end] - target) ? start : end;
    }

    private int[] getKClosest(int[] array, int target, int k) {
        if (array == null || k >= array.length) {
            return array;
        }

        int left = getClosestElement(array, target);
        int right = left + 1;

        int[] res = new int[k];

        for (int i = 0; i < k; ++i) {
            if (left < 0 || right < array.length && Math.abs(array[right] - target) < Math.abs(array[left] - target)) {
                res[i] = array[right++];
            } else {
                res[i] = array[left--];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        ClassicalBinarySearch test1 = new ClassicalBinarySearch();
        int res1 = test1.binarySearch(new int[]{1, 2, 5, 6, 8}, 8);
        System.out.println(res1);
        System.out.println("===========================");

        int res2 = test1.getClosestElement(new int[]{1, 2, 5, 7, 8}, 4);
        System.out.println(res2);
        System.out.println("===========================");

        int[] res3 = test1.getKClosest(new int[]{1, 2, 5, 7, 8}, 4, 2);
        for (int item : res3) {
            System.out.println(item);
        }


    }
}
