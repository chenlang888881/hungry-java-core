package hungry.java.math;

import java.math.BigDecimal;

/**
 * 指定数字操作丢失精度能力的舍入行为。
 *
 * Created by admin on 2019/5/25.
 */
public enum RoundingModeSpecification {

    // 舍入模式是越远离零。总是会对非零丢弃小数的数前增加一位
    UP(BigDecimal.ROUND_UP),

    // 舍入模式是越靠近零，毫不会对丢失小数的数增加。
    DOWN(BigDecimal.ROUND_DOWN),

    // 舍入模式越靠近正的无限大，如果结果为正，行为是RoundMode.UP; 如果是负数，行为就是RoundingMode.DOWN
    CEILING(BigDecimal.ROUND_CEILING),

    // 舍入模式越靠近负的无限大，如果结果为正，行为是RoundMode.DOWN; 如果是负数，行为就是RoundingMode.UP
    FLOOR(BigDecimal.ROUND_FLOOR),

    // 舍入模式越靠近最相邻的那个数，如果相邻的两个数相等，则使用round_up 的情况
    HALF_UP(BigDecimal.ROUND_HALF_UP),

    // 舍入模式越靠近最相邻的那个数，如果相邻的两个数相等，则使用round_down 的情况
    HALF_DOWN(BigDecimal.ROUND_HALF_DOWN),

    // 舍入模式越靠近最相邻的那个数，如果相邻的两个数相等，则使用相邻数是偶数的那个
    HALF_EVEN(BigDecimal.ROUND_HALF_EVEN),

    // 舍入模式断定请求的操作有一个精确的结果，因此舍入模式是不需要的。如果舍入模式是在不精确的结果指定的
    // ，ArithmeticException异常就会抛出
    UNNECESSARY(BigDecimal.ROUND_UNNECESSARY);

    final int oldMode;

    private RoundingModeSpecification(int oldMode) {
        this.oldMode = oldMode;
    }


}
