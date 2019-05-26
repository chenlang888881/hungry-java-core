package hungry.java.math;

import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 不变对象囊括了上下文的设置，他描述了数值运算符的某个规则，如BigDecimal类的实现。
 * <p>
 * <p>
 * 基于独立的设置：
 * 精度：
 * 代表一个操作的被使用的操作位数，结果就是向这个精度舍入。
 * <p>
 * 舍入模式：
 * 使用指定的算法进行舍入
 * <p>
 * Created by admin on 2019/5/25.
 */
public class MathContextSpecification {

    final int precision;

    final RoundingMode roundingMode;

    /**
     * 他设置的值要求是一个无限制精度的
     */
    public static final MathContext UNLIMITED = new MathContext(0, RoundingMode.HALF_UP);

    /**
     * 该对象精度匹配IEEE 754R Decimal32格式，7位，舍入模式为 {@link RoundingMode#HALF_EVEN}, IEEE 754R 默认的
     */
    public static final MathContext DECIMAL32 = new MathContext(7, RoundingMode.HALF_EVEN);

    /**
     * 该对象精度匹配IEEE 754R Decimal64格式，16位，舍入模式为 {@link RoundingMode#HALF_EVEN}, IEEE 754R 默认的
     */
    public static final MathContext DECIMAL64 = new MathContext(16, RoundingMode.HALF_EVEN);

    /**
     * 该对象精度匹配IEEE 754R Decimal128格式，34位，舍入模式为 {@link RoundingMode#HALF_EVEN}, IEEE 754R 默认的
     */
    public static final MathContext DECIMAL128 = new MathContext(34, RoundingMode.HALF_EVEN);

    public MathContextSpecification(int setPrecision, RoundingMode roundingMode) {
        this.precision = setPrecision;
        this.roundingMode = roundingMode;
    }
}


