package jdbc.dao.domain;

import java.util.Date;

/**
 * @author gjd
 * @create 2021/9/28  13:46:24
 *
 * Actor对象要和表中的字段一一对应。
 */
public class Actor {

    private Integer id;
    private String name;
    private String sex;
    private Date borndate;
    private String phone;

    //一定要给一个无参构造器，底层反射会用到
    public Actor(){

    }

    public Actor(Integer id, String name, String sex, Date date, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.borndate = date;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBorndate() {
        return borndate;
    }

    public void setBorndate(Date borndate) {
        this.borndate = borndate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", date=" + borndate +
                ", phone='" + phone + '\'' +
                '}';
    }
}
