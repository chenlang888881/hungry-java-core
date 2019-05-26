package hungry.java.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

/**
 * 一个不可变的任意精度带有符号的十进制数。一个BigDecimal由任意精度的整数非标度值
 * 和32位的标度组成。如果是零或者正数，标度就是小数点后的位数。如果是负数，则将该数的
 * 非标度值乘以10的负scale次幂。因此，BigDecimal表示的数值是unscaledValue * 10 ^ -scale.
 * <p>
 * <p>
 * 提供算术，数字范围操纵，舍入，比较，hashing, 格式化转换。
 * <p>
 * 结果的精度有MathContext中的精度设定，默认是精确的，不持有MathContext对象。
 * Created by admin on 2019/5/23.
 */
public class BigDecimalSpecification {

    // 构造函数

    /**
     * 把一个字符数组翻译成一个BigDecimal，也接受一个相同的字符序列的BigDecimal构造函数BigDecimal(string)
     * ,然而也允许一个数组指定。
     * 记住，使用构造函数比你将字符数组转为字符串构造函数更快
     *
     * @param in
     * @param offset
     * @param len
     */
    public BigDecimalSpecification(char in, int offset, int len) {
        this(in, offset, len, MathContext.UNLIMITED);
        char[] inArr = {'1', '2', '3', '.', '8'};
        System.out.println(new BigDecimal(inArr, 0, inArr.length));
        System.out.println(new BigDecimal(inArr, 1, inArr.length));
    }

    /**
     * 与上面方法一致，只是添加了四舍五入的上下文设置
     *
     * @param in
     * @param offset
     * @param len
     * @param mc
     */
    public BigDecimalSpecification(char in, int offset, int len, MathContext mc) {
        char[] inArr = {'1', '2', '3', '.', '8'};
        System.out.println(new BigDecimal(inArr, 0, inArr.length));
        System.out.println(new BigDecimal(inArr, 1, inArr.length));
    }

    /**
     * 把string翻译成BigDecimal的形式，字符串形式组成：一个可选的符号标识（+或-），跟上0个或多个十进制位（整形的），
     * 跟上可选的小数，可选的指数(指数有字符‘e’组成，科学计数法)
     *
     * @param val
     */
    public BigDecimalSpecification(String val) {
        System.out.println(new BigDecimal("0.1"));
    }

    /**
     * 把一个double值翻译成一个精确的小数形式。scale值是能取到的最小值。
     * <p>
     * 注意：但是这构造方法大的结果稍微不可预料，比如new BigDecimal(0.1)，它的实际结果为：
     * 0.1000000000000000055511151231257827021181583404541015625.
     * 这是因为0.1不能呈现一个精确的double。这是由于浮点数的最小精度单位引起的。
     * <p>
     * 另一方面，String构造函数是可完全预测，new BigDecimal("0.1")是精确等于0.1的。因此BigDecimal(String)
     * 会优于该构造函数。
     * <p>
     * 当一定要用double值作为BigDecimal的源，可以使用valueOf(double)方法代替，其中它会
     *
     * @param val
     */
    public BigDecimalSpecification(double val) {
        System.out.println(new BigDecimal(0.1));
    }

    /**
     * 将一个BigInteger转为一个BigDecimal，标度scale为零
     *
     * @param val
     */
    public BigDecimalSpecification(BigInteger val) {
        System.out.println(new BigDecimal(BigInteger.ONE));
    }

    /**
     * 将一个BigInteger的非标度值和一个int的标度值转为一个BigDecimal。其值为
     * unscaledVal &times 10<sup>-scale</sup>
     *
     * @param unscaledVal
     * @param scale
     */
    public BigDecimalSpecification(BigInteger unscaledVal, int scale) {
        System.out.println(new BigDecimal(BigInteger.valueOf(3333), 2));
    }

    // 静态工厂方法

    /**
     * 将一个非标度的long值和一个标度的int值转为一个BigDecimal
     * 该方法优于（{long，int}）的构造函数，因为它允许重用经常使用的BigDecimal值
     *
     * @param unscaledVal
     * @param scale
     * @return
     */
    public static BigDecimal valueOf(long unscaledVal, int scale) {
        return BigDecimal.valueOf(unscaledVal, scale);
    }

    /**
     * 用标度为零将long值翻译成BigDecimal值
     *
     * @param val
     * @return
     */
    public static BigDecimal valueOf(long val) {
        return BigDecimal.valueOf(val);
    }

    /**
     * 将double转为一个BigDecimal值，使用Double#toString方法提供的权威的字符串方法
     * <p>
     * 这是讲double转为BigDecimal的首选方式
     *
     * @param val
     * @return
     */
    public static BigDecimal valueOf(double val) {
        return BigDecimal.valueOf(val);
    }


    // 算术操作

    /**
     * 他的值是将两个BigDecimal相加，他的标度值是max(this.scale, augend.scale)
     *
     * @param augend
     * @return
     */
    public BigDecimal add(BigDecimal augend) {
        System.out.println(BigDecimal.ONE.add(BigDecimal.TEN));
        return null;
    }

    /**
     * 带上一个四舍五入的上下文设置。
     * 如果一个数是零，精度设置为非零，如果舍入需要的话，另外一个数被作为结果使用
     *
     * @param augend
     * @param mc
     * @return
     */
    public BigDecimal add(BigDecimal augend, MathContext mc) {
        System.out.println(BigDecimal.valueOf(30.03).add(BigDecimal.TEN, MathContext.DECIMAL32));
        return null;
    }

    /**
     * 其值返回两个BigDecimal的差，标度值为max(this.scale, subtrahend.scale())
     *
     * @param subtrahend
     * @return
     */
    public BigDecimal substract(BigDecimal subtrahend) {
        System.out.println(BigDecimal.valueOf(56.7).subtract(BigDecimal.ONE));
        return null;
    }

    /**
     * 其值返回两个数的乘积，标度值为（this.scale + multiplicand.scale()）
     *
     * @param multiplicand
     * @return
     */
    public BigDecimal multiply(BigDecimal multiplicand) {
        System.out.println(BigDecimal.valueOf(67.3).multiply(BigDecimal.TEN));
        return null;
    }

    /**
     * 其值返回(this/divisor), 他的标度值是被指定，舍入模式通过使用标度值产生的结果被应用
     *
     * @param divisor
     * @param scale
     * @param roundingMode 异常：除数为零，舍入模式为Round_unnecessary并且指定的标度scale不足以呈现一个精确的结果
     * @return
     */
    public BigDecimal divide(BigDecimal divisor, int scale, RoundingMode roundingMode) {
        System.out.println(BigDecimal.valueOf(666).divide(BigDecimal.valueOf(5.6), 3, BigDecimal.ROUND_FLOOR));
        return null;
    }

    /**
     * 该方法的标度值为this.scale()方法获得
     *
     * @param divisor
     * @param roundingMode
     * @return
     */
    public BigDecimal divide(BigDecimal divisor, RoundingMode roundingMode) {
        return null;
    }

    /**
     * 返回值为this/divisor商的rounded down的整数部分， 首选的标度值为（this.scale() - divisor.scale()）
     *
     * @param divisor
     * @return
     */
    public BigDecimal divideToIntegralValue(BigDecimal divisor) {
        System.out.println(BigDecimal.valueOf(-5).divideToIntegralValue(BigDecimal.valueOf(3)));
        System.out.println(BigDecimal.valueOf(5).divideToIntegralValue(BigDecimal.valueOf(3)));
        return null;
    }

    /**
     * 由于商的整数部分不依赖于rounding mode，所以rounding mode不会影响这个方法返回的值。
     * 如果商的整数部分大于mc.precision的位数，算术异常会抛出
     *
     * @param divisor
     * @param mc
     * @return
     */
    public BigDecimal divideToIntegralValue(BigDecimal divisor, MathContext mc) {
        System.out.println(BigDecimal.valueOf(55555555555555555L).divideToIntegralValue(BigDecimal.ONE, MathContext.DECIMAL32));
        return null;
    }


    /**
     * 返回一个余数（this % divisor）
     * this.subtract(this.divideToIntegralValue(divisor).multiply(divisor))
     * 这不是一个模操作（结果可以是负数）
     *
     * @param divisor
     * @return
     */
    public BigDecimal remainder(BigDecimal divisor) {
        System.out.println(BigDecimal.valueOf(-5).remainder(BigDecimal.valueOf(3)));
        return null;
    }

    /**
     * 返回包含divideIntegralValue和跟着remainder两个操作值的两个元素的数组
     *
     * @param divisor
     * @return
     */
    public BigDecimal divideAndRemainder(BigDecimal divisor) {
        System.out.println(Arrays.toString(BigDecimal.valueOf(-5).divideAndRemainder(BigDecimal.valueOf(3))));
        return null;
    }

    /**
     * 返回一个this<sup>n</sup>的值，根据上下文的设置，当前实现采用了in ANSI standard X3.274-1996 的核心算法。
     * 总的来说，返回的算术值是在被选精度的精确算术值的两个ulp之内。
     * 详细的精度方面的设置可参考官方文档
     *
     * @param n
     * @param mathContext
     * @return
     */
    public BigDecimal pow(int n, MathContext mathContext) {
        System.out.println(BigDecimal.valueOf(1.22).pow(3, MathContext.DECIMAL32));
        return null;
    }

    /**
     * 返回这个数的绝对值，根据舍入上下文的设置
     *
     * @return
     */
    public BigDecimal abs(MathContext mc) {
        System.out.println(BigDecimal.valueOf(-5).abs());
        return null;
    }

    /**
     * 返回该数的相反数, 根据舍入上下文的设置
     *
     * @param mc
     * @return
     */
    public BigDecimal negate(MathContext mc) {
        System.out.println(BigDecimal.ONE.negate());
        System.out.println(BigDecimal.valueOf(-5).negate());
        return null;
    }

    /**
     * 返回这个值的（+this）
     * 这个方法简单的返回这个BigDecimal，他和一元负数方法对称
     *
     * @param mc
     * @return
     */
    public BigDecimal plus(MathContext mc) {
        System.out.println(BigDecimal.ONE.plus());
        System.out.println(BigDecimal.valueOf(-5).plus());
        return null;
    }

    /**
     * 返回这个BigDecimal的正负号函数
     *
     * @return
     */
    public int signum() {
        System.out.println(BigDecimal.ONE.signum());
        System.out.println(BigDecimal.valueOf(-5).signum());
        return 0;
    }

    /**
     * 返回这个BigDecimal的标度值。如果为零或者正数，标度值就是小数点右边的位数。
     * 如果为负数，非标度值的数乘以十的-scale次幂。
     *
     * @return
     */
    public int scale() {
        System.out.println(BigDecimal.valueOf(0.09).scale());
        return 0;
    }

    /**
     * 返回这个BigDecimal的精度值（该值就是非标度值的位数）
     *
     * @return
     */
    public int precision() {
        System.out.println(BigDecimal.valueOf(0.09).precision());
        return 0;
    }

    /**
     * 返回这个数的非标度值（有this * 10<sup>this.scale()</sup>）
     *
     * @return
     */
    public BigInteger unscaledValue() {
        System.out.println(BigDecimal.valueOf(0.09).unscaledValue());
        return BigInteger.ONE;
    }


    // 标度、舍入操作

    /**
     * 返回一个BigDecimal的四舍五入，根据舍入上下文的设置。如果一个精度设置为零，之后舍入不会发生
     *
     * @param mc
     * @return
     */
    public BigDecimal round(MathContext mc) {
        System.out.println(BigDecimal.valueOf(0.09999999999).round(MathContext.DECIMAL32));
        return null;
    }

    /**
     * 返回一个指定的标度值，并使用指定的舍入模式，该非标度值为这个数乘以或者除以合适的10次幂的数为了维持当前的值。
     * <p>
     * 由于BigDecimal是不可变对象，所以这个不会导致原始对象修改。反而会返回一个合适的标度对象，可能是或者不是一个新分配的对象
     *
     * @param newScale
     * @param roundingMode
     * @return
     */
    public BigDecimal setScale(int newScale, RoundingMode roundingMode) {
        System.out.println(BigDecimal.valueOf(0.00009).setScale(2, RoundingMode.HALF_UP));
        return null;
    }


    // 小数点的移位操作

    /**
     * 返回一个将小数点向左移动n个位置的数。如果n为非负数，这个调用仅仅只是添加n到scale。
     * 如何n为负数，则会乘以10的-n次幂
     *
     * @param n
     * @return
     */
    public BigDecimal movePointLeft(int n) {
        System.out.println(BigDecimal.valueOf(0.01).movePointLeft(2));
        System.out.println(BigDecimal.valueOf(0.01).movePointRight(2));
        return null;
    }

    /**
     * 返回这个数值乘以10的n次幂
     *
     * @param n
     * @return
     */
    public BigDecimal scaleByPowerOfTen(int n) {
        System.out.println(BigDecimal.valueOf(3.33).scaleByPowerOfTen(5));
        return null;
    }

    /**
     * 返回去除尾部零的形式格式
     *
     * @return
     */
    public BigDecimal stripTrailingZeros() {
        System.out.println(BigDecimal.valueOf(600.10).scale());
        BigDecimal bigDecimal = BigDecimal.valueOf(600.10).stripTrailingZeros();
        System.out.println(bigDecimal + " " + bigDecimal.scale());
        return null;
    }


    // 比较操作

    /**
     * 这个BigDecimal和指定的BigDecimal比较。
     * 如果两个对象有相同的值，但是有不同的scale（如2.0和2.00），考虑用该方法。
     *
     * @param val
     * @return
     */
    public int compareTo(BigDecimal val) {
        System.out.println(BigDecimal.valueOf(2.0).compareTo(BigDecimal.valueOf(2.00)));
        return 0;
    }

    /**
     * 这个BigDecimal和指定的对象要相等。不像compareTo方法，这个方法考虑值和scale都要相等
     *
     * @param x
     * @return
     */
    public boolean equals(Object x) {
        System.out.println(new BigDecimal("0.2").equals(new BigDecimal("2.00")));
        return true;
    }

    /**
     * 返回这个BigDecimal和val最小的那个
     *
     * @param val
     * @return
     */
    public BigDecimal min(BigDecimal val) {
        System.out.println(BigDecimal.valueOf(0.09).min(BigDecimal.valueOf(0.0000988)));
        return null;
    }

    /**
     * 返回这个BigDecimal和val的最大值
     *
     * @param val
     * @return
     */
    public BigDecimal max(BigDecimal val) {
        System.out.println(BigDecimal.valueOf(0.09).max(BigDecimal.valueOf(0.0000988)));
        return null;
    }


    // hash功能

    /**
     * 返回这个BigDecimal的hash码。两个对象数字上相等但是有不同的scale，将会有不同的hash码
     *
     * @return
     */
    public int hashCode() {
        System.out.println(new BigDecimal("9.0").hashCode());
        System.out.println(new BigDecimal("9.00").hashCode());
        return 0;
    }


    // 格式化反转

    /**
     * 返回一个BigDecimal的字符串表现，如果指数需要使用科学计数法。
     * <p>
     * 一个标准的字符串创建的第一步：一个非标度值的绝对值，使用'0'-'9'的字符，无前导零。
     * 第二步：调整的指数被计算：负的scale，加上一个非标度值的位数减去一。那就是{-scale+(ulength-1)}
     * 其中ulength即为its precision
     * <p>
     * 如果scale大于等于零，并且调整的指数大于等于-6，则数的反转成字符形式毫不会用指数的格式。
     * <p>
     * 否则，（那就是scale小于零，或者调整指数小于-6），该数就会反转为字符的指数格式。
     * <p>
     * 最后，如果非标度值小于零，字符串前面会以-字符为前缀。
     * <p>
     * 下面的为示例：
     * [123,0]      "123"
     * [-123,0]     "-123"
     * [123,-1]     "1.23E+3"
     * [123,-3]     "1.23E+5"
     * [123,1]      "12.3"
     * [123,5]      "0.00123"
     * [123,10]     "1.23E-8"
     * [-123,12]    "-1.23E-10"
     * <p>
     * 由该字符串产生一个数总会是相同的；不会受本地的影响。
     *
     * @return
     */
    public String toString() {
        BigDecimal b = new BigDecimal(BigInteger.valueOf(123), 5);
        System.out.println(b);
        System.out.println(b.toEngineeringString());
        BigDecimal b1 = new BigDecimal(BigInteger.valueOf(123), 6);
        System.out.println(b1);
        System.out.println(b1.toEngineeringString());
        BigDecimal b2 = new BigDecimal(BigInteger.valueOf(123), 7);
        System.out.println(b2);
        System.out.println(b2.toEngineeringString());
        BigDecimal b3 = new BigDecimal(BigInteger.valueOf(123), 8);
        System.out.println(b3);
        System.out.println(b3.toEngineeringString());
        BigDecimal b4 = new BigDecimal(BigInteger.valueOf(123), 9);
        System.out.println(b4);
        System.out.println(b4.toEngineeringString());

        BigDecimal b5 = new BigDecimal(BigInteger.valueOf(123), -1);
        System.out.println(b5);
        System.out.println(b5.toEngineeringString());
        return null;
    }

    /**
     * 使用工程计数法来表示BigDecimal。
     * <p>
     * 返回#toString 方法的字符串形式，如果指数被使用，除了十的次幂要调整为3的倍数（工程计数），也就是说整数部分为1-999.
     * <p>
     * 该方法不像#toString,这个方法的输出不能保证恢复一个相同的BigDecimal，只能产生一个数字上相等的数，所以会有一些微弱的限制
     *
     * @return
     */
    public String toEngineeringString() {
        BigDecimal b2 = new BigDecimal(BigInteger.valueOf(123), 7);
        System.out.println(b2);
        System.out.println(b2.toEngineeringString());
        BigDecimal b3 = new BigDecimal(BigInteger.valueOf(123), 8);
        System.out.println(b3);
        System.out.println(b3.toEngineeringString());
        BigDecimal b4 = new BigDecimal(BigInteger.valueOf(123), 9);
        System.out.println(b4);
        System.out.println(b4.toEngineeringString());
        return null;
    }

    /**
     * 返回一个毫无指数域的BigDecimal字符串呈现形式。
     *
     * 如果要通过#BigDecimal(String)恢复的话，可能会有不同的标度。
     * @return
     */
    public String toPlainString() {
        return null;
    }

    /**
     * 反转一个BigDecimal向BigInteger。这反转类似于从double到long的缩小的原生转换，
     * 任何小数部分会被丢弃。
     *
     * 如果不想精度丢失，即非零的小数部分不会被丢失。请使用#toBigIntegerExact()方法
     *
     * @return
     */
    public BigInteger toBigInteger() {
        return null;
    }

    /**
     * 反转一个BigDecimal到BigInteger, 检查信息的丢失。如果有非零的小数部分，一个异常会抛出
     * @return
     */
    public BigInteger toBigIntegerExact() {
        return null;
    }



    public static void main(String[] args) {
/*        System.out.println(new BigDecimal(BigInteger.valueOf(3300), 2));

        System.out.println(BigDecimal.valueOf(0.1));
        System.out.println(new BigDecimal(0.1));*/
//        System.out.println(new BigDecimal("0.1"));

//        System.out.println(new BigDecimal(, -1));
//        System.out.println(BigDecimal.ONE.divide(BigDecimal.valueOf(2), 3, RoundingMode.HALF_DOWN));

/*        System.out.println(BigDecimal.valueOf(1).remainder(BigDecimal.valueOf(3), MathContext.DECIMAL32));

        System.out.println(Arrays.toString(BigDecimal.valueOf(5).divideAndRemainder(BigDecimal.valueOf(3))));*/

//        System.out.println(BigDecimal.valueOf(3).plus());
//        System.out.println(BigDecimal.valueOf(-3).plus());
//        System.out.println(BigDecimal.valueOf(4543567.667000).precision());
//        System.out.println(BigDecimal.valueOf(4543567.667000).unscaledValue());
//        System.out.println(BigDecimal.valueOf(4543567.6674536546543654645).plus(MathContext.DECIMAL32));
//        System.out.println(BigDecimal.valueOf(0.0035).scale());

//        System.out.println(BigDecimal.valueOf(3).movePointLeft(-3));
//
//        System.out.println(BigDecimal.valueOf(3).scaleByPowerOfTen(4).toEngineeringString());
//        System.out.println(BigDecimal.valueOf(3).scaleByPowerOfTen(4).toPlainString());
//        System.out.println(new BigDecimal("3.0001000").stripTrailingZeros());
//        System.out.println(new BigDecimal("333.33").ulp());
//        System.out.println(new BigDecimal("333.3300").precision());
//        System.out.println(new BigDecimal("333.33").unscaledValue());
//        System.out.println(BigDecimal.ZERO.ulp());

//        System.out.println(new BigDecimalSpecification(BigInteger.ONE, 2));
//
//        System.out.println(new BigDecimalSpecification("555").substract(BigDecimal.ONE));
//
//        System.out.println(new BigDecimalSpecification("5").divideToIntegralValue(BigDecimal.ONE));
//
//        System.out.println(new BigDecimalSpecification("6").remainder(BigDecimal.ONE));
//        System.out.println(new BigDecimalSpecification("6").pow(3, null));

//        System.out.println(new BigDecimalSpecification("6").negate(null));
//        System.out.println(new BigDecimalSpecification("6").plus(null));
/*        System.out.println(BigDecimalSpecification.valueOf(4).signum());
        System.out.println(BigDecimalSpecification.valueOf(0.09).scale());
        System.out.println(BigDecimalSpecification.valueOf(0.09).precision());*/

//        System.out.println(new BigDecimalSpecification("6").setScale(1, RoundingMode.HALF_DOWN));

//        System.out.println(new BigDecimalSpecification("6").movePointLeft(3));
//        System.out.println(new BigDecimalSpecification("6").scaleByPowerOfTen(3));
//        System.out.println(new BigDecimalSpecification("6").stripTrailingZeros());
//        System.out.println(BigDecimal.valueOf(0.0001));
//        System.out.println(new BigDecimalSpecification("6").compareTo(BigDecimal.ONE));
//        System.out.println(new BigDecimalSpecification("6").equals(BigDecimal.ONE));
//        System.out.println(new BigDecimalSpecification("6").min(BigDecimal.ONE));
//        System.out.println(new BigDecimalSpecification("6").max(BigDecimal.ONE));
        System.out.println(new BigDecimalSpecification("6").hashCode());

//        BigDecimal bigDecimal = new BigDecimal(1000);
//        System.out.println(bigDecimal);
//        System.out.println(bigDecimal.scale());
//        System.out.println(bigDecimal.unscaledValue());
//
//        BigDecimal bigDecimal1 = BigDecimal.valueOf(3).scaleByPowerOfTen(4);
//        System.out.println(bigDecimal1);
//        System.out.println(bigDecimal1.scale());
//        System.out.println(bigDecimal1.unscaledValue());


    }

}
