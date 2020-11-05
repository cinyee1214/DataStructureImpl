package Practice;

import java.util.Objects;

public class Cell implements Comparable<Cell> {
    int row, col, num;
    public Cell(int row, int col, int num) {
        this.row = row;
        this.col = col;
        this.num = num;
    }

    @Override
    public int compareTo(Cell c) {
        if (c.num == this.num) {
            return 0;
        }
        return this.num < c.num ? -1 : 1;
    }

    @Override
    public boolean equals(Object o) {
        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        return 31 * 31 * row + 31 * col + num;
    }
}
