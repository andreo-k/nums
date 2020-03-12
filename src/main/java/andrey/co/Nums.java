package andrey.co;

import java.math.BigDecimal;

public class Nums {
    private BigDecimal min = null;
    private BigDecimal max = null;
    private BigDecimal sum = BigDecimal.ZERO;
    private int count = 0;

    Nums() {

    }

    public void emit(BigDecimal next) {
        if (next == null) {
            throw new RuntimeException("number can not be null!");
        }

        min = min == null ? next : min.min(next);
        max = max == null ? next : max.max(next);
        sum = sum.add(next);

        ++count;
    }

    public void emit(String next) {
        this.emit(new BigDecimal(next));
    }

    public void emit(double next) {
        this.emit(BigDecimal.valueOf(next));
    }

    public BigDecimal getMin() {
        return min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public BigDecimal getAvg() {
        if (count == 0) {
            return null;
        }

        return sum.divide(BigDecimal.valueOf(count));
    }

}
