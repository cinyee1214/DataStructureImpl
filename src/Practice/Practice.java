package Practice;

public class Practice {
    public int minimumBoxes(int num) {
        int[] min = new int[num + 1];

        min[1] = 1;

        for (int i = 2; i <= num; ++i) {
            min[i] = i;
            for (int j = 1; j * j <= i; ++j) {
                min[i] = Math.min(min[i], min[i - j * j] + 1);
            }
        }

        return min[num];
    }



    public void printSchedule(String input) {
        if (input == null || input.length() == 0) {
            return;
        }
        helper(input, 0, new StringBuilder());
    }

    private void helper(String input, int index, StringBuilder sb) {
        if (index == input.length()) {
            if (sb.charAt(sb.length() - 1) == 'x') {
                return;
            }
            System.out.println(sb.toString());
            return;
        }

        sb.append(input.charAt(index));

        // add x
        sb.append("x");
        helper(input, index + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        // not add x
        helper(input, index + 1, sb);

        sb.deleteCharAt(sb.length() - 1);
    }

}
