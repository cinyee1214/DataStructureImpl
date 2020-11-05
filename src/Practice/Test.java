package Practice;

import java.awt.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Practice p = new Practice();
//        p.printSchedule("ABC");
        System.out.println(p.minimumBoxes(10400));


    }
//        int[] array = new int[0];
////        System.out.println(array[0]);
//
//        System.out.println(new String(array, 0, 0));

//
//        try {
//            throw new NullPointerException("test");
//        } catch (Exception e) {
//            throw new ArrayIndexOutOfBoundsException("test1");
//        } finally {
//            System.out.println("haha");
//        }








//        int[][] array = new int[5][];
//        for (int i = 0; i < 5; ++i) {
//            System.out.println(array[i]);
//            if (array[i] != null) {
//                System.out.println(array[i].length);
//            }
//
//        }
//
//        Deque<Integer> stack = new LinkedList<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.pop();
//        System.out.println(stack.element());
//
//        List<String> sub = new ArrayList<>();
//        sub.add("abc");
//
//        List<Integer> iList = new ArrayList<>();
//        iList.add(123);
//
//        List<List> test = new ArrayList<>();
//        test.add(sub);
//        test.add(iList);

//
//        Solution test = new Solution();
//        int[][] matrix = {{1,2,3,4},{11,12,133,14},{15,16,17,18},{19,20,21,22}};
//        System.out.println(test.kthSmallest(matrix, 4));

//        Object a = "abcde";
//        System.out.println(a.getClass());  //String
//
//        Object n = 2;
//        System.out.println(n instanceof Object);
//        System.out.println(n instanceof Integer);
//        System.out.println(n instanceof Number);
//
//        int num = 4;
        //primitive type does not have class, cannot getClass()

//
//        int i = copyDigit(12, 123456);
//        System.out.println(i);
//    }
//
//    private static int copyDigit(int i, int num) {
//        int len = 0;
//        for (int j = num; j > 0; j /= 10) {
//            len++;
//        }
//        int end = i + len;
//        for (int j = num; j > 0; j /= 10) {
//            int digit = j % 10;
//            char ch = (char) (digit + '0');
//            System.out.println(ch);
//        }
//        return end;
//    }

}
