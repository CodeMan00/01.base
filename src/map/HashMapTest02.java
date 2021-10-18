package map;

import org.junit.Test;

import java.util.*;

public class HashMapTest02 {

    @Test
    public void test() {

        HashMap<String, String> map = new HashMap<>();

        //添加方法 如果同一个键，存入两次，那么最后一次存入的值会替代之前存入的值，且返回的是上一次的value值。如果第一插入，返回的是null
        map.put("1", "zhangsna");
        map.put("2", "lisi");
        map.put("3", "wangwu");
        map.put("4", "zhaoliu");


        //判断是否包含指定键
        boolean b = map.containsKey("1");
        //判断是否包含指定值
        boolean b1 = map.containsValue("zhagnsan");


        //通过键获取值
        String value = map.get("1");

        //获取map集合中所有的值
        Collection<String> values = map.values();


        System.out.println(map);
    }


    //map的遍历
    @Test
    public void test1() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "zhangsna");
        map.put("2", "lisi");
        map.put("3", "wangwu");
        map.put("4", "zhaoliu");

        //第一种 获取所有的key  然后通过key获取值
        Set<String> set = map.keySet();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {

            String s = iterator.next();
            System.out.println(s + "<------>" + map.get(s));
        }


        System.out.println();
        System.out.println("===================================");
        System.out.println();


        //第二种方式  获取所有的映射关系
        Iterator<Map.Entry<String, String>> entry = map.entrySet().iterator();
        while (entry.hasNext()) {
            Map.Entry<String, String> next = entry.next();
            System.out.println(next.getKey() + "<----->" + next.getValue());

        }


        System.out.println();
        System.out.println("===================================");
        System.out.println();


        //第三种方式
        for (String key : map.keySet()) {
            System.out.println(key + "<----->" + map.get(key));
        }


        System.out.println();
        System.out.println("===================================");
        System.out.println();


        //第四种方式
        for (Map.Entry entry1 : map.entrySet()) {
            System.out.println(entry1.getKey() + "<----->" + entry1.getValue());
        }
    }
}
