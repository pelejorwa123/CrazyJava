package Container.Collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/*
*@author: pele
*@time: 2018/2/8 12:53
*@project: CrazyJava
*@description:Iterator示例
*/
public class IteratorTest {
    public static void main(String[] args){
        Collection books = new HashSet();
        books.add("轻量级java ee企业应用实战");
        books.add("疯狂java讲义");
        //创建迭代器
        Iterator iterator = books.iterator();
        while(iterator.hasNext()){
            String book = (String) iterator.next();
            System.out.println(book);
            if(book.equals("疯狂java讲义")){
                //从集合中删除上一次next()方法返回的元素
                iterator.remove();
                //以下语句是错误的，在迭代器里面循环时，不能直接通过集合类去操作
                //books.add("疯狂java讲义2");
            }
        }
        System.out.println(books);
        for(Object object:books){
            //此处的object指向元素的字符串，改变字符串，也就让object的引用指向了另外一个字符串
            //因此集合内部并不会改变
            object = "xxxx";
        }
        System.out.println(books);
    }
}
