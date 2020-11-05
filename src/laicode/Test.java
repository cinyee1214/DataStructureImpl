package laicode;

import Practice.Solution;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        laicode.Solution test = new laicode.Solution();
//        int res = test.nthSuperUglyNumber(4, new int[]{2,3,5});
//        System.out.println(res);


//        String[] input = new String[]{"aa", "dda", "ad"};
//        boolean it = test.formRing(input);
//
//
//        List<List<Integer>> res = test.combinationSum(new int[]{1,2,3,6}, 12);
        Solution27 test1 = new Solution27();
        int res = test1.kthSum(new int[]{1,3,5,8,9}, new int[]{2,3,4,7}, 2);
        System.out.println(res);
        Integer.valueOf(5);







    }

}
