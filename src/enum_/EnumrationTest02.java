package enum_;

/**
 * @author gjd
 * @create 2021/9/26  17:19:16
 *
 * 通过enum关键字实现枚举类，实际上使用关键字定义枚举类，该类隐式的继承了Enum类。
 */
public class EnumrationTest02 {

    public static void main(String[] args) {

        System.out.println(Season.SUMMER);
        System.out.println(Season.WINTER);
    }
}


/**
 *    1. 使用关键字 enum
 *    2. 不用在类中创建对象了，直接通过 常量名("","")的形式使用。  1.常量名通常大写 2.括号内是构造方法中的参数
 *    3. 如果有多个常量， 使用逗号隔开，最后一个使用分号
 *    4. 使用enum来实现枚举，要求将定义常量对象写在前面。
 *    5. 需要构造方法和get方法
 *    6. 调用无参构造器，可以直接写常量名，不用带小括号了。
 */
enum Seasonn{

    SPRING("春天","舒服"),
    SUMMER("夏天","炎热"),
    AUTUMN("秋天","凉爽"),
    WINTER("冬天","寒冷");

    private final String name;
    private final String desc;


    Seasonn(String name,String desc){
        this.name = name;
        this.desc = desc;
    }


    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Seasonn{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
