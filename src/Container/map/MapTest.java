package Container.map;

import java.util.HashMap;
import java.util.Map;

/*
*@author: pele
*@time: 2018/2/12 13:28
*@project: CrazyJava
*@description:
*/
public class MapTest {
    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();
        //成对放入多对键值对
        map.put("疯狂java讲义",95);
        map.put("疯狂IOS讲义",10);
        map.put("疯狂Ajax讲义",79);
        //放入重复的key时，新的value会覆盖原来的value,返回被覆盖的value
        System.out.println(map.put("疯狂java讲义",96));
        //判断是否包含指定的key
        System.out.println(map.containsKey("疯狂java讲义"));
        //判断是否包含指定的value
        System.out.println(map.containsValue(95));
        //利用entrySet遍历map
        for (Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }
        //利用keySet遍历map，效率较低
        for (String key:map.keySet()){
            System.out.println(key+"---"+map.get(key));
        }
    }
}
