package laicode;

import java.util.*;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Write your solution here
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null) {
            return res;
        }

        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int remain, int index, List<Integer> sub, List<List<Integer>> res) {
        if (index == candidates.length) {
            return;
        }
        if (remain == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }

        for (int i = 0; i <= remain / candidates[index]; ++i) {
            int j = i;
            while (j > 0) {
                sub.add(candidates[index]);
                j--;
            }

            //de-duplicate
            while (index + 1 < candidates.length && candidates[index] == candidates[index + 1]) {
                index++;
            }

            dfs(candidates, remain - i * candidates[index], index + 1, sub, res);

            //backtraking
            j = i;
            while (j > 0) {
                sub.remove(sub.size() - 1);
                j--;
            }
        }
    }



    static class TreeNode {
        int key;
        TreeNode left;
        TreeNode right;
        public TreeNode(int key) {
          this.key = key;
        }
      }

    public List<Integer> rightView(TreeNode root) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // level - rightmost_key
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, 0, map);

        for (int i = 0; i < map.size(); ++i) {
            res.add(map.get(i));
        }

        return res;
    }

    private void dfs(TreeNode root, int level, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }

        map.getOrDefault(level, root.key);

        dfs(root.right, level + 1, map);
        dfs(root.left, level + 1, map);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        // solution two:
        // data structure: minHeap & hashSet,  tc: O(knlogkn), sc: O(n + n)
        if (n == 1) {
            return 1;
        }
        Queue<Integer> minHeap = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        minHeap.offer(1);
        set.add(1);

        while (n > 1) {
            n--;
            int num = minHeap.poll();
            for (int i = 0; i < primes.length; ++i) {
                int tmp = num * primes[i];
                if (!set.add(tmp)) {
                    continue;
                }
                minHeap.offer(tmp);
            }
        }
        return minHeap.poll();
    }

    public boolean formRing(String[] input) {
        // Write your solution here
        boolean flag = false;
        dfs(input, 0, flag);
        return flag;
    }

    private void dfs(String[] input, int index, boolean flag) {
        if (index == 0) {
            for (int i = 0; i < input.length; ++i) {
                swap(input, i, 0);
                dfs(input, 1, flag);
                swap(input, i, 0);
            }
            return;
        }

        //index > 0
        for (int i = index; i < input.length; ++i) {
            String str = input[index - 1];
            if (input[i].charAt(0) != str.charAt(str.length() - 1)) {
                continue;
            }
            swap(input, i, index);
            dfs(input, index + 1, flag);
            swap(input, i, index);
        }

        if (index == input.length) {
            if (input[index - 1].charAt(input[index - 1].length() - 1) == input[0].charAt(0)) {
                flag = true;
            }
            return ;
        }
    }

    private void swap(String[] input, int i, int j) {
        String tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    }
}
