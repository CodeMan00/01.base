package clone;

/**
 * @author gjd
 * @create 2021/10/15  12:58:17
 */

/**
 * 深克隆和浅克隆
 *
 * 一.什么是克隆?
 *      克隆就是根据已存在的数据,创造一份完全一项的新数据拷贝.
 *
 *  二.克隆的实现
 *      1.继承Cloneable接口
 *      2.覆盖Object的clone方法(访问修饰符设置为public,默认为portect)
 *      3.在clone方法中调用super.clone();
 *
 *
 *  三.浅克隆和深克隆
 *     java中的变量是分为基本数据类型和引用类型 , 基本数据类型存储在栈中  引用类型存放在堆中
 *
 *     1.浅克隆:就是把基本数据类型的值赋值到新的对象中,对于引用类型的数据,只是拷贝了引用类型的对象的地址(指向).[没有创建对象]
 *     2.深克隆: 对于引用类型的对象,深克隆直接创建一个新的对象,然后把原对象的数据拷贝到新对象中.[创建了新的对象]
 *
 *
 *  四.注意:
 *    1.实现深克隆,Student类中的引用对象的类也要实现Cloneable接口,并且重写clone方法,它实际
 *    上就是自己创建一个对象,然后把原对象的属性值赋值给新创建的对象.
 */
public class MyClone {

    public static void main(String[] args) throws CloneNotSupportedException {

        Student student = new Student("zhangsan",12,new Address("CHINA","ZHOUKOU"));

        Student clone = student.clone();
        clone.getAddress().setCity("japan");

        System.out.println(student);
        System.out.println(clone);
    }
}


class Student implements Cloneable{

    private String name;
    private Integer age;
    private Address address;

    public Student() {
    }

    public Student(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //浅克隆实现方式
//    @Override
//    public Student clone() throws CloneNotSupportedException {
//
//        return (Student)super.clone();
//    }

    //深克隆实现方式


    @Override
    protected Student clone() throws CloneNotSupportedException {

        Student clone = (Student)super.clone();
        clone.address = address.clone();
        return clone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}

class Address implements Cloneable{

    private  String province;
    private String  city;

    public Address(String province, String city) {
        this.province = province;
        this.city = city;
    }

    public Address() {
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    protected Address clone() throws CloneNotSupportedException {
        return (Address) super.clone();
    }
}