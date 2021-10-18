package reflect;

public class Person {

    private String username;
    public int age;
    String sex;
    protected boolean flag;
    static String country ;


    Person(){
        System.out.println();
    }

    public Person(String name){
        username = name;
    }

    public Person(String username,int age){

        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", flag=" + flag +
                '}';
    }
}
