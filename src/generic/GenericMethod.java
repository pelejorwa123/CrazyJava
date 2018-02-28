package generic;

import java.util.ArrayList;
import java.util.Collection;

/*
*@author: pele
*@time: 2018/2/13 18:00
*@project: CrazyJava
*@description:泛型方法示例
*/
public class GenericMethod {
    //声明一个泛型方法，该方法中带一个T类型形参
    //解决了？类型通配符不能添加的问题
    static <T> void fromArrayToCollection(T[] a, Collection<T> c){
        for(T t:a){
            c.add(t);
        }
    }
    public static void main(String[] args){
        Collection<Object> collectionList = new ArrayList<>();
        String[] stringArray = new String[100];
        //下面代码中T代表Object类型
        //可以发现，此时判定T为Object类型
        //因为colletionTest里T是Object类型，系统只判断<T>的值
        //之所以stringArray是String数组不报错，是因为String[]是Object[]子类
        fromArrayToCollection(stringArray,collectionList);
    }
}
