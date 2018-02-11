package Container.set;

import java.util.Comparator;
import java.util.TreeSet;

/*
*@author: pele
*@time: 2018/2/10 19:25
*@project: CrazyJava
*@description:自定义排序的TreeSet示例
*/
class M{
    int age;
    public M(int age){
        this.age = age;
    }
    public String toString(){
        return "M[age:"+age+"]";
    }
}
public class TreeSetComparator {
    public static void main(String[] args){
        //使用lambda表达式创建Comparator
        TreeSet ts = new TreeSet((o1,o2) -> {
            M m1 = (M)o1;
            M m2 = (M)o2;
            //根据M对象的age属性来决定大小，age越大，M对象越小
            return m1.age>m2.age ? -1:m1.age < m2.age ? 1:0;
        });
        /*
        * 使用匿名内部类创建comparator接口
         TreeSet ts = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                M m1 = (M)o1;
                M m2 = (M)o2;
                //根据M对象的age属性来决定大小，age越大，M对象越小
                return m1.age>m2.age ? -1:m1.age < m2.age ? 1:0;
            }
        });
        */
        ts.add(new M(5));
        ts.add(new M(-3));
        ts.add(new M(9));
        System.out.println(ts);
    }
}
