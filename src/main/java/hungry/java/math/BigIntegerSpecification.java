package hungry.java.math;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 * 不变的任意精度的整数。BigInteger提供了：模运算，GCD 计算（最大公约数计算），质数测试，素数生成
 * 位操作，以及一些其他的操作。
 * <p>
 *
 * PS: 大端字节序（Big endian）,将地址低位存储值的低位，将地址高位存储值的高位（最符合人的思维）
 * 小端字节序（little endian），将地址高位存储值的低位，将地址低位存储值得高位（直观）
 *
 * one's complement 指的是正数=原码， 负数=反码
 * two's complement 就是通常所指的补码， 负数=反码 + 1
 * Created by admin on 2019/5/27.
 */
public class BigIntegerSpecification {

    // 构造函数

    /**
     * 翻译包含二进制补码格式的BigInteger转为BigInteger，输入的数组为big-endian 字节序：最重要的是第零个元素
     * @param val
     */
    public BigIntegerSpecification(byte[] val) {
        byte[] bytes = {2, 3, 5};
        // 20305
        System.out.println(Long.toHexString(new BigInteger(bytes).intValue()));
        byte[] byte2 = {-3, 2, 3, 5};
        // fffffffffd020305
        System.out.println(Long.toHexString(new BigInteger(byte2).intValue()));
    }

    /**
     * 转换一个带符号数值大小的BigInteger转为BigInteger。符号包含一个-1负数，0零, 1正数
     * @param signum
     * @param magnitude
     */
    public BigIntegerSpecification(int signum, byte[] magnitude) {
        byte[] bytes = {2, 3, 5};
        // 131845
        System.out.println(new BigInteger(1, bytes));
        // -131845
        System.out.println(new BigInteger(-1, bytes));
    }

    /**
     *
     * 用指定radix进制的BigInteger的string形式转为BigInteger
     * @param val
     * @param radix
     */
    public BigIntegerSpecification(String val, int radix) {
        System.out.println(new BigInteger("1111", 2));
        System.out.println(new BigInteger("35675", 8));
    }

    /**
     * 翻译一个十进制的字符串形式成一个BigInteger
     * @param val
     */
    public BigIntegerSpecification(String val) {
        System.out.println(new BigInteger("467"));
    }


    /**
     * 构造一个统一分布的范围是 0 - 2^numBits, 包括这两个数。分布统一就是一个公平的随机源rnd
     * @param numBits
     * @param rnd
     */
    public BigIntegerSpecification(int numBits, Random rnd) {
        Random random = new Random();
        System.out.println(new BigInteger(8, random));
        System.out.println(new BigInteger(8, random));
    }


    /**
     * 构造一个随机产生的素数, 使用指定的位的长度。
     *
     * probablePrime方法是优于该构造函数的，出入有一个强迫需要指定一个可能性
     * @param bitLength
     * @param certainty 一个调用者能承受不确定的测量。 一个新的整数能表现为素数的可能性为(1 - 1/2^certainty),
     *                  这个构造函数的执行时间和这个参数的值成比例
     * @param rnd
     */
    public BigIntegerSpecification(int bitLength, int certainty, Random rnd) {
        Random random = new Random();
        System.out.println(new BigInteger(5, 6, random));
        System.out.println(new BigInteger(5, 6, random));
    }


    /**
     * 返回正素数，用指定的位数长度。其可能性不会超过2^-100
     *
     * @param bitLength
     * @param rnd
     * @return
     */
    public static BigInteger probablePrime(int bitLength, Random rnd) {
        Random random = new Random();
        System.out.println(BigInteger.probablePrime(6, random));
        return null;
    }

    /**
     * 返回比这个BigInteger大的下一个素数。
     * @return
     */
    public BigInteger nextProbablePrime() {
        System.out.println(new BigInteger("56789").nextProbablePrime());
        return null;
    }

    // 静态工厂方法

    /**
     * 返回一个值为val的BigInteger数，静态工厂方法优于一个long类型的构造方法，因为它允许BigInteger的重用
     * @param val
     * @return
     */
    public static BigInteger valueOf(long val) {
        System.out.println(BigInteger.valueOf(134));
        return null;
    }


    // 算术操作

    /**
     * 返回一个大整数他的值为 this + val
     * @param val
     * @return
     */
    public BigInteger add(BigInteger val) {
        System.out.println(BigInteger.valueOf(5).add(BigInteger.ONE));
        return null;
    }

    /**
     * 返回一个this - val 的大整数
     * @param val
     * @return
     */
    public BigInteger subtract(BigInteger val) {
        System.out.println(BigInteger.valueOf(8).subtract(BigInteger.ONE));
        return null;
    }

    /**
     * 返回一个this * val 的大整数.
     * 注意：当this == val时，一个实现提供一个更好的算法性能
     * @param val
     * @return
     */
    public BigInteger multiply(BigInteger val) {
        System.out.println(BigInteger.valueOf(6666).multiply(BigInteger.valueOf(3)));
        return null;
    }

    /**
     * 返回一个 this / val的大整数值
     *
     * @param val
     * @return
     */
    public BigInteger divide(BigInteger val) {
        System.out.println(BigInteger.valueOf(6662).divide(BigInteger.valueOf(3)));
        return null;
    }

    /**
     * 返回一个this % val 的大整数
     * @param val
     * @return
     */
    public BigInteger remainder(BigInteger val) {
        System.out.println(BigInteger.valueOf(6662).remainder(BigInteger.valueOf(3)));
        return null;
    }

    /**
     * 返回两个整数的数组包含(this / val) 跟着 this % val
     *
     * @param val
     * @return
     */
    public BigInteger[] divideAndRemainder(BigInteger val) {
        System.out.println(Arrays.toString(BigInteger.valueOf(662).divideAndRemainder(BigInteger.valueOf(3))));
        return null;
    }

    /**
     * 返回一个整数他的值为this^exponent, 注意参数exponet 是一个整数不是大整数,且不能为负数
     * @param exponent
     * @return
     */
    public BigInteger pow(int exponent) {
        System.out.println(BigInteger.valueOf(3).pow(3));
        return null;
    }

    /**
     * 返回一个最大公约数
     * @param val
     * @return
     */
    public BigInteger gcd(BigInteger val) {
        System.out.println(BigInteger.valueOf(15).gcd(BigInteger.valueOf(12)));
        return null;
    }

    // 模运算

    /**
     * 返回一个this mod m. 这个方法不同remainder， 他总会返回一非负大整数
     * @param m
     * @return
     */
    public BigInteger mod(BigInteger m) {
        System.out.println(BigInteger.valueOf(-5).mod(BigInteger.valueOf(3)));
        return null;
    }

    /**
     * 返回一个BigInteger他的值是 this^exponent mod m, 即为乘法逆元
     * @param m
     * @return
     */
    public BigInteger modInverse(BigInteger m) {
        System.out.println(BigInteger.valueOf(5).modInverse(BigInteger.valueOf(3)));
        return null;
    }
    /**
     * 返回一个this^exponent mod m. 不像pow, 这个方法允许负指数
     * @param exponent
     * @param m
     * @return
     */
    public BigInteger modPow(BigInteger exponent, BigInteger m) {
        System.out.println(BigInteger.valueOf(8).modPow(BigInteger.valueOf(-1), BigInteger.valueOf(5)));
        System.out.println(BigInteger.valueOf(8).modInverse(BigInteger.valueOf(5)));
        return null;
    }


    // 移位操作

    /**
     * 返回一个大整数他的值是this << n. 移动的距离n, 可能是负数，那就是这个方法会执行右移。计算（floor（this * 2 ^ n））
     * @param n
     * @return
     */
    public BigInteger shiftLeft(int n) {
        System.out.println(BigInteger.valueOf(2).shiftLeft(2));
        return null;
    }

    /**
     * 返回一个大整数他的值是this >> n
     * @param n
     * @return
     */
    public BigInteger shiftRight(int n) {
        System.out.println(BigInteger.valueOf(8).shiftRight(2));
        return null;
    }

    // 按位操作
    /**
     * 返回一个大整数他的值 this & val. 这个方法返回一个负大整数仅仅是this 和 val 都为负数
     * @param val
     * @return
     */
    public BigInteger and(BigInteger val) {
        System.out.println(BigInteger.valueOf(4).and(BigInteger.ONE));
        return null;
    }

    /**
     * 返回一个大整数 this | val. 这个方法返回一个负大整数仅仅 this 和 val 其中一个为负数
     * @param val
     * @return
     */
    public BigInteger or(BigInteger val) {
        System.out.println(BigInteger.valueOf(4).or(BigInteger.ONE));
        return null;
    }

    /**
     * 返回一个大整数他的值是 this ^ val. 这个方法返回一个负大整数，只要this和val是一个负数
     * @param val
     * @return
     */
    public BigInteger xor(BigInteger val) {
        System.out.println(BigInteger.valueOf(5).xor(BigInteger.ONE));
        return null;
    }

    /**
     * 返回一个大整数，这个值（~ this）. 这个方法返回一个负数，如果这个大整数是非负数
     * @return
     */
    public BigInteger not() {
        //  0101
        //  1010
        System.out.println(BigInteger.valueOf(5).not());
        System.out.println(BigInteger.valueOf(0).not());
        return null;
    }

    /**
     * 返回一个大整数是 this & ~val. 这个方法等于是提供一个方便的掩码操作(掩码操作即屏蔽当前的输入位)
     *
     * @param val
     * @return
     */
    public BigInteger andNot(BigInteger val) {
        System.out.println(BigInteger.valueOf(5).andNot(BigInteger.valueOf(3)));
        System.out.println(BigInteger.valueOf(5).andNot(BigInteger.valueOf(15)));
        return null;
    }

    // 单 位操作

    /**
     * 返回一个被指定位是否设置, 该位是从零开始计算
     * @param n
     * @return
     */
    public boolean testBit(int n) {
        System.out.println(BigInteger.valueOf(5).testBit(0));
        System.out.println(BigInteger.valueOf(5).testBit(1));
        System.out.println(BigInteger.valueOf(5).testBit(2));
        return false;
    }

    /**
     * 返回一个对这个大整数指定为设置的大整数
     * @param n
     * @return
     */
    public BigInteger setBit(int n) {
        System.out.println(BigInteger.valueOf(5).setBit(1));
        return null;
    }

    /**
     * 取消指定的n位的大整数
     * @param n
     * @return
     */
    public BigInteger clearBit(int n) {
        System.out.println(BigInteger.valueOf(5).clearBit(0));
        return null;
    }

    /**
     * 对指定位的翻转
     * @param n
     * @return
     */
    public BigInteger flipBit(int n) {
        return null;
    }


    /**
     * 返回这个大整数最右边（最低位）一位的数
     * @return
     */
    public int getLowestSetBit() {
        System.out.println(new BigInteger("6757567"));
        return 1;
    }


    // 多种多样的位操作

    /**
     * 返回呈现这个大整数二进制补码最小位数的长度
     * @return
     */
    public int bitLength() {
        System.out.println(BigInteger.valueOf(8).bitLength());
        return 1;
    }

    /**
     * 呈现大整数的二进制补码的位的数量，即为1的位数
     * @return
     */
    public int bitCount() {
        System.out.println(BigInteger.valueOf(5).bitCount());
        return 1;
    }


    // 素数测试

    /**
     * 如果是质数则返回true，如果是合数返回false。如果certainty 是小于等于零，则返回true
     * @param certainty
     * @return
     */
    public boolean isProbablePrime(int certainty) {
        System.out.println(BigInteger.valueOf(6).isProbablePrime(3));
        System.out.println(BigInteger.valueOf(7).isProbablePrime(100));
        return true;
    }


    // 比较操作

    /**
     * 这个整数和指定的整数比较。
     * @param val
     * @return -1, 0, 1就是这个大整数比val小于，等于，大于
     */
    public int compareTo(BigInteger val) {
        return 1;
    }

    /**
     * 比较这个整数和指定的对象是否等值
     * @param x
     * @return 仅仅指定的对象和这个大整数数值上相等就返回true
     */
    public boolean equals(Object x) {
        return true;
    }

    /**
     * 返回一个包含这个大整数的二进制补码字节数组。数组是一个大端序列：最有效的字节在第零个元素。
     * @return
     */
    public byte[] toByteArray() {
        byte[] bytes = {2, 3, 5};
        // 131845
        System.out.println(new BigInteger(bytes));
        // [2, 3, 5]
        System.out.println(Arrays.toString(new BigInteger(bytes).toByteArray()));
        return null;
    }

    public static void main(String[] args) {
        System.out.println(5 % -3);
        System.out.println(-5 % 3);
        System.out.println(-5 % -3);
        System.out.println(5 % 3);

        // 0000 0011
        // 1111 1100 + 1 (13)
        byte[] bytes = {2, 3, 5};

//        System.out.println(new BigInteger(1, bytes));
//        System.out.println(new BigInteger(-1, bytes));
//        System.out.println(new BigIntegerSpecification("", 0));
//        System.out.println(new BigIntegerSpecification("1"));
//        System.out.println(new BigIntegerSpecification(1, new Random()));
//        System.out.println(new BigIntegerSpecification(1, 1, null));
//        System.out.println(BigIntegerSpecification.probablePrime(1, null));
//        System.out.println(new BigIntegerSpecification("").nextProbablePrime());
//        System.out.println(BigIntegerSpecification.valueOf(10));

//        System.out.println(new BigIntegerSpecification("").modInverse(null));
//        System.out.println(new BigIntegerSpecification("").modPow(BigInteger.valueOf(-1), BigInteger.valueOf(20)));
//        System.out.println(BigInteger.valueOf(56897).modInverse(BigInteger.valueOf(36)));

//        System.out.println(new BigIntegerSpecification("").modPow(null, null));
//        System.out.println(new BigIntegerSpecification("").and(null));
//        System.out.println(new BigIntegerSpecification("").or(null));
//        System.out.println(new BigIntegerSpecification("").xor(null));

//        System.out.println(new BigIntegerSpecification("").not());
//        System.out.println(new BigIntegerSpecification("").andNot(BigInteger.valueOf(0)));
//        System.out.println(new BigIntegerSpecification("").testBit(1));
//        System.out.println(new BigIntegerSpecification("").setBit(1));
//        System.out.println(new BigIntegerSpecification("").clearBit(1));
//        System.out.println(new BigIntegerSpecification("").getLowestSetBit());
//        System.out.println(new BigIntegerSpecification("").bitLength());
//        System.out.println(new BigIntegerSpecification("").bitCount());
//        System.out.println(new BigIntegerSpecification("").isProbablePrime(1));
        System.out.println(new BigIntegerSpecification("").toByteArray());
    }
}
