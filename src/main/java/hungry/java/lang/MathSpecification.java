package hungry.java.lang;

/**
 * 首先讲一下浮点数的概念：浮点数是属于有理数中某特定子集的数的数字表示，在计算机中用近似表示任意某个实数。
 * 具体来说，这个实数由一个整数或定点数乘以某个基数（计算机中通常是2）的整数次幂得到；
 * <p>
 * 这个Math类包含完成基础指数，对数，平方根，三角函数基本数量的操作。
 * <p>
 * 实现的标准关注返回结果的准确性和方法的单调性。根据ulps（即Math.ulp(double),最小精度单位）去决定Math方法的精确性
 * <p>
 * 防止计算值不溢出操作，需要使用addExact, subtractExact, multiplyExact, toIntExact.当结果溢出时，抛出一个ArithmeticException
 * <p>
 * Created by admin on 2019/5/10.
 */
public class MathSpecification {

    /**
     * 返回一个三角正弦。
     *
     * @param a
     * @return
     */
    public static double sin(double a) {
        double pi = Math.PI;
        double semiPi = Math.PI / 2;
        System.out.println(Math.sin(semiPi));
        System.out.println(Math.sin(pi));
        return Math.sin(a);
    }

    /**
     * 返回一个反正弦的值。角度是在-pi/2到pi/2之间
     *
     * @param a
     * @return
     */
    public static double asin(double a) {

        System.out.println(Math.asin(-1));
        System.out.println(Math.asin(0));
        System.out.println(Math.asin(1));
        return Math.asin(a);
    }

    /**
     * 近似反转一个用度数测量的角度到一个用弧度测量的角度。
     *
     * @return
     */
    public static double toRadians(double angdeg) {
        System.out.println(Math.toRadians(90));
        System.out.println(Math.toRadians(360));
        return Math.toRadians(angdeg);
    }

    /**
     * 近似反转一个用弧度测量的角度到一个用度数测量的角度
     *
     * @param angrad
     * @return
     */
    public static double toDegrees(double angrad) {
        System.out.println(Math.PI);
        return Math.toDegrees(angrad);
    }

    /**
     * 返回欧拉e^a次幂的值
     *
     * @param a
     * @return
     */
    public static double exp(double a) {
        System.out.println(Math.exp(1));
        return Math.exp(a);
    }

    /**
     * 返回一个a值的自然对数
     *
     * @param a
     * @return
     */
    public static double log(double a) {
        System.out.println(Math.log(Math.E));
        return Math.log(a);
    }

    /**
     * 返回一个a值以10为底的自然对数
     *
     * @param a
     * @return
     */
    public static double log10(double a) {
        System.out.println(Math.log10(100));
        return Math.log10(a);
    }

    /**
     * 返回一个四舍五入a值平方根
     *
     * @param a
     * @return
     */
    public static double sqrt(double a) {
        System.out.println(Math.sqrt(4));
        System.out.println(Math.sqrt(9));
        return Math.sqrt(a);
    }

    /**
     * 返回一个a值的立方根
     *
     * @param a
     * @return
     */
    public static double cbrt(double a) {
        System.out.println(Math.cbrt(9));
        return Math.cbrt(a);
    }

    /**
     * 余数等于f1 - n * f2, 而n是最接近f1 / f2 的商(quotient), 但是如果有两个数都接近(code f1/f2)
     * n 取偶数，例如2.5取2， 3.5取4。
     *
     * @param f1
     * @param f2
     * @return
     */
    public static double IEEEremainder(double f1, double f2) {
        System.out.println(Math.IEEEremainder(14, 4));
        System.out.println(Math.IEEEremainder(10, 4));
        return Math.IEEEremainder(f1, f2);
    }

    /**
     * 返回一个大于等于参数的最小值
     * Math.ceil(x) 和 -Math.floor(-x)是等价的
     *
     * @param a
     * @return
     */
    public static double ceil(double a) {
        System.out.println(Math.ceil(7.8));
        System.out.println(Math.ceil(7.1));
        System.out.println(Math.ceil(-3.4));
        System.out.println(-Math.floor(-7.8));
        return Math.ceil(a);
    }

    /**
     * 返回一个小于等于参数值的最大值
     *
     * @param a
     * @return
     */
    public static double floor(double a) {
        System.out.println(Math.floor(7.8));
        System.out.println(Math.floor(7.1));
        System.out.println(Math.floor(-3.4));
        return Math.floor(a);
    }

    /**
     * 返回一个接近或者等于参数的值，如果有两个数字值都接近相等，则该结果值取偶数
     *
     * @param a
     * @return
     */
    public static double rint(double a) {
        System.out.println(Math.rint(2.5));
        System.out.println(Math.rint(3.5));
        System.out.println(Math.rint(2.3));
        System.out.println(Math.rint(2.6));
        return Math.rint(a);
    }

    /**
     * 以a为底b次幂
     *
     * @param a 基数
     * @param b 指数
     * @return
     */
    public static double pow(double a, double b) {
        System.out.println(Math.pow(2, 3));
        return Math.pow(a, b);
    }

    /**
     * 返回一个更接近参数的int， 四舍五入
     *
     * @param a
     * @return
     */
    public static int round(float a) {
        System.out.println(Math.round(5.6));
        System.out.println(Math.round(5.5));
        System.out.println(Math.round(5.3));
        return Math.round(a);
    }

    /**
     * 返回一个正数double值， 比0大比1.0小。返回值在那个统一的范围内选择一个伪随机数。
     * <p>
     * 这个方法第一次被调用会产生一个伪随机产生器。
     * <p>
     * 伪随机数产生器会在此后这个方法的所有调用中使用，不会再在其他地方使用。
     * <p>
     * 这个方法要适当地同步，为了正确的多线程使用
     *
     * @return
     */
    public static double random() {
        System.out.println(Math.random());
        return Math.random();
    }

    /**
     * 返回参数的和，如果结果溢出，则抛出异常
     *
     * @param x
     * @param y
     * @return
     */
    public static int addExact(int x, int y) {
        return Math.addExact(x, y);
    }

    /**
     * 返回两个数的差，溢出照样会抛异常
     *
     * @param x
     * @param y
     * @return
     */
    public static long subtractExact(long x, long y) {
        return Math.subtractExact(x, y);
    }

    /**
     * 返回参数的乘积，结果溢出抛异常
     *
     * @param x
     * @param y
     * @return
     */
    public static int multiplyExact(int x, int y) {
        return Math.multiplyExact(x, y);
    }

    /**
     * 返回参数的自增，如果结果溢出抛出异常
     *
     * @param a
     * @return
     */
    public static int incrementExact(int a) {
        System.out.println(Math.incrementExact(6));
        return Math.incrementExact(a);
    }

    /**
     * 返回参数的自减，如果结果溢出抛出异常
     *
     * @param a
     * @return
     */
    public static int decrementExact(int a) {
        return Math.decrementExact(a);
    }

    /**
     * 返回参数的相反数，如果结果溢出就会抛出异常
     *
     * @param a
     * @return
     */
    public static int negateExact(int a) {
        return Math.negateExact(a);
    }

    /**
     * 将一个long参数返回一个值，如果溢出就会抛出异常
     *
     * @param value
     * @return
     */
    public static int toIntExact(long value) {
        return Math.toIntExact(value);
    }

    /**
     * 返回一个小于等于算术商的最大值,特殊情况下被除数Integer.MAX_VALUE和除数-1，整数溢出发生和其结果等于Integer.MIN_VALUE
     * 两个参数符号一样的时候
     * {@code floorDiv(4, 3) == 1} and {@code (4 / 3) == 1}
     * 两个参数符号不一致时
     * {@code floorDiv(-4, 3) == -2}, whereas {@code (-4 / 3) == -1}
     *
     * @param x
     * @param y
     * @return
     */
    public static int floorDiv(int x, int y) {
        System.out.println(Math.floorDiv(Integer.MIN_VALUE + 1, -1));

        return Math.floorDiv(x, y);
    }

    /**
     * 返回一个int值的绝对值。
     * 如果参数为不是负数， 参数被返回。
     * 如果参数为负数， 参数的相反数被返回
     *
     * @param a
     * @return
     */
    public static int abs(int a) {

        return Math.abs(a);
    }

    /**
     * 返回两个值中最大的一个， 结果是最接近Integer#MAX_VALUE 的值
     *
     * @param a
     * @param b
     * @return
     */
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    /**
     * 返回两个值中最小的数
     *
     * @param a
     * @param b
     * @return
     */
    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    /**
     * PS: 该方法是确定浮点数精确度的关键方法，代表最小的精度单位，即在某个浮点数能浮动的最小范围
     *
     * 返回参数的一个ulp（最小的精度单位）大小, double值是两个浮点数之间的举例，其double值仅次于最大的精度值.
     * 该函数随着参数的增大，所对应的值也增大，精度大小越大
     *
     * @param d
     * @return
     */
    public static double ulp(double d) {
        System.out.println(Math.ulp(Double.MAX_VALUE));
        return Math.ulp(d);
    }

    /**
     * 返回一个参数的正负号函数， 如果参数为零就是零，大于零为1， 小于零为-1
     * 正零和负零可以通过该函数区分
     *
     * @param d
     * @return
     */
    public static double signum(double d) {
        System.out.println();
        return Math.signum(d);
    }

    /**
     * 返回一个值的双曲线正弦
     *
     * @param x
     * @return
     */
    public static double sinh(double x) {
        return Math.sinh(x);
    }

    /**
     * 勾股定理，返回sqrt（x*x + y*y）,不会有中间的上溢和下溢
     *
     * @param x
     * @param y
     * @return
     */
    public static double hypot(double x, double y) {
        return Math.hypot(x, y);
    }

    /**
     * 返回欧拉e^x - 1。注意对于x值接近0的，expm1(x) + 1 的值比 exp(x) 的值更加的精确。
     *
     * @param x
     * @return
     */
    public static double expm1(double x) {
        System.out.println(Math.expm1(1));
        System.out.println(Math.expm1(1) + 1);
        return Math.exp(x);
    }

    /**
     * 返回参数 + 1的自然对数，注意对于较小的x值，log1p(x)比log(1.0 + x) 更接近于ln(1 + x)
     *
     * @param x
     * @return
     */
    public static double log1p(double x) {
        System.out.println(log1p(Math.E));
        System.out.println(log(Math.E + 1));
        return Math.log1p(x);
    }

    /**
     * 返回以第二个参数符号的第一个浮点参数的值。
     * 注意这个方法没有NAN问题，NAN被对待为一个正数值。
     *
     * @param magnitude
     * @param sign
     * @return
     */
    public static double copySign(double magnitude, double sign) {
        System.out.println(Math.copySign(10, -1));
        System.out.println(Math.copySign(10, 1));
        return Math.copySign(magnitude, sign);
    }

    /**
     * 返回一个表示参数d值的公正指数
     *
     * @param d
     * @return
     */
    public static int getExponent(double d) {
        System.out.println(Math.getExponent(5));
        System.out.println(Math.getExponent(12));
        return Math.getExponent(d);
    }

    /**
     * 返回和第一个参数相邻，加减方向和第二个参数方向一致的。如果两个参数相等，第二个参数被返回
     *
     * @param start
     * @param direction
     * @return
     */
    public static double nextAfter(double start, double direction) {
        System.out.println(Math.nextAfter(1, -1));
        System.out.println(Math.nextAfter(1, 1));
        System.out.println(Math.nextAfter(1, 3));
        return Math.nextAfter(start, direction);
    }

    /**
     * 返回一个与d接近的正无限方向的值 , 和nextAfter(d, Double.Max_value)等价。
     * 不过，该方法会比nextAfter的速度更快
     *
     * @param d
     * @return
     */
    public static double nextUp(double d) {
        System.out.println(Math.nextUp(1));
        System.out.println(1 + Math.ulp(1));
        return Math.nextUp(d);
    }

    /**
     * 返回一个与d相近的负无限方向的值，和nextAfter(d, Double.negative_infinity等价，
     * 不过，该方法会比nextAfter的速度更快
     *
     * @param d
     * @return
     */
    public static double nextDown(double d) {
        System.out.println(Math.nextDown(100000000));
        System.out.println(100000000 - Math.ulp(100000000));
        return Math.nextDown(d);
    }

    /**
     * d乘以（times）2^scaleFactor
     *
     * @param d
     * @param scaleFactor
     * @return
     */
    public static double scalb(double d, int scaleFactor) {
        return Math.scalb(d, scaleFactor);
    }

    public static void main(String[] args) {
//        System.out.println(MathSpecification.IEEEremainder(6, 9));
//        System.out.println(MathSpecification.ceil(3.2));
//        System.out.println(MathSpecification.floor(3.2));
        System.out.println(MathSpecification.rint(2));
//        System.out.println(MathSpecification.pow(3, 4));
//        System.out.println(MathSpecification.round(5.2f));
//        System.out.println(MathSpecification.random());

//        System.out.println(MathSpecification.incrementExact(999999999));
//        System.out.println(MathSpecification.addExact(1500000000, 1500000000));
//        System.out.println(MathSpecification.toIntExact(343333333333333L));

//        System.out.println(MathSpecification.floor(-4.0/3));

//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(MathSpecification.floorDiv(Integer.MAX_VALUE, -1));

//        System.out.println(MathSpecification.ulp(Double.MIN_VALUE));

//        System.out.println(MathSpecification.copySign(89, -1));

//        System.out.println(MathSpecification.getExponent(16));

//        System.out.println(MathSpecification.nextAfter(3, 3));

//        System.out.println(MathSpecification.nextUp(5));
//        System.out.println(MathSpecification.nextDown(10));

//        System.out.println(MathSpecification.scalb(1.5, 3));


    }


}

