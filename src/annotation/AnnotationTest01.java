package annotation;

/**
 * 注解博文地址：
 *  https://www.jianshu.com/p/5cac4cb9be54
 *
 *
 *  注解：
 *      注解是一种引用数据类型，编译之后也是生成.class文件
 *
 *
 *   自定义注解
 *
 *
 *   注解怎么使用？
 *      注解可以使用在方法上、类上、变量上、属性上、还可以出现在注解上。
 *
 *
 *    jdk内置注解：
 *      Deprecated  过时
 *      Override  重写  只能注解方法，这个注解是给编译器用来识别是否重写父类的方法。这个注解只是在编译器起作用。
 *      SuppressWarning
 *
 *
 *    @Documented、@Retention、@Target、@Inherited就是元注解，它们的作用是负责注解其它注解，
 *    主要是描述注解的一些属性，任何注解都离不开元注解（包括元注解自身，通过元注解可以自定义注解）
 *
 *      @Target：
 *      作用：用于描述注解的使用范围，即被描述的注解可以用在什么地方；
 *
 *      @Retention：
 *      作用：表示需要在什么级别保存该注解信息，用于描述注解的生命周期，即被描述的注解在什么范围内有效；
 *             取值：
 *              SOURCE:在源文件中有效，即源文件(java文件中)保留；
 *
 *              2、CLASS:在class文件中有效，即class保留；
 *
 *              3、RUNTIME:在运行时有效，即运行时保留，可以被反射机制读取；
 *
 *      @Documented：
 *          作用：用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，因此可以被例如javadoc此类的工具文档化。
 *      @Inherited：
 *          作用：用于描述某个被标注的类型是可被继承的。如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类。
 *
 */
public class AnnotationTest01 {
}
