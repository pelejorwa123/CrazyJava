package Container.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/*
*@author: pele
*@time: 2018/2/8 12:16
*@project: CrazyJava
*@description:Collection接口示例
*/
public class CollectionTest {
    public static void main(String[] args){
        Collection c1 = new ArrayList();
        //添加元素
        c1.add("孙悟空");
        //虽然集合里不能放基本类型的值，但是java支持自动装箱
        c1.add(6);
        System.out.println(c1.size());
        //删除指定元素
        c1.remove(6);
        System.out.println(c1.size());
        System.out.println("是否包含孙悟空:"+c1.contains("孙悟空"));
        c1.add("轻量级java ee企业应用实战");
        System.out.println("c1:"+c1);
        Collection books = new HashSet();
        books.add("轻量级java ee企业应用实战");
        books.add("疯狂java讲义");
        c1.removeAll(books);
        System.out.println("c1:"+c1);
        //删除c1的所有元素
        c1.clear();
        System.out.println(c1.size());
        //控制books集合里只剩下c集合里也包含的元素
        books.retainAll(c1);
        System.out.println("books:"+books);

    }
}
