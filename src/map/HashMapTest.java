package map;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {


        HashMap<String, HashMap<String, String>> map = new HashMap<>();

        HashMap<String, String> up = new HashMap<>();

        HashMap<String, String> base = new HashMap<>();


        map.put("up", up);
        map.put("base", base);


        up.put("1", "hah");
        up.put("2", "tianqi");

        base.put("3", "fasd");
        base.put("4", "dfasdf");

        getStudentInfo(map);
    }


    public static void getStudentInfo(HashMap<String, HashMap<String, String>> rooms) {

        //获取的是所有的班级名
        for (String room : rooms.keySet()) {

            HashMap<String, String> stus = rooms.get(room);
            for (String key : stus.keySet()) {
                System.out.println(key + "<----->" + stus.get(key));
            }
        }

    }
}

