package hungry.java.lang;


import hungry.java.lang.assist.ClassSpecSuper;
import hungry.java.lang.assist.TypeUseAnnotation;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.reflect.*;
import java.net.URL;
import java.security.ProtectionDomain;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Resource
public class ClassSpec<T> extends @TypeUseAnnotation ClassSpecSuper {
    private T obj;
    public ClassSpec() {
//        System.out.println("参数为： " + param );
//        if (!param.isEmpty() && param.length() > 0) {
//            throw new RuntimeException("也噢");
//        }
//        throw new RuntimeException("hello good");
        class ClassA {

        }
        System.out.println(ClassA.class.getEnclosingConstructor());
    }

    public ClassSpec(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    @Override
    public Integer getNum() {
        return 555;
    }

    /**
     * 针对类对象返回class + getName 返回的全限定名称
     * 基本类型直接返回基本类型的名称
     *
     * @return
     */
    public String toString() {
        String toString = ClassSpec.class.toString();
        // class hungry.java.lang.ClassSpec
        System.out.println(toString);
        // int

//        System.out.println(int.class.toString());
        return toString;
    }

    /**
     * 返回一个描述该类的字符串, 包括修饰符和类型参数
     * <p>
     * 一个类型修饰符列表（如public, abstract, final）,类型（class， interface，enum）,
     * 类型名称, 用三角括号逗号隔开的类型参数列表
     *
     * @return
     */
    public String toGenericString() {
        String toString = ClassSpec.class.toGenericString();
        // public class hungry.java.lang.ClassSpec
        System.out.println(toString);
        // public abstract interface java.util.List<E>
        System.out.println(List.class.toGenericString());
        // public abstract interface java.util.Map<K,V>
        System.out.println(Map.class.toGenericString());
        // public final class java.lang.String
        System.out.println(String.class.toGenericString());
        // int
        System.out.println(int.class.toGenericString());
        return toString;
    }

    /**
     * 返回关联给定字符串类或接口的类对象.
     *
     * @param className 所需类的全限定名称
     * @return
     */
    public static Class<?> forName(String className) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
            System.out.println(clazz);
            System.out.println(int[].class.getName());
            Class<?> aClass = Class.forName("hungry.java.lang.ClassSpec");
            System.out.println(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    /**
     * 如果加载器是空的，通过bootstrap加载器加载。如果之前没有加载过, 只有当initialize为true时被加载。
     * <p>
     * 名称如果为基本类型, 通过用户定义没有包名的类去定位，因此这个方法不能获得基本类型的类对象的。
     * <p>
     * 如果是数组类，数组的组件类型被加载但是不会初始化。
     *
     * @param name
     * @param initialize 该参数如果为true，将会被初始化。请看The Java Language Specification 12.4
     * @param loader
     * @return
     */
    public static Class<?> forName(String name, boolean initialize, ClassLoader loader) {
        // TODO 请看The Java Language Specification 12.4. 该地方需要确认如何初始化类对象
        Class<?> clazz = null;
        try {
            clazz = Class.forName(name, initialize, loader);
            System.out.println(clazz);
            // 抛出异常，由于会从用户定义没有包名的目录去查找
            // System.out.println(Class.forName("int"));
            // class [I
            Class<?> aClass = Class.forName("[I");
            System.out.println(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    /**
     * 创建一个类对象的实例。这个类通过一个空参数列表实例化。如果还没有初始化，将会被初始化。
     * <p>
     * 这个方法可以产生由空元构造器的任何异常，包括检查时异常。这个方法可以有效绕过编译时异常，Constructor.newInstance
     * 方法可以通过用java.lang.reflect.InvocationTargetException包裹构造器的任何异常来避免这个问题（即调用目标发生了异常）
     *
     * @return
     */
    public T newInstance() {
        try {
            // 如果该构造器抛出异常，将以原样异常返回
            ClassSpec classSpec = ClassSpec.class.newInstance();
            System.out.println(classSpec);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        try {
            ClassSpec classSpec = ClassSpec.class.getConstructor(String.class).newInstance("yesyes");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // 如果调用的该构造器抛出异常，将会以InvocationTargetException来包裹该异常
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 指定对象是当前类或其子类的一个实例时返回true。相当于java 语言instanceof操作符
     * 数组的表现也是一样的。基本类型会返回空.
     *
     * @param object
     * @return
     */
    public boolean isInstance(Object object) {
        // true
        System.out.println(List.class.isInstance(new ArrayList<>()));
        // true
        System.out.println(ClassSpec.class.isInstance(new ClassSpec<>()));
        // false
        System.out.println(int.class.isInstance(5));
        return true;
    }

    /**
     * 当前类是指定参数类或者其超类。
     * <p>
     * 指定类参数是否可以转换为当前类，通过标识转换和扩展引用转换。查看The Java Language
     * Specification，5.1.1 and 5.1.4
     *
     * @param cls
     * @return
     */
    public boolean isAssignableFrom(Class<?> cls) {
        // true
        System.out.println(List.class.isAssignableFrom(ArrayList.class));
        // true
        System.out.println(ClassSpec.class.isAssignableFrom(ClassSpec.class));
        // true
        System.out.println(int.class.isAssignableFrom(int.class));
        return true;
    }


    /**
     * 指定类对象是否表现为接口类型
     *
     * @return
     */
    public boolean isInterface() {
        // true
        System.out.println(List.class.isInterface());
        // false
        System.out.println(ArrayList.class.isInterface());
        return true;
    }

    /**
     * 决定是否这个类对象表现为数组类。
     *
     * @return
     */
    public boolean isArray() {
        return true;
    }

    /**
     * 决定指定的类对象是否为基本类型。
     * <p>
     * 预定义类对象表现八种（byte，boolean，char, short, int, long, float, double）基本类型和void.
     * <p>
     * 也只有这些类会返回true
     *
     * @return
     * @see Boolean#TYPE
     * @see Character#TYPE
     * @see Byte#TYPE
     * @see Short#TYPE
     * @see Integer#TYPE
     * @see Long#TYPE
     * @see Float#TYPE
     * @see Double#TYPE
     * @see Void#TYPE
     */
    public boolean isPrimitive() {
        // true
        System.out.println(int.class.isPrimitive());
        // true
        System.out.println(Integer.TYPE.isPrimitive());
        // false
        System.out.println(ClassSpec.class.isPrimitive());
        return true;
    }

    /**
     * 如果类对象表现为注解类型，就返回true。如果这个方法返回true，isInterface()也返回true，
     * 因为注解类型也是接口。
     *
     * @return
     */
    public boolean isAnnotation() {
        // true
        System.out.println(Deprecated.class.isAnnotation());
        // true
        System.out.println(Deprecated.class.isInterface());
        return true;
    }

    /**
     * 决定
     *
     * @return
     */
    public boolean isSynthetic() {
        User user = new User();
        user.age = 1;
        user.name = "fff";
        Method[] declaredMethods = user.getClass().getDeclaredMethods();
        // 为了访问内部类的私有成员，编译器自动生成访问age的方法，以及自动生成的类ClassSpec$1.class
        // ，为了给私有内部类的构造函数作为参数使用
        // access$102 isSynthetic: true
        // access$202 isSynthetic: true
        // setAge isSynthetic: false
        // getAge isSynthetic: false
        for (Method method : declaredMethods) {
            System.out.println(method.getName() + " isSynthetic: " + method.isSynthetic());
        }
        return true;
    }

    /**
     * 1、如果是引用类型，则就是类的全限定名称。
     * 2、基本类型，就是Java语言关键字对应的基本类型和void
     * 3、如果是数组类型，前面加一个或多个[，取决于数组的维度; 加上下面对应元素类型名称组成。
     *
     * <table summary="Element types and encodings">
     * <tr><th> Element Type <th> &nbsp;&nbsp;&nbsp; <th> Encoding
     * <tr><td> boolean      <td> &nbsp;&nbsp;&nbsp; <td align=center> Z
     * <tr><td> byte         <td> &nbsp;&nbsp;&nbsp; <td align=center> B
     * <tr><td> char         <td> &nbsp;&nbsp;&nbsp; <td align=center> C
     * <tr><td> class or interface
     *                       <td> &nbsp;&nbsp;&nbsp; <td align=center> L<i>classname</i>;
     * <tr><td> double       <td> &nbsp;&nbsp;&nbsp; <td align=center> D
     * <tr><td> float        <td> &nbsp;&nbsp;&nbsp; <td align=center> F
     * <tr><td> int          <td> &nbsp;&nbsp;&nbsp; <td align=center> I
     * <tr><td> long         <td> &nbsp;&nbsp;&nbsp; <td align=center> J
     * <tr><td> short        <td> &nbsp;&nbsp;&nbsp; <td align=center> S
     * </table>
     *
     * @return
     */
    public String getName() {
        // int
        System.out.println(int.class.getName());
        // hungry.java.lang.ClassSpec
        System.out.println(ClassSpec.class.getName());
        // [J
        System.out.println(long[].class.getName());
        // 除了加上L,后面还需加；
        // [Lhungry.java.lang.ClassSpec;
        System.out.println(ClassSpec[].class.getName());
        return "name";
    }

    /**
     * 返回该类的类加载器。被bootstrap加载器加载的该方法返回空。
     * <p>
     * 安全管理器存在，调用者的类加载器不是空，并且调用者的类加载器和被对类请求的类加载不相同
     * 或者不是祖先类加载器时。会调用安全管理器的checkPermission 方法。
     *
     * @return
     */
    public ClassLoader getClassLoader() {
        ClassLoader classLoader = ClassSpec.class.getClassLoader();
        // 类加载器的顺序
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        // sun.misc.Launcher$ExtClassLoader@1b6d3586
        // 当为空时为bootstrap类加载器
        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }
        return null;
    }

    /**
     * 返回一个被GenericDeclaration对象表示的通用声明声明的类型变量数组
     *
     * @return
     */
    public TypeVariable<Class<T>>[] getTypeParameters() {
        List<Long> longList = new ArrayList<>();
        TypeVariable<? extends Class<? extends List>>[] typeParameters = longList.getClass().getTypeParameters();
        // E
        System.out.println(typeParameters[0]);
        TypeVariable<Class<Map>>[] typeParameters1 = Map.class.getTypeParameters();
        // K  V
        System.out.println(typeParameters1[0] + "  " + typeParameters1[1]);
        return null;
    }

    /**
     * 返回这个类对象的超类。
     * 如果类表示为Object Class, 接口, 基本类型, void则返回空。
     * 如果是一个数组，则数组中的对象被返回。
     * 如果是除Object之外的对象，则超类表示为Object
     *
     * @return
     */
    public Class<? super T> getSuperClass() {
        // class java.util.AbstractList
        System.out.println(ArrayList.class.getSuperclass());
        // class java.lang.Object
        System.out.println(ClassSpec.class.getSuperclass());
        // null
        System.out.println(int.class.getSuperclass());
        // null
        System.out.println(Object.class.getSuperclass());
        // null
        System.out.println(List.class.getSuperclass());
        // class java.lang.Object
        System.out.println(ClassSpec[].class.getSuperclass());
        return null;
    }

    /**
     * 如果超类是参数化类型, 该方法返回的结果会反映在源码中的真实类型参数.即会返回泛型超类。
     *
     * @return
     */
    public Type getGenericSuperClass() {
        // java.util.AbstractList<E> 会带有参数类型E
        Type genericSuperclass = ArrayList.class.getGenericSuperclass();
        System.out.println(genericSuperclass);
        // null
        Type genericSuperclass1 = HashMap.class.getGenericSuperclass();
        System.out.println(genericSuperclass1);
        // class java.lang.Object
        System.out.println(ClassSpec.class.getGenericSuperclass());
        return null;
    }

    /**
     * 返回类的包信息, 类的类加载器被用来找到包。
     * 如果是根加载器，为了找到类的包将会从classpath中搜索一系列包。
     * 包信息中有版本和说明信息。
     *
     * @return
     */
    public Package getPackage() {
        // package hungry.java.lang
        System.out.println(ClassSpec.class.getPackage());
        // package java.util, Java Platform API Specification, version 1.8
        System.out.println(List.class.getPackage());
        return null;
    }

    /**
     * 返回一个实现该类的接口类数组, 顺序是和在实现子句声明的一致。
     * 如果是没有实现接口的class对象或接口，返回会返回长度为0的数组。
     * 如果是基本类型或void, 也会返回长度为0的数组。
     * 如果类是数组类型, 按Cloneable和serializable顺序返回
     *
     * @return
     */
    public Class<?>[] getInterfaces() {
        // interface java.util.Collection
        System.out.println(List.class.getInterfaces()[0]);
        // interface java.lang.Cloneable : interface java.io.Serializable
        System.out.println(ClassSpec[].class.getInterfaces()[0] + " : " + ClassSpec[].class.getInterfaces()[1]);
        // 0
        System.out.println(ClassSpec.class.getInterfaces().length);
        return null;
    }

    /**
     * 如果超类是泛型接口, 以泛型的形式返回。
     *
     * @return
     */
    public Type[] getGenericInterfaces() {
        // java.util.Collection<E>
        System.out.println(List.class.getGenericInterfaces()[0]);
        // interface java.lang.Cloneable : interface java.io.Serializable
        System.out.println(ClassSpec[].class.getGenericInterfaces()[0] + " : " + ClassSpec[].class.getGenericInterfaces()[1]);
        // 0
        System.out.println(ClassSpec.class.getGenericInterfaces().length);
        return null;
    }


    /**
     * 返回一个数组组件类型的类。
     *
     * @return
     */
    public Class<?> getComponentType() {
        // class hungry.java.lang.ClassSpec
        System.out.println(ClassSpec[].class.getComponentType());
        // null
        System.out.println(ClassSpec.class.getComponentType());
        return null;
    }


    /**
     * 返回对这个类或接口的Java语言修饰符，被编码成整数。
     * 包括public，protected，private，final，static，abstract，interface
     *
     * @return
     * @see Modifier
     */
    public int getModifiers() {
        System.out.println(Modifier.isPublic(ClassSpec.class.getModifiers()));
        System.out.println(Modifier.isInterface(ClassSpec.class.getModifiers()));
        return 1;
    }

    /**
     * @return
     */
    public Object[] getSigners() {
        Object[] signers = List.class.getSigners();
        for (Object obj : signers) {
            System.out.println(obj);
        }
        return null;
    }

    /**
     * 返回一个本地类和匿名类的外围方法。如果基本类被a type
     * declaration, instance initializer or static initializer 包围，则这个方法会返回空。
     *
     * @return
     */
    public Method getEnclosingMethod() {
        class ClassA {

        }
        // public java.lang.reflect.Method hungry.java.lang.ClassSpec.getEnclosingMethod()
        System.out.println(ClassA.class.getEnclosingMethod());
        // public java.lang.reflect.Method hungry.java.lang.ClassSpec.getEnclosingMethod()
        Runnable runnable = new Runnable() {
            @Override
            public void run() {


            }
        };
        System.out.println(runnable.getClass().getEnclosingMethod());
        return null;
    }


    /**
     * 返回一个本地或匿名类的外围构造函数。
     *
     * @return
     */
    public Constructor<?> getEnclosingConstructor() {
        new ClassSpec<>();
        return null;
    }

    private List<Long> longList = new ArrayList<>();

    /**
     * 被这个类对象表示的类或接口是另一个类的成员，将会返回这个被声明的类对象
     *
     * @return
     */
    public Class<?> getDeclaringClass() {
        // class hungry.java.lang.ClassSpec
        System.out.println(User.class.getDeclaringClass());
        return null;
    }

    /**
     * 直接返回基本类的外围类。如果基本类是顶层类，这个方法将会返回空
     *
     * @return
     */
    public Class<?> getEnclosingClass() {
        // class hungry.java.lang.ClassSpec
        System.out.println(User.class.getEnclosingClass());
        return null;
    }

    /**
     * 返回在代码中给出的基本类的名称。如果是匿名类则返回空字串。
     * 如果为数组，则为组件类型的simple name加上[]
     *
     * @return
     */
    public String getSimpleName() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        // 空
        System.out.println(runnable.getClass().getSimpleName());
        // Runnable
        System.out.println(Runnable.class.getSimpleName());
        return null;
    }

    /**
     * 返回这个类型名称信息字串，带包名和类名
     *
     * @return
     */
    public String getTypeName() {
        // java.util.List
        System.out.println(List.class.getTypeName());
        // hungry.java.lang.ClassSpec
        System.out.println(ClassSpec.class.getTypeName());
        // hungry.java.lang.ClassSpec[]
        System.out.println(ClassSpec[].class.getTypeName());
        class ClassA {

        }
        // hungry.java.lang.ClassSpec$3ClassA
        System.out.println(ClassA.class.getTypeName());
        return "";
    }


    /**
     * 返回在Java Language Specification定义基本类的权威名称。
     * 如果它是一个本地或匿名类或是一个数组，返回空
     *
     * @return
     */
    public String getCanonicalName() {
        // hungry.java.lang.ClassSpec
        System.out.println(ClassSpec.class.getCanonicalName());
        // hungry.java.lang.ClassSpec[]
        System.out.println(ClassSpec[].class.getTypeName());
        class ClassA {

        }
        // null
        System.out.println(ClassA.class.getCanonicalName());
        return null;
    }

    /**
     * 基本类是否为匿名类
     *
     * @return
     */
    public boolean isAnonymousClass() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        // true
        System.out.println(runnable.getClass().isAnonymousClass());
        // false
        System.out.println(Runnable.class.isAnonymousClass());
        return true;
    }


    /**
     * 如果基本类是一个本地类，就返回true.本地类定义在方法里面
     *
     * @return
     */
    public boolean isLocalClass() {
        class ClassA {

        }
        // true
        System.out.println(ClassA.class.isLocalClass());
        // false
        System.out.println(Runnable.class.isLocalClass());
        return true;
    }

    /**
     * 如果基本类是成员类则返回true
     *
     * @return
     */
    public boolean isMemberClass() {
        // true
        System.out.println(User.class.isMemberClass());
        // true
        System.out.println(DifferentBetweenClassGetEnclosingClassAndDeclaringClass.class.isMemberClass());
        // false
        System.out.println(ClassSpec.class.isMemberClass());
        return true;
    }

    /**
     * 返回当前类对象的所有共有类或者接口成员。
     * 包括超类的共有类和接口成员，以及自己声明的类和接口。
     *
     * @return
     */
    public Class<?>[] getClasses() {
        Class<?>[] classes = ClassSpec.class.getClasses();
//        class hungry.java.lang.ClassSpec$DifferentBetweenClassGetEnclosingClassAndDeclaringClass
//        interface hungry.java.lang.ClassSpec$HelloService
//        class hungry.java.lang.ClassSpec$User
        for (Class clz : classes) {
            System.out.println(clz);
        }
        return null;
    }

    /**
     * 返回一个共有的field数组。包括所有超类的共有field
     * 这个数组的元素不会排序，没有任何特定顺序
     *
     * @return
     */
    public Field[] getFields() {
        // public int hungry.java.lang.ClassSpec.fruitField
        // public java.lang.String hungry.java.lang.ClassSpec.fruitStrField
        Field[] fields = ClassSpec.class.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        return null;
    }

    /**
     * 返回当前类对象中所有共有方法，包括超类和接口。
     * 如果存在方法名称和参数类型相同的多个方法，返回值不同，则每个方法对象都会返回。
     * 如果类对象表示一个类初始化<clinit>方法，则数组中不会返回该方法
     * 如果是数组，则会继承Object中公有方法，当不会包含clone()方法
     * 如果是接口，则不会包含Object中的方法
     * 也不会显示超类中的静态方法
     *
     *
     * @return
     */
    public Method[] getMethods() {
        // 打印该类的所有公有方法包括静态方法，但是不包括超类中的静态方法，但没有构造方法
//        Method[] methods = ClassSpec.class.getMethods();
        // 只展现Object中共有的方法。
        ClassSpec[] clzArr = new ClassSpec[100];
        Method[] methods = clzArr.getClass().getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        return null;
    }


    /**
     * 返回该类中构造函数数组。
     *
     * 返回的是限定符类型?, 而不是类型变量T，因为对于不同的类会有不同的constructor对象
     *
     *
     * @return
     */
    public Constructor<?>[] getConstructors() {
        ClassSpec<String> classSpecStr = new ClassSpec<>("sss");
        // sss
        System.out.println(classSpecStr.getObj());
        Constructor<?>[] constructors = classSpecStr.getClass().getConstructors();
        try {
            ClassSpec classSpecInt = (ClassSpec) constructors[1].newInstance(689);
            // 689
            System.out.println(classSpecInt.getObj());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//        for (Constructor constructor : constructors) {
//            constructor.newInstance()
//            System.out.println(constructor);
//        }
        return null;
    }

    /**
     * 找到指定名称的公有域成员，从当前类开始查，找不到则递归查找其超类，直到没有发现
     * @param name
     * @return
     */
    public Field getField(String name) {
        return null;
    }

    /**
     * 指定需要方法的名称，以及一个对应方法像是参数类型数组。
     * 从当前类查找，找不到则递归查找其超类，构造函数除外。
     *
     * 在Java语言中是禁止声明多个方法签名相同而返回类型不同。但是在Java虚拟机中是可以的。
     * 能够增加在Java虚拟机中用来实现各种语言特性的灵活性。
     *
     * @param name
     * @param parameterTypes
     * @return
     */
    public Method getMethod(String name, Class<?>... parameterTypes) {
        try {
            Method getNum = ClassSpecSuper.class.getMethod("getNum");
            Object invoke = getNum.invoke(this);
            System.out.println(getNum.isBridge());
            System.out.println(invoke);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 找到给定名称的资源。只加载类路径下的文件。及当前
     * <p>
     * 这个方法委托给这个对象的classloader。如果这个对象是被根加载器加载则是委托给{@link
     * ClassLoader#getSystemResource}
     * 资源名称的构造方式：如果是以‘/’开头则名称是除‘/’后的名称
     * 否则这种形式{@code modified_package_name/name}情况下，modified_package_name是当前对象包名
     * 用‘/’替换‘.’
     * ClassSpec.class.getResourceAsStream( "hungry.java.lang.MathSpecification.class") 将会是hungry/java/lang/hungry.java.lang.MathSpecification.class
     * <p>
     * ClassSpec.class.getResourceAsStream("/hungry/java/lang/MathSpecification.class")
     * 则会是/hungry/java/lang/MathSpecification.class
     *
     * @param name
     * @return
     */
    public InputStream getResourceAsStream(String name) {

        try (InputStream resourceAsStream = ClassSpec.class.getResourceAsStream("/resource_class.properties");
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));) {
            bufferedReader.lines().forEach(line -> System.out.println(line));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 如上getResourceAsStream方法，只是以资源的形式展示
     *
     * @param name
     * @return
     */
    public URL getResource(String name) {
        // /D:/workspace/hungry-java-core/target/classes/resource_class.properties
        // protocol = file
        URL urlResource = ClassSpec.class.getResource("/resource_class.properties");
        System.out.println();
        return null;
    }

    /**
     * @return
     */
    public ProtectionDomain getProtectionDomain() {
        ProtectionDomain protectionDomain = ClassSpec.class.getProtectionDomain();
//        protectionDomain.
        System.out.println(protectionDomain);
        return null;
    }

    /**
     * 返回想要的断定状态
     *
     * @return
     * @see ClassLoader#setClassAssertionStatus
     * @see ClassLoader#setPackageAssertionStatus
     * @see ClassLoader#setDefaultAssertionStatus
     */
    public boolean desiredAssertionStatus() {
        // true   指定运行参数 java -ea
        // false
        System.out.println(ClassSpec.class.desiredAssertionStatus());
        return true;
    }

    /**
     * 该类是否为枚举类型
     *
     * @return
     */
    public boolean isEnum() {
        // false
        System.out.println(ClassSpec.class.isEnum());
        // true
        System.out.println(ClientInfoStatus.class.isEnum());
        return true;
    }


    /**
     * 获取枚举类中所有的常量
     *
     * @return
     */
    public T[] getEnumConstants() {
        ClientInfoStatus[] enumConstants = ClientInfoStatus.class.getEnumConstants();
        System.out.println(enumConstants);
        return null;
    }

    /**
     * 强转一个对象到这个类对象的类或接口
     *
     * @param object
     * @return
     */
    public T cast(Object object) {
        ClassSpec cast = ClassSpec.class.cast(new ClassSpec<Long>());
        System.out.println(cast);
        List cast1 = List.class.cast(new ArrayList<>());
        System.out.println(cast1);
        return null;
    }

    /**
     * 当前类对象作为指定类对象的子类
     *
     * @param clazz
     * @param <U>
     * @return
     */
    public <U> Class<? extends U> asSubclass(Class<U> clazz) {
        Class<? extends List> aClass = ArrayList.class.asSubclass(List.class);
        System.out.println(aClass);
        return null;
    }


    /**
     * 获取当前类指定的注解类对象
     *
     * @param annotationClass
     * @param <A>
     * @return
     */
    public <A extends Annotation> A getAnnotation(Class<A> annotationClass) {
        Target annotation = Retention.class.getAnnotation(Target.class);
        System.out.println(annotation);
        return null;
    }


    /**
     * 当前类是否有指定的注解类对象
     */
    public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
        boolean annotationPresent = Retention.class.isAnnotationPresent(Target.class);
        System.out.println(annotationPresent);
        return true;
    }

    /**
     * 获取当前类对象指定的注解对象
     *
     * @param annotationClass
     * @param <A>
     * @return
     */
    public <A extends Annotation> A[] getAnnotationsByType(Class<A> annotationClass) {
        Retention[] annotationsByType = Retention.class.getAnnotationsByType(Retention.class);
        System.out.println(annotationsByType);
        return null;
    }


    /**
     * 获取当前的所有注解对象
     *
     * @return
     */
    public Annotation[] getAnnotations() {
        Annotation[] annotations = Retention.class.getAnnotations();
        System.out.println(annotations);
        return null;
    }

    /**
     * 获取当前类所声明的指定注解类
     *
     * @param annotationClass
     * @param <A>
     * @return
     */
    public <A extends Annotation> A getDeclaredAnnotation(Class<A> annotationClass) {
        return null;
    }

    /**
     * 获取当前类所声明的指定注解类数组
     *
     * @param annotationClass
     * @param <A>
     * @return
     */
    public <A extends Annotation> A[] getDeclaredAnnotationsByType(Class<A> annotationClass) {
        return null;
    }

    /**
     * 获取当前类所有声明的注解
     *
     * @return
     */
    public Annotation[] getDeclaredAnnotations() {
        return null;
    }


    /**
     * 返回当前类超类的类型使用的一个注解类型；相当于是超类的元数据，如下的TypeUseAnnotation，属于ElementType.TYPE_USE
     * ClassSpec<T> extends @TypeUseAnnotation ClassSpecSuper
     *
     * @return
     */
    public AnnotatedType getAnnotatedSuperclass() {
        AnnotatedType annotatedSuperclass = ClassSpec.class.getAnnotatedSuperclass();
        Type type = annotatedSuperclass.getType();
        // class hungry.java.lang.ClassSpecSuper
        System.out.println(type);
        Annotation[] annotations = annotatedSuperclass.getAnnotations();
        // @hungry.java.lang.TypeUseAnnotation()
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        // sun.reflect.annotation.AnnotatedTypeFactory$AnnotatedTypeBaseImpl@61bbe9ba
        System.out.println(annotatedSuperclass);
        return null;
    }

    /**
     * 和getAnnotatedSuperclass方法使用一样，只是表示的维超类接口的元数据
     * @return
     */
    public AnnotatedType[] getAnnotatedInterfaces() {
        return null;
    }

    // Type： Java所有类型的父接口，参数化类型，数组类型，类型变量，原始类型
    public static void main(String[] args) {

        ClassSpec classSpec = new ClassSpec();
        if (classSpec instanceof ClassSpec) {

        }
//        classSpec.toString();
//        classSpec.toGenericString();
//        ClassSpec.forName("java.util.List");
//        ClassSpec.forName("java.lang.Thread", true, ClassSpec.class.getClassLoader());
//        classSpec.newInstance();

//        classSpec.isInstance(null);
//        classSpec.isAssignableFrom(null);
//        classSpec.isInterface();
//        classSpec.isPrimitive();
//        classSpec.isAnnotation();
//        classSpec.isSynthetic();

//        classSpec.getName();
//        classSpec.getClassLoader();
//        classSpec.getTypeParameters();
//        classSpec.getSuperClass();
//        classSpec.getGenericSuperClass();
//        classSpec.getPackage();

//        classSpec.getInterfaces();
//        classSpec.getGenericInterfaces();
//        classSpec.getComponentType();
//        classSpec.getModifiers();
//        classSpec.getSigners();
//        classSpec.getEnclosingMethod();
//        classSpec.getEnclosingConstructor();
//        classSpec.getDeclaringClass();
//        classSpec.getEnclosingClass();

        // getDeclaringClass  和  getEnclosingClass 两者的区别如下
//        new DifferentBetweenClassGetEnclosingClassAndDeclaringClass().getHelloService().sayHello();
//        classSpec.getSimpleName();
//        classSpec.getTypeName();
//        classSpec.getCanonicalName();
//        classSpec.isAnonymousClass();
//        classSpec.isLocalClass();
//        classSpec.isMemberClass();
//        classSpec.getClasses();
//        classSpec.getFields();


//        classSpec.getResourceAsStream("");
//        classSpec.getResource("");
//        classSpec.getProtectionDomain();

//        classSpec.desiredAssertionStatus();
//        classSpec.isEnum();
//        classSpec.getEnumConstants();
//        classSpec.cast(null);
//        classSpec.asSubclass(null);
//        classSpec.getAnnotation(null);

//        classSpec.getAnnotatedSuperclass();
//        classSpec.getMethods();
//        classSpec.getConstructors();
        classSpec.getMethod(null);

    }


    public int fruitField;

    public String fruitStrField;

    private String fruitPrvField;

    public static int staticFruitField;

    public class User {
        private int age;
        private String name;

        private User() {

        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public interface HelloService {

        void sayHello();
    }

    public static class DifferentBetweenClassGetEnclosingClassAndDeclaringClass {

        HelloService getHelloService() {
            //匿名内部类
            return new HelloService() {

                @Override
                public void sayHello() {
                    // class hungry.java.lang.ClassSpec$DifferentBetweenClassGetEnclosingClassAndDeclaringClass
                    System.out.println(this.getClass().getEnclosingClass());
                    // null
                    System.out.println(this.getClass().getDeclaringClass());

                }

            };
        }

    }
}
