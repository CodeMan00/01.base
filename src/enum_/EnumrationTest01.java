package enum_;

/**
 * @author gjd
 * @create 2021/9/26  17:01:50
 *
 * 一. 枚举的使用：
 *      1. 枚举类的理解：类的对象只有有限个，且是确定的，我们称此类为枚举类。
 *      2. 当需要定义一组常量时，强烈建议使用枚举类。
 *
 *  二. 如何定义枚举类。
 *       方式一. java5.0 之前都是自定义枚举类
 *       方法二. jdk5.0 可以使用enum定义枚举类
 */
public class EnumrationTest01 {

    public static void main(String[] args) {


        System.out.println(Season.WINTER);
        System.out.println(Season.SUMMER);
    }
}


class Season{

    private final String season;
    private final String desc;

    //直接创建固定的的对象  枚举对象名一般大写
    public static final Season WINTER = new Season("winter","cool");
    public static final Season AUTUMN = new Season("autumn","happy");
    public static final Season SUMMER = new Season("summer","hot");
    public static final Season SPRING = new Season("spring","joy");

    //1.私有化构造器  防止直接new对象
    private Season(String season, String desc){

        this.season = season;
        this.desc = desc;
    }

    /**
     *  无需设置set方法，为了避免数据被修改
     * @return
     */
    //  获取枚举类的其他属性的值
    public String getSeason() {
        return season;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "season='" + season + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}