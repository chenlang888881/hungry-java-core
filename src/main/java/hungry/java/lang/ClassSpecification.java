package hungry.java.lang;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * 运行时类型信息
 *
 * 类和接口的类实例。枚举是类和注解是接口。数组属于一个相同元素类型和大小的类。
 * 原生类也表现为Class对象。
 *
 * Class 对象无构造函数, 通过JVM加载或者通过ClassLoader.defineClass方法来加载。
 *
 * 该对象可用object.getClass()或者类字面常量来获取Foo.class
 *
 *
 * @author ChenLang
 * @date 2019/11/6 9:10
 */
public class ClassSpecification<T> {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(Class.forName("hungry.java.lang.ClassSpecification"));
        System.out.println(Class.forName("java.util.List"));
        System.out.println(List.class.toGenericString());
        System.out.println(ClassSpecification.class.getClassLoader());
        System.out.println(List.class.getClassLoader());

        System.out.println(ClassSpecification.class.getDeclaringClass());

        System.out.println(new ClassSpecification<>().getConstructor());
    }

    /**
     * 返回指定参数类型的，具有public访问权限的构造函数对象。
     * 当是内部类时，第一个参数为外部类的实例
     *
     * @author ChenLang
     * @date 2019/11/23 12:42
     * @param parameterTypes
     * @return
     */
    public Constructor<T> getConstructor(Class<?>... parameterTypes) {
        return null;
    }


    /**
     * 返回所有具有public访问权限的构造器数组。
     * 泛型为?, 是为了能将构造器对象保存为不同类
     *
     * @author ChenLang
     * @date 2019/11/23 13:03
 * @return
     */
    public Constructor<?>[] getConstructors() {
        return null;
    }

    /**
     * 返回指定参数类型，所有声明的构造函数对象
     *
     * @author ChenLang
     * @date 2019/11/23 13:12
     * @param parameterTypes
     * @return
     */
    public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) {
        return null;
    }

    /**
     * 返回所有声明的构造函数，包括公有，私有，默认访问权限，私有的。返回顺序不固定
     *
     * @author ChenLang
     * @date 2019/11/23 13:18
     * @return 
     */
    public Constructor<?>[] getDeclaredConstructors() {
        
        return null;
    }


    /**
     * 返回一个带有空参数列表的构造函数。
     * 但是此方法可以绕过检查时异常。使用Constructor#newInstance(java.lang.Object...)
     * 则可以避免，他将会把检查时异常包裹在java.lang.reflect.InvocationTargetException
     * 当中
     *
     * @author ChenLang
     * @date 2019/11/23 13:25
     * @return
     */
    public T newInstance() {
        return null;
    }
}
