package Container.map;

import java.util.HashMap;
import java.util.Map;

/*
*@author: pele
*@time: 2018/2/12 15:24
*@project: CrazyJava
*@description:Map常用默认方法示例
*/
public class MapDefaultMethodTest {
    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();
        //成对放入键值对
        map.put("疯狂java讲义",95);
        map.put("疯狂IOS讲义",10);
        map.put("疯狂Ajax讲义",79);
        //尝试替换key为"疯狂xml"讲义的value，但是该key不存在
        //所以Map没有改变，不会添加新的键值对，区别于put
        map.replace("疯狂xml讲义",100);
        //使用原value与传入参数计算出来的结果覆盖原有的value
        map.merge("疯狂IOS讲义",15,
                (oldVal,param) -> ((oldVal+param)));
        System.out.println(map);
        //当key为"java"对应的value为null时(或不存在)时，使用计算结果作为value
        map.computeIfAbsent("java",key -> (key.length()));
        System.out.println(map);
        //当key为"java"的value存在时，使用计算结果作为value
        map.computeIfPresent("java",(key,value) -> (value*value));
        System.out.println(map);
    }
}
