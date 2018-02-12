package Container.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
*@author: pele
*@time: 2018/2/12 15:57
*@project: CrazyJava
*@description:
*/
class A{
    int count;
    public A(int count){
        this.count = count;
    }
    //根据count判断两个对象是否相等
    public boolean equals(Object obj){
        if(obj == this)
            return true;
        if(null != obj && obj.getClass()==A.class){
            A a = (A)obj;
            return this.count == a.count;
        }
        return false;
    }
    //根据count计算hashCode
    public int hashCode(){
        return this.count;
    }
}
class B{
    //重写equals方法，总是返回true
    public boolean equals(Object obj){
        return true;
    }
}
public class HashMapTest {
    public static void main(String[] args){
        Map<Object,Object> map = new HashMap<>();
        map.put(new A(60000),"疯狂java讲义");
        map.put(new A(87563),"轻量级java ee企业应用实战");
        map.put(new A(1232),new B());
        System.out.println(map.containsValue("测试字符串"));//输出false

    }
}
